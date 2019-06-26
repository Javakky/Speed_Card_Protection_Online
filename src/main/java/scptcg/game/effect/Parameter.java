package scptcg.game.effect;

import scptcg.game.ConditionParameter;
import scptcg.game.Zone;
import scptcg.game.card.Clazz;

public class Parameter {
    private String targetPlayer;
    private String targetZone;
    private String nextAction;
    private boolean overlap;
    private int count;
    private int point;
    private boolean isThere;
    private String reference;
    private ConditionParameter[] condition;
    private String[] subTags;
    private Effect subEffect;
    private Clazz targetClazz;
    private Trigger trigger;

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

    public ConditionParameter[] getCondition() {
        return condition;
    }

    public String[] getSubTag() {
        return subTags;
    }

    public Effect getSubEffect() {
        return subEffect;
    }

    public Clazz getTargetClazz() {
        return targetClazz;
    }

    public void setTargetClazz(Clazz targetClazz) {
        this.targetClazz = targetClazz;
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

}
