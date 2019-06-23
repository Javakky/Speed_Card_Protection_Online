package scptcg.game.card;

import scptcg.game.CardHolder;

import static scptcg.game.card.CardKind.*;

public class Incident extends Tale {

    protected Incident(CardHolder parent, String name) {
        super(parent, INCIDENT, name);
    }

    @Override
    public Incident clone() {
        return new Incident(getParent(), getName());
    }
}
