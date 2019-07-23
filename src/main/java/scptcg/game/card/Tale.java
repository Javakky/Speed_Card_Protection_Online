package scptcg.game.card;

import scptcg.game.CardHolder;
import scptcg.game.effect.Effects;

public abstract class Tale extends Card {
    protected Tale(final CardHolder parent, final String category, final String name, final boolean canDecommission, final Effects effects) {
        super(CardCategory.Tale);
    }

    @Override
    public Card clone() {
        return null;
    }
}
