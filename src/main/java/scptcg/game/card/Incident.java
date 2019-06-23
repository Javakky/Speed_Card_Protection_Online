package scptcg.game.card;

import scptcg.game.CardHolder;
import scptcg.game.effect.Effects;

public class Incident extends Tale {
    protected Incident(final CardHolder parent, final String category, final String name, final boolean canDecommission, final Effects effects) {
        super(parent, category, name, canDecommission, effects);
    }
}
