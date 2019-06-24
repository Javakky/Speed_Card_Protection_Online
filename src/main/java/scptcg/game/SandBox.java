package scptcg.game;

import org.apache.commons.lang3.NotImplementedException;
import scptcg.game.card.Card;
import scptcg.game.card.CardCategory;
import scptcg.game.card.Clazz;
import scptcg.game.card.Scp;

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

    public SandBox(Player parent, Clazz clazz, int maxProtectionForce, int size, Scp... sandBox) {
        if (size != sandBox.length) throw new IllegalArgumentException("カードの枚数が適切ではありません");
        this.sandBox = Arrays.asList(sandBox);
        this.clazz = clazz;
        this.maxProtectionForce = maxProtectionForce;
        this.protectionForce = maxProtectionForce;
        this.size = size;
        this.parent = parent;
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
        return Zone.Sandbox;
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
            return draw();
        }
        return null;
    }

    public boolean remainProtection() {
        return this.protectionForce > 0;
    }

    public Scp damage(int point) {
        if (point <= 0) {
            throw new IllegalArgumentException("pointが0以下です");
        } else if (point != 1) {
            protectionForce -= (point - 1);
        }
        return damage();
    }

    public void heal(int point) {
        protectionForce += point;
        if (protectionForce > maxProtectionForce) {
            refreshProtection();
        }
    }

    @Override
    public int indexOf(Card card) {
        return CardHolder.indexOf(card, sandBox);
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
}
