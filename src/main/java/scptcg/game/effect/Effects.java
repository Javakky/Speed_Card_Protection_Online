package scptcg.game.effect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Effects {

    private Map<String, List<Effect>> effects;

    public List<Effect> getEffects() {
        List<Effect> e = new ArrayList<>();
        for (List<Effect> list : effects.values()) {
            if (list != null) {
                e.addAll(list);
            }
        }
        return e;
    }

    public void addEffect(final Effect effect, final Trigger trigger) {
        String trg = trigger.name();
        if (effects.containsKey(trg)) {
            effects.get(trg).add(effect);
        } else {
            List<Effect> list = new ArrayList<>();
            list.add(effect);
            effects.put(trg, list);
        }
    }

    public Effect getEffect(final Trigger trigger, final int index) {
        return effects.get(trigger.name()).get(index);
    }

    public boolean containsTrigger(final Trigger trigger) {
        return effects.containsKey(trigger.name());
    }

    public List<Effect> getEffects(final Trigger trigger) {
        return effects.get(trigger.name());
    }
}
