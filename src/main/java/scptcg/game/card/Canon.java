package scptcg.game.card;

import scptcg.game.CardHolder;
import scptcg.game.effect.Effects;

public abstract class Canon extends Card {

    public Canon(final CardHolder parent, final String category, final String name, final boolean canDecommission, final Effects effects) {
        super(CardCategory.Canon);
    }

    @Override
    public void refresh() {

    }
}
