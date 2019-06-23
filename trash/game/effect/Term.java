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
        //System.out.println(action);
        if (tmpAction == null) return (tmpAction = TermKind.getByName(action));
        return tmpAction;
    }

    public boolean fulfill(Effect parent) {
        Player p = parent.getMyPlayer();
        //////System.out.println("action:" + getAction());
        TermKind kind = getAction();
        if (kind == null) return true;
        switch (kind) {
            case NOT_PARTNER: {
                return !((Scp) parent.getCard()).isPartner();
            }
            case HAS_PERSONNEL: {
                return p.hasPersonnel();
            }
            case HAS_SCP: {
                //////System.out.println("\"" + this.param[0] + "\"");
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
            case HAVE_PERSONNEL: {
                return p.hasPersonnel();
            }
            case FIRST_TIME_BY_TURN: {
                return parent.getAlready() == 0;
            }
            case MY_TURN: {
                return parent.isMyTurn();
            }
            case HAS_SECURE: {
                return ((Scp) parent.getCard()).getSecure() > 0;
            }
            case DECOMMISSIONED_SCP: {
                switch (this.param[0]) {
                    case "me":
                        return parent.getMyPlayer().getDecommissinoed().length > 0;
                    case "enemy":
                        return parent.getMyPlayer().getEnemy().getDecommissinoed().length > 0;
                    case "both":
                        return parent.getMyPlayer().getDecommissinoed().length > 0 && parent.getMyPlayer().getEnemy().getDecommissinoed().length > 0;
                    case "any":
                        return parent.getMyPlayer().getDecommissinoed().length > 0 || parent.getMyPlayer().getEnemy().getDecommissinoed().length > 0;
                    default:
                        return false;
                }
            }
            default: {
                return true;
            }
        }
    }

}
