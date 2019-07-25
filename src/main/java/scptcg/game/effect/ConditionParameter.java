package scptcg.game.effect;

import scptcg.game.card.Clazz;

public class ConditionParameter {
    private String name;
    private int point;
    private String tag;
    private String clazz;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Clazz getClazz() {
        return Clazz.valueOf(clazz);
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz.name();
    }
}
