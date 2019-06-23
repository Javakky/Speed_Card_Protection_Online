package scptcg.game.effect;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static scptcg.game.effect.EFFECT_TYPE_LIST.*;

public class Effects {

    protected EffectType[] effect;

    int getNumber(String type) {
        switch (type) {
            case "Decommissioned":
                return DECOMMISSIONED;
            default:
                return -1;
        }
    }

    public List<Effect> getEffect() {
        List<Effect> e = new ArrayList<>();
        for (EffectType ef : effect) {
            if (ef != null) {
                List<Effect> tmp = ef.getEffect();
                if (tmp != null)
                    e.addAll(tmp);
            }
        }
        return e;
    }

    public void addEffect(Effect e, String type, String compel) {
        if (this.effect.length <= getNumber(type)) {
            List<EffectType> li = new ArrayList(Arrays.asList(effect));
            while (li.size() <= getNumber(type)) {
                li.add(new EffectType());
            }
            this.effect = li.toArray(new EffectType[li.size()]);
        }
        if (this.effect[getNumber(type)] == null) {
            this.effect[getNumber(type)] = new EffectType();
        }
        this.effect[getNumber(type)].addEffect(e);
    }

    public Effect getEffect(int term, int num) {
        return effect[term].getEffect(num);
    }

    public Pair<Result[], Boolean> activeEffect(int timing, int num, String[] param) {
        if (hasn_tEffect(timing)) {
            return null;
        }
        return effect[timing].active(num, param);
    }

    protected boolean hasn_tEffect(int timing) {
        return effect.length <= timing || effect[timing] == null;
    }

    public List<Effect> getEffectList(int suffix) {
        if (effect != null && effect.length > suffix && effect[suffix] != null) {
            List<Effect> li = effect[suffix].getEffect();
            return li == null ? new LinkedList<>() : li;
        }
        return new LinkedList<>();
    }
}
