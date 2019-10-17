package scptcg.game.effect;

import scptcg.game.K_Class;
import scptcg.game.Zone;
import scptcg.game.card.Clazz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Parameter {
    private String targetPlayer;
    private String targetZone;
    private String[] nextAction;
    private boolean overlap;
    private int count;
    private int point;
    private boolean isThere;
    private String reference;
    private ConditionParameter[] condition;
    private String[] subTags;
    private Effect subEffect;
    private String targetClazz;
    private String trigger;
    private boolean isThis;
    private String[] scenario;
    private boolean isAll;

    public String getTargetPlayer() {
        return targetPlayer;
    }


    public Zone getTargetZone() {
        return Zone.valueOf(targetZone);
    }

    public ActionMethod[] getNextAction() {
        return (ActionMethod[]) Arrays.stream(nextAction).map(ActionMethod::valueOf).toArray();
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
        return Clazz.valueOf(targetClazz);
    }

    public void setTargetClazz(Clazz targetClazz) {
        this.targetClazz = targetClazz.name();
    }

    public Trigger getTrigger() {
        return Trigger.valueOf(trigger);
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger.name();
    }

    public boolean isThis() {
        return isThis;
    }

    public K_Class[] getScenario() {
        if (scenario == null) scenario = new String[]{K_Class.IK.name()};
        List<K_Class> list = new ArrayList<>();
        for (String k : scenario) {
            if (Objects.nonNull(k)) {
                list.add(K_Class.valueOf(k));
            }
        }
        return list.toArray(new K_Class[0]);
    }

    public void setScenario(K_Class[] scenario) {
        List<String> list = new ArrayList<>();
        for (K_Class k : scenario) {
            if (Objects.nonNull(k)) {
                list.add(k.name());
            }
        }
        this.scenario = list.toArray(new String[0]);
    }

    public boolean isAll() {
        return isAll;
    }
}
