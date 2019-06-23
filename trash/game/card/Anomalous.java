package scptcg.game.card;

import scptcg.game.CardHolder;

import java.util.List;

import static scptcg.game.card.CardKind.*;

public class Anomalous extends Scp {

    protected Anomalous(
            CardHolder parent,
            String name,
            int secure,
            List<String> tag,
            String clazz,
            List<String> subClazz) {
        super(parent, ANOMALOUS, name, 0, secure, tag, clazz, subClazz);
    }

    @Override
    public Anomalous clone() {
        return new Anomalous(getParent(), getName(), secure, getTag(), clazz, getSubClazz());
    }
}
