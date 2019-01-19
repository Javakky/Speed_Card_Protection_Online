package scptcg.game.card;

import scptcg.game.CardHolder;
import scptcg.game.effect.Effect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static scptcg.game.Place.*;
import static scptcg.game.card.CardKind.*;

public class Scp extends Card {

    protected boolean isPartner;
    protected int cost;
    protected int secure;
    protected String clazz;
    protected boolean canAttack = true;
    protected int attackNumber = 0;
    protected int canAttackNumber = 1;
    protected List<String> subClazz = new ArrayList<>();
    protected List<String> tag = new ArrayList<String>();
    protected boolean canPartner = true;
    protected String containmentClass;

    protected Scp(
            CardHolder parent, String name, int cost, int secure, List<String> tag, List<String> objc) {
        this(parent, SCP, name, cost, secure, tag, objc);
    }

    protected Scp(
            CardHolder parent,
            CardKind kind,
            String name,
            int cost,
            int secure,
            List<String> tag,
            List<String> clazz) {
        super(parent, kind, name);
        setCost(cost);
        setSecure(secure);
        addTag(tag);
        setClazz(clazz.get(0));

        for (int i = 1; i < clazz.size(); i++) {
            setSubClazz(clazz.get(i));
        }
    }

    public Scp(CardHolder parent, CardKind kind, String name, int cost, int secure, List<String> tag, String clazz, List<String> subClazz) {
        super(parent, kind, name);
        setCost(cost);
        setSecure(secure);
        addTag(tag);
        setClazz(clazz);
        setSubClazz(subClazz);
    }

    private void setSubClazz(List<String> subClazz) {
        this.subClazz = subClazz;
    }

    public int getCost() {
        return cost;
    }

    protected void setCost(int cost) {
        this.cost = cost;
    }

    public int getSecure() {
        return secure;
    }

    protected void setSecure(int secure) {
        this.secure = secure;
    }

    public ObjectClassKind getClazz() {
        return ObjectClassKind.getByName(clazz);
    }

    protected void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public ObjectClassKind getContainmentClass() {
        if (containmentClass == null || containmentClass.equals("")) {
            return null;
        }
        return ObjectClassKind.getByName(containmentClass);
    }

    public String getTagElement(int num) {
        return tag.get(num);
    }

    public int getTagLength() {
        return tag.size();
    }

    public int getAttackNumber() {
        return attackNumber;
    }

    public boolean canPartner() {
        return canPartner;
    }

    public boolean isPartner() {
        return isPartner;
    }

    public boolean canAttack() {
        return canAttack && attackNumber > 0;
    }

    public void setCanAttackNumber(int canAttackNumber) {
        this.canAttackNumber = canAttackNumber;
    }

    private void setSubClazz(String clazz) {
        subClazz.add(clazz);
    }

    private void addTag(List<String> tag) {
        this.tag.addAll(tag);
    }

    public void partnerIs() {
        isPartner = true;
    }

    public void partnerIsn_t() {
        isPartner = false;
    }

    private void prepareSecure() {
        if (secure < 0) {
            setSecure(0);
        }
    }

    protected void minusSecure(int point) {
        if (point < 0) {
            throw new RuntimeException("minus-Force is minus");
        }
        setSecure(secure - point);
        prepareSecure();
    }

    protected void minusSecure() {
        setSecure(secure - 1);
        prepareSecure();
    }

    public int crossTest() {
        if (attackNumber < canAttackNumber && canAttack) {
            attackNumber++;
            return getSecure();
        }
        return -1;
    }

    public void refresh() {
        super.refresh();
        attackNumber = 0;
    }

    @Override
    public int reContainment() {
        return getMyPlayer().reContainment(this, SANDBOX);
    }

    @Override
    public Card clone() {
        return new Scp(parent, SCP, name, cost, secure, tag, clazz, subClazz);
    }

    public boolean isCrossTested() {
        return attackNumber > 0;
    }

    public List<Effect> getEffectList(int suffix) {
        if (effects != null)
            return effects.getEffectList(suffix);
        return new LinkedList<>();
    }

    public void addTag(String tag) {
        this.tag.add(tag);
    }

    public List<String> getTags() {
        return this.tag;
    }
}
