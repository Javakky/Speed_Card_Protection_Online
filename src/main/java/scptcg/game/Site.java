package scptcg.game;

import org.apache.commons.lang3.ArrayUtils;
import scptcg.game.card.Anomalous;
import scptcg.game.card.Card;
import scptcg.game.card.CardCategory;
import scptcg.game.card.Scp;
import scptcg.game.effect.ConditionParameter;
import scptcg.game.effect.Effect;
import scptcg.game.effect.Trigger;

import java.util.*;

import static scptcg.game.K_Class.*;

public class Site implements CardHolder {

    private int size;
    private Scp[] site;
    private int anomalousCost = 0;
    private Player parent;
    private int maxCost;

    public Site(Player player, int maxCost, int size) {
        parent = player;
        this.maxCost = maxCost;
        this.size = size;
        this.site = new Scp[size];
    }

    @Override
    public Player getPlayer() {
        return parent;
    }

    @Override
    public Zone getZone() {
        return Zone.Site;
    }

    @Override
    public void nextTurn() {
        for (Scp scp : site) {
            if (Objects.nonNull(scp)) {
                scp.refresh();
            }
        }
    }

    @Override
    public void deleteCard(Card card) {
        for (int i = 0; i < site.length; i++) {
            if (site[i] == card) {
                site[i] = null;
            }
        }
    }

    public void deleteCard(int index) {
        site[index] = null;
    }

    @Override
    public Card find(String cardName) {
        for (int i = 0; i < site.length; i++) {
            if (site[i].getName().equals(cardName)) {
                return site[i];
            }
        }
        return null;
    }

    @Override
    public int addCard(Card c) {
        int index = getEmpty();
        if (!(c instanceof Scp)) throw new IllegalArgumentException("引数のカードがSCPではありません");
        site[index] = (Scp) c;
        return index;
    }

