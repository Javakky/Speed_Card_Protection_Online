package scptcg.server;

import org.apache.commons.lang3.tuple.Pair;
import scptcg.game.Game;
import scptcg.game.K_ClassScenario;
import scptcg.game.Place;
import scptcg.game.card.Card;
import scptcg.game.card.Scp;
import scptcg.json.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static scptcg.game.Place.*;

public class GameOperator {

    public static List<Pair<String, String>> selectBreach(String action, boolean player) {
        Data d = new Data();
        d.Event = action;
        d.Player = player;
        return toListMe(d.toJson());
    }

    public static List<Pair<String, String>> selectingEffect(Card[] cards) {
        String[] card = new String[cards.length];
        String[] place = new String[cards.length];
        for (int i = 0; i < cards.length; i++) {
            card[i] = cards[i].getName();
            place[i] = cards[i].getPlace().toString();
        }
        Data d = new Data();
        d.Zone = place;
        d.CardName = card;
        return toListMe(d.toJson());
    }


    public static List<Pair<String, String>> changeProtectionEffect(final boolean player, final String action, final int point, final int count, final boolean overlap) {
        Data d = new Data();
        d.Event = action;
        d.Player = player;
        d.Point = new int[]{point};
        d.Count = count;
        d.BeAbleTo = overlap;

        return toListMe(d.toJson()
        );
    }

    public static List<Pair<String, String>> select(final boolean player, final String action, final String place, int[][] coordinate) {
        Data d = new Data();
        d.Event = action;
        d.Player = player;
        d.Zone = new String[1];
        d.Zone[0] = place;
        d.Coordinate = coordinate;

        return toListMe(d.toJson());
    }

    public static List<Pair<String, String>> getMyDeck(final boolean player, final int clazz, final Game game) {
        List<String> card = new ArrayList<>();
        for (String s : game.getMyDeckList(player ? 0 : 1, clazz)) {
            if (s != null) card.add(s);
        }
        Data d = new Data();
        d.Event = "GetMyDeck";
        d.CardName = card.toArray(new String[card.size()]);
        return toListMe(d.toJson());
    }

