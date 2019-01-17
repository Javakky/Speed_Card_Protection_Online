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
        switch (action) {
            case "Decommission": {
                Card c = null;
                switch (this.param[0]) {
                    case "Personnel": {
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
                c.decommission();
                break;
            }

            case "Select": {
                int player = -1;
                switch (this.param[1]) {
                    case "enemy":
                    case "me":
                        player = getPlayerNumber(parent, this.param[1]);
                        break;
                    case "both":
                        System.out.println("both");
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
            case "DamageSandBox":
            case "healSandBox": {
                int num = 0;
                int player = getPlayerNumber(parent, this.param[0]);

                switch (this.param[3]) {
                    case "Cost":
                        Scp tmp = (Scp) before.object[0];
                        num = tmp.getCost();
                        break;
                    case "Point":
                        num = Integer.parseInt(this.param[4]);
                        break;
                }
                result.setParam(null, null, new String[]{this.param[2]}, new int[]{num, player, Integer.parseInt(this.param[1])});
                System.out.println(result.action);
                break;
            }

            case "addTag": {
                switch (this.param[0]) {
                    case "SCP": {
                        Player player = ga.getPlayer(getPlayerNumber(parent, this.param[1]));
                        System.out.println(Arrays.toString(player.select(removeAll(this.param, 0, 1, 2))));
                        for (int i : player.select(removeAll(this.param, 0, 1, 2))) {
                            player.addTag(SCP, i, this.param[2]);
                        }
                        break;
                    }
                }
                result.setParam(new Card[0], new Place[0], null, null);
                break;
            }

            case "AddEffect": {
                switch (this.param[0]) {
                    case "Personnel": {
                        Map<String, String[]> act = new HashMap();
                        for (int i = 8; i < this.param.length; i++) {
                            String[] str = this.param[i].split(",");
                            act.put(str[0], ArrayUtils.remove(str, 0));
                        }
                        p.getPersonnel().addEffect(
                                new Effect(this.param[3],
                                        this.param[4],
                                        Integer.parseInt(this.param[5]),
                                        Boolean.parseBoolean(this.param[6]),
                                        this.param[7].split(","),
                                        act
                                ),
                                this.param[1],
                                this.param[2]
                        );
                        break;
                    }
                }
                result.setParam(new Card[0], new Place[0], null, null);
                break;
            }

            case "K-class": {
                ga.ignitionK(IK, ga.getPlayer(Integer.parseInt(param)));
                result.setParam(new Card[0], new Place[0], null, null);
                break;
            }

            case "Breach": {
                int i = -1;
                switch (this.param[1]) {
                    case "me":
                        i = parent.getPlayerNumber();
                        break;
                    case "enemy":
                        i = parent.getEnemyNumber();
                        break;
                }
                result.setParam(null, null, new String[]{this.param[0], this.param[1]}, new int[]{i});
                if (result.resStr != null && result.resStr.length > 0 && result.resStr[0] != null) {
                    String times = null;
                    switch (result.resStr[0]) {
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
                        map.put(result.getAction(), new String[]{
                                result.resStr[0],
                                result.resStr[1],
                                "select"
                        });
                        ga.addEffects(
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
            }

            case "ReContainment": {
                int index = parent.reContainment();
                result.setParam(new Card[]{parent}, new Place[]{parent.getPlace()}, null, new int[]{index});
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
