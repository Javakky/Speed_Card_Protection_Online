package scptcg.game.effect;

import org.apache.commons.lang3.ArrayUtils;
import scptcg.game.Game;
import scptcg.game.Place;
import scptcg.game.Player;
import scptcg.game.card.Card;
import scptcg.game.card.Scp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.ArrayUtils.*;
import static scptcg.game.K_ClassScenario.*;
import static scptcg.game.card.CardKind.*;

public class Action extends AbstractAction {

    public Action(String action) {
        super(action);
    }

    public Action(String action, String[] param) {
        super(action, param);
    }

    private ActionKind tmpAction = null;

    @Override
    public ActionKind getAction() {
        if (tmpAction == null) return (tmpAction = ActionKind.getByName(action));
        return tmpAction;
    }

    public Result active(String param, Effect ef, Result before) {
        Card parent = ef.getCard();
        Result result = new Result(
                parent.getTurn(),
                parent.getPlayerNumber(),
                parent.getPlace(),
                action,
                parent
        );
        Player p = parent.getMyPlayer();
        Game ga = p.getGame();
        switch (getAction()) {
            case DECOMMISSION: {
                Card c = null;
                switch (this.param[0]) {
                    case "trash/Personnel": {
                        c = parent.getMyPlayer().getPersonnel();
                        break;
                    }
                    case "this": {
                        c = parent;
                        break;
                    }
                }
                result.setParam(new Card[]{c},
                        new Place[]{c.getPlace()},
                        null,
                        new int[]{c.getMyPlayer().find(parent.getPlace(), parent)});
                //System.out.println("DEC:" + c.getEffect(DECOMMISSIONED, 0).action[0].action);
                ga.decommission(parent.getPlayerNumber(), c);
                break;
            }

            case SELECT: {
                int player = -1;
                switch (this.param[1]) {
                    case "enemy":
                    case "me":
                        player = getPlayerNumber(parent, this.param[1]);
                        break;
                    case "both":
                        //////System.out.println("both");
                        Player e = p.getEnemy();
                        int[] ps = p.select(removeAll(this.param, 0, 1));
                        int[] es = e.select(removeAll(this.param, 0, 1));
                        result.setParam(
                                null,
                                null,
                                new String[]{this.param[0], this.param[2], Integer.toString(parent.getPlayerNumber()), Integer.toString(ps.length)},
                                addAll(ps, es));
                        return result;
                }
                result.setParam(
                        null,
                        null,
                        new String[]{this.param[0], this.param[2], Integer.toString(player)},
                        p.select(removeAll(this.param, 0, 1)));
                break;
            }

            case DAMAGE_SAND_BOX:
            case HEAL_SAND_BOX: {
                int num = 0;
                int player = getPlayerNumber(parent, this.param[0]);

                switch (this.param[3]) {
                    case "Cost":
                        Scp tmp = (Scp) before.getObject()[0];
                        num = tmp.getCost();
                        break;
                    case "Secure":
                        tmp = (Scp) before.getObject()[0];
                        num = tmp.getSecure();
                        break;
                    case "Point":
                        num = Integer.parseInt(this.param[4]);
                        break;
                    case "Number":
                        num = before.getResInt().length;
                        break;
                }
                result.setParam(null, null, new String[]{this.param[2]}, new int[]{num, player, Integer.parseInt(this.param[1])});
                //////System.out.println(result.getAction());
                break;
            }

            case ADD_TAG: {
                switch (this.param[0]) {
                    case "trash/SCP": {
                        Player player = ga.getPlayer(getPlayerNumber(parent, this.param[1]));
                        //////System.out.println(Arrays.toString(player.select(removeAll(this.param, 0, 1, 2))));
                        for (int i : player.select(removeAll(this.param, 0, 1, 2))) {
                            player.addTag(SCP, i, this.param[2]);
                        }
                        break;
                    }
                }
                result.setParam(new Card[0], new Place[0], null, null);
                break;
            }

            case ADD_EFFECT: {
                //System.out.println("addeffect");
                switch (this.param[0]) {
                    case "trash/Personnel": {
                        //System.out.println("personnel");
                        Map<String, String[]> act = new HashMap();
                        for (int i = 8; i < this.param.length; i++) {
                            String[] str = this.param[i].split(",");
                            //System.out.println(str[0]);
                            act.put(str[0], ArrayUtils.remove(str, 0));
                        }
                        p.getPersonnel().addEffect(
                                new Effect(this.param[3],
                                        Boolean.parseBoolean(this.param[4]),
                                        Integer.parseInt(this.param[5]),
                                        Boolean.parseBoolean(this.param[6]),
                                        this.param[7].split(","),
                                        act
                                ),
                                this.param[1],
                                this.param[2]
                        );
                        //System.out.println(p.getPersonnel().getEffect(DECOMMISSIONED, 0).getMessage());
                        break;
                    }

                    case "Site": {
                        //System.out.println("personnel");
                        Map<String, String[]> act = new HashMap();

                        //System.out.println(p.getPersonnel().getEffect(DECOMMISSIONED, 0).getMessage());
                        break;
                    }
                }
                result.setParam(new Card[0], new Place[0], null, null);
                break;
            }

            case K_CLASS: {
                //System.out.println("K-Class");
                ga.ignitionK(IK, parent.getMyPlayer());
                result.setParam(new Card[0], new Place[0], null, null);
                break;
            }

            case MINUS_SECURE: {
                ((Scp) parent).minusSecure(Integer.parseInt(this.param[0]));
                break;
            }

            case BREACH: {
            }

            case RECONTAINMENT: {
                int index = parent.reContainment();
                result.setParam(new Card[]{parent}, new Place[]{parent.getPlace()}, null, new int[]{index});
                break;
            }

            case RECONTAINMENT_ALL: {
                Player player = parent.getMyPlayer();
                Player enemy = parent.getMyPlayer().getEnemy();
                int[] array = new int[0];
                Card[] cards = new Card[0];
                int index = -1;
                Map<Card, Integer> map = null;
                switch (this.param[1]) {
                    case "me":
                        map = player.reContainmentAll(Place.create(this.param[0]), parent.getType());
                        array = ArrayUtils.toPrimitive(map.values().toArray(new Integer[0]));
                        cards = map.keySet().toArray(new Card[0]);
                        break;
                    case "enemy":
                        map = enemy.reContainmentAll(Place.create(this.param[0]), parent.getType());
                        array = ArrayUtils.toPrimitive(map.values().toArray(new Integer[0]));
                        cards = map.keySet().toArray(new Card[0]);
                        break;
                    case "both":
                        int[] a, b;
                        Card[] c, d;
                        map = player.reContainmentAll(Place.create(this.param[0]), parent.getType());
                        a = ArrayUtils.toPrimitive(map.values().toArray(new Integer[0]));
                        c = map.keySet().toArray(new Card[0]);
                        index = a.length;
                        map = enemy.reContainmentAll(Place.create(this.param[0]), parent.getType());
                        b = ArrayUtils.toPrimitive(map.values().toArray(new Integer[0]));
                        d = map.keySet().toArray(new Card[0]);
                        array = ArrayUtils.addAll(a, b);
                        cards = ArrayUtils.addAll(c, d);
                        break;
                }
                result.setParam(cards, new Place[]{Place.create(this.param[0])}, index > 0 ? new String[]{String.valueOf(index)} : null, array);
                break;
            }
        }
        return result;
    }

    protected int getPlayerNumber(Card parent, String name) {
        switch (name) {
            case "enemy":
                return parent.getEnemyNumber();
            case "me":
                return parent.getPlayerNumber();
            default:
                return -1;
        }
    }
}
