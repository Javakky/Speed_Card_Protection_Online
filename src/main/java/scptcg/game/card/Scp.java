package scptcg.game.card;

import scptcg.exception.UnsupportedAnnotationException;
import scptcg.game.CardHolder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Scp extends Card {
    private boolean isPartner;
    private int cost;
    private int secure;
    private String clazz;
    private Set<Clazz> subClazz = new HashSet<>();
    private String containmentClass;
    private Set<String> tag = new HashSet<>();
    private boolean canPartner = true;
    private boolean crossTestable = true;
    private int crossTestsCount;
    private int crossTestCount = 0;

    protected Scp(CardHolder parent) {
        this();
        setParent(parent);
    }

    protected Scp() {
        super(CardCategory.SCP);
        scptcg.annotation.Scp scp = getClass().getAnnotation(scptcg.annotation.Scp.class);
        if (Objects.isNull(scp)) {
            throw new UnsupportedAnnotationException(scptcg.annotation.Scp.class.getName() + "アノテーションのないクラス:" + getClass().getName());
        }
        setCost(scp.cost());
        setSecure(scp.secure());
        setClazz(scp.clazz());
        setTags(new HashSet<>(Arrays.asList(scp.tag())));

        scptcg.annotation.SubClazz subClazz = getClass().getAnnotation(scptcg.annotation.SubClazz.class);
        if (Objects.nonNull(subClazz)) {
            setSubClazz(new HashSet<>(Arrays.asList(subClazz.value())));
        } else {
            setSubClazz(new HashSet<>());
        }

        scptcg.annotation.ContainmentClass containmentClass = getClass().getAnnotation(scptcg.annotation.ContainmentClass.class);
        if (Objects.nonNull(containmentClass)) {
            setContainmentClass(containmentClass.value());
        } else {
            setContainmentClass(getClazz());
        }

        scptcg.annotation.DisablePartner disablePartner = getClass().getAnnotation(scptcg.annotation.DisablePartner.class);
        if (Objects.nonNull(disablePartner)) {
            disablePartner();
        } else {
            enablePartner();
        }

        scptcg.annotation.DisableCrossTest disableCrossTest = getClass().getAnnotation(scptcg.annotation.DisableCrossTest.class);
        if (Objects.nonNull(disableCrossTest)) {
            disableCrossTest();
        } else {
            enableCrossTest();
        }

        scptcg.annotation.MultiCrossTest multiCrossTest = getClass().getAnnotation(scptcg.annotation.MultiCrossTest.class);
        if (Objects.nonNull(multiCrossTest)) {
            if (multiCrossTest.value() < 0) {
                throw new IllegalArgumentException(scptcg.annotation.MultiCrossTest.class.getName() + "アノテーションのvalueが負数です:" + getClass().getName());
            }
            setCrossTestsCount(multiCrossTest.value());
        } else {
            setCrossTestsCount(1);
        }

        resetCrossTestCount();
    }

    private void setTags(Set<String> tag) {
        this.tag = tag;
    }

    public Set<Clazz> getSubClazz() {
        return subClazz;
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

    private void setSubClazz(Set<Clazz> subClazz) {
        this.subClazz = subClazz;
    }

    public void addSubClazz(final Clazz subClazz) {
        this.subClazz.add(subClazz);
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

    public boolean containsClazz(final Clazz clazz) {
        boolean contais = getClazz() == clazz;
        if (contais) return true;
        contais = subClazz.contains(clazz.name());
        if (contais) return true;
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

    public void enablePartner(final boolean canPartner) {
        this.canPartner = canPartner;
    }

    public void enablePartner() {
        this.canPartner = true;
    }

    public void disablePartner() {
        this.canPartner = false;
    }

    public boolean canCrossTest() {
        return crossTestable;
    }

    public void enableCrossTest(final boolean canCrossTest) {
        this.crossTestable = canCrossTest;
    }

    public void enableCrossTest() {
        this.crossTestable = true;
    }

    public void disableCrossTest() {
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
        Scp card = (Scp) super.clone();
        card.setCost(getCost());
        card.setSecure(getSecure());
        card.setClazz(getClazz());
        card.addAllSubClazz(getSubClazz());
        card.setContainmentClass(getContainmentClass());
        card.addTags(tag.toArray(new String[0]));
        card.enablePartner(canPartner());
        card.enableCrossTest(canCrossTest());
        card.setCrossTestsCount(getCrossTestsCount());
        return card;
    }

    protected void addAllSubClazz(Set<Clazz> subClazz) {
        for (Clazz clazz : subClazz) {
            addSubClazz(clazz);
        }
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
