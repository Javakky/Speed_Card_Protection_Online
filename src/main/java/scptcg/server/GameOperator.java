package scptcg.server;

import scptcg.game.Game;
import scptcg.game.K_ClassScenario;
import scptcg.game.Place;
import scptcg.game.card.Card;
import scptcg.game.card.Scp;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static scptcg.game.Place.*;

public class GameOperator {

    public static List<Map.Entry<String, String>> selectBreach(String action, int player) {
        StringBuilder sb = new StringBuilder();
        sb.append(action)
                .append("\n")
                .append(player)
                .append("\n");
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> selectingEffect(Card[] cards) {
        StringBuilder sb_1 = new StringBuilder();
        StringBuilder sb_2 = new StringBuilder();
        sb_1.append("selectEffect\n");
        for (int i = 0; i < cards.length; i++) {
            sb_1.append(cards[i].getName());
            sb_2.append(cards[i].getPlace().toString());
            if (i == cards.length - 1) continue;
            sb_1.append(",");
            sb_2.append(",");
        }
        sb_1.append("\n")
                .append(sb_2);
        return toListMe(sb_1.toString());
    }


    public static List<Map.Entry<String, String>> changeProtectionEffect(final int player, final String action, final int point, final int count, final String overlap) {
        StringBuilder sb = new StringBuilder();
        sb.append(action)
                .append("\n")
                .append(player)
                .append("\n")
                .append(point)
                .append("\n")
                .append(count)
                .append("\n")
                .append(overlap);
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> select(final int player, final String action, final String place, int[][] coordinate) {
        StringBuilder sb = new StringBuilder();
        sb.append("Select")
                .append(action)
                .append("\n")
                .append(player)
                .append("\n")
                .append(place)
                .append("\n");
        for (int i = 0; i < coordinate.length; i++) {
            for (int j = 0; j < coordinate[i].length; j++) {
                sb.append(coordinate[i]);
                if (j == coordinate[i].length - 1) {
                    continue;
                }
                sb.append(",");
            }
            sb.append("\n");
        }
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> getMyDeck(final int player, final int clazz, final Game game) {
        String[] txt = game.getMyDeckList(player, clazz);
        StringBuilder sb = new StringBuilder();
        sb.append("getMyDeck\n");
        for (String s : txt) {
            if (s != null) {
                sb.append(s)
                        .append("\n");
            }
        }
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> getDecommission(final int player, final Game game) {
        String[] txt = game.getDecommissioned(player);
        StringBuilder sb = new StringBuilder();
        sb.append("getDecommissioned\n");
        for (String s : txt) {
            if (s != null) {
                sb.append(s).append("\n");
            }
        }
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> getCanPartners(final int player, final Game game) {
        StringBuilder sb = new StringBuilder();
        sb.append("getCanPartners\n");
        String[] str = game.getPartnerList(player);
        for (String s : str) {
            sb.append(s).append("\n");
        }
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> selectPartner(final int coordinate, final Scp scp) {
        StringBuilder sb = new StringBuilder();
        sb.append("selectPartner\n")
                .append(scp.getName())
                .append("\n")
                .append(coordinate)
                .append("\n");
        System.out.println(sb.toString());
        List m = toListMe(sb.toString() + "true");
        m.addAll(toListEnemy(sb.toString() + "false"));
        return m;
    }

    public static List<Map.Entry<String, String>> getEmptysite(final int player, final Game game) {
        int[] li = game.getEmptySite(player);
        StringBuilder sb = new StringBuilder();
        sb.append("getEmptySite\n")
                .append(li.length).append("\n");
        for (int i : li) {
            sb.append(i).append("\n");
        }
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> canAttack(final int player, final int coordinate, final Game game) {
        StringBuilder sb = new StringBuilder();
        sb.append("canAttack\n")
                .append(game.canAttack(player, coordinate));
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> breach(final int player, int coordinate, final Scp scp) {
        StringBuilder sb = new StringBuilder();
        sb.append("breach\n")
                .append(scp.getName())
                .append("\n")
                .append(coordinate)
                .append("\n")
                .append(player)
                .append("\n");
        System.out.println(sb.toString());
        return toListBoth(sb.toString());
    }

    public static List<Map.Entry<String, String>> turnEnd(final Game game) {
        StringBuilder sb = new StringBuilder();
        sb.append("turnEnd\n")
                .append(game.getTurn());
        return toListBoth(sb.toString());
    }

    public static List<Map.Entry<String, String>> getPersonnel(final int player, final Game game) {
        String[] str = game.getPersonnel();
        StringBuilder sb = new StringBuilder();
        sb.append("getPersonnel\n")
                .append(str[player])
                .append("\n")
                .append(str[player == 0 ? 1 : 0])
                .append("\n");
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> getTale(final int player, final Game game) {
        StringBuilder sb = new StringBuilder();
        sb.append("getTale\n");
        String[] str = game.getTale(player);
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i])
                    .append("\n");
        }
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> getCost(final int player, final Game game) {
        StringBuilder sb = new StringBuilder();
        sb.append("getCost\n")
                .append(game.getCost(player))
                .append("\n")
                .append(game.getCost(player == 0 ? 1 : 0))
                .append("\n");
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> getSiteNumber(final int player, final Game game) {
        StringBuilder sb = new StringBuilder();
        sb.append("getSiteNumber\n")
                .append(game.getSiteNumber(player))
                .append("\n");
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> getSandBoxNumber(final int player, final Game game) {
        int[] arr = game.getSandBoxNumber(player);
        StringBuilder sb = new StringBuilder();
        sb.append("getSandBoxNumber\n")
                .append(player)
                .append("\n")
                .append(arr[0])
                .append("\n")
                .append(arr[1])
                .append("\n")
                .append(arr[2])
                .append("\n");
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> getEffect(final Game game, final int length) {
        StringBuilder sb = new StringBuilder();
        sb.append("getEffect\n");
        sb.append(length);
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> activeTale(final int player, final String name, final int coordinate) {
        StringBuilder sb = new StringBuilder();
        sb.append("activeTale\n")
                .append(player)
                .append("\n")
                .append(name)
                .append("\n")
                .append(coordinate);
        return toListBoth(sb.toString());
    }

    public static List<Map.Entry<String, String>> failEffect() {
        return toListMe("failEffect\n");
    }

    public static List<Map.Entry<String, String>> heal(final int player, final int coordinate, final int point) {
        StringBuilder sb = new StringBuilder();
        sb.append("HealSandBox\n")
                .append(player)
                .append("\n")
                .append(point)
                .append("\n")
                .append(coordinate)
                .append("\n");
        return toListBoth(sb.toString());
    }

    public static List<Map.Entry<String, String>> damage(final int player, final int coordinate, final int point, final int atkCoordinate) {
        StringBuilder sb = new StringBuilder();
        sb.append("damage\n")
                .append(player)
                .append("\n")
                .append(point)
                .append("\n")
                .append(atkCoordinate)
                .append("\n")
                .append(coordinate)
                .append("\n");
        return toListBoth(sb.toString());
    }

    public static List<Map.Entry<String, String>> startBreach(final Scp scp, final boolean isMe) {
        StringBuilder sb = new StringBuilder();
        sb.append("breaching\n")
                .append(scp.getName());
        List m;
        if (!isMe) {
            m = toListMe("breachWait\n");
            m.addAll(toListEnemy(sb.toString()));
        } else {
            m = toListEnemy("breachWait\n");
            m.addAll(toListMe(sb.toString()));
        }
        return m;
    }

    public static List<Map.Entry<String, String>> isFirst(final Game game, final String name) {
        StringBuilder sb = new StringBuilder();
        sb.append("isFirst\n")
                .append(String.valueOf(game.isFirst(name)));
        return toListMe(sb.toString());
    }

    public static List<Map.Entry<String, String>> reContainMent(final int player, final Card subject, final Place before,
                                                                final Place after, final int coordinate) {
        StringBuilder sb = new StringBuilder();
        sb.append("ReContainment\n")
                .append(player)
                .append("\n")
                .append(before.toString())
                .append("\n")
                .append(0)
                .append("\n")
                .append(after.toString())
                .append("\n")
                .append(coordinate)
                .append("\n")
                .append(subject.getName());
        if (before == DECOMMISSIONED) {
            Card c = subject.getMyPlayer().getDecommissionedTop();
            if (c != null) {
                sb.append("\n");
                sb.append(c.getName());
            }
        }
        return toListBoth(sb.toString());
    }

    public static List<Map.Entry<String, String>> decommission(final int player, final String place, final int coordinate,
                                                               final Card card) {
        StringBuilder sb = new StringBuilder();
        sb.append("Decommission\n")
                .append(player)
                .append("\n")
                .append(place)
                .append("\n")
                .append(coordinate)
                .append("\n")
                .append(card.getName());
        return toListBoth(sb.toString());
    }

    public static List<Map.Entry<String, String>> checkK_Class(final Game ga) {
        K_ClassScenario k = ga.isK_ClassScenario();
        if (k != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("K-Class-Scenario\n")
                    .append(k.toString())
                    .append("\n")
                    .append(ga.getKClassPlayer())
                    .append("\n");
            return toListBoth(sb.toString());
        }
        return new LinkedList<>();
    }

    public static List<Map.Entry<String, String>> getCardParam(final int player, final int index, final Scp scp) {
        StringBuilder sb = new StringBuilder();
        sb.append("getCardParam\n");
        sb.append(player);
        sb.append("\n");
        sb.append(index);
        sb.append("\n");
        sb.append(scp.getCost());
        sb.append("\n");
        sb.append(scp.getSecure());
        sb.append("\n");
        return toListBoth(sb.toString());
    }

    static List<Map.Entry<String, String>> toListMe(final List<String> list_1) {
        List<Map.Entry<String, String>> list = new LinkedList<>();
        for (String str : list_1) {
            list.add(new AbstractMap.SimpleEntry("me", str));
        }
        return list;
    }

    static List<Map.Entry<String, String>> toListEnemy(final List<String> list_1) {
        List<Map.Entry<String, String>> list = new LinkedList<>();
        for (String str : list_1) {
            list.add(new AbstractMap.SimpleEntry("enemy", str));
        }
        return list;
    }

    static List<Map.Entry<String, String>> toListBoth(final List<String> list_1) {
        List<Map.Entry<String, String>> list = new LinkedList<>();
        for (String str : list_1) {
            list.add(new AbstractMap.SimpleEntry("me", str));
            list.add(new AbstractMap.SimpleEntry("enemy", str));
        }
        return list;
    }

    static List<Map.Entry<String, String>> toListBoth(final List<String> list_1, final List<String> list_2) {
        List<Map.Entry<String, String>> list = new LinkedList<>();
        for (String str : list_1) {
            list.add(new AbstractMap.SimpleEntry("me", str));
        }
        for (String str : list_2) {
            list.add(new AbstractMap.SimpleEntry("enemy", str));
        }
        return list;
    }

    static List<Map.Entry<String, String>> toListMe(final String str) {
        List<Map.Entry<String, String>> list = new LinkedList<>();
        list.add(new AbstractMap.SimpleEntry("me", str));
        return list;
    }

    static List<Map.Entry<String, String>> toListEnemy(final String str) {
        List<Map.Entry<String, String>> list = new LinkedList<>();
        list.add(new AbstractMap.SimpleEntry("enemy", str));
        return list;
    }

    static List<Map.Entry<String, String>> toListBoth(final String str) {
        List<Map.Entry<String, String>> list = new LinkedList<>();
        list.add(new AbstractMap.SimpleEntry("me", str));
        list.add(new AbstractMap.SimpleEntry("enemy", str));
        return list;
    }
}
