package scptcg.game.card;

import org.apache.commons.lang3.NotImplementedException;
import scptcg.game.CardHolder;
import scptcg.game.effect.Effects;

import java.util.Set;

public class Anomalous extends Scp {

    public Anomalous(CardHolder parent, String category, String name, boolean canDecommission, Effects effects, boolean isPartner, int cost, int secure, String clazz, Set<String> subClazz, String containmentClass, Set<String> tag, boolean canPartner, boolean crossTestable, int crossTestsCount, int crossTestCount) {
        super(parent, category, name, canDecommission, effects, isPartner, cost, secure, clazz, subClazz, containmentClass, tag, canPartner, crossTestable, crossTestsCount, crossTestCount);
    }

    @Override
    public int getCost() throws NotImplementedException {
        throw new NotImplementedException("Anomalousアイテムは複数で1つのコストを持ちます");
    }

}
