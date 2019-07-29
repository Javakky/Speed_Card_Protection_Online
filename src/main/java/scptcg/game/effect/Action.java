package scptcg.game.effect;

import scptcg.game.Player;
import scptcg.game.Zone;
import scptcg.game.card.Card;
import scptcg.game.card.CardCategory;
import scptcg.game.card.Scp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

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

    public Result active(Result before, Effect effect) {
        if (before != null)
            tmpBefore = before;
        setParent(effect);
        Card card = getCard();
        tmpResult = new ResultBuilder(
                getAction().name(),
                getPlayer().isFirst(),
                card.whereZone(),
                card,
                card.getName(),
                card.getCoordinate());

        //System.out.println("Activate : " + getAction().name());

        switch (getAction()) {

            case Decommission:
                decommission();
                break;

            case Select:
                select();
                break;

            case UpXKCost:
                upXKCost();
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

            case PlusSecure:
                plusSecure();
                break;

            case Breach:
                breach();
                break;

            case ReContainment:
                reContainment();
                break;

            case Optional:
                optionalActive();
                break;
            case SetSecure:
                setSecure();
                break;

            case CancelK:
                cancelK();
                break;

            case SecureToZero:
                secureToZero();
                break;

            default:
                throw new IllegalArgumentException("存在しないアクションです。：" + getAction().name());
        }

        tmpBefore = null;
        return tmpResult.createResult();
    }

    private void secureToZero() {
        Scp self = (Scp) getCard();
        int point = self.getSecure();
        self.minusSecure(point);
        tmpResult.setPoint(point);
        tmpResult.setIsComplete(true);
    }

    private void cancelK() {
        getGame().cancelK();
        tmpResult.setIsComplete(true);
    }

    private void upXKCost() {
        getGame().upXKCost(getParameter().getPoint());
        tmpResult.setIsComplete(true);
    }

    private void setSecure() {
        ((Scp) getCard()).setSecure(getParameter().getPoint());
        tmpResult.setIsComplete(true);
    }

    private void optionalActive() {
        tmpResult.setIsComplete(false);
        tmpResult.setTargetPlayer(getCard().ownerIsFirst());
        tmpResult.setMessage(getParent().getMessage());
    }

    private void reContainment() {
        int index = getPlayer().reContainment((Scp) getCard(), getParameter().getTargetClazz());
        tmpResult.setCoordinate(index);
        //System.out.println("name : " + getCard().getName());
        tmpResult.setObjects(
                getPlayer().isFirst(),
                getCard().whereZone(),
                getCard(),
                getCard().getName(),
                getCard().getCoordinate());
        tmpResult.setIsComplete(true);
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
        tmpResult.setIsComplete(true);
    }

    private void plusSecure() {
        int number = 0;
        switch (getParameter().getReference()) {
            case "DecommissionedNumber":
                number = getPlayer().getSize(Zone.Decommissioned);
                break;
            case "DecommissionedSCP":
                number = getPlayer().getDecommissioned(CardCategory.SCP).length;
            case "Point":
                number = getParameter().getPoint();
                break;
            case "Cost":
                number = ((Scp) tmpBefore.getSubject()).getCost();
                break;
        }
        ((Scp) getCard()).plusSecure(number);
        tmpResult.setIsComplete(true);
    }

    private void k_class() {
        List<Player> player = new ArrayList<>();
        getTargetPlayer(player);
        getGame().ignitionK(getParameter().getScenario(), player.get(0));
        tmpResult.setTargetPlayer(player.get(0).isFirst());
        tmpResult.setIsComplete(true);
    }

    private <T> void add(Function<T[], Function<Zone, Function<Player, Function<Integer, Object>>>> func, T[] elements) {
        Parameter p = getParameter();
        tmpResult.setIsComplete(true);
        switch (p.getTargetZone()) {
            case Site: {
                List<Player> player = new ArrayList<>();
                getTargetPlayer(player);
                Function<Player, Function<Integer, Object>> adder = func.apply(elements).apply(p.getTargetZone());
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
            case PersonnelFile: {
                List<Player> player = new ArrayList<>();
                getTargetPlayer(player);
                Function<Player, Function<Integer, Object>> adder = func.apply(elements).apply(p.getTargetZone());
                if (isTargetPlayerOne()) {
                    adder.apply(player.get(0)).apply(0);
                } else {
                    adder.apply(player.get(0)).apply(0);
                    adder.apply(player.get(1)).apply(0);
                }
            }
        }
        tmpResult.setIsComplete(true);
    }

    private void addTag() {
        add((String[] tags) -> zone -> player -> index -> {
            player.addTag(zone, index, tags);
            return null;
        }, getParameter().getSubTag());
        tmpResult.setIsComplete(true);
    }

    private void addEffect() {
        add((Object[] effect_trigger) -> zone -> player -> index -> {
            Effect effect = (Effect) effect_trigger[0];
            Trigger trigger = (Trigger) effect_trigger[1];
            player.addEffect(getParameter().getTargetZone(), index, effect, trigger);
            //System.out.println("カード名：" + player.getCard(getParameter().getTargetZone(), index));
            //System.out.println("効果：" + effect.getMessage());
            //System.out.println("発動条件：" + trigger);
            return null;
        }, new Object[]{getParameter().getSubEffect(), getParameter().getTrigger()});
        tmpResult.setIsComplete(true);
    }

    private void changeProtectionSandBox() {
        Parameter p = getParameter();
        int point = 0;
        switch (p.getReference()) {
            case "Cost":
                Scp tmp = (Scp) (tmpBefore.getSubject());
                point = tmp.getCost();
                break;
            case "Secure":
                tmp = (Scp) (tmpBefore.getSubject());
                point = tmp.getSecure();
                break;
            case "Point":
                point = p.getPoint();
                break;
            case "Number":
                point = tmpBefore.getObject()[0].length + tmpBefore.getObject().length > 0 ? tmpBefore.getObject()[1].length : 0;
                break;
            case "Before":
                point = tmpBefore.getPoint();
                break;
        }
        tmpResult.setOverlap(p.canOverlap());
        tmpResult.setPoint(point);
        List<Player> player = new ArrayList<>();
        getTargetPlayer(player);
        tmpResult.setTargetPlayer(player.get(0).isFirst());
        tmpResult.setIsComplete(false);
        tmpResult.setCount(p.getCount());
    }

    private void select() {
        List<Player> player = new ArrayList<>();
        Parameter p = getParameter();
        getTargetPlayer(player);
        tmpResult.setTargetPlayer(player.get(0).isFirst());
        if (isTargetPlayerOne()) {
            tmpResult.setCoordinate(player.get(0).getSelectables(p.isThere(), p.getCondition()));
        } else {
            tmpResult.setCoordinate(new int[][]{
                    player.get(0).getSelectables(p.isThere(), p.getCondition()),
                    player.get(1).getSelectables(p.isThere(), p.getCondition())
            });
        }
        tmpResult.setIsComplete(false);
        tmpResult.setTargetZone(p.getTargetZone());
        tmpResult.setNextAction(p.getNextAction().name());
    }

    private void decommission() {
        int coord = -1;
        if (getParameter().isThis()) {
            coord = getCard().getCoordinate();
            tmpResult.setTargetZone(getCard().whereZone());
            getPlayer().decommission(getCard().whereZone(), getCard());
        } else {
            tmpResult.setTargetZone(getParameter().getTargetZone());
            switch (getParameter().getTargetZone()) {
                case PersonnelFile:
                    coord = 0;
                    Card pf = getPlayer().getCard(Zone.PersonnelFile, 0);
                    tmpResult.setTargetZone(pf.whereZone());
                    getPlayer().decommission(Zone.PersonnelFile, pf);
                    tmpResult.setObjects(
                            pf.ownerIsFirst(),
                            pf.whereZone(),
                            pf,
                            pf.getName(),
                            pf.getCoordinate()
                    );
                    break;
                case Site:
                    coord = getParent().getParent().getCoordinate();
                    tmpResult.setTargetZone(getPlayer().getCard(Zone.Site, coord).whereZone());
                    getPlayer().decommission(Zone.Site, getParent().getParent());
            }
        }
        tmpResult.objectEqualSubject();
        tmpResult.setCoordinate(coord);
        tmpResult.setIsComplete(true);
    }
}

