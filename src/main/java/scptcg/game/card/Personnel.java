package scptcg.game.card;

import scptcg.game.CardHolder;
import scptcg.game.effect.Effects;

public class Personnel extends Card {

    protected Personnel(final CardHolder parent, final String category, final String name, final boolean canDecommission, final Effects effects) {
        super(parent, category, name, canDecommission, effects);
    }

    @Override
    public Personnel clone() {
        return new Personnel(getParent(), getCategory().name(), getName(), canDecommission(), getEffects());
    }
}
