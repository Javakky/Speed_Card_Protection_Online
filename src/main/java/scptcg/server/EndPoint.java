package scptcg.server;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import scptcg.game.CreateGame;
import scptcg.game.Game;
import scptcg.game.Place;
import scptcg.game.card.Card;
import scptcg.game.card.Scp;
import scptcg.game.effect.Effect;
import scptcg.game.effect.Result;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import static jooq.scp_tcg.tables.Deck.*;
import static org.apache.logging.log4j.Level.*;
import static scptcg.server.GameOperator.*;
import static scptcg.game.Place.*;
import static scptcg.server.DeckMakeServlet.*;

@ServerEndpoint("/ws")
public final class EndPoint {

    private static Map<String, Session> session = new HashMap<>();
    private static List<Game> game = new ArrayList<>();
    private static Map<String, Integer> id = new HashMap<>();
    private static boolean wait = false;
    private static String waiting;
    private static String waitingDeck;
    private Logger logger;
    {
        logger = LogManager.getLogger(EndPoint.class);
    }

    @OnOpen
    public void onOpen(final Session client, final EndpointConfig config) {
        String log = client.getId() + " was connected.";
        System.out.println(log);
        logger.log(INFO, log);
    }

    @OnClose
    public void onClose(final Session client, final CloseReason reason) throws IOException {
        String log = client.getId() + " was closed by "
                + reason.getCloseCode() + "[" + reason.getCloseCode().getCode() + "]";
        System.out.println(log);
        logger.log(INFO, log);
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
        logger.log(ERROR, log);
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
        try{
            String t = text.replaceAll("\n", "");
            Data data = (new Gson()).fromJson(t, Data.class);
            //System.out.println(data.event);
            System.out.println(data);
            logger.log(INFO, data.event);

            if (data.event.equals("Login")) {
                login(data.player, data.name[0], client);
            } else {
                main(data.event, data);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.log(ERROR, e.getMessage());
        }
    }

    private void main(final String event, final Data data) throws IOException {
        List<Map.Entry<String, String>> list = new LinkedList<>();
        Game game = this.game.get(id.get(data.player));
        switch (event) {
            case "isFirst":
                list.addAll(isFirst(game, data.player));
                break;

            case "getMyDeck":
                list.addAll(getMyDeck(data.isFirst, data.ObjectClass, game));
                break;

            case "getDecommissioned":
                list.addAll(getDecommission(data.isFirst, game));
                break;

            case "getCanPartners":
                list.addAll(getCanPartners(data.isFirst, game));
                break;

            case "selectPartner":
                Scp scp = game.selectPartner(data.isFirst, data.name[0], data.place[0]);
                list.addAll(selectPartner(data.place[0], scp));
                list.addAll(getCardParam(data.isFirst, data.place[0], scp));
                break;

            case "getEmptySite":
                list.addAll(getEmptysite(data.isFirst, game));
                break;

            case "crossTest":
            case "damage":
                Map.Entry<Integer, Scp> result;
                int player = -1;
                if (data.event.equals("damage")) {
                    //System.out.println(data.isFirst + " " + data.place[0] + " " + data.name[0]);
                    result = game.damage(data.isFirst, data.place[0], Integer.parseInt(data.name[0]));
                    player = data.isFirst;
                } else {
                    result = game.crossTest(data.isFirst, data.place[0], data.place[1]);
                    player = data.isFirst == 0 ? 1 : 0;
                }
                Integer damage = result.getKey();
                Scp wait = result.getValue();
                list.addAll(damage(player,
                        data.place[data.place.length >= 2 ? 1 : 0],
                        damage,
                        data.place.length >= 2 ? data.place[0] : -1));

                if (wait != null) {
                    list.addAll(startBreach(wait, player == data.isFirst));
                }

                list.addAll(checkK_Class(game));
                break;

            case "canAttack":
                list.addAll(canAttack(data.isFirst, data.place[0], game));
                break;

            case "breach":
                scp = game.breach(data.isFirst, data.place[0]);
                list.addAll(breach(data.isFirst, data.place[0], scp));
                list.addAll(getCardParam(data.isFirst, data.place[0], scp));
                list.addAll(checkK_Class(game));
                break;

            case "turnEnd":
                game.nextTurn();
                list.addAll(turnEnd(game));
                break;

            case "getPersonnel":
                list.addAll(getPersonnel(data.isFirst, game));
                break;

            case "getTale":
                list.addAll(getTale(data.isFirst, game));
                break;

            case "getCost":
                list.addAll(getCost(data.isFirst, game));
                break;

            case "getSiteNumber":
                list.addAll(getSiteNumber(data.isFirst, game));
                break;

            case "getSandBoxNumber":
                list.addAll(getSandBoxNumber(data.isFirst, game));
                break;

            case "getEffect":
                int len = 0;
                switch (data.name[0]) {
                    case "PersonnelFiles":
                        len = game.personnelEffectNumber(data.isFirst);
                        break;
                    case "Tales":
                        len = game.taleEffectNumber(data.isFirst, data.place[0]);
                        break;
                    case "Site":
                        len = game.siteEffectNumber(data.isFirst, data.place[0]);
                }
                list.addAll(getEffect(game, len));
                break;

            case "activeEffect":
                Place pl = game.getSelectEffectPlace();
                String efctNm;
                int index;
                Card select = game.getSelectEffect();

                if (pl == TALES) {
                    index = game.find(data.isFirst, TALES, select);
                    efctNm = select.getName();
                }

                boolean canSelect = game.selectedEffect(data.place[0]);

                if (canSelect && pl == TALES) {
                    list.addAll(activeTale(data.isFirst, select.getName(), select.getNumber()));
                }

                break;

            case "decommission":
                Card card = game.decommission(data.isFirst, data.name[0], data.place[0]);
                list.addAll(decommission(data.isFirst, data.name[0], data.place[0], card));
                break;

            case "HealSandBox":
                //System.out.print(data.toString());
                int point = game.healSandBox(Integer.parseInt(data.name[1]), data.place[0], Integer.parseInt(data.name[2]));
                list.addAll(heal(data.isFirst, data.place[0], point));
                break;

            case "damageSandBox":
                result = game.damage(Integer.parseInt(data.name[1]) == 0 ? 1 : 0, data.place[0], Integer.parseInt(data.name[0]));
                list.addAll(damage(Integer.parseInt(data.name[1]), data.place[0], Integer.parseInt(data.name[0]), -1));

                if (result.getValue() != null) {
                    list.addAll(startBreach(result.getValue(), true));
                }
                list.addAll(checkK_Class(game));
                break;

            case "getCardParam":
                scp = (Scp) game.getCard(data.isFirst, data.name[0], data.place[0]);
                list.addAll(getCardParam(data.isFirst, data.place[0], scp));
                break;

            case "selectEffect":
                game.sortWaitingEffects(data.place);
                break;
        }

        boolean flg = true;
        if (!game.isOnActive() && game.hasWaitEffects()) {
            Card[] cards = game.getWaitingEffectsCard();
            if (cards.length > 1) {
                list.addAll(selectingEffect(cards));
                flg = false;
            }
        }

        if (flg && !game.isOnActiveEffect() && game.hasWaitEffects()) {
            Result[] r = game.activeEffects(null, null);
            for (Result res:r
                 ) {
                //System.out.println("active:" + res.getAction());
            }
            list.addAll(
                    sendEffectResult(game, data, r));
        }

        String enemy = game.getEnemyName(data.player);
        String me = data.player;

        for (Map.Entry<String, String> e : list) {
            switch (e.getKey()) {
                case "me":
                    send(me, e.getValue());
                    System.out.println("send = [me: " + e.getValue() + "\n]");
                    break;
                case "enemy":
                    send(enemy, e.getValue());
                    System.out.println("send = [enemy: " + e.getValue() + "\n]");
                    break;
            }
        }
    }

    private List<Map.Entry<String, String>> sendEffectResult(Game game, Data data, Result[] st) throws IOException {
        List<Map.Entry<String, String>> list = new LinkedList<>();
        for (Result r : st) {
            if (r == null) {
                //list.addAll(failEffect());
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
                    if (r.resStr != null && r.resStr.length > 0 && r.resStr[0] != null) {
                        String times = null;
                        switch (r.resStr[0]) {
                            case "once":
                                break;
                            case "twice":
                                times = "once";
                                break;
                            case "notFullSite":
                                times = "notFullSite";
                                break;
                        }
                        if (times != null) {
                            Map<String, String[]> map = new HashMap<>();
                            map.put(r.getAction(), new String[]{
                                    r.resStr[0],
                                    r.resStr[1],
                                    "select"
                            });
                            game.addEffects(
                                    new Effect(
                                            "",
                                            "force",
                                            1,
                                            true,
                                            null,
                                            map
                                    )
                            );
                        }
                    }
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
                                    r.resInt[0],
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


    public String[][] getDeck(String id, String deckName) {
        try {
            DSLContext con = connectionDB();
            String txt = null;
            //System.out.println(id);
            //System.out.println(deckName);
            for (org.jooq.Record r :
                    con.select().from(DECK)
                            .where(DECK.ID.eq(id))
                            .and(DECK.NAME.eq(deckName))
                            .fetch()) {
                txt = r.getValue(DECK.DECK_);
                //System.out.println(txt);
                break;
            }
            Deck json = (new Gson()).fromJson(txt, Deck.class);
            return new String[][]{json.Safe, json.Euclid, json.Keter, json.Tale, json.Personnel, json.Anomalous, json.Exclusion};
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new String[7][0];
    }

    static class Deck {
        public String[] Personnel;
        public String[] Tale;
        public String[] Anomalous;
        public String[] Exclusion;
        public String[] Safe;
        public String[] Keter;
        public String[] Euclid;
    }

    public class Data {
        public String[] name;
        public String player;
        int[] place;
        String event;
        int isFirst;
        int ObjectClass;
        String effect;

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("receive = [\tplayer:")
                    .append(player)
                    .append("\n\tevent:")
                    .append(event)
                    .append("\n\tisFirst:")
                    .append(isFirst)
                    .append("\n\tname:")
                    .append(Arrays.toString(name))
                    .append("\n\tplace:")
                    .append(Arrays.toString(place))
                    .append("\n]");
            return sb.toString();
        }
    }
}
