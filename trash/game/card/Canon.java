package scptcg.game.card;

import scptcg.game.CardHolder;
import scptcg.game.exception.ClassDifferentException;

import static scptcg.game.card.CardKind.*;

public class Canon extends Card {

    protected Canon(CardHolder parent, String name) {
        super(parent, CANON, name);
    }

    @Override
    public int reContainment() {
        throw new ClassDifferentException("can't contain");
    }

    @Override
    public Canon clone() {
        return new Canon(getParent(), getName());
    }
}
