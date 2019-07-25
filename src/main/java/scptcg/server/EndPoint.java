package scptcg.server;

import com.google.gson.Gson;
import org.apache.commons.lang3.tuple.Pair;
import org.jooq.DSLContext;
import scptcg.game.Game;
import scptcg.game.Zone;
import scptcg.game.card.*;
import scptcg.game.effect.ActionMethod;
import scptcg.game.effect.Result;
import scptcg.game.effect.ResultBuilder;
import scptcg.json.Data;
import scptcg.json.Deck;
import scptcg.log.Log4j;
import scptcg.log.Logger;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import static jooq.tables.Deck.*;
import static scptcg.server.DeckMakeServlet.*;

@ServerEndpoint("/ws")
public final class EndPoint {

    private static Map<String, Session> session = new HashMap<>();
    private static List<Game> game = new ArrayList<>();
    private static Map<String, Integer> id = new HashMap<>();
    private static boolean wait = false;
    private static String waiting;
    private static String waitingDeck;
    static private Logger logger = null;

    static {
        logger = Log4j.getInstance();
    }

    @OnOpen
    public void onOpen(final Session client, final EndpointConfig config) {
        String log = client.getId() + " was connected.";
        logger.info(log);
    }

    @OnClose
    public void onClose(final Session client, final CloseReason reason) throws IOException {
        String log = client.getId() + " was closed by " + reason.getCloseCode();
        logger.info(log);
        cutConnection(getId(client));
    }

    private void cutConnection(final String name) throws IOException {
        try {
            int id = EndPoint.id.get(name);
            Game game = EndPoint.game.get(id);
            String enemy = game.getEnemyName(name);
            try {
                EndPoint.game.remove(id);
                Session session1 = session.get(enemy);
                session1.close();
                session.remove(enemy);
            } catch (IllegalStateException | NullPointerException ignored) {
            }
            EndPoint.id.remove(enemy);
        } catch (IndexOutOfBoundsException ignored) {
        }
        session.remove(name);
        EndPoint.id.remove(name);
    }

    @OnError
    public void onError(final Session client, final Throwable error) {
        logger.error(error);
    }

