package scptcg.game.effect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EffectType implements Serializable {
    private List<Effect> effects;

    public int length() {
        return effects.size();
    }

    List<Effect> getEffect() {
        //System.out.println(effects == null ? null : effects.size());
        return effects;
    }

    public Effect getEffect(int num) {
        return effects.get(num);
    }

    Map.Entry<Result[], Boolean> active(int num, String[] param) {
        return effects.get(num).active(param, null);
    }

    public void addEffect(Effect e) {
        if (effects == null) {
            effects = new ArrayList<>();
        }
        effects.add(e);
    }
}
