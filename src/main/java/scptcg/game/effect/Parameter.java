package scptcg.game.effect;

import scptcg.game.Zone;

public class Parameter {
    private String targetPlayer;
    private String targetZone;
    private String nextAction;
    private boolean overlap;
    private int count;
    private int point;
    private boolean isThere;
    private String reference;
    private String[] condition;
    private String[] subTags;
    private Effect subEffect;

    public String getTargetPlayer() {
        return targetPlayer;
    }

    public Zone getTargetZone() {
        return Zone.valueOf(targetZone);
    }

    public ActionMethod getNextAction() {
        return ActionMethod.valueOf(nextAction);
    }

    public boolean canOverlap() {
        return overlap;
    }

    public int getCount() {
        return count;
    }

    public int getPoint() {
        return point;
    }

    public boolean isThere() {
        return isThere;
    }

    public String getReference() {
        return reference;
    }

    public String[] getCondition() {
        return condition;
    }

    public String[] getSubTag() {
        return subTags;
    }

    public Effect getSubEffect() {
        return subEffect;
    }
}
