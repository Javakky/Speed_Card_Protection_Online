package scptcg.game;

import scptcg.game.card.*;
import scptcg.game.effect.ConditionParameter;
import scptcg.game.effect.Effect;
import scptcg.game.effect.Trigger;
import scptcg.json.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static scptcg.game.SandBox.*;

public class Player {

    protected String name;
    protected Game parent;
    protected Tales tales;
    protected PersonnelFile personnelFile;
    protected AnomalousRocker rocker;
    protected Site site;
    protected Decommissioned decommissioned;
    protected Exclusion exclusion;

    private SandBox safe;
    private SandBox euclid;
    private SandBox keter;

    private CardHolder[] areas = null;

    public Player(Game parent, String name, Deck deck, int xk, int nk) {
        this.name = name;
        this.parent = parent;
        tales = new Tales(this, createCard(CardCategory.Tale, deck.Tale));
        personnelFile = new PersonnelFile(this, createCard(CardCategory.Personnel, deck.Personnel));
        rocker = new AnomalousRocker(this, createCard(CardCategory.Anomalous, deck.Anomalous));
        site = new Site(this, xk, nk - 1);
        decommissioned = new Decommissioned(this);
        exclusion = new Exclusion(this);
        safe = createSafe(createCard(CardCategory.SCP, deck.Safe));
        euclid = createEuclid(createCard(CardCategory.SCP, deck.Euclid));
        keter = createKeter(createCard(CardCategory.SCP, deck.Keter));
        getTmpAleas();
    }

    private Card[] createCard(CardCategory category, String[] names) {
        if (names != null) {
            Card[] result = new Card[names.length];
            for (int i = 0; i < names.length; i++) {
                result[i] = CardFactory.create(names[i], category);
            }
            return result;
        } else return new Card[0];
    }


    private static int classToNumber(Clazz clazz) {
        switch (clazz) {
            case Safe:
                return 0;
            case Euclid:
                return 1;
            case Keter:
                return 2;
            default:
                return -1;
        }
    }

    private CardHolder[] getTmpAleas() {
        if (Objects.isNull(areas)) {
            areas = new CardHolder[]{
                    site,
                    safe,
                    euclid,
                    keter,
                    rocker,
                    personnelFile,
                    tales,
                    decommissioned,
                    exclusion
            };
        }
        return areas;
    }

    private SandBox createSafe(Card... scp) {
        return new SandBox(this, Clazz.Safe, SAFE_PROTECTION_FORCE, SAFE_CARD_NUMBER, scp);
    }

    private SandBox createEuclid(Card... scp) {
        return new SandBox(this, Clazz.Euclid, EUCLID_PROTECTION_FORCE, EUCLID_CARD_NUMBER, scp);
    }


    public boolean isFirst() {
        return parent.isFirst(this);
    }

    private SandBox createKeter(Card... scp) {
        return new SandBox(this, Clazz.Keter, KETER_PROTECTION_FORCE, KETER_CARD_NUMBER, scp);
    }

    public boolean isMyTurn() {
        return parent.isTurnPlayer(this);
    }

    public Player getEnemy() {
        return parent.getEnemy(this);
    }

    public Game getGame() {
        return parent;
    }

    public boolean hasPersonnel() {
        return personnelFile.hasPersonnel();
    }

    public boolean hasSCP(Zone zone, ConditionParameter[] condition) {
        return getArea(zone).hasCard(CardCategory.SCP, condition);
    }

    private CardHolder getArea(Zone targetZone) {
        switch (targetZone) {
            case Tales:
                return tales;
            case Site:
                return site;
            case SafeSandbox:
                return safe;
            case EuclidSandbox:
                return euclid;
            case KeterSandbox:
                return keter;
            case Exclusion:
                return exclusion;
            case PersonnelFile:
                return personnelFile;
            case Decommissioned:
                return decommissioned;
            case AnomalousRocker:
                return rocker;
        }
        throw new IllegalArgumentException("Playerはそのエリアを保持していません：" + targetZone.name());
    }

    public int reContainment(Scp card, Clazz clazz) {
        if (Objects.isNull(clazz)) clazz = card.getContainmentClass();
        CardHolder before = getArea(card.whereZone());
        CardHolder after = getSandBox(clazz);
        before.deleteCard(card);
        int index = after.addCard(card);
        return index;
    }


    private SandBox getSandBox(Clazz clazz) {
        switch (clazz) {
            case Safe:
                return safe;
            case Euclid:
                return euclid;
            case Keter:
                return keter;
        }
        throw new IllegalArgumentException("不正なクラスです");
    }

    public int[] getSelectables(boolean isThere, ConditionParameter[] condition) {
        return site.getSelectables(isThere, condition);
    }

    public List<Effect> getEffects(Zone zone, Trigger trigger) {
        return getArea(zone).getEffects(trigger);
    }

