package scptcg.game;

import org.apache.commons.lang3.NotImplementedException;
import scptcg.game.card.Card;
import scptcg.game.card.CardCategory;
import scptcg.game.card.Clazz;
import scptcg.game.card.Scp;
import scptcg.game.effect.ConditionParameter;
import scptcg.game.effect.Effect;
import scptcg.game.effect.Trigger;

import java.util.*;

import static scptcg.game.K_Class.*;

public class SandBox implements CardHolder {
    public static final int SAFE_PROTECTION_FORCE = 4;
    public static final int EUCLID_PROTECTION_FORCE = 8;
    public static final int KETER_PROTECTION_FORCE = 12;
    public static final int SAFE_CARD_NUMBER = 7;
    public static final int EUCLID_CARD_NUMBER = 4;
    public static final int KETER_CARD_NUMBER = 2;
    private List<Scp> sandBox;
    private Clazz clazz;
    private int maxProtectionForce;
    private int protectionForce;
    private int size;
    private Player parent;
    private Zone zone;

    public SandBox(Player parent, Clazz clazz, int maxProtectionForce, int size, Card... sandBox) {
        if (size > sandBox.length) throw new IllegalArgumentException("カードの枚数が適切ではありません");
        this.sandBox = new ArrayList<>();
        for (Card box : sandBox) {
            this.sandBox.add((Scp) box);
        }
        this.clazz = clazz;
        this.maxProtectionForce = maxProtectionForce;
        this.protectionForce = maxProtectionForce;
        this.size = size;
        this.parent = parent;
        this.zone = classToZone(clazz);
        for (Card c : sandBox) c.setParent(this);
        shuffle();

    }

    private Zone classToZone(Clazz clazz) {
        switch (clazz) {
            case Safe:
                return Zone.SafeSandbox;
            case Euclid:
                return Zone.EuclidSandbox;
            case Keter:
                return Zone.KeterSandbox;
        }
        return null;
    }

    public int getProtection() {
        return this.protectionForce;
    }

    public int getMaxProtectionForce() {
        return this.maxProtectionForce;
    }

    public Scp draw() {
        if (sandBox.size() <= 0) {
            getGame().ignitionK(ZK, this.parent);
            return null;
        }
        Scp tmp = pop();
        return tmp;
    }

    public Scp[] getPartnerables() {
        if (clazz != Clazz.Safe) throw new NotImplementedException("Safe以外のサンドボックスからカードを選ぶことはできません");
        List<Scp> partners = new ArrayList<>();
        for (Scp card : sandBox) {
            if (card.canPartner()) partners.add(card);
        }
        return partners.toArray(new Scp[0]);
    }

    public void shuffle() {
        Collections.shuffle(sandBox);
    }

    protected void refreshProtection() {
        this.protectionForce = this.maxProtectionForce;
    }

    @Override
    public Player getPlayer() {
        return parent;
    }

    @Override
    public Zone getZone() {
        return zone;
    }

    @Override
    public void nextTurn() {
    }

    @Override
    public void deleteCard(Card card) {
        CardHolder.deleteCard(card, sandBox);
    }

    @Override
    public Card find(String cardName) {
        return CardHolder.find(cardName, sandBox);
    }

    @Override
    public int addCard(Card card) {
        if (card instanceof Scp) {
            sandBox.add((Scp) card);
            card.setParent(this);
            return sandBox.size() - 1;
        }
        throw new IllegalArgumentException("cardはSCPではありません");
    }

    @Override
    public Card getCard(int index) {
        return CardHolder.getCard(index, sandBox);
    }

    @Override
    public Map<Card, Integer> deleteCardAll(CardCategory category) {
        Map<Card, Integer> map = new HashMap<>();
        Scp[] tmp = sandBox.toArray(new Scp[0]);
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].getCategory() == category) {
                map.put(tmp[i], i);
                tmp[i] = null;
            }
        }
        List<Scp> finalDec = Arrays.asList(tmp);
        finalDec.removeAll(Collections.singleton(null));
        sandBox = finalDec;
        return map;
    }


    public Scp damage() {
        this.protectionForce--;
        if (!remainProtection()) {
            refreshProtection();
            Scp tmp = getTop();
            return tmp;
        }
        return null;
    }

    public boolean remainProtection() {
        return this.protectionForce > 0;
    }

    public Scp damage(int point) {
        if (point <= 0) {
            return null;
        } else if (point != 1) {
            protectionForce -= (point - 1);
        }
        return damage();
    }

    public int heal(int point) {
        int before = protectionForce;
        protectionForce += point;
        if (protectionForce > maxProtectionForce) {
            refreshProtection();
        }
        return protectionForce - before;
    }

    @Override
    public int indexOf(Card card) {
        return CardHolder.indexOf(card, sandBox);
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    @Override
    public void addTag(int index, String[] tags) {
        sandBox.get(index).addTags(tags);
    }

    @Override
    public void addEffect(int index, Effect effect, Trigger trigger) {
        sandBox.get(index).addEffect(effect, trigger);
    }

    @Override
    public boolean hasCard(CardCategory category, ConditionParameter[] condition) {
        for (Card card : sandBox) {
            if (Objects.nonNull(card) && card.getCategory() == category) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getCardCount() {
        return sandBox.size();
    }

    public void setParent(Player parent) {
        this.parent = parent;
    }

    public Scp getTop() {
        return sandBox.size() <= 0 ? null : sandBox.get(sandBox.size() - 1);
    }

    private Scp pop() {
        return sandBox.size() <= 0 ? null : sandBox.remove(sandBox.size() - 1);
    }

    private List<Scp> getSandBox() {
        return sandBox;
    }

    public Clazz getClazz() {
        return clazz;
    }

    private void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public List<Effect> getEffects(Trigger trigger) {
        return CardHolder.getEffects(trigger, sandBox);
    }

    @Override
    public Card[] getCards() {
        return sandBox.toArray(new Card[0]);
    }
}
