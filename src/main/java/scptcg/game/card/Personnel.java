package scptcg.game.card;

import scptcg.game.CardHolder;

import static scptcg.game.Place.*;
import static scptcg.game.card.CardKind.*;

public class Personnel extends Card {

    protected Personnel(CardHolder parent, String name) {
        super(parent, PERSONNEL, name);
    }

    @Override
    public int reContainment() {
        return getMyPlayer().reContainment(this, PERSONNEL_FILE);
    }

    @Override
    public Personnel clone() {
        return new Personnel(parent, name);
    }
}
