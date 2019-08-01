package scptcg.game.effect;

import scptcg.game.Player;
import scptcg.game.card.Scp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Condition extends AbstractAction {

    private ConditionPattern tmpCondition = null;

    public Condition(final String action) {
        super(action);
    }

    @Override
    public ConditionPattern getAction() {
        if (Objects.isNull(tmpCondition)) {
            return (tmpCondition = ConditionPattern.valueOf(getActionMessage()));
        }
        return tmpCondition;
    }

    public boolean fulfill(final Effect parent) {

        if (Objects.nonNull(parent)) {
            this.setParent(parent);
        }

        List<Player> player = new ArrayList<>();
        boolean or = getTargetPlayer(player);

        if (isTargetPlayerOne()) {
            return checkCondition(player.get(0));
        } else {
            boolean a = checkCondition(player.get(0));
            boolean b = checkCondition(player.get(1));
            if (or) {
                return a || b;
            } else {
                return a && b;
            }
        }
    }

    private boolean checkCondition(final Player player) {
        switch (getAction()) {
            case MyTurn:
                return isMyTurn(player);
            case HasSCP:
                return hasSCP(player);
            case NonPartner:
                return nonPartner();
            case HasPersonnel:
                return hasPersonnel(player);
            case SecureIsZero:
                return secureIsZero();
            case SecureNonZero:
                return secureNonZero();
            case FirstTimeInTurn:
                return firstTime(player);
            case SecureIs:
                return secureIs();
            case SecureNon:
                return secureNon();
            case DidntCrossTest:
                boolean flag = didntCrossTest();
                System.out.println("Didn't Cross Test: " + flag);
                return flag;
            case SumSiteCostOver:
                return sumSiteCostOver();
            case ScenarioIs:
                return scenarioIs();
            case SecureUnder:
                return secureUnder();
            case SecureOver:
                return secureOver();
            default:
                throw new IllegalArgumentException("存在しない条件です。：" + getActionMessage());
        }
    }

    private boolean secureOver() {
        return ((Scp) getCard()).getSecure() >= getParameter().getPoint();
    }

    private boolean secureUnder() {
        return ((Scp) getCard()).getSecure() <= getParameter().getPoint();
    }

    private boolean scenarioIs() {
        List<Player> p = new ArrayList<>();
        getTargetPlayer(p);
        return p.get(0).isFirst() == this.getGame().getKClassPlayerIsFirst() && getGame().getScenario() == getParameter().getScenario();
    }

    private boolean sumSiteCostOver() {
        return getPlayer().getSumSiteCost() >= getParameter().getPoint();
    }

    private boolean didntCrossTest() {
        return ((Scp) getCard()).getCrossTestCount() == 0;
    }

    private boolean secureNon() {
        return !secureIs();
    }

    private boolean secureIs() {
        return ((Scp) getCard()).getSecure() == getParameter().getPoint();
    }

    private boolean firstTime(final Player player) {
        return getParent().firstTime();
    }

    private boolean hasSCP(final Player player) {
        Parameter p = getParameter();
        return player.hasSCP(p.getTargetZone(), p.getCondition());
    }

    private boolean secureIsZero() {
        if (!(getCard() instanceof Scp)) return false;
        return ((Scp) getCard()).getSecure() == 0;

    }

    private boolean secureNonZero() {
        if (!(getCard() instanceof Scp)) return false;
        return ((Scp) getCard()).getSecure() != 0;
    }

    private boolean hasPersonnel(final Player player) {
        return player.hasPersonnel();
    }

    private boolean isMyTurn(final Player player) {
        return player.isMyTurn();
    }

    private boolean nonPartner() {
        if (!(getCard() instanceof Scp)) return false;
        return !((Scp) getCard()).isPartner();
    }

}
