package scptcg.game.card;

import scptcg.game.CardHolder;
import scptcg.game.effect.Effects;

public class Canon extends Card {

    protected Canon(final CardHolder parent, final String category, final String name, final boolean canDecommission, final Effects effects) {
        super(parent, category, name, canDecommission, effects);
    }

    @Override
    public Canon clone() {
        return new Canon(getParent(), getCategory().name(), getName(), canDecommission(), getEffects());
    }

    @Override
    public void refresh() {

    }
}
