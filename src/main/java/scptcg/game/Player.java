package scptcg.game;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.Pair;
import scptcg.game.card.*;
import scptcg.game.effect.Effect;

import java.util.List;

import static scptcg.game.Place.*;
import static scptcg.game.effect.EFFECT_TYPE_LIST.DECOMMISSIONED;

public class Player implements ICardSetHolder {

    protected String name;
    protected Game parent;
    protected SandBox[] sandbox = new SandBox[3];
    protected Tales tale;
    protected PersonnelFile personnelFile;
    protected AnomalousRocker rocker;
    protected Site site;
    protected Decommissioned decommissioned;
    protected Exclusion exclusion;

    protected int activeTale = 0;

    public Player(Game parent, String[][] name, String playerName) {
        sandbox[0] = SandBox.createSafe(this, name[0]);
        sandbox[1] = SandBox.createEuclid(this, name[1]);
        sandbox[2] = SandBox.createKeter(this, name[2]);
        tale = Tales.create(this, name[3]);
        site = new Site(this);
        personnelFile = PersonnelFile.create(this, name[4][0]);
        decommissioned = new Decommissioned(this);
        this.parent = parent;
        this.name = playerName;
    }

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.site.getCost();
    }

    public int getProtectionForce(int place) {
        return this.sandbox[place].getProtectionForce();
    }

    public String[] getMyDeckList(int place) {
        return this.sandbox[place].getSandboxString();
    }

    public String[] getPartnerList() {
        return sandbox[0].getPartnerList();
    }

    public int getEmptySite() {
        return site.getEmptySite();
    }

    public int[] getEmptySiteList() {
        return site.getEmptySiteList();
    }

    public Game getGame() {
        return this.parent;
    }

    public int getActiveTaleNumber() {
        return activeTale;
    }

    public int getTurnNumber() {
        return getPlayerNumber();
    }

    public int getTurn() {
        return this.parent.getTurn();
    }

    public String getTale(int i) {
        return tale.tale.get(i).getName();
    }

    public Personnel getPersonnel() {
        return this.personnelFile.getPersonnel();
    }

    public int getSiteNumber() {
        return this.site.size - this.site.getEmptySiteNumber();
    }

    public int[] getSandboxNumber() {
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.sandbox[i].getNumber();
        }
        return arr;
    }

    public boolean hasPersonnel() {
        return personnelFile.hasPersonnel();
    }

    public boolean siteHas(int place) {
        return site.hasSCP(place);
    }

    public boolean canAttack(int i) {
        return this.site.canAttack(i);
    }

    public void nextTurn() {
        this.site.nextTurn();
        this.tale.nextTurn();
        this.personnelFile.nextTurn();
        this.activeTale = 0;
    }

    public void activeTale() {
        activeTale++;
    }

    protected Scp searchSandBox(String name) {
        for (SandBox box : sandbox) {
            Scp tmp = box.searchSandBox(name);
            if (tmp != null) {
                return tmp;
            }
        }
        return null;
    }

    protected Scp searchSandBox(String name, int place) {
        Scp tmp = sandbox[place].searchSandBox(name);
        if (tmp != null) {
            return tmp;
        }
        return null;
    }

    Scp selectPartner(String name, int place) {
        Scp tmp = searchSandBox(name);
        assert tmp != null;
        tmp.partnerIs();
        site.breachPartner(place, tmp);
        this.shuffle();
        return tmp;
    }

    private void shuffle() {
        for (SandBox box : sandbox) {
            box.shuffle();
        }
    }

    public Scp firstDamage(int damage, int place) {
        return sandbox[place].damage(damage);
    }

    public int healSandBox(int clazz, int num) {
        return sandbox[clazz].Heal(num);
    }

    Scp damage(int objClass, int damage) {
        return this.sandbox[objClass].damage(damage);
    }

    List<Effect> breach(Scp card, int place) {
        if (card != null) {
            card.partnerIsn_t();
            return site.breach(place, card);
        } else {
            throw new RuntimeException("card is null");
        }
    }

    public Pair<Scp, List<Effect>> breach(ObjectClassKind clazz, String name, int index, Place place) {
        CardHolder before = getHolder(place, index);
        Scp tmp = sandbox[classToNumber(clazz)].searchSandBox(name);
        return Pair.of(tmp, site.breach(index, tmp));
    }

    private CardHolder getHolder(Place place, int index) {
        switch (place) {
            case SITE:
                return site;
            case DECOMMISSIONED:
                return decommissioned;
            case TALES:
                return tale;
            case PERSONNEL_FILE:
                return personnelFile;
            case EXCLUSION:
                return exclusion;
            case SANDBOX:
                return sandbox[index];
            default:
                return null;
        }
    }

    public int crossTest(int place) {
        return site.crossTest(place);
    }

    public List<Effect> decommission(Card c) {
        if (c instanceof Scp) {
            this.site.decommission(site.getNumber(c));
        } else if (c instanceof Personnel) {
            this.personnelFile.decommission();
        } else if (c instanceof Tale) {
            this.tale.decommission((Tale) c);
        }
        this.decommissioned.addCard(c);
        return c.getEffectList(DECOMMISSIONED);
    }

    public Pair<Card, List<Effect>> decommission(Place place, int index, int player) {
        Card tmp = null;
        switch (place) {
            case SITE:
                tmp = site.decommission(index);
                break;
            case PERSONNEL_FILE:
                tmp = personnelFile.decommission();
                break;
        }
        decommissioned.addCard(tmp);
        assert tmp != null;
        return Pair.of(tmp, tmp.getEffectList(DECOMMISSIONED));
    }

    public int[] select(String... param) {
        Place p = create(param[0]);
        switch (p) {
            case SITE:
                return this.site.select(ArrayUtils.remove(param, 0));
        }
        return null;
    }

    public Card find(Place place, int index) {
        return getPlace(place).getCard(index);
    }

    public int find(Place place, Card waitingEffect) {
        return getPlace(place).getNumber(waitingEffect);
    }

    private CardHolder getPlace(Place place) {
        switch (place) {
            case TALES:
                return tale;
            case SITE:
                return site;
        }
        return null;
    }

    public Card findCard(String s) {
        Card tmp;
        tmp = site.findCard(s);
        if (tmp != null) {
            return tmp;
        }
        for (int i = 0; i < sandbox.length; i++) {
            tmp = sandbox[i].findCard(s);
            if (tmp != null) {
                return tmp;
            }
        }
        tmp = decommissioned.findCard(s);
        if (tmp != null) {
            return tmp;
        }
        tmp = personnelFile.findCard(s);
        if (tmp != null) {
            return tmp;
        }
        tmp = tale.findCard(s);
        if (tmp != null) {
            return tmp;
        }
        tmp = exclusion.findCard(s);
        if (tmp != null) {
            return tmp;
        }
        return null;
    }

    public int reContainment(Card c, Place place) {
        CardHolder before = null;
        CardHolder after = null;
        switch (c.getPlace()) {
            case DECOMMISSIONED:
                before = decommissioned;
                break;
            case SITE:
                before = site;
                break;
        }

        int index = -1;
        switch (place) {
            case TALES:
                after = tale;
                break;
            case PERSONNEL_FILE:
                after = personnelFile;
                break;
            case SANDBOX:
                ObjectClassKind clazz = ((Scp) c).getContainmentClass();
                if (clazz == null) {
                    clazz = ((Scp) c).getClazz();
                }
                if (clazz == null) {
                    break;
                }
                switch (clazz) {
                    case SAFE:
                        index = 0;
                        break;
                    case EUCLID:
                        index = 1;
                        break;
                    case KETER:
                        index = 2;
                        break;
                }
                after = sandbox[index];
                break;
        }
        before.deleteCard(c);
        int i = after.addCard(c);
        if (place == SANDBOX) {
            return index;
        }
        return i;
    }

    public String[] getDecommissinoed() {
        return decommissioned.getDecommissionedString();
    }

    public Card getDecommissionedTop() {
        return decommissioned.getTop();
    }

    public boolean hasSCP(String[] param) {
        return site.select(param).length > 0;
    }

    public Player getEnemy() {
        return parent.getEnemy(this);
    }

    public int getEnemyNumber() {
        return parent.getEnemyNumber(name);
    }

    public int getPlayerNumber() {
        return parent.getPlayerNumber(name);
    }

    public Card getCard(Place place, int i) {
        switch (place) {
            case SITE:
                return site.getCard(i);
        }
        return null;
    }

    public void addTag(CardKind kind, int index, String tag) {
        switch (kind) {
            case SCP:
                site.addTag(index, tag);
                break;
        }
    }

    private int classToNumber(ObjectClassKind clazz) {
        switch (clazz) {
            case SAFE:
                return 0;
            case EUCLID:
                return 1;
            case KETER:
                return 2;
            default:
                return -1;
        }
    }

    public int getProtectionForceSandBox(int clazz) {
        return sandbox[clazz].getProtectionForce();
    }

    public int getCardNumber(Place place, int clazz) {
        switch (place) {
            case SANDBOX:
                return sandbox[clazz].getNumber();
            default:
                break;
        }
        return -1;
    }

    public List<Effect> getEffectList(int timing) {
        return this.site.getEffectList(timing);
    }

    public boolean isMyTurn() {
        return parent.getTurnPlayer() == parent.getMyTurn(this);
    }

}