    public static List<Pair<String, String>> getDecommission(final boolean player, final Game game) {
        List<String> cards = new ArrayList<>();
        for (String s : game.getDecommissioned(player ? 0 : 1)) {
            if (s != null) cards.add(s);
        }
        Data data = new Data();
        data.Event = "GetDecommissioned";
        data.CardName = cards.toArray(new String[cards.size()]);
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> getCanPartners(final boolean player, final Game game) {
        Data data = new Data();
        data.Event = "GetCanPartners";
        data.CardName = game.getPartnerList(player ? 0 : 1);
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> selectPartner(final int coordinate, final Scp scp) {
        Data data = new Data();
        data.Event = "selectPartner";
        data.CardName = new String[]{scp.getName()};
        data.Coordinate = new int[][]{{coordinate}};
        data.Player = true;
        List m = toListMe(data.toJson());
        data.Player = false;
        m.addAll(toListEnemy(data.toJson()));
        return m;
    }

    public static List<Pair<String, String>> getEmptysite(final boolean player, final Game game) {
        int[] li = game.getEmptySite(player ? 0 : 1);
        Data data = new Data();
        data.Event = "getEmptySite";
        data.Coordinate = new int[][]{li};
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> canAttack(final boolean player, final int coordinate, final Game game) {
        Data data = new Data();
        data.Event = "CanAttack";
        data.BeAbleTo = game.canAttack(player ? 0 : 1, coordinate);
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> breach(final boolean player, int coordinate, final Scp scp) {
        Data data = new Data();
        data.Event = "ViewBreach";
        data.CardName = new String[]{scp.getName()};
        data.Coordinate = new int[][]{{coordinate}};
        data.Player = player;
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> turnEnd(final Game game) {
        Data data = new Data();
        data.Event = "TurnEnd";
        data.Player = game.getTurn() == 0;
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> getPersonnel(final boolean player, final Game game) {
        Data data = new Data();
        data.CardName = new String[]{game.getPersonnel()[player ? 0 : 1]};
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> getTale(final boolean player, final Game game) {
        Data data = new Data();
        data.Event = "GetTale";
        data.CardName = game.getTale(player ? 0 : 1);
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> getCost(final boolean player, final Game game) {
        Data data = new Data();
        data.Event = "GetCost";
        data.Cost = game.getCost(player ? 0 : 1);
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> getSiteNumber(final boolean player, final Game game) {
        Data data = new Data();
        data.Event = "GetSCPCount";
        data.Count = game.getSiteNumber(player ? 0 : 1);
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> getSandBoxNumber(final boolean player, final Game game) {
        int[] arr = game.getSandBoxNumber(player ? 0 : 1);
        Data data = new Data();
        data.Event = "GetSandBoxProtection";
        data.Player = player;
        data.Point = arr;
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> getEffect(final Game game, final int length) {
        Data data = new Data();
        data.Event = "GetEffectCount";
        data.Count = length;
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> activeTale(final boolean player, final String name, final int coordinate) {
        Data data = new Data();
        data.Event = "ActiveTale";
        data.Player = player;
        data.CardName = new String[]{name};
        data.Coordinate = new int[][]{{coordinate}};
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> failEffect() {
        Data data = new Data();
        data.Event = "Impossible";
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> heal(final boolean player, final int coordinate, final int point) {
        Data data = new Data();
        data.Event = "HealSandBox";
        data.Player = player;
        data.Point = new int[]{point};
        data.Coordinate = new int[][]{{coordinate}};
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> damage(final boolean player, final int coordinate, final int point, final int atkCoordinate) {
        Data data = new Data();
        data.Event = "Damage";
        data.Player = player;
        data.Point = new int[]{point};
        data.Coordinate = new int[][]{{atkCoordinate}};
        data.SandBox = coordinate;
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> startBreach(final Scp scp, final boolean isMe) {
        Data data = new Data();
        data.Event = "SelectBreach";
        data.CardName = new String[]{scp.getName()};
        Data data2 = new Data();
        List m;
        if (!isMe) {
            data2.Event = "Wait";
            m = toListMe(data2.toJson());
            m.addAll(toListEnemy(data.toJson()));
        } else {
            data2.Event = "Wait";
            m = toListEnemy(data2.toJson());
            m.addAll(toListMe(data.toJson()));
        }
        return m;
    }

    public static List<Pair<String, String>> isFirst(final Game game, final String name) {
        Data data = new Data();
        data.Event = "IsFirst";
        data.Player = game.isFirst(name);
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> reContainMent(final boolean player, final Card subject, final Place before,
                                                           final Place after, final int coordinate) {
        Data data = new Data();
        data.Event = "ReContainment";
        data.Player = player;
        data.Coordinate = new int[][]{{0, coordinate}};
        data.Zone = new String[]{before.toString(), after.toString()};
        if (before == DECOMMISSIONED) {
            Card c = subject.getMyPlayer().getDecommissionedTop();
            data.CardName = new String[]{subject.getName(), c.getName()};
        } else {
            data.CardName = new String[]{subject.getName()};
        }
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> decommission(final boolean player, final String place, final int coordinate,
                                                          final Card card) {
        Data data = new Data();
        data.Event = "Decommission";
        data.Player = player;
        data.Coordinate = new int[][]{{coordinate}};
        data.CardName = new String[]{card.getName()};
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> checkK_Class(final Game ga) {
        K_ClassScenario k = ga.isK_ClassScenario();
        if (k != null) {
            Data data = new Data();
            data.Event = "K-Class-Scenario";
            data.Scenario = k.toString();
            data.Player = ga.getKClassPlayer() == 0;
            return toListBoth(data.toJson());
        }
        return new LinkedList<>();
    }

    public static List<Pair<String, String>> getCardParam(final boolean player, final int index, final Scp scp) {
        Data data = new Data();
        data.Event = "GetCardParameter";
        data.Player = player;
        data.Coordinate = new int[][]{{index}};
        data.Cost = scp.getCost();
        data.Secure = scp.getSecure();
        return toListBoth(data.toJson());
    }

    static List<Pair<String, String>> toListMe(final List<String> list_1) {
        List<Pair<String, String>> list = new LinkedList<>();
        for (String str : list_1) {
            list.add(Pair.of("me", str));
        }
        return list;
    }

    static List<Pair<String, String>> toListEnemy(final List<String> list_1) {
        List<Pair<String, String>> list = new LinkedList<>();
        for (String str : list_1) {
            list.add(Pair.of("enemy", str));
        }
        return list;
    }

    static List<Pair<String, String>> toListBoth(final List<String> list_1) {
        List<Pair<String, String>> list = new LinkedList<>();
        for (String str : list_1) {
            list.add(Pair.of("me", str));
            list.add(Pair.of("enemy", str));
        }
        return list;
    }

    static List<Pair<String, String>> toListBoth(final List<String> list_1, final List<String> list_2) {
        List<Pair<String, String>> list = new LinkedList<>();
        for (String str : list_1) {
            list.add(Pair.of("me", str));
        }
        for (String str : list_2) {
            list.add(Pair.of("enemy", str));
        }
        return list;
    }

    static List<Pair<String, String>> toListMe(final String str) {
        List<Pair<String, String>> list = new LinkedList<>();
        list.add(Pair.of("me", str));
        return list;
    }

    static List<Pair<String, String>> toListEnemy(final String str) {
        List<Pair<String, String>> list = new LinkedList<>();
        list.add(Pair.of("enemy", str));
        return list;
    }

    static List<Pair<String, String>> toListBoth(final String str) {
        List<Pair<String, String>> list = new LinkedList<>();
        list.add(Pair.of("me", str));
        list.add(Pair.of("enemy", str));
        return list;
    }

}
