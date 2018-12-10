package scptcg.game.card;

import scptcg.game.CardHolder;

import static scptcg.game.Place.*;
import static scptcg.game.card.CardKind.*;

public class Tale extends Card {

    protected Tale(CardHolder parent, String name) {
        super(parent, TALE, name);
    }

    protected Tale(CardHolder parent, CardKind kind, String name) {
        super(parent, kind, name);
    }

    @Override
    public int reContainment() {
        return getMyPlayer().reContainment(this, TALES);
    }

    @Override
    public Tale clone() {
        return new Tale(parent, name);
    }

}