    private String getId(final Session s) {
        for (Map.Entry<String, Session> entry : session.entrySet()) {
            if (entry.getValue() == s) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void login(final String player, final String deck, final Session client) throws IOException {
        Data data = new Data();
        data.Event = "Login";
        session.put(player, client);
        if (id.get(player) != null) {
            if (waiting == null || !waiting.equals(player)) {
                data.Status = "Start";
            } else {
                data.Status = "Wait";
            }
            send(player, data.toJson());
            return;
        }
        EndPoint.wait = !EndPoint.wait;
        if (EndPoint.wait) {
            data.Status = "Wait";
            EndPoint.waiting = player;
            System.out.println("visit : " + player);
            if (Objects.nonNull(deck)) {
                EndPoint.waitingDeck = deck;
            }
        } else {
            data.Status = "Start";
            System.out.println("wait : " + waiting + " visit : " + player);
            game.add(new Game(waiting, getDeck(waiting, waitingDeck), player, getDeck(player, deck)));
            send(waiting, data.toJson());
            waiting = null;
        }
        id.put(player, game.size() > 0 ? game.size() - 1 : 0);
        send(player, data.toJson());
    }

    @OnMessage
    public void onMessage(final String text, final Session client) throws IOException {
        try {
            Data data = (new Gson()).fromJson(text, Data.class);
            if (data.PlayerName == null || data.PlayerName.equals("")) {
                Log4j.getInstance().error(new RuntimeException(data.Event + "のPlayerNameは空です。"));
            } else {
                Log4j.getInstance().info(data.toJson());
                if (data.Event.equals(Events.Login.name())) {
                    login(data.PlayerName, data.DeckName, client);
                } else {
                    main(data.Event, data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    private void main(final String event, final Data data) throws IOException {
        Game game = EndPoint.game.get(id.get(data.PlayerName));
        String[] name = new String[]{data.PlayerName, game.getEnemyName(data.PlayerName)};
        switch (Events.valueOf(event)) {
            case IsFirst:
                isFirst(data, game, name);
                break;

            case GetPartnerables:
                getPartnerable(data, game, name);
                break;

            case SelectPartner:
                selectPartner(data, game, name);
                break;

            case GetEmptySite:
                getEmptySite(data, game, name);
                break;

            case GetRemainSandBox:
                getRemainSandBox(data, game, name);
                break;

            case CrossTest:
                crossTest(data, game, name);
                break;

            case WhetherActive:
                whetherActive(data, game);
                break;

            case Damage:
                damage(data, game, name);
                break;

            case CanCrossTest:
                canCrossTest(data, game, name);
                break;

            case Breach: {
                breach(data, game, name);
                break;
            }

            case TurnEnd:
                turnEnd(data, game, name);
                break;

            case GetPersonnel:
                getPersonnel(data, game, name);
                break;

            case GetTale:
                getTale(data, game, name);
                break;

            case GetSumSiteCost:
                getSumSiteCost(name, data.Player, game.getSumSiteCost(data.Player));
                break;

            case GetSCPCount:
                getSCPCount(data, game, name);
                break;

            case GetSandBoxProtection:
                getSandBoxProtection(data, game, name);
                break;
/*
            case GET_COST:
                send(name, getCost(data.Player, game));
                break;*/

            case GetEffect:
                getEffect(data, game, name);
                break;

            case ActiveEffect:
                activeEffect(data, game, name);
                break;

            case Decommission:
                Result before = decommission(data, game, name);
                if (game.isChainSolving()) {
                    List<Result> r = new ArrayList<>();
                    game.activeEffect(before, r);
                    sendEffectResult(game, data, r.toArray(new Result[0]));
                }
                break;

            case LostEffect:
                lostEffect(data, game, name);
                break;

            case HealSandBox:
                int point = healSandBox(data, game, name);
                if (game.isChainSolving()) {
                    List<Result> r = new ArrayList<>();
                    ResultBuilder rb = new ResultBuilder(
                            ActionMethod.HealSandBox.name(),
                            data.Player,
                            null,
                            null,
                            null,
                            -1
                    );
                    rb.setPoint(point);
                    game.activeEffect(rb.createResult(), r);
                    sendEffectResult(game, data, r.toArray(new Result[0]));
                }
                break;

            case DamageSandBox:
                damageSandBox(data, game, name);
                break;

            case GetCardParameters:
                getCardParameters(data, game, name);
                break;

            case SelectEffect:
                selectEffect(data, game);
                break;

            case GetDecommissioned:
                getDecommissioned(data, game, name);
                break;
        }

        do {
            List<Result> r = new ArrayList<>();
            if (!game.isActive() && game.isWait()) {
                game.activeEffect(null, r);
                sendEffectResult(game, data, r.toArray(new Result[0]));
            }
        } while (!game.isChainSolving() && game.isWait());

        if (!game.isWait() && game.isK()) {
            send(name, SendFormatter.K_Class(game.getKClassPlayerIsFirst(), game.getScenario()));
        }

    }

    private void getDecommissioned(Data data, Game game, String[] name) throws IOException {
        send(name, SendFormatter.getDecommissioned(data.Player, game.getCards(data.Player, Zone.Decommissioned)));
    }


    private void isFirst(Data data, Game game, String[] name) throws IOException {
        send(name, SendFormatter.isFirst(data.PlayerName, game.isFirst(data.PlayerName)));
    }

    private void getPartnerable(Data data, Game game, String[] name) throws IOException {
        send(name, SendFormatter.getPartnerables(data.Player, game.getPartnerables(data.Player)));
    }

    private void selectPartner(Data data, Game game, String[] name) throws IOException {
        Scp scp = game.breachPartner(data.Player, data.CardName[0], data.Coordinate[0][0]);
        send(name, SendFormatter.selectPartner(data.Player, data.Coordinate[0][0], scp));
        send(name, SendFormatter.getCardParameter(data.Player, data.Coordinate[0][0], scp));
    }

    private void getEmptySite(Data data, Game game, String[] name) throws IOException {
        send(name, SendFormatter.getEmptysite(data.Player, game.getEmptySite(data.Player)));
    }

    private void getRemainSandBox(Data data, Game game, String[] name) throws IOException {
        send(name, SendFormatter.getSandBoxNumber(data.Player, game.getRemainSandBox(data.Player, Clazz.Safe),
                game.getRemainSandBox(data.Player, Clazz.Euclid),
                game.getRemainSandBox(data.Player, Clazz.Keter)));
    }

    private void crossTest(Data data, Game game, String[] name) throws IOException {
        List<Scp> breach = new ArrayList<>();
        int point = game.crossTest(data.Player, data.Coordinate[0][0], intToSandBox(data.SandBox), breach);
        if (point >= 0) {
            Scp wait = breach.get(0);
            send(name, SendFormatter.damage(!data.Player,
                    data.SandBox,
                    point,
                    data.Coordinate[0][0]));

            if (wait != null) {
                send(name, SendFormatter.startBreach(wait, false, data.SandBox));
            }
        } else {
            send(name, SendFormatter.can_tCross(data.Player));
        }

    }

    private void whetherActive(Data data, Game game) throws IOException {
        if (data.BeAbleTo) {
            List<Result> result = new ArrayList<>();
            game.activeEffect(null, result);
            sendEffectResult(game, data, result.toArray(new Result[0]));
        } else {
            game.cancelEffect();
        }
    }

    private void damage(Data data, Game game, String[] name) throws IOException {
        List<Scp> scp = new ArrayList<>();
        int damage = data.Point[0];
        game.damage(data.Player, intToSandBox(data.SandBox), data.Point[0], scp);
        Scp wait = scp.get(0);
        send(name, SendFormatter.damage(data.Player,
                data.SandBox,
                damage,
                -1));

        if (wait != null) {
            send(name, SendFormatter.startBreach(wait, true, data.SandBox));
        }

    }

    private void canCrossTest(Data data, Game game, String[] name) throws IOException {
        send(name, SendFormatter.canCrossTest(data.Player, data.Coordinate[0][0], game.canCrossTest(data.Player, data.Coordinate[0][0])));
    }

    private void breach(Data data, Game game, String[] name) throws IOException {
        Scp scp = game.breach(data.Player, data.CardName[0], intToSandBox(data.SandBox), data.Coordinate[0][0]);

        send(name, SendFormatter.breach(data.Player, data.Coordinate[0][0], scp));

        send(name, SendFormatter.getCardParameter(data.Player, data.Coordinate[0][0], scp));

        int me = game.getSumSiteCost(data.Player);
        getSumSiteCost(name, data.Player, me);
        int enemy = game.getSumSiteCost(!data.Player);
        getSumSiteCost(name, !data.Player, enemy);
    }

    private void turnEnd(Data data, Game game, String[] name) throws IOException {
        boolean flag = game.nextTurn();
        if (flag)
            send(name, SendFormatter.turnEnd(data.Player));
    }

    private void getPersonnel(Data data, Game game, String[] name) throws IOException {
        send(name, SendFormatter.getPersonnel(data.Player, data.BeAbleTo, (Personnel) game.getCards(data.Player == data.BeAbleTo, Zone.PersonnelFile)[0]));
    }

    private void getTale(Data data, Game game, String[] name) throws IOException {
        send(name, SendFormatter.getTale(data.Player, (Tale[]) game.getCards(data.Player, Zone.Tales)));
    }

    private void getSumSiteCost(String[] name, boolean player, int sumSiteCost) throws IOException {
        send(name, SendFormatter.getSumSiteCost(player, sumSiteCost));
    }

    private void getSCPCount(Data data, Game game, String[] name) throws IOException {
        switch (Zone.valueOf(data.Zone[0])) {
            case Site:
                send(name, SendFormatter.getSiteNumber(data.Player, game.getSCPCount(data.Player)));
                break;
        }
    }

    private void getSandBoxProtection(Data data, Game game, String[] name) throws IOException {
        send(name, SendFormatter.getSandBoxProtection(data.Player, game.getSandBoxProtection(data.Player)));
    }

    private void getEffect(Data data, Game game, String[] name) throws IOException {
        int len = game.effectSize(data.Player, Zone.valueOf(data.Zone[0]), data.Coordinate[0][0]);
        send(name, SendFormatter.getEffect(data.Zone[0], data.Coordinate[0][0], len));
    }

    private void activeEffect(Data data, Game game, String[] name) throws IOException {
        game.selectEffect(data.Player, Zone.valueOf(data.Zone[0]), data.Coordinate[0][0], data.Coordinate[0][1]);
    }

    private void lostEffect(Data data, Game game, String[] name) {
        game.lostEffect(data.Player, Zone.valueOf(data.Zone[0]), data.Coordinate[0][0]);
    }

    private Result decommission(Data data, Game game, String[] name) throws IOException {
        Card card;
        int[] coord;
        boolean p;
        if (data.Coordinate[0].length <= 0) {
            coord = data.Coordinate[1];
            p = !data.Player;
        } else {
            coord = data.Coordinate[0];
            p = data.Player;
        }
        card = game.decommission(p, Zone.valueOf(data.Zone[0]), coord[0]);
        send(name, SendFormatter.decommission(p, data.Zone[0], coord[0], card, false));
        ResultBuilder result = new ResultBuilder(ActionMethod.Decommission.name(), data.Player, Zone.valueOf(data.Zone[0]), card, card.getName(), coord[0]);
        int me = game.getSumSiteCost(data.Player);
        getSumSiteCost(name, data.Player, me);
        int enemy = game.getSumSiteCost(!data.Player);
        getSumSiteCost(name, !data.Player, enemy);
        return result.createResult();
    }

    private int healSandBox(Data data, Game game, String[] name) throws IOException {
        int point = game.healSandBox(data.Player, intToSandBox(data.SandBox), data.Point[0]);
        send(name, SendFormatter.heal(data.Player, data.SandBox, point));
        return point;

    }

    private Zone clazzToZone(Clazz intToSandBox) {
        switch (intToSandBox) {
            case Safe:
                return Zone.SafeSandbox;
            case Euclid:
                return Zone.EuclidSandbox;
            case Keter:
                return Zone.KeterSandbox;
            default:
                return null;
        }
    }

    private void damageSandBox(Data data, Game game, String[] name) throws IOException {
        List<Scp> scp = new ArrayList<>();
        game.damage(data.Player, intToSandBox(data.SandBox), data.Point[0], scp);
        send(name, SendFormatter.damage(data.Player, data.SandBox, data.Point[0], -1));

        if (scp.get(0) != null) {
            send(name, SendFormatter.startBreach(scp.get(0), data.Player, data.SandBox));
        }

    }

    private void getCardParameters(Data data, Game game, String[] name) throws IOException {
        Scp scp = (Scp) game.getCard(data.Player, Zone.valueOf(data.Zone[0]), data.Coordinate[0][0]);
        send(name, SendFormatter.getCardParameter(data.Player, data.Coordinate[0][0], scp));
    }

    private void selectEffect(Data data, Game game) {
        game.sortEffect(data.Order);
    }

    private void send(String[] name, List<Pair<String, String>> list) throws IOException {

        for (Pair<String, String> e : list) {
            switch (e.getKey()) {
                case "me":
                    send(name[0], e.getValue());
                    logger.info("me[" + name[0] + "]\n: " + e.getValue());
                    ////System.out.println();
                    break;
                case "enemy":
                    send(name[1], e.getValue());
                    logger.info("enemy[" + name[1] + "]:\n " + e.getValue());
                    break;
            }
        }
    }

    private int sandBoxToInt(String str) {
        switch (Clazz.valueOf(str)) {
            case Safe:
                return 0;
            case Euclid:
                return 1;
            case Keter:
                return 2;
        }
        return -1;
    }

    private Clazz intToSandBox(int index) {
        switch (index) {
            case 0:
                return Clazz.Safe;
            case 1:
                return Clazz.Euclid;
            case 2:
                return Clazz.Keter;
        }
        return null;
    }

    private List<Pair<String, String>> sendEffectResult(Game game, Data data, Result[] st) throws IOException {
        List<Pair<String, String>> list = new LinkedList<>();
        String[] name = new String[]{data.PlayerName, game.getEnemyName(data.PlayerName)};
        for (Result r : st) {
            if (r == null) {
                continue;
            }

            int sender;
            if (game.isFirst(data.PlayerName) == (Objects.nonNull(r.getObject()) && r.getObject().length > 0 && r.getObject()[0].length > 0 ? r.getObject()[0][0].ownerIsFirst() : r.getSubject().ownerIsFirst()))
                sender = SendFormatter.ME;
            else {
                sender = SendFormatter.ENEMY;
            }
            //System.out.println("effectsss: " + sender + ":" + data.PlayerName + ":" + game.isFirst(data.PlayerName) + ":" + r.getSubject().ownerIsFirst());
            switch (ActionMethod.valueOf(r.getAction())) {
                case ActiveTale:
                    send(name, SendFormatter.activeTale(data.Player, r.getSubjectName(), r.getSubjectCoordinate()));
                    break;
                case Decommission:
                    send(name, SendFormatter.decommission(
                            r.getSubjectPlayer(),
                            r.getTargetZone(),
                            r.getCoordinate()[0][0],
                            r.getObject()[0][0],
                            false
                    ));
                    int me = game.getSumSiteCost(data.Player);
                    getSumSiteCost(name, data.Player, me);
                    int enemy = game.getSumSiteCost(!data.Player);
                    getSumSiteCost(name, !data.Player, enemy);
                    if (game.isChainSolving()) {
                        ResultBuilder result = new ResultBuilder(
                                ActionMethod.Decommission.name(),
                                r.getSubjectPlayer(),
                                Zone.valueOf(r.getTargetZone()),
                                r.getObject()[0][0],
                                r.getObject()[0][0].getName(),
                                r.getCoordinate()[0][0]
                        );
                        List<Result> tmp = new ArrayList<>();
                        game.activeEffect(result.createResult(), tmp);
                        sendEffectResult(game, data, tmp.toArray(new Result[0]));
                    }
                    break;

                case ReContainment:
                    send(name, SendFormatter.reContainment(
                            r.getSubjectPlayer(),
                            r.getSubject(),
                            r.getSubjectZone(),
                            r.getObjectZone()[0][0],
                            game.getDecommisionedTop(r.getSubjectPlayer()),
                            r.getCoordinate()[0][0]
                    ));
                    me = game.getSumSiteCost(data.Player);
                    getSumSiteCost(name, data.Player, me);
                    enemy = game.getSumSiteCost(!data.Player);
                    getSumSiteCost(name, !data.Player, enemy);
                    break;
                case Fail:
                    send(name, SendFormatter.impossible(data.Player, sender));
                    break;
                case K_Class:
                    break;

                case Select:
                    send(name, SendFormatter.select(r.getTargetPlayer(), r.getNextAction(), r.getTargetZone(), r.getCoordinate(), r.isComplete(), sender));
                    break;

                case HealSandBox:
                case DamageSandBox:
                    send(name,
                            SendFormatter.changeProtectionEffect(
                                    r.getTargetPlayer(),
                                    r.getAction(),
                                    r.getPoint(),
                                    r.getCount(),
                                    r.canOverlap(),
                                    sender));
                    break;

                case MinusSecure:
                case PlusSecure:
                case SetSecure:
                    send(name, SendFormatter.getCardParameter(r.getSubjectPlayer(), r.getSubjectCoordinate(), (Scp) r.getSubject()));
                    break;

                case Optional:
                    send(name, SendFormatter.optional(r.getSubjectPlayer(), r.getSubjectName(), r.getMessage(), sender));

                default:
                    break;
            }
        }

        return list;
    }

    private synchronized void send(final String name, final String str) throws IOException {
        session.get(name).getBasicRemote().sendText(str);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public Deck getDeck(String id, String deckName) {
        try {
            DSLContext con = connectionDB();
            String txt = null;
            for (org.jooq.Record r :
                    con.select().from(DECK)
                            .where(DECK.ID.eq(id))
                            .and(DECK.NAME.eq(deckName))
                            .fetch()) {
                txt = r.getValue(DECK.DECK_);
                break;
            }
            Deck d = (new Gson()).fromJson(txt, Deck.class);
            System.out.println(txt);
            return d;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Deck();
    }

}
