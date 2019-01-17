package scptcg.server;

import com.google.gson.Gson;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.jooq.DSLContext;
import scptcg.game.GM;
import scptcg.game.Game;
import scptcg.game.Place;
import scptcg.game.card.Card;
import scptcg.game.card.Scp;
import scptcg.game.effect.Result;
import scptcg.json.Data;
import scptcg.json.Deck;
import scptcg.log.Log4j;
import scptcg.log.Logger;
import type.Union;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import static jooq.scp_tcg.tables.Deck.*;
import static scptcg.game.Place.*;
import static scptcg.server.DeckMakeServlet.*;
import static scptcg.server.GameOperator.*;

@ServerEndpoint("/ws")
public final class EndPoint {

    private static Map<String, Session> session = new HashMap<>();
    private static List<GM> game = new ArrayList<>();
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
        System.out.println(log);
        logger.info(log);
    }

    @OnClose
    public void onClose(final Session client, final CloseReason reason) throws IOException {
        String log = client.getId() + " was closed by "
                + reason.getCloseCode() + "[" + reason.getCloseCode().getCode() + "]";
        System.out.println(log);
        logger.info(log);
        cutConnection(getId(client));
    }

    void cutConnection(final String id) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("K-Class-Scenario\n");
        sb.append("IK");
        sb.append("\n");
        try {
            Game ga = game.get(EndPoint.id.get(id)).getGame();
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
            game.add(new GM(waiting, getDeck(waiting, waitingDeck), player, getDeck(player, name)));
            send(waiting, sb.toString());
            waiting = null;
        }
        id.put(player, game.size() > 0 ? game.size() - 1 : 0);
        send(player, sb.toString());
    }

    @OnMessage
    public void onMessage(final String text, final Session client) throws IOException {
        try {
            String t = text.replaceAll("\n", "");
            Data data = (new Gson()).fromJson(t, Data.class);
            System.out.println(data.event);
            System.out.println(data);
            logger.info(data.toString());

            if (data.event.equals("Login")) {
                login(data.player, data.name[0], client);
            } else {
                main(data.event, data);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    private void main(final String event, final Data data) throws IOException {
        List<Pair<String, String>> list = new LinkedList<>();
        GM gm = game.get(id.get(data.player));
        switch (event) {
            case "isFirst":
                list.addAll(isFirst(gm.getGame(), data.player));
                break;

            case "getMyDeck":
                list.addAll(getMyDeck(data.isFirst, data.ObjectClass, gm.getGame()));
                break;

            case "getDecommissioned":
                list.addAll(getDecommission(data.isFirst, gm.getGame()));
                break;

            case "getCanPartners":
                list.addAll(getCanPartners(data.isFirst, gm.getGame()));
                break;

            case "selectPartner": {
                Union<Scp> u = gm.MainProcess(data);
                Scp scp = u.getClazz().cast(u.getData());
                list.addAll(selectPartner(data.place[0], scp));
                list.addAll(getCardParam(data.isFirst, data.place[0], scp));
                break;
            }
            case "getEmptySite":
                list.addAll(getEmptysite(data.isFirst, gm.getGame()));
                break;

            case "crossTest":
            case "damage": {
                Union<Triple<Integer, Integer, Scp>> u = gm.MainProcess(data);
                Triple<Integer, Integer, Scp> result = u.getClazz().cast(u.getData());

                Integer damage = result.getMiddle();
                Scp wait = result.getRight();
                Integer player = result.getLeft();
                list.addAll(damage(player,
                        data.place[data.place.length >= 2 ? 1 : 0],
                        damage,
                        data.place.length >= 2 ? data.place[0] : -1));

                if (wait != null) {
                    list.addAll(startBreach(wait, player == data.isFirst));
                }

                list.addAll(checkK_Class(gm.getGame()));
                break;
            }

            case "canAttack":
                list.addAll(canAttack(data.isFirst, data.place[0], gm.getGame()));
                break;

            case "breach": {
                Union<Scp> u = gm.MainProcess(data);
                Scp scp = u.getClazz().cast(u.getData());
                list.addAll(breach(data.isFirst, data.place[0], scp));
                list.addAll(getCardParam(data.isFirst, data.place[0], scp));
                list.addAll(checkK_Class(gm.getGame()));
                break;
            }

            case "turnEnd":
                gm.MainProcess(data);
                list.addAll(turnEnd(gm.getGame()));
                break;

            case "getPersonnel":
                list.addAll(getPersonnel(data.isFirst, gm.getGame()));
                break;

            case "getTale":
                list.addAll(getTale(data.isFirst, gm.getGame()));
                break;

            case "getCost":
                list.addAll(getCost(data.isFirst, gm.getGame()));
                break;

            case "getSiteNumber":
                list.addAll(getSiteNumber(data.isFirst, gm.getGame()));
                break;

            case "getSandBoxNumber":
                list.addAll(getSandBoxNumber(data.isFirst, gm.getGame()));
                break;

            case "getEffect": {
                Union<Integer> u = gm.MainProcess(data);
                int len = u.getClazz().cast(u.getData());
                list.addAll(getEffect(gm.getGame(), len));
                break;
            }

            case "activeEffect": {
                Place pl = gm.getGame().getSelectEffectPlace();
                Card select = gm.getGame().getSelectEffect();
                Union<Boolean> u = gm.MainProcess(data);
                boolean canSelect = u.getClazz().cast(u.getData());

                if (canSelect && pl == TALES) {
                    list.addAll(activeTale(data.isFirst, select.getName(), select.getNumber()));
                }
                break;
            }
            case "decommission": {
                Union<Card> u = gm.MainProcess(data);
                Card card = u.getClazz().cast(u.getData());
                list.addAll(decommission(data.isFirst, data.name[0], data.place[0], card));
                break;
            }

            case "HealSandBox": {
                Union<Integer> u = gm.MainProcess(data);
                int point = u.getClazz().cast(u.getData());
                list.addAll(heal(data.isFirst, data.place[0], point));
                break;
            }

            case "damageSandBox": {
                Union<Pair<Integer, Scp>> u = gm.MainProcess(data);
                Pair<Integer, Scp> result = u.getClazz().cast(u.getData());
                list.addAll(damage(Integer.parseInt(data.name[1]), data.place[0], Integer.parseInt(data.name[0]), -1));

                if (result.getValue() != null) {
                    list.addAll(startBreach(result.getValue(), true));
                }
                list.addAll(checkK_Class(gm.getGame()));
                break;
            }

            case "getCardParam": {
                Scp scp = (Scp) gm.getGame().getCard(data.isFirst, data.name[0], data.place[0]);
                list.addAll(getCardParam(data.isFirst, data.place[0], scp));
                break;
            }

            case "selectEffect":
                gm.MainProcess(data);
                break;
        }

        boolean flg = true;
        if (!gm.getGame().isOnActive() && gm.getGame().hasWaitEffects()) {
            Card[] cards = gm.getGame().getWaitingEffectsCard();
            if (cards.length > 1) {
                list.addAll(selectingEffect(cards));
                flg = false;
            }
        }

        Result[] r = gm.activeEffect();
        if (r != null) {
            list.addAll(
                    sendEffectResult(gm.getGame(), data, r));
        }
        String enemy = gm.getGame().getEnemyName(data.player);
        String me = data.player;

        for (Pair<String, String> e : list) {
            switch (e.getKey()) {
                case "me":
                    send(me, e.getValue());
                    logger.info("me\n: " + e.getValue());
                    System.out.println();
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
                            r.subject.getPlayerNumber(),
                            r.objectPlace[0].toString(),
                            r.resInt[0],
                            r.object[0]
                    ));
                    break;

                case "ReContainment":
                    list.addAll(reContainMent(
                            r.subject.getPlayerNumber(),
                            r.subject,
                            r.subjectPlace,
                            r.objectPlace[0],
                            r.resInt[0]
                    ));
                    break;

                case "finish":
                    if (r.subjectPlace == TALES) {
                        list.addAll(decommission(r.subject.getPlayerNumber(), TALES.toString(), r.resInt[0], r.subject));
                    }
                    break;

                case "K-class":
                    list.addAll(checkK_Class(game));
                    break;

                case "Breach":
                    list.addAll(selectBreach(r.getAction(), r.resInt[0]));
                    break;
                case "Select":
                    int len = r.resStr.length > 2 ? 2 : 1;
                    int[][] coordinate = new int[len][];

                    if (len == 2) {
                        int plen = Integer.parseInt(r.resStr[2]);

                        coordinate[0] = new int[plen];
                        for (int i = 0; i < plen; i++) {
                            coordinate[0][i] = r.resInt[i];
                        }

                        int elen = r.resInt.length - plen;
                        coordinate[1] = new int[elen];

                        for (int i = 0; i < elen; i++) {
                            coordinate[1][i] = r.resInt[i + plen];
                        }
                    } else {
                        coordinate[0] = r.resInt;
                    }

                    list.addAll(select(Integer.parseInt(r.resStr[2]), r.getAction(), r.subjectPlace.toString(), coordinate));
                    break;

                case "healSandBox":
                case "HealSandBox":
                case "DamageSandBox":
                    list.addAll(
                            changeProtectionEffect(
                                    r.resInt[1],
                                    r.getAction(),
                                    r.resInt[0],
                                    r.resInt[2],
                                    r.resStr[0]));
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
            System.out.println(id);
            System.out.println(deckName);
            for (org.jooq.Record r :
                    con.select().from(DECK)
                            .where(DECK.ID.eq(id))
                            .and(DECK.NAME.eq(deckName))
                            .fetch()) {
                txt = r.getValue(DECK.DECK_);
                System.out.println(txt);
                break;
            }
            return (new Gson()).fromJson(txt, Deck.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Deck();
    }

}