    public int getEmpty() {
        for (int i = 0; i < site.length; i++) {
            if (site[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public int emptyCount() {
        int sum = 0;
        for (int i = 0; i < site.length; i++) {
            if (site[i] == null) {
                sum++;
            }
        }
        return sum;
    }

    public int[] getEmptys() {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < site.length; i++) {
            if (site[i] == null) {
                index.add(i);
            }
        }
        return ArrayUtils.toPrimitive(index.toArray(new Integer[0]));
    }

    @Override
    public Card getCard(int index) {
        return site[index];
    }

    @Override
    public Map<Card, Integer> deleteCardAll(CardCategory category) {
        Map<Card, Integer> map = new HashMap<>();
        for (int i = 0; i < site.length; i++) {
            if (site[i].getCategory() == category) {
                map.put(site[i], i);
                site[i] = null;
            }
        }
        return map;
    }

    @Override
    public int indexOf(Card card) {
        for (int i = 0; i < site.length; i++) {
            if (site[i] == card) {
                return i;
            }
        }
        return -1;
    }

    public int[] getSelectables(boolean isThere, ConditionParameter[] condition) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < site.length; i++) {
            if (!isThere && Objects.isNull(site[i])) {
                indexes.add(i);
            } else if (isThere && Objects.nonNull(site[i])) {
                boolean flag = true;
                for (ConditionParameter c : condition) {
                    switch (SelectCondition.valueOf(c.getName())) {
                        case Cost:
                            if (site[i].getCost() != c.getPoint()) flag = false;
                            break;
                        case Secure:
                            if (site[i].getSecure() != c.getPoint()) flag = false;
                            break;
                        case NotPartner:
                            if (site[i].isPartner()) flag = false;
                            break;
                        case CrossTested:
                            if (site[i].getCrossTestCount() <= 0) flag = false;
                            break;
                    }
                }
                if (flag) indexes.add(i);
            }
        }
        return ArrayUtils.toPrimitive(indexes.toArray(new Integer[0]));
    }

    @Override
    public void addTag(int index, String[] tags) {
        site[index].addTags(tags);
    }

    @Override
    public void addEffect(int index, Effect effect, Trigger trigger) {
        site[index].addEffect(effect, trigger);
    }

    @Override
    public boolean hasCard(CardCategory category, ConditionParameter[] condition) {
        for (Scp scp : site) {
            if (Objects.nonNull(scp) && scp.getCategory() == category) {
                boolean flag = true;
                for (ConditionParameter c : condition) {
                    switch (SelectCondition.valueOf(c.getName())) {
                        case Cost:
                            if (scp.getCost() != c.getPoint()) flag = false;
                            break;
                        case Secure:
                            if (scp.getSecure() != c.getPoint()) flag = false;
                            break;
                        case NotPartner:
                            if (scp.isPartner()) flag = false;
                            break;
                        case CrossTested:
                            if (scp.getCrossTestCount() <= 0) flag = false;
                            break;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }

    @Override
    public int getCardCount() {
        return getScpCount();
    }

    @Override
    public List<Effect> getEffects(Trigger trigger) {
        List<Effect> tmp = new ArrayList<>();
        for (Card c : site) {
            if (Objects.nonNull(c)) {
                tmp.addAll(c.getEffects(trigger));
            }
        }
        return tmp;
    }

    @Override
    public Card[] getCards() {
        List<Card> list = Arrays.asList(site);
        list.removeAll(Collections.singleton(null));
        return list.toArray(new Card[0]);
    }

    private Scp[] getSite() {
        return site;
    }

    private void setSite(Scp[] site) {
        this.site = site;
    }

    public int getSize() {
        return size;
    }

    public List<Card> setSize(int size, boolean justified, boolean throwable) {
        Scp[] scp = new Scp[size];
        List<Card> overflow = new ArrayList<>();
        int scpCount = getScpCount();
        if (size < scpCount) {
            if (throwable)
                throw new ArrayIndexOutOfBoundsException("場のSCPの数よりもサイズの方が小さいです。");
        }
        if (!justified) {
            for (int i = size; i < site.length; i++) {
                if (site[i] != null) {
                    if (throwable)
                        throw new ArrayIndexOutOfBoundsException("場のサイズよりも奥にSCPが置かれています");
                    else {
                        overflow.add(site[i]);
                    }
                }
            }
            site = ArrayUtils.subarray(site, 0, size);
        } else {
            List<Scp> tmp = new LinkedList<>();
            for (int i = 0; i < site.length; i++) {
                if (site[i] != null) {
                    if (tmp.size() > size) {
                        int index = tmp.lastIndexOf(null);
                        if (index < 0) {
                            overflow.add(site[i]);
                        } else {
                            tmp.remove(index);
                            tmp.add(site[i]);
                        }
                    } else {
                        tmp.add(site[i]);
                    }
                }
            }
            site = tmp.toArray(new Scp[0]);
        }
        this.size = size;
        return overflow;
    }

    public int getScpCount() {
        int sum = 0;
        for (int i = 0; i < site.length; i++) {
            if (site[i] != null) {
                sum++;
            }
        }
        return sum;
    }

    public boolean isThere(int index) {
        if (site.length >= index)
            throw new ArrayIndexOutOfBoundsException("indexがサイトのサイズよりも大きいです");
        return site[index] != null;
    }

    public boolean canCrossTest(int index) {
        if (site[index] == null) return false;
        return site[index].canCrossTest();
    }

    private K_Class isXK() {
        int cost = 0;
        boolean anomalous = false;
        for (Scp s : site) {
            if (s != null) {
                if (!anomalous && (s instanceof Anomalous)) {
                    anomalous = true;
                    cost += this.anomalousCost;
                } else {
                    cost += s.getCost();
                }
            }
        }
        if (cost >= getMaxCost()) {
            return K_Class.XK;
        }
        return null;
    }


    public int crossTest(int index) {
        return site[index].crossTest();
    }

    public Scp decommission(int index) {
        Scp tmp = site[index];
        deleteCard(index);
        return tmp;
    }

    public void breach(int[] place, int cost, Anomalous... card) {
        for (int i = 0; i < card.length; i++) {
            breach(place[i], card[i]);
        }
        this.setAnomalousCost(cost);
    }

    public void breach(int index, Scp card) {
        if (index >= getSize()) {
            getGame().ignitionK(NK, this.parent);
        }
        site[index] = card;
        card.setParent(this);
        K_Class k = isXK();
        if (k != null) {
            getGame().ignitionK(XK, this.parent);
        }
    }


    public boolean crossTested() {
        for (Scp s : site) {
            if (Objects.isNull(s)) {
                continue;
            }
            if (s.getCrossTestCount() > 0) {
                return true;
            }
        }
        return false;
    }


    public void addTag(int index, String tag) {
        site[index].addTag(tag);
    }

    public List<Effect> getEffectList(Trigger trigger) {
        List<Effect> list = new ArrayList<>();
        for (Scp tmp : site) {
            if (tmp != null) {
                list.addAll(tmp.getEffects(trigger));
            }
        }
        return list;
    }


    public int getSecure(int index) {
        return site[index].getSecure();
    }

    public int getAnomalousCost() {
        return anomalousCost;
    }

    public void setAnomalousCost(int anomalousCost) {
        this.anomalousCost = anomalousCost;
    }

    public void setParent(Player parent) {
        this.parent = parent;
    }

    public int getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(int maxCost) {
        this.maxCost = maxCost;
    }

    public int getCost() {
        int cost = 0;
        boolean anomalous = false;
        for (Scp s : site) {
            if (s != null) {
                if (!anomalous && (s instanceof Anomalous)) {
                    anomalous = true;
                    cost += this.anomalousCost;
                } else {
                    cost += s.getCost();
                }
            }
        }
        return cost;
    }

}