    public List<Effect> getEffects(Trigger trigger) {
        List<Effect> result = new ArrayList<>();
        for (CardHolder area : getTmpAleas()) {
            result.addAll(getEffects(trigger, area));
        }
        return result;
    }

    public List<Effect> getEffects(Trigger trigger, CardHolder area) {
        List<Effect> result = new ArrayList<>();
        List<Effect> arr = area.getEffects(trigger);
        if (Objects.nonNull(arr)) result.addAll(arr);
        return result;
    }


    public List<Effect> getEffects(Trigger trigger, Zone zone) {
        return getEffects(trigger, getArea(zone));
    }

    public List<Effect> getEffects(Trigger trigger, Zone... zone) {
        List<Effect> result = new ArrayList<>();
        for (Zone tmp : zone) {
            result.addAll(getEffects(trigger, getArea(tmp)));
        }
        return result;
    }

    public int getRemainSandBox(Clazz clazz) {
        return getSandBox(clazz).getCardCount();
    }

    public Card getCard(Zone zone, int index) {
        return getArea(zone).getCard(index);
    }

    public Card getCard(Zone zone, String name) {
        System.out.println(zone.name());
        return getArea(zone).find(name);
    }

    public int getProtection(Clazz clazz) {
        return getSandBox(clazz).getProtection();
    }

    public int indexOfCard(Zone zone, Card card) {
        return getArea(zone).indexOf(card);
    }

    public void addTag(Zone zone, int index, String[] tags) {
        getArea(zone).addTag(index, tags);
    }

    public void addEffect(Zone zone, int index, Effect effects, Trigger trigger) {
        getArea(zone).addEffect(index, effects, trigger);
    }

    public int getTurn() {
        return getGame().getTurn();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Effect getEffect(Zone zone, int index, Trigger trigger, int effectIndex) {
        return getArea(zone).getEffect(index, trigger, effectIndex);
    }

    public List<Effect> getEffects(Zone zone, int index, Trigger trigger) {
        return getArea(zone).getEffects(index, trigger);
    }

    public int effectSize(Zone zone, Trigger trigger, int index) {
        return getArea(zone).effectSize(index, trigger);
    }

    public void nextTurn() {
        for (CardHolder area : getTmpAleas()) {
            area.nextTurn();
        }
    }

    public Card[] getPartnerables() {
        return safe.getPartnerables();
    }

    public Card find(CardHolder area, String name) {
        return area.find(name);
    }

    public Card find(Zone zone, String name) {
        return getArea(zone).find(name);
    }

    public Card find(String name) {
        for (CardHolder area : getTmpAleas()) {
            Card result = find(area, name);
            if (Objects.nonNull(result)) {
                return result;
            }
        }
        return null;
    }

    public Scp breach(String name, Clazz clazz, int index) {
        Scp card = (Scp) getSandBox(clazz).pick(name);
        card.toPartner(false);
        site.breach(index, card);
        shuffle(clazz);
        return card;
    }

    public Scp breachPartner(String name, int index) {
        Scp card = (Scp) safe.pick(name);
        card.toPartner(true);
        site.breach(index, card);
        shuffle(Clazz.Safe);
        return card;
    }

    private void shuffle(Clazz clazz) {
        getSandBox(clazz).shuffle();
    }

    private void shuffle() {
        safe.shuffle();
        euclid.shuffle();
        keter.shuffle();
    }


    public int crossTest(int place) {
        return site.crossTest(place);
    }


    public Card decommission(Zone zone, int index) {
        System.out.println("Zone : " + zone.name());
        Card c = getArea(zone).pick(index);
        if (Objects.isNull(c)) throw new NullPointerException();
        this.decommissioned.addCard(c);
        return c;
    }

    public Card decommission(Zone zone, Card card) {
        if (Objects.isNull(card)) throw new NullPointerException();
        getArea(zone).deleteCard(card);
        this.decommissioned.addCard(card);
        return card;
    }


    public boolean canCrossTest(int index) {
        return site.canCrossTest(index);
    }

    public void damage(Clazz clazz, int point, List<Scp> breached) {
        Scp tmp = getSandBox(clazz).damage(point);
        breached.add(tmp);
    }

    public int heal(Clazz clazz, int point) {
        return getSandBox(clazz).heal(point);
    }

    public Card[] getCards(Zone zone) {
        return getArea(zone).getCards();
    }

    public int getSumSiteCost() {
        return site.getCost();
    }

    public int getSCPCount() {
        return site.getScpCount();
    }

    public int[] getSandBoxProtection() {
        return new int[]{
                safe.getProtection(),
                euclid.getProtection(),
                keter.getProtection()
        };
    }

    public Card getTop(Zone zone) {
        return getArea(zone).getTop();
    }

}
