package scptcg.game.card;

import scptcg.game.CardHolder;
import scptcg.game.effect.Effects;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Scp extends Card {
    private boolean isPartner;
    private int cost;
    private int secure;
    private String clazz;
    private Set<String> subClazz = new HashSet<>();
    private String containmentClass;
    private Set<String> tag = new HashSet<>();
    private boolean canPartner = true;
    private boolean crossTestable = true;
    private int crossTestsCount;
    private int crossTestCount = 0;

    public void plusSecure() {
        this.setSecure(getSecure() + 1);
    }

    public void plusSecure(int point) {
        this.setSecure(getSecure() + point);
    }

    protected Scp(final CardHolder parent, final String category, final String name, final boolean canDecommission, final Effects effects, final boolean isPartner, final int cost, final int secure, final String clazz, final Set<String> subClazz, final String containmentClass, final Set<String> tag, final boolean canPartner, final boolean crossTestable, final int crossTestsCount, final int crossTestCount) {
        super(parent, category, name, canDecommission, effects);
        this.isPartner = isPartner;
        this.cost = cost;
        this.secure = secure;
        this.clazz = clazz;
        this.subClazz = subClazz;
        this.containmentClass = containmentClass;
        this.tag = tag;
        this.canPartner = canPartner;
        this.crossTestable = crossTestable;
        this.crossTestsCount = crossTestsCount;
        this.crossTestCount = crossTestCount;
    }

    public boolean isPartner() {
        return isPartner;
    }

    public void toPartner(final boolean partner) {
        isPartner = partner;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(final int cost) {
        this.cost = cost;
    }

    public int getSecure() {
        return secure;
    }

    public void setSecure(final int secure) {
        this.secure = secure;
        if (getSecure() < 0) this.secure = 0;
    }

    public Clazz getClazz() {
        return Clazz.valueOf(clazz);
    }

    protected void setClazz(final Clazz clazz) {
        this.clazz = clazz.name();
    }

    public Set<Clazz> getSubClazz() {
        return subClazz.stream()
                .map(Clazz::valueOf)
                .collect(Collectors.toSet());
    }

    public void addSubClazz(final Clazz subClazz) {
        this.subClazz.add(subClazz.toString());
    }

    public Clazz getContainmentClass() {
        try {
            return Clazz.valueOf(containmentClass);
        } catch (IllegalArgumentException | NullPointerException e) {
            return getClazz();
        }
    }

    public void setContainmentClass(final Clazz containmentClass) {
        this.containmentClass = containmentClass.toString();
    }

    @Override
    public void lostEffect() {
        super.lostEffect();
        enableCanCrossTest();
        enableDecommission();
    }

    public boolean containsClazz(final Clazz clazz) {
        boolean contais = getClazz() == clazz;
        if (contais) return true;
        if (Objects.nonNull(subClazz)) {
            contais = subClazz.contains(clazz.name());
            if (contais) return true;
        }
        return getContainmentClass() == clazz;
    }

    public Set<String> getTag() {
        return tag;
    }

    public boolean containsTag(final String tag) {
        return this.tag.contains(tag);
    }

    public void addTag(final String tag) {
        this.tag.add(tag);
    }

    public boolean canPartner() {
        return canPartner;
    }

    public void enableCanPartner(final boolean canPartner) {
        this.canPartner = canPartner;
    }

    public void enableCanPartner() {
        this.canPartner = true;
    }

    public void disableCanPartner() {
        this.canPartner = false;
    }

    public boolean canCrossTest() {
        return crossTestable && crossTestCount < crossTestsCount;
    }

    public void enableCanCrossTest(final boolean canCrossTest) {
        this.crossTestable = canCrossTest;
    }

    public void enableCanCrossTest() {
        this.crossTestable = true;
    }

    public void disableCanCrossTest() {
        this.crossTestable = false;
    }

    public int getCrossTestsCount() {
        return crossTestsCount;
    }

    public void setCrossTestsCount(final int crossTestsCount) {
        this.crossTestsCount = crossTestsCount;
    }

    public int getCrossTestCount() {
        return crossTestCount;
    }

    protected void addCrossTestCount(final int crossTestCount) {
        this.crossTestCount += crossTestCount;
    }

    protected void resetCrossTestCount() {
        this.crossTestCount = 0;
    }

    protected void addCrossTestCount() {
        this.crossTestCount++;
    }

    public void minusSecure(final int point) {
        setSecure(getSecure() - point);
    }

    public void minusSecure() {
        setSecure(getSecure() - 1);
    }

    @Override
    public Scp clone() {
        return new Scp(getParent(), getCategory().name(), getName(), canDecommission(), getEffects(), isPartner, cost, secure, clazz, subClazz, containmentClass, tag, canPartner, crossTestable, crossTestsCount, crossTestCount);
    }

    @Override
    public void refresh() {
        crossTestCount = 0;
        super.refresh();
    }

    public int crossTest() {
        if (canCrossTest() && crossTestCount < crossTestsCount) {
            addCrossTestCount();
            return getSecure();
        }
        return -1;
    }

    public void addTags(String[] tags) {
        for (String tag : tags) {
            addTag(tag);
        }
    }
}
