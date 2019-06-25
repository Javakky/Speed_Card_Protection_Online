package scptcg.game.effect;

import scptcg.game.Player;
import scptcg.game.Zone;
import scptcg.game.card.Card;
import scptcg.game.card.Scp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import static scptcg.game.K_Class.*;

public class Action extends AbstractAction {

    private ActionMethod tmpAction = null;

    private Result tmpBefore = null;

    private ResultBuilder tmpResult;

    public Action(final String action) {
        super(action);
    }

    @Override
    public ActionMethod getAction() {
        if (Objects.isNull(tmpAction)) {
            return (tmpAction = ActionMethod.valueOf(getActionMessage()));
        }
        return tmpAction;
    }

    public Result active(Result before) {
        tmpBefore = before;
        Card card = getCard();
        tmpResult = new ResultBuilder(
                getPlayer().isFirst(),
                card.whereZone(),
                card,
                card.getName(),
                card.getCoordinate());

        switch (getAction()) {

            case Decommission:
                decommission();
                break;

            case Select:
                select();
                break;

            case HealSandBox:
            case DamageSandBox:
                changeProtectionSandBox();
                break;

            case AddTag:
                addTag();
                break;

            case AddEffect:
                addEffect();
                break;

            case K_Class:
                k_class();
                break;

            case MinusSecure:
                minusSecure();
                break;

            case Breach:
                breach();
                break;

            case ReContainment:
                reContainment();
                break;

            default:
                throw new IllegalArgumentException("存在しないアクションです。：" + getActionMessage());
        }

        tmpBefore = null;
        return tmpResult.createResult();
    }

    private void reContainment() {
        int index = getPlayer().reContainment(getCard(), getParameter().getTargetClazz());
        tmpResult.objectEqualSubject();
    }

    private void breach() {
        /*

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
                if (result.getResStr() != null && result.getResStr().length > 0 && result.getResStr()[0] != null) {
                    String times = null;
                    switch (result.getResStr()[0]) {
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
                                result.getResStr()[0],
                                result.getResStr()[1],
                                "select"
                        });
                        ga.addEffect(
                                new Effect(
                                        "",
                                        false,
                                        1,
                                        true,
                                        null,
                                        map
                                )
                        );
                    }
                }
         */
    }

    private void minusSecure() {
        ((Scp) getCard()).minusSecure(getParameter().getPoint());
    }

    private void k_class() {
        Parameter p = getParameter();
        List<Player> player = new ArrayList<>();
        getTargetPlayer(player);
        getGame().ignitionK(IK, player.get(0));
        tmpResult.setTargetPlayer(player.get(0).isFirst());
    }

    private <T> void add(Function<T[], Function<Zone, Function<Player, Function<Integer, Object>>>> func, T[] elements) {
        Parameter p = getParameter();
        switch (p.getTargetZone()) {
            case Site: {
                List<Player> player = new ArrayList<>();
                getTargetPlayer(player);
                int[][] coordinate = null;
                Function<Player, Function<Integer, Object>> adder = func.apply(elements).apply(Zone.Site);
                if (isTargetPlayerOne()) {
                    for (int index : player.get(0).getSelectables(p.isThere(), p.getCondition())) {
                        adder.apply(player.get(0)).apply(index);
                    }
                } else {
                    for (int index : player.get(0).getSelectables(p.isThere(), p.getCondition())) {
                        adder.apply(player.get(0)).apply(index);
                    }
                    for (int index : player.get(1).getSelectables(p.isThere(), p.getCondition())) {
                        adder.apply(player.get(1)).apply(index);
                    }
                }
                break;
            }
        }
        tmpResult.setIsComplete(true);
    }

    private void addTag() {
        add((String[] tags) -> zone -> player -> index -> {
            player.addTag(zone, index, tags);
            return null;
        }, getParameter().getSubTag());
    }

    private void addEffect() {
        add((Object[] effect_trigger) -> zone -> player -> index -> {
            Effect effect = (Effect) effect_trigger[0];
            Trigger trigger = (Trigger) effect_trigger[1];
            player.addEffect(zone, index, effect, trigger);
            return null;
        }, new Object[]{getParameter().getSubEffect(), getParameter().getTrigger()});
    }

    private void changeProtectionSandBox() {
        Parameter p = getParameter();
        int point;
        switch (p.getReference()) {
            case "Cost":
                Scp tmp = (Scp) (tmpBefore.getObject()[tmpBefore.getObjectPlayer() ? 0 : 1][0]);
                point = tmp.getCost();
                break;
            case "Secure":
                tmp = (Scp) (tmpBefore.getObject()[tmpBefore.getObjectPlayer() ? 0 : 1][0]);
                point = tmp.getSecure();
                break;
            case "Point":
                point = p.getPoint();
                break;
            case "Number":
                point = tmpBefore.getObject()[0].length + tmpBefore.getObject().length > 0 ? tmpBefore.getObject()[1].length : 0;
                break;
        }
        tmpResult.setOverlap(p.canOverlap());
        List<Player> player = new ArrayList<>();
        getTargetPlayer(player);
        tmpResult.setTargetPlayer(player.get(0).isFirst());
        tmpResult.setIsComplete(false);
    }

    private void select() {
        List<Player> player = new ArrayList<>();
        Parameter p = getParameter();
        if (isTargetPlayerOne()) {
            tmpResult.setCoordinate(player.get(0).getSelectables(p.isThere(), p.getCondition()));
        } else {
            tmpResult.setCoordinate(new int[][]{
                    player.get(0).getSelectables(p.isThere(), p.getCondition()),
                    player.get(1).getSelectables(p.isThere(), p.getCondition())
            });
        }
        tmpResult.setIsComplete(false);
    }

    private void decommission() {
        getPlayer().decommission(getParameter().getTargetZone(), getCard());
        tmpResult.objectEqualSubject();
        tmpResult.setIsComplete(true);
    }
}

