package scptcg.server;

import com.google.gson.Gson;
import org.apache.commons.lang3.tuple.Pair;
import org.jooq.DSLContext;
import scptcg.game.Game;
import scptcg.game.Zone;
import scptcg.game.card.*;
import scptcg.game.effect.ActionMethod;
import scptcg.game.effect.Result;
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
import static scptcg.server.SendFormatter.*;

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
        String log = client.getId() + " was error by " + error.getMessage();
        logger.error(error);
    }

    private String getId(final Session s) {
        for (String key : session.keySet()) {
            if (session.get(key) == s) {
                return key;
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
        wait = !wait;
        if (wait) {
            data.Status = "Wait";
            waiting = player;
            if (Objects.nonNull(deck)) {
                waitingDeck = deck;
            }
        } else {
            data.Status = "Start";
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
                return;
            }
            Log4j.getInstance().info(data.toJson());

            if (data.Event.equals(Events.Login.name())) {
                login(data.PlayerName, data.DeckName, client);
            } else {
                main(data.Event, data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    private void main(final String event, final Data data) throws IOException {
        List<Pair<String, String>> list = new LinkedList<>();
        Game game = EndPoint.game.get(id.get(data.PlayerName));
        String[] name = new String[]{data.PlayerName, game.getEnemyName(data.PlayerName)};
        switch (Events.valueOf(event)) {
            case IsFirst:
                send(name, isFirst(data.PlayerName, game.isFirst(data.PlayerName)));
                break;

            case GetPartnerables:
                send(name, getPartnerables(data.Player, game.getPartnerables(data.Player)));
                break;

            case SelectPartner: {
                Scp scp = game.breachPartner(data.Player, data.CardName[0], data.Coordinate[0][0]);
                send(name, selectPartner(data.Coordinate[0][0], scp));
                send(name, getCardParameter(data.Player, data.Coordinate[0][0], scp));
                break;
            }

            case GetEmptySite:
                send(name, getEmptysite(data.Player, game.getEmptySite(data.Player)));
                break;

            case CrossTest: {
                List<Scp> breach = new ArrayList<>();
                int point = game.crossTest(data.Player, data.Coordinate[0][0], Clazz.valueOf(data.SandBox), breach);
                Scp wait = breach.get(0);
                send(name, damage(!data.Player,
                        data.SandBox,
                        point,
                        data.Coordinate[0][0]));

                if (wait != null) {
                    send(name, startBreach(wait, false));
                }

                if (game.isK()) {
                    send(name, K_Class(game.getKClassPlayerIsFirst(), game.getScenario()));
                }
                break;
            }

            case WhetherActive:
                if (data.BeAbleTo) {
                    List<Result> result = new ArrayList<>();
                    game.activeEffect(null, result);
                    sendEffectResult(game, data, result.toArray(new Result[0]));
                } else {
                    game.cancelEffect();
                }
                break;

            case Damage: {
                if (data.Coordinate[0].length <= 0) {
                    data.SandBox = intToSandBox(data.Coordinate[1][0]).name();
                } else {
                    data.SandBox = intToSandBox(data.Coordinate[0][0]).name();
                }
                data.Point = new int[]{Integer.parseInt(data.CardName[0])};
                List<Scp> scp = new ArrayList<>();
                int damage = data.Point[0];
                game.damage(data.Player, Clazz.valueOf(data.SandBox), data.Point[0], scp);
                Scp wait = scp.get(0);
                send(name, damage(data.Player,
                        data.SandBox,
                        damage,
                        -1));

                if (wait != null) {
                    send(name, startBreach(wait, true));
                }

                if (game.isK()) {
                    send(name, K_Class(game.getKClassPlayerIsFirst(), game.getScenario()));
                }

                break;
            }

            case CanCrossTest:
                send(name, canCrossTest(data.Player, data.Coordinate[0][0], game.canCrossTest(data.Player, data.Coordinate[0][0])));
                break;

            case Breach: {
                Scp scp = game.breach(data.Player, data.CardName[0], Clazz.valueOf(data.SandBox), data.Coordinate[0][0]);

                send(name, breach(data.Player, data.Coordinate[0][0], scp));

                if (game.isK()) {
                    send(name, K_Class(game.getKClassPlayerIsFirst(), game.getScenario()));
                }

                send(name, getCardParameter(data.Player, data.Coordinate[0][0], scp));

                int me = game.getSumSiteCost(data.Player);
                send(name, getSumSiteCost(data.Player, me));
                int enemy = game.getSumSiteCost(!data.Player);
                send(name, getSumSiteCost(!data.Player, enemy));
                break;
            }

            case TurnEnd:
                game.nextTurn();
                send(name, turnEnd(data.Player));
                break;

            case GetPersonnel:
                send(name, getPersonnel(data.Player, data.BeAbleTo, (Personnel) game.getCards(data.Player, Zone.PersonnelFile)[0]));
                break;

            case GetTale:
                send(name, getTale(data.Player, (Tale[]) game.getCards(data.Player, Zone.Tales)));
                break;

            case GetSumSiteCost:
                send(name, getSumSiteCost(data.Player, game.getSumSiteCost(data.Player)));
                break;

            case GetSCPCount:
                switch (Zone.valueOf(data.Zone[0])) {
                    case Site:
                        send(name, getSiteNumber(data.Player, game.getSCPCount(data.Player)));
                        break;
                }
                break;

            case GetSandBoxProtection:
                send(name, getSandBoxNumber(data.Player, game.getSandBoxProtection(data.Player)));
                break;
/*
            case GET_COST:
                send(name, getCost(data.Player, game));
                break;*/

            case GetEffect: {
                int len = game.effectSize(data.Player, Zone.valueOf(data.Zone[0]), data.Coordinate[0][0]);
                send(name, getEffect(len));
                break;
            }

            case ActiveEffect: {

                if (Zone.valueOf(data.SandBox) == Zone.Tales) {
                    send(name, activeTale(data.Player, game.getCard(data.Player, Zone.valueOf(data.SandBox), data.Coordinate[0][0]).getName(), data.Coordinate[0][0]));
                }

                List<Result> result = new ArrayList<>();
                game.selectEffect(data.Player, Zone.valueOf(data.SandBox), data.Coordinate[0][0], data.Coordinate[0][1], result);
                sendEffectResult(game, data, result.toArray(new Result[0]));
                break;
            }
            case Decommission: {
                data.Zone = new String[]{data.CardName[0]};
                data.Player = data.CardName[1].equals("True");
                Card card;
                int[] coord;
                boolean p;
                if (data.Coordinate[0].length <= 0) {
                    coord = data.Coordinate[1];
                    p = data.Player;
                } else {
                    coord = data.Coordinate[0];
                    p = !data.Player;
                }
                card = game.decommission(p, Zone.valueOf(data.Zone[0]), coord[0]);
                send(name, decommission(p, data.Zone[0], coord[0], card, false));
                int me = game.getSumSiteCost(data.Player);
                send(name, getSumSiteCost(data.Player, me));
                int enemy = game.getSumSiteCost(!data.Player);
                send(name, getSumSiteCost(!data.Player, enemy));
                break;
            }

            case HealSandBox: {
                if (data.Coordinate[0].length <= 0) {
                    data.SandBox = intToSandBox(data.Coordinate[1][0]).name();
                } else {
                    data.SandBox = intToSandBox(data.Coordinate[0][0]).name();
                }
                boolean me = data.Player;
                if (!data.CardName[0].equals("True")) {
                    data.Player = !data.Player;
                }
                data.Point = new int[]{Integer.parseInt(data.CardName[1])};
                int point = data.Point[0];
                game.healSandBox(data.Player, Clazz.valueOf(data.SandBox), data.Point[0]);
                send(name, heal(data.Player, data.SandBox, point));
                break;
            }

            case DamageSandBox: {
                data.SandBox = intToSandBox(data.Coordinate[0][0]).name();
                boolean me = data.Player;
                if (!data.CardName[0].equals("True")) {
                    data.Player = !data.Player;
                }
                data.Point = new int[]{Integer.parseInt(data.CardName[1])};
                List<Scp> scp = new ArrayList<>();
                int point = data.Point[0];
                game.damage(data.Player, Clazz.valueOf(data.SandBox), data.Point[0], scp);
                send(name, damage(data.Player, data.SandBox, data.Point[0], -1));

                if (scp.get(0) != null) {
                    send(name, startBreach(scp.get(0), data.Player == me));
                }

                if (game.isK()) {
                    send(name, K_Class(game.getKClassPlayerIsFirst(), game.getScenario()));
                }

                break;
            }

            case GetCardParameters: {
                Scp scp = (Scp) game.getCard(data.Player, Zone.valueOf(data.Zone[0]), data.Coordinate[0][0]);
                send(name, getCardParameter(data.Player, data.Coordinate[0][0], scp));
                break;
            }

            case SelectEffect:
                game.sortEffect(data.Order);
                break;

        }

        if (game.isK()) {
            send(name, K_Class(game.getKClassPlayerIsFirst(), game.getScenario()));
        }

    }

    private void send(String[] name, List<Pair<String, String>> list) throws IOException {

        for (Pair<String, String> e : list) {
            try {
                if ((new Gson()).fromJson(e.getValue(), Data.class).Event.equals("ReContainment")) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            switch (e.getKey()) {
                case "me":
                    send(name[0], e.getValue());
                    logger.info("me\n: " + e.getValue());
                    ////System.out.println();
                    break;
                case "enemy":
                    send(name[1], e.getValue());
                    logger.info("enemy:\n " + e.getValue());
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
                send(name, failEffect());
                continue;
            }
            switch (ActionMethod.valueOf(r.getAction())) {
                case Decommission:
                    send(name, decommission(
                            r.getSubjectPlayer(),
                            r.getObjectZone()[0][0].name(),
                            r.getCoordinate()[0][0],
                            r.getObject()[0][0],
                            false
                    ));
                    int me = game.getSumSiteCost(data.Player);
                    send(name, getSumSiteCost(data.Player, me));
                    int enemy = game.getSumSiteCost(!data.Player);
                    send(name, getSumSiteCost(!data.Player, enemy));
                    break;

                case ReContainment:
                    send(name, reContainment(
                            r.getSubjectPlayer(),
                            r.getSubject(),
                            r.getSubjectZone(),
                            r.getObjectZone()[0][0],
                            game.getDecommisionedTop(r.getSubjectPlayer()),
                            r.getCoordinate()[0][0]
                    ));
                    me = game.getSumSiteCost(data.Player);
                    send(name, getSumSiteCost(data.Player, me));
                    enemy = game.getSumSiteCost(!data.Player);
                    send(name, getSumSiteCost(!data.Player, enemy));
                    break;

                case K_Class:
                    if (game.isK()) {
                        send(name, K_Class(game.getKClassPlayerIsFirst(), game.getScenario()));
                    }
                    break;

                case Select:
                    send(name, select(r.getTargetPlayer(), r.getNextAction(), r.getObjectZone()[0][0].name(), r.getCoordinate(), r.isComplete()));
                    break;

                case HealSandBox:
                case DamageSandBox:
                    send(name,
                            changeProtectionEffect(
                                    r.getTargetPlayer(),
                                    r.getAction(),
                                    r.getPoint(),
                                    r.getCount(),
                                    r.canOverlap()));
                    break;

                case MinusSecure:
                    send(name, getCardParameter(r.getSubjectPlayer(), r.getSubjectCoordinate(), (Scp) r.getSubject()));
                    break;

                default:
                    break;
            }
        }

        if (game.isK()) {
            send(name, K_Class(game.getKClassPlayerIsFirst(), game.getScenario()));
        }

        return list;
    }

    private void send(final String name, final String str) throws IOException {
        session.get(name).getBasicRemote().sendText(str);
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
            return (new Gson()).fromJson(txt, Deck.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Deck();
    }

}
