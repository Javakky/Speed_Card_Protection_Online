package scptcg.game.effect;

import scptcg.game.Player;
import scptcg.game.card.Scp;

import static org.apache.commons.lang3.ArrayUtils.*;

public class Term extends AbstractAction {

    public Term(String action) {
        super(action);
    }

    public Term(String action, String[] param) {
        super(action, param);
    }

    private TermKind tmpAction = null;

    @Override
    public TermKind getAction() {
        if (tmpAction == null) return (tmpAction = TermKind.getByName(action));
        return tmpAction;
    }

    public boolean fulfill(Effect parent) {
        Player p = parent.getMyPlayer();
        System.out.println("action:" + getAction());
        switch (getAction()) {
            case NOT_PARTNER: {
                return !((Scp) parent.getCard()).isPartner();
            }
            case HAS_PERSONNEL: {
                return p.hasPersonnel();
            }
            case HAS_SCP: {
                System.out.println("\"" + this.param[0] + "\"");
                switch (this.param[0]) {
                    case "me":
                        return p.hasSCP(remove(param, 0));
                    case "enemy":
                        return p.getEnemy().hasSCP(remove(param, 0));
                    case "both":
                        return p.hasSCP(remove(param, 0)) || p.getEnemy().hasSCP(remove(param, 0));
                    default:
                        return false;
                }
            }
            case FIRST_TIME_BY_TURN: {
                return parent.getAlready() == 0;
            }
            case MY_TURN: {
                return parent.isMyTurn();
            }
            default: {
                return true;
            }
        }
    }

}
