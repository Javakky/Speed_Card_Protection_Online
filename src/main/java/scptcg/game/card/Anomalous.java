package scptcg.game.card;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Set;

public class Anomalous extends Scp {

    protected Anomalous(final boolean isPartner, final int cost, final int secure, final String clazz, final Set<String> subClazz, final String containmentClass, final Set<String> tag, final boolean canPartner, final boolean canAttack, final int attacksCount, final int attackCount) {
        super(isPartner, cost, secure, clazz, subClazz, containmentClass, tag, canPartner, canAttack, attacksCount, attackCount);
    }

    @Override
    public int getCost() throws NotImplementedException {
        throw new NotImplementedException("Anomalousアイテムは複数で1つのコストを持ちます");
    }

}
