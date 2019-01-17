package scptcg.game;

import scptcg.game.card.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static scptcg.game.K_ClassScenario.*;
import static scptcg.game.Place.*;
import static scptcg.game.card.ObjectClassKind.*;

public class SandBox extends CardHolder {

    public static final int SAFE_PROTECTION_FORCE = 4;
    public static final int EUCLID_PROTECTION_FORCE = 8;
    public static final int KETER_PROTECTION_FORCE = 12;
    public static final int SAFE_CARD_NUMBER = 7;
    public static final int EUCLID_CARD_NUMBER = 4;
    public static final int KETER_CARD_NUMBER = 2;
    List<Scp> sandBox;
    int size;
    private int maxProtectionForce;
    private int protectionForce;

    private SandBox(int num, int pf, Player parent) {
        this(parent);
        sandBox = new ArrayList<Scp>(num);
        this.size = num;
        for (int i = 0; i < num; i++) {
            sandBox.add(null);
        }
        this.maxProtectionForce = pf;
        this.protectionForce = pf;
    }

    SandBox(Player parent) {
        super(parent);
    }

    static SandBox createSafe(Player parent, String... name) {
        return create(SAFE_CARD_NUMBER, SAFE_PROTECTION_FORCE, parent, name);
    }

    static SandBox createEuclid(Player parent, String... name) {
        return create(EUCLID_CARD_NUMBER, EUCLID_PROTECTION_FORCE, parent, name);
    }

    static SandBox createKeter(Player parent, String... name) {
        return create(KETER_CARD_NUMBER, KETER_PROTECTION_FORCE, parent, name);
    }

    private static SandBox create(int num, int pf, Player parent, String... name) {
        SandBox tmp = new SandBox(num, pf, parent);
        tmp.setCard(name);
        return tmp;
    }

    public static ObjectClassKind numberToClass(int number) {
        switch (number) {
            case 0:
                return SAFE;
            case 1:
                return EUCLID;
            case 2:
                return KETER;
            default:
                return null;
        }
    }

    int getProtectionForce() {
        return this.protectionForce;
    }

    public int getMaxProtectionForce() {
        return this.maxProtectionForce;
    }

    String[] getSandboxString() {
        String[] str = new String[this.size()];
        for (int i = 0; i < this.size(); i++) {
            str[i] = this.sandBox.get(i).getName();
        }
        return str;
    }

    public int size() {
        return this.size;
    }

    public boolean isBreach() {
        return protectionForce <= 0;
    }

    public int getNumber() {
        int count = 0;
        for (int i = 0; i < sandBox.size(); i++) {
            if (this.sandBox.get(i) != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Place getPlace() {
        return SANDBOX;
    }

    @Override
    public int getNumber(Card parent) {
        return sandBox.indexOf(parent);
    }

    public String[] getPartnerList() {
        StringBuilder sb = new StringBuilder();
        List<String> txt = new ArrayList<>();
        for (Scp s : sandBox) {
            if (s != null && s.canPartner()) {
                txt.add(s.getName());
            }
        }
        return txt.toArray(new String[txt.size()]);
    }

    public void setCard(String... name) {
        List<Scp> l = new ArrayList<>();
        int j = 0;
        for (String n : name) {
            Scp tmp = (Scp) CardFactory.create(this, n, CardKind.SCP);
            if (tmp.canPartner()) {
                sandBox.set(j, tmp);
                j++;
            } else {
                l.add(tmp);
            }
        }
        int i = size - l.size();
        for (Scp s : l) {
            sandBox.set(i, s);
            i++;
        }
    }

    @Override
    public int[] select(String full) {
        return super.select(full, sandBox);
    }

    @Override
    public void deleteCard(Card card) {
        super.deleteCard(card, sandBox);
    }

    public void shuffle() {
        Collections.shuffle(sandBox);
    }

    public Scp searchSandBox(String name) {
        for (int i = 0; i < sandBox.size(); i++) {
            if (sandBox.get(i).getName().equals(name)) {
                Scp tmp = sandBox.get(i);
                sandBox.remove(tmp);
                shuffle();
                return tmp;
            }
        }
        return null;
    }

    protected void RefreshProtectionForce() {
        this.protectionForce = this.maxProtectionForce;
    }

    public Scp drawSandBox() {

        if (sandBox.size() <= 0) {
            ((Player) this.parent).parent.ignitionK(ZK, (Player) this.parent);
            return null;
        }

        Scp tmp = sandBox.get(0);

        sandBox.remove(tmp);
        return tmp;
    }

    public Scp damage() {
        this.protectionForce--;
        if (isBreach()) {
            Scp tmp = drawSandBox();
            RefreshProtectionForce();
            return tmp;
        }
        return null;
    }

    public Scp damage(int dam) {
        if (dam <= 0) {
            return null;
        } else if (dam != 1) {
            protectionForce -= (dam - 1);
        }
        return damage();
    }

    public int Heal(int num) {
        protectionForce += num;
        if (protectionForce > maxProtectionForce) {
            int t = protectionForce - maxProtectionForce;
            protectionForce -= t;
            RefreshProtectionForce();
            return num - t;
        }
        return num;
    }

    @Override
    public Card findCard(String s) {
        return super.findCard(s, sandBox);
    }

    @Override
    public int addCard(Card c) {
        sandBox.add((Scp) c);
        c.setParent(this);
        shuffle();
        return -1;
    }

    @Override
    public Card getCard(int i) {
        return super.getCard(i, sandBox);
    }

}
