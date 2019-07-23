package scptcg.server;

import org.apache.commons.lang3.tuple.Pair;
import scptcg.game.Zone;
import scptcg.game.card.Card;
import scptcg.game.card.Personnel;
import scptcg.game.card.Scp;
import scptcg.game.card.Tale;
import scptcg.json.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static scptcg.server.Events.*;

public class SendFormatter {

    public static final int ME = 0;
    public static final int ENEMY = 1;
    public static final int BOTH = 2;

    public static List<Pair<String, String>> selectBreach(boolean player, int receiver) {
        Data d = new Data();
        d.Event = Breach.name();
        d.Player = player;
        return toList(receiver, d.toJson());
    }

    public static List<Pair<String, String>> selectBreach(boolean player) {
        return selectBreach(player, ME);
    }

    public static List<Pair<String, String>> selectingEffect(Card[] cards, int receiver) {
        String[] card = new String[cards.length];
        String[] place = new String[cards.length];
        for (int i = 0; i < cards.length; i++) {
            card[i] = cards[i].getName();
            place[i] = cards[i].whereZone().name();
        }
        Data d = new Data();
        d.Event = SortEffect.name();
        d.Zone = place;
        d.CardName = card;
        return toList(receiver, d.toJson());
    }

    public static List<Pair<String, String>> selectingEffect(Card[] cards) {
        return selectingEffect(cards, ME);
    }

    public static List<Pair<String, String>> changeProtectionEffect(final boolean player, final String action, final int point, final int count, final boolean overlap, int receiver) {
        Data d = new Data();
        d.Event = action;
        d.Player = player;
        d.Point = new int[]{point};
        d.Count = count;
        d.BeAbleTo = overlap;
        return toList(receiver, d.toJson());
    }

    public static List<Pair<String, String>> changeProtectionEffect(final boolean player, final String action, final int point, final int count, final boolean overlap) {
        return changeProtectionEffect(player, action, point, count, overlap, ME);
    }


    public static List<Pair<String, String>> damageSandBox(final boolean player, final int point, final int count, final boolean overlap) {
        return changeProtectionEffect(player, DamageSandBox.name(), point, count, overlap);
    }

    public static List<Pair<String, String>> healSandBox(final boolean player, final int point, final int count, final boolean overlap) {
        return changeProtectionEffect(player, HealSandBox.name(), point, count, overlap);
    }


    public static List<Pair<String, String>> damageSandBox(final boolean player, final int point, final int count, final boolean overlap, int receiver) {
        return changeProtectionEffect(player, DamageSandBox.name(), point, count, overlap, receiver);
    }

    public static List<Pair<String, String>> healSandBox(final boolean player, final int point, final int count, final boolean overlap, int receiver) {
        return changeProtectionEffect(player, HealSandBox.name(), point, count, overlap, receiver);
    }


    public static List<Pair<String, String>> select(final boolean player, final String after, final String place, int[][] coordinate, boolean cont, int receiver) {
        Data d = new Data();
        d.Event = Select.name();
        d.Player = player;
        d.Zone = new String[]{place};
        d.Coordinate = coordinate;
        d.After = after;
        d.Continue = cont;
        return toList(receiver, d.toJson());
    }

    public static List<Pair<String, String>> select(final boolean player, final String after, final String place, int[][] coordinate, boolean cont) {
        return select(player, after, place, coordinate, cont, ME);
    }

    public static List<Pair<String, String>> getPartnerables(final boolean player, Card[] cards, int receiver) {
        Data data = new Data();
        data.Event = GetPartnerables.name();
        String[] name = new String[cards.length];
        for (int i = 0; i < name.length; i++) {
            name[i] = cards[i].getName();
        }
        data.CardName = name;
        return toList(receiver, data.toJson());
    }

    public static List<Pair<String, String>> getPartnerables(final boolean player, Card[] cards) {
        return getPartnerables(player, cards, ME);
    }

