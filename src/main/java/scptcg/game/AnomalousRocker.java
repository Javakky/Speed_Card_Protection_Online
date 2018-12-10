package scptcg.game;

import scptcg.game.card.Anomalous;

import static scptcg.game.Place.*;
import static scptcg.game.card.CardFactory.create;
import static scptcg.game.card.CardKind.*;

public class AnomalousRocker extends SandBox {

    public AnomalousRocker(Player parent, String... name) {
        super(parent);
        this.size = 5;
        if (name.length > 5) {
            throw new RuntimeException("cardOverFlow");
        }
        for (int i = 0; i < name.length; i++) {
            sandBox.set(i, (Anomalous) create(this, name[i], ANOMALOUS));
        }
    }

    @Override
    public Place getPlace() {
        return ANOMALOUS_ROCKER;
    }
}
