package scptcg.server;

import com.google.gson.Gson;
import org.apache.commons.lang3.tuple.Pair;
import org.jooq.DSLContext;
import scptcg.game.CreateGame;
import scptcg.game.Events;
import scptcg.game.Game;
import scptcg.game.Place;
import scptcg.game.card.Card;
import scptcg.game.card.Scp;
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

import static jooq.scp_tcg.tables.Deck.*;
import static scptcg.game.Events.*;
import static scptcg.game.Place.*;
import static scptcg.server.DeckMakeServlet.*;
import static scptcg.server.GameOperator.*;

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
        //////System.out.println(log);
        logger.info(log);
    }

    @OnClose
    public void onClose(final Session client, final CloseReason reason) throws IOException {
        String log = client.getId() + " was closed by "
                + reason.getCloseCode() + "[" + reason.getCloseCode().getCode() + "]";
        ////System.out.println(log);
        logger.info(log);
        cutConnection(getId(client));
    }

    void cutConnection(final String id) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("K-Class-Scenario\n");
        sb.append("IK");
        sb.append("\n");
        try {
            Game ga = game.get(EndPoint.id.get(id));
            sb.append(ga.getPlayerNumber(id));
            sb.append("\n");
            try {
                game.remove((int) (EndPoint.id.get(id)));
                send(ga.getEnemyName(id), sb.toString());
                Session session1 = session.get(ga.getEnemyName(id));
                session1.close();
                session.remove(session1);
            } catch (IllegalStateException | NullPointerException e) {
            }
            EndPoint.id.remove(ga.getEnemyName(id));
        } catch (IndexOutOfBoundsException e) {
        }
        session.remove(id);
        EndPoint.id.remove(id);
    }

    @OnError
    public void onError(final Session client, final Throwable error) {
        String log = client.getId() + " was error. [" + error.getMessage() + "]";
        logger.error(error);
        error.printStackTrace();
    }

    private String getId(final Session s) {

        for (String key : session.keySet()) {
            if (session.get(key) == s) {
                return key;
            }
        }
        return null;
    }

    public void login(final String player, final String name, final Session client) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Login\n");
        session.put(player, client);
        if (id.get(player) != null) {
            if (waiting == null || !waiting.equals(player)) {
                sb.append("start");
            } else {
                sb.append("wait");
            }
            send(player, sb.toString());
            return;
        }
        wait = !wait;
        if (wait) {
            sb.append("wait");
            waiting = player;
            if (name != null) {
                waitingDeck = name;
            }
        } else {
            sb.append("start");
            game.add(CreateGame.create(waiting, getDeck(waiting, waitingDeck), player, getDeck(player, name)));
            send(waiting, sb.toString());
            waiting = null;
        }
        id.put(player, game.size() > 0 ? game.size() - 1 : 0);
        send(player, sb.toString());
    }

    @OnMessage
    public void onMessage(final String text, final Session client) throws IOException {
        try {
            Data data = (new Gson()).fromJson(text, Data.class);
            //System.out.println(data.event);
            Log4j.getInstance().info(data.toString());

            if (data.Event.equals(LOGIN.name())) {
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
        Game game = EndPoint.game.get(id.get(data.Player ? 0 : 1));
        switch (Events.getEventByValue(event)) {
            case IS_FIRST:
                list.addAll(isFirst(game, data.PlayerName));
                break;

            case GET_MY_DECK:
                list.addAll(getMyDeck(data.Player, data.ObjectClass, game));
                break;

            case GET_DECOMMISSIONED:
                list.addAll(getDecommission(data.Player, game));
                break;

            case GET_CAN_PARTNERS:
                list.addAll(getCanPartners(data.Player, game));
                break;

            case SELECT_PARTNER: {
                Scp scp = game.selectPartner(data.Player ? 0 : 1, data.CardName[0], data.Coordinate[0][0]);
                list.addAll(selectPartner(data.Coordinate[0][0], scp));
                list.addAll(getCardParam(data.Player, data.Coordinate[0][0], scp));
                break;
            }
            case GET_EMPTY_SITE:
                list.addAll(getEmptysite(data.Player, game));
                break;

            case CROSS_TEST: {
                Pair<Integer, Scp> result = game.crossTest(data.Player ? 0 : 1, data.Coordinate[0][0], data.SandBox);
                Integer damage = result.getLeft();
                Scp wait = result.getRight();
                list.addAll(damage(data.Player,
                        data.SandBox,
                        damage,
                        data.Coordinate[0][0]));

                if (wait != null) {
                    list.addAll(startBreach(wait, false));
                }

                list.addAll(checkK_Class(game));
                break;
            }
            case DAMAGE: {
                Pair<Integer, Scp> result = game.damage(data.Player ? 0 : 1, data.SandBox, data.Point[0]);
                int damage = result.getLeft();
                Scp wait = result.getRight();
                list.addAll(damage(data.Player,
                        data.SandBox,
                        damage,
                        -1));

                if (wait != null) {
                    list.addAll(startBreach(wait, true));
                }

                list.addAll(checkK_Class(game));
                break;
            }

            case CAN_ATTACK:
                list.addAll(canAttack(data.Player, data.Coordinate[0][0], game));
                break;

            case BREACH: {
                Scp scp = game.breach(data.Player ? 0 : 1, data.Coordinate[0][0]);
                list.addAll(breach(data.Player, data.Coordinate[0][0], scp));
                list.addAll(getCardParam(data.Player, data.Coordinate[0][0], scp));
                list.addAll(checkK_Class(game));
                break;
            }

            case TURN_END:
                game.nextTurn();
                list.addAll(turnEnd(game));
                break;

            case GET_PERSONNEL:
                list.addAll(getPersonnel(data.Player, game));
                break;

            case GET_TALE:
                list.addAll(getTale(data.Player, game));
                break;

            case GET_SUM_SITE_COST:
                list.addAll(getCost(data.Player, game));
                break;

            case GET_SCP_COUNT:
                switch (Place.create(data.Zone[0])) {
                    case SITE:
                        list.addAll(getSiteNumber(data.Player, game));
                        break;
                }
                break;

            case GET_SANDBOX_PROTECTION:
                list.addAll(getSandBoxNumber(data.Player, game));
                break;

            case GET_EFFECT: {
                int len = 0;
                switch (Place.create(data.Zone[0])) {
                    case PERSONNEL_FILE:
                        len = game.personnelEffectNumber(data.Player ? 0 : 1);
                        break;
                    case TALES:
                        len = game.taleEffectNumber(data.Player ? 0 : 1, data.Coordinate[0][0]);
                        break;
                    case SITE:
                        len = game.siteEffectNumber(data.Player ? 0 : 1, data.Coordinate[0][0]);
                }
                list.addAll(getEffect(game, len));
                break;
            }

            case ACTIVE_EFFECT: {
                Place pl = game.getSelectEffectPlace();
                Card select = game.getSelectEffect();
                boolean canSelect = game.selectedEffect(data.Index);

                if (canSelect && pl == TALES) {
                    list.addAll(activeTale(data.Player, select.getName(), select.getNumber()));
                }
                break;
            }
            case DECOMMISSION: {
                Card card = game.decommission(data.Player ? 0 : 1, create(data.Zone[0]), data.Coordinate[0][0]);
                list.addAll(decommission(data.Player, data.Zone[0], data.Coordinate[0][0], card));
                break;
            }

            case HEAL_SANDBOX: {
                int point = game.healSandBox(data.Player ? 0 : 1, data.SandBox, data.Point[0]);
                list.addAll(heal(data.Player, data.SandBox, point));
                break;
            }

            case DAMAGE_SANDBOX: {
                Pair<Integer, Scp> result = game.damage(data.Player ? 1 : 0, data.SandBox, data.Point[0]);
                list.addAll(damage(data.Player, data.SandBox, data.Point[0], -1));

                if (result.getValue() != null) {
                    list.addAll(startBreach(result.getValue(), true));
                }
                list.addAll(checkK_Class(game));
                break;
            }

            case GET_CARD_PARAMETER: {
                Scp scp = (Scp) game.getCard(data.Player ? 0 : 1, data.Zone[0], data.Coordinate[0][0]);
                list.addAll(getCardParam(data.Player, data.Coordinate[0][0], scp));
                break;
            }

            case SELECT_EFFECT:
                game.sortWaitingEffects(data.Order);
                break;
        }

        if (!game.effectIsSorted() && game.hasWaitEffects()) {
            Card[] cards = game.getWaitingEffectsCard();
            if (cards.length > 1) {
                list.addAll(selectingEffect(cards));
            }
        }

        do {
            Result[] r = null;
            if (!game.isOnActiveEffect() && game.hasWaitEffects()) {
                r = game.activeEffects(null, null);
                if (r != null) {
                    list.addAll(
                            sendEffectResult(game, data, r));
                }
            }
        } while (game.hasWaitEffects() && !game.isOnActiveEffect());

        String enemy = game.getEnemyName(data.Player ? 0 : 1);
        String me = game.getMyName(data.Player ? 0 : 1);

        list.addAll(checkK_Class(game));

        for (Pair<String, String> e : list) {
            switch (e.getKey()) {
                case "me":
                    send(me, e.getValue());
                    logger.info("me\n: " + e.getValue());
                    ////System.out.println();
                    break;
                case "enemy":
                    send(enemy, e.getValue());
                    logger.info("enemy:\n " + e.getValue());
                    break;
            }
        }
    }

    private List<Pair<String, String>> sendEffectResult(Game game, Data data, Result[] st) throws IOException {
        List<Pair<String, String>> list = new LinkedList<>();
        for (Result r : st) {
            if (r == null) {
                list.addAll(failEffect());
                continue;
            }
            switch (r.getAction()) {
                case "Decommission":
                    list.addAll(decommission(
                            r.getSubject().getPlayerNumber() == 0,
                            r.getObjectPlace()[0].toString(),
                            r.getResInt()[0],
                            r.getObject()[0]
                    ));
                    break;

                case "ReContainment":
                    list.addAll(reContainMent(
                            r.getSubject().getPlayerNumber() == 0,
                            r.getSubject(),
                            r.getSubjectPlace(),
                            r.getObjectPlace()[0],
                            r.getResInt()[0]
                    ));
                    break;

                case "finish":
                    if (r.getSubjectPlace() == TALES) {
                        list.addAll(decommission(r.getSubject().getPlayerNumber() == 0, TALES.toString(), r.getResInt()[0], r.getSubject()));
                    }
                    break;

                case "K-class":
                    list.addAll(checkK_Class(game));
                    break;

                case "Breach":
                    list.addAll(selectBreach(r.getAction(), r.getResInt()[0] == 0));
                    break;
                case "Select":
                    int len = r.getResStr().length > 2 ? 2 : 1;
                    int[][] coordinate = new int[len][];

                    if (len == 2) {
                        int plen = Integer.parseInt(r.getResStr()[2]);

                        coordinate[0] = new int[plen];
                        for (int i = 0; i < plen; i++) {
                            coordinate[0][i] = r.getResInt()[i];
                        }

                        int elen = r.getResInt().length - plen;
                        coordinate[1] = new int[elen];

                        for (int i = 0; i < elen; i++) {
                            coordinate[1][i] = r.getResInt()[i + plen];
                        }
                    } else {
                        coordinate[0] = r.getResInt();
                    }

                    list.addAll(select(Integer.parseInt(r.getResStr()[2]) == 0, r.getAction(), r.getSubjectPlace().toString(), coordinate));
                    break;

                case "healSandBox":
                case "HealSandBox":
                case "DamageSandBox":
                    list.addAll(
                            changeProtectionEffect(
                                    r.getResInt()[1] == 0,
                                    r.getAction(),
                                    r.getResInt()[0],
                                    r.getResInt()[2],
                                    Boolean.valueOf(r.getResStr()[0])));
                    break;

                default:
                    break;
            }
        }
        list.addAll(checkK_Class(game));
        return list;
    }

    private void send(final String name, final String str) throws IOException {
        session.get(name).getBasicRemote().sendText(str);
    }


    public Deck getDeck(String id, String deckName) {
        try {
            DSLContext con = connectionDB();
            String txt = null;
            ////System.out.println(id);
            ////System.out.println(deckName);
            for (org.jooq.Record r :
                    con.select().from(DECK)
                            .where(DECK.ID.eq(id))
                            .and(DECK.NAME.eq(deckName))
                            .fetch()) {
                txt = r.getValue(DECK.DECK_);
                ////System.out.println(txt);
                break;
            }
            return (new Gson()).fromJson(txt, Deck.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Deck();
    }

}