    public static List<Pair<String, String>> selectPartner(final boolean player, final int coordinate, final Scp scp) {
        Data data = new Data();
        data.Event = BreachPartner.name();
        data.CardName = new String[]{scp.getName()};
        data.Coordinate = new int[][]{{coordinate}};
        data.Player = player;
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> getEmptysite(final boolean player, final int[] indexes, int receiver) {
        Data data = new Data();
        data.Player = player;
        data.Event = GetEmptySite.name();
        data.Coordinate = new int[][]{indexes};
        return toList(receiver, data.toJson());
    }

    public static List<Pair<String, String>> getEmptysite(final boolean player, final int[] indexes) {
        return getEmptysite(player, indexes, ME);
    }

    public static List<Pair<String, String>> canCrossTest(final boolean player, final int coordinate, final boolean canTest, int receiver) {
        Data data = new Data();
        data.Event = CanCrossTest.name();
        data.BeAbleTo = canTest;
        return toList(receiver, data.toJson());
    }

    public static List<Pair<String, String>> canCrossTest(final boolean player, final int coordinate, final boolean canTest) {
        return canCrossTest(player, coordinate, canTest, ME);
    }

    public static List<Pair<String, String>> breach(final boolean player, int coordinate, final Scp scp) {
        Data data = new Data();
        data.Event = ViewBreach.name();
        data.CardName = new String[]{scp.getName()};
        data.Coordinate = new int[][]{{coordinate}};
        data.Player = player;
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> turnEnd(final boolean turnPlayer) {
        Data data = new Data();
        data.Event = TurnEnd.name();
        data.Player = !turnPlayer;
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> getPersonnel(final boolean player, final boolean flag, final Personnel personnel, int receiver) {
        Data data = new Data();
        data.Event = GetPersonnel.name();
        data.Player = flag == player;
        data.CardName = new String[]{personnel.getName()};
        return toList(receiver, data.toJson());
    }

    public static List<Pair<String, String>> getPersonnel(final boolean player, final boolean flag, final Personnel personnel) {
        return getPersonnel(player, flag, personnel, ME);
    }

    public static List<Pair<String, String>> getTale(final boolean player, final Tale[] tales, int receiver) {
        Data data = new Data();
        data.Event = GetTale.name();
        String[] name = new String[tales.length];
        for (int i = 0; i < tales.length; i++) {
            name[i] = tales[i].getName();
        }
        data.CardName = name;
        return toList(receiver, data.toJson());
    }

    public static List<Pair<String, String>> getTale(final boolean player, final Tale[] tales) {
        return getTale(player, tales, ME);
    }

    public static List<Pair<String, String>> getSumSiteCost(final boolean player, final int cost) {
        Data data = new Data();
        data.Player = player;
        data.Event = GetSumSiteCost.name();
        data.Cost = cost;
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> getSiteNumber(final boolean player, final int count, final int receiver) {
        Data data = new Data();
        data.Event = GetSCPCount.name();
        data.Count = count;
        return toList(receiver, data.toJson());
    }


    public static List<Pair<String, String>> getSiteNumber(final boolean player, final int count) {
        return getSiteNumber(player, count, ME);
    }

    public static List<Pair<String, String>> getSandBoxNumber(final boolean player, final int safe, int euclid, int keter, int recieve) {
        Data data = new Data();
        data.Event = GetSandBoxProtection.name();
        data.Player = player;
        data.Point = new int[]{safe, euclid, keter};
        return toList(recieve, data.toJson());
    }

    public static List<Pair<String, String>> getSandBoxNumber(final boolean player, final int... sandbox) {
        return getSandBoxNumber(player, sandbox[0], sandbox[1], sandbox[2], ME);
    }


    public static List<Pair<String, String>> getRemainSandBox(final boolean player, final int safe, int euclid, int keter, int recieve) {
        Data data = new Data();
        data.Event = GetRemainSandBox.name();
        data.Player = player;
        data.Point = new int[]{safe, euclid, keter};
        return toList(recieve, data.toJson());
    }

    public static List<Pair<String, String>> getRemainSandBox(final boolean player, final int... sandbox) {
        return getSandBoxNumber(player, sandbox[0], sandbox[1], sandbox[2], ME);
    }

    public static List<Pair<String, String>> getEffect(final String zone, final int index, final int length) {
        Data data = new Data();
        data.Event = GetEffectCount.name();
        data.Count = length;
        data.Zone = new String[]{zone};
        data.Coordinate = new int[][]{{index}};
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> activeTale(final boolean player, final String name,
                                                        final int coordinate) {
        Data data = new Data();
        data.Event = ActiveTale.name();
        data.Player = player;
        data.CardName = new String[]{name};
        data.Coordinate = new int[][]{{coordinate}};
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> failEffect() {
        Data data = new Data();
        data.Event = Impossible.name();
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> heal(final boolean player, final int coordinate, final int point) {
        Data data = new Data();
        data.Event = Heal.name();
        data.Player = player;
        data.Point = new int[]{point};
        data.SandBox = coordinate;
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> damage(final boolean player, final int coordinate, final int point,
                                                    final int atkCoordinate) {
        Data data = new Data();
        data.Event = Damage.name();
        data.Player = player;
        data.Point = new int[]{point};
        data.Coordinate = new int[][]{{atkCoordinate}};
        data.SandBox = coordinate;
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> startBreach(final Scp scp, final boolean isMe, int sandBox) {
        Data data = new Data();
        data.Event = SelectBreach.name();
        data.CardName = new String[]{scp.getName()};
        data.SandBox = sandBox;
        Data data2 = new Data();
        List<Pair<String, String>> m;
        if (!isMe) {
            data2.Event = Wait.name();
            m = toListMe(data2.toJson());
            m.addAll(toListEnemy(data.toJson()));
        } else {
            data2.Event = Wait.name();
            m = toListEnemy(data2.toJson());
            m.addAll(toListMe(data.toJson()));
        }
        return m;
    }

    public static List<Pair<String, String>> isFirst(final String name, final boolean isFirst, final int receiver) {
        Data data = new Data();
        data.Event = IsFirst.name();
        data.Player = isFirst;
        data.PlayerName = name;
        return toList(receiver, data.toJson());
    }

    public static List<Pair<String, String>> isFirst(final String name, final boolean isFirst) {
        return isFirst(name, isFirst, ME);
    }

    public static List<Pair<String, String>> reContainment(final boolean player, final Card subject,
                                                           final Zone before,
                                                           final Zone after, final Card under, final int coordinate) {
        Data data = new Data();
        data.Event = ReContainment.name();
        data.Player = player;
        data.Coordinate = new int[][]{{0}};
        data.SandBox = coordinate;
        data.Zone = new String[]{before.toString(), after.toString()};
        data.CardName = new String[]{subject.getName(), under == null ? null : under.getName()};

        return toListBoth(data.toJson());
    }


    public static List<Pair<String, String>> optional(boolean player, String cardName, String message) {
        return optional(player, cardName, message, ME);
    }

    public static List<Pair<String, String>> optional(boolean player, String cardName, String message, int sender) {
        Data data = new Data();
        data.Event = Optional.name();
        data.Player = player;
        data.CardName = new String[]{cardName};
        data.Text = message;
        return toList(sender, data.toJson());
    }

    public static List<Pair<String, String>> decommission(final boolean player, final String place,
                                                          final int coordinate,
                                                          final Card card, boolean cont) {
        Data data = new Data();
        data.Event = Decommission.name();
        data.Player = player;
        data.Zone = new String[]{place};
        data.Coordinate = new int[][]{{coordinate}};
        data.CardName = new String[]{card.getName()};
        data.Continue = cont;
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> K_Class(final boolean isFirst, scptcg.game.K_Class k) {
        Data data = new Data();
        data.Event = K_Class.name();
        data.Scenario = k.name();
        data.Player = isFirst;
        return toListBoth(data.toJson());
    }

    public static List<Pair<String, String>> getCardParameter(final boolean player, final int index, final Scp scp) {
        Data data = new Data();
        data.Event = GetCardParameters.name();
        data.Player = player;
        data.Coordinate = new int[][]{{index}};
        data.Cost = scp.getCost();
        data.Secure = scp.getSecure();
        return toListBoth(data.toJson());
    }

    static List<Pair<String, String>> toList(final int receiver, String message) {
        switch (receiver) {
            case ME:
                return toListMe(message);
            case ENEMY:
                return toListEnemy(message);
            case BOTH:
                return toListBoth(message);
        }
        return new ArrayList<>();
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

    public static List<Pair<String, String>> can_tCross(boolean player) {
        Data data = new Data();
        data.Event = Can_tCrossTest.name();
        data.Player = player;
        return toListMe(data.toJson());
    }

    public static List<Pair<String, String>> impossible(boolean player, int target) {
        Data data = new Data();
        data.Event = Impossible.name();
        data.Player = player;
        return toList(target, data.toJson());
    }


    public static List<Pair<String, String>> impossible(boolean player) {
        return impossible(player, ME);
    }

    public static List<Pair<String, String>> getSandBoxProtection(boolean player, int[] sandBoxProtection) {
        Data data = new Data();
        data.Event = GetSandBoxProtection.name();
        data.Player = player;
        data.Point = sandBoxProtection;
        return toListMe(data.toJson());
    }

}
