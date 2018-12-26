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

    public boolean fulfill(Effect parent) {
        Player p = parent.getMyPlayer();
        //System.out.println("action:" + getAction());
        switch (getAction()) {
            case "notPartner": {
                return !((Scp) parent.getCard()).isPartner();
            }
            case "hasPersonnel": {
                return p.hasPersonnel();
            }
            case "hasSCP": {
                //System.out.println("\"" + this.param[0] + "\"");
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
            case "firstTimeTurn": {
                return parent.getAlready() == 0;
            }
            default: {
                return true;
            }
        }
    }

}
