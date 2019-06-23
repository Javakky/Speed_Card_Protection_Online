package scptcg.game.card;

import scptcg.game.CardHolder;
import scptcg.game.effect.Effects;

public class Tale extends Card {
    protected Tale(final CardHolder parent, final String category, final String name, final boolean canDecommission, final Effects effects) {
        super(parent, category, name, canDecommission, effects);
    }

    @Override
    public Card clone() {
        return new Tale(getParent(), getCategory().name(), getName(), canDecommission(), getEffects());
    }
}
