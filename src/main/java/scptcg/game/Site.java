package scptcg.game;

import org.apache.commons.lang3.ArrayUtils;
import scptcg.game.card.Anomalous;
import scptcg.game.card.Card;
import scptcg.game.card.CardKind;
import scptcg.game.card.Scp;
import scptcg.game.effect.Effect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static scptcg.game.K_ClassScenario.*;
import static scptcg.game.Place.*;
import static scptcg.game.card.CardKind.*;
import static scptcg.game.effect.EFFECT_TYPE_LIST.*;

public class Site extends CardHolder {

    protected List<Scp> site;
    int size = 6;
    private int anomalousCost = 0;

    Site(Player parent) {
        super(parent);
        site = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            site.add(null);
        }
    }

    private static int[] asList(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int getForce(int place) {
        if (site.size() <= place) {
            throw new RuntimeException("this place is bigger than length");
        }
        return site.get(place).getSecure();
    }

    protected int getCost() {
        int cost = 0;
        for (Scp scp : this.site) {
            if (scp != null) {
                if (scp.getType() == SCP) {
                    cost += scp.getCost();
                } else {
                    if (scp.getType() != null)
                        System.out.println(scp.getType().toString());
                }
            }
        }
        return cost + getAnomalousCost();
    }

    private int getAnomalousCost() {
        return this.anomalousCost;
    }

    private void setAnomalousCost(int cost) {
        this.anomalousCost = cost;
    }

    int getEmptySite() {
        for (int i = 0; i < site.size(); i++) {
            if (site.get(i) == null) {
                return i;
            }
        }
        return -1;
    }

    int[] getEmptySiteList() {
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < site.size(); i++) {
            if (site.get(i) == null) {
                arr.add(i);
            }
        }
        return asList(arr);
    }

    int getEmptySiteNumber() {
        int count = 0;
        for (Scp scp : site) {
            if (scp == null) {
                count++;
            }
        }
        return count;
    }

    boolean hasSCP(int place) {
        if (place >= site.size()) {
            throw new RuntimeException("place is bigger than site num");
        }
        return site.get(place) != null;
    }

    public boolean canAttack(int i) {
        return this.site.get(i).canAttack();
    }

    private K_ClassScenario isXK() {
        int cost = 0;
        boolean anom = false;
        for (Scp s : site) {
            if (s != null) {
                if ((s instanceof Anomalous) && !anom) {
                    anom = true;
                    cost += this.anomalousCost;
                } else {
                    cost += s.getCost();
                }
            }
        }
        if (cost >= ((Player) this.parent).getGame().getXkCost()) {
            return XK;
        }
        return null;
    }

    @Override
    public Place getPlace() {
        return SITE;
    }

    @Override
    public int getNumber(Card parent) {
        return site.indexOf(parent);
    }

    private boolean fullTerm(Scp card, String... param) {
        if (param.length == 0) {
            return true;
        }
        for (int i = 0; i < param.length; i++) {
            if (param[i] == null) continue;
            switch (param[i]) {
                case "notPartner":
                    if (card.isPartner()) {
                        return false;
                    }
                    break;
                case "cost":
                    if (Integer.parseInt(param[++i]) != card.getCost()) {
                        return false;
                    }
                    break;
                case "secure":
                    if (Integer.parseInt(param[++i]) != card.getSecure()) {
                        return false;
                    }
                    break;
                case "crossTested":
                    if (!card.isCrossTested()) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    public boolean onlyPartner() {
        boolean only = true;
        for (Scp s : site) {
            if (!only) {
                break;
            }
            if (s == null) {
                continue;
            }
            only = s.isPartner();
        }
        return only;
    }

    public boolean hasCost(int cost) {
        for (Scp s : site) {
            if (s == null) {
                continue;
            }
            boolean b = (cost == s.getCost());
            if (b) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSecure(int cost) {
        for (Scp s : site) {
            if (s == null) {
                continue;
            }
            boolean b = (cost == s.getSecure());
            if (b) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int[] select(String full) {
        return super.select(full, site);
    }

    public int[] select(String... param) {
        int[] index = this.select(param[0]);
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            Scp tmp = site.get(index[i]);
            if (tmp == null) {
                continue;
            }
            if (fullTerm(tmp, ArrayUtils.remove(param, 0))) {
                li.add(index[i]);
            }
        }
        int[] res = new int[li.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = li.get(i);
        }
        return res;
    }

    @Override
    public void deleteCard(Card card) {
        if (card instanceof Scp) {
            super.deleteCard(card, site);
        } else {
            throw new RuntimeException("card isn't site");
        }
    }

    public void nextTurn() {
        for (Scp scp : this.site) {
            if (scp != null) {
                scp.refresh();
            }
        }
    }

    public int crossTest(int place) {
        return this.site.get(place).crossTest();
    }

    public Scp decommission(int index) {
        Scp tmp = site.get(index);
        deleteCard(tmp);
        return tmp;
    }

    public void breach(int[] place, int cost, Anomalous... card) {
        for (int i = 0; i < card.length; i++) {
            breach(place[i], card[i]);
        }
        this.setAnomalousCost(cost);
    }

    public List<Effect> breach(int place, Scp card) {
        breachPartner(place, card);
        return card.getEffectList(BREACHED);
    }

    public void breachPartner(int place, Scp card) {

        if (place >= ((Player) this.parent).getGame().getNkNumber()) {
            ((Player) this.parent).getGame().ignitionK(NK, (Player) this.parent);
        }

        if (place < size) {
            if (card.getAttackNumber() <= 0) {
                card.setCanAttackNumber(1);
            }
            site.set(place, card);
            card.setParent(this);
            K_ClassScenario k = isXK();
            if (k != null) {
                ((Player) this.parent).getGame().ignitionK(XK, (Player) this.parent);
            }
        }
    }

    @Override
    public Card findCard(String s) {
        return super.findCard(s, site);
    }

    @Override
    public int addCard(Card c) {
        throw new RuntimeException("cannot add");
    }

    @Override
    public Card getCard(int i) {
        return super.getCard(i, site);
    }

    @Override
    public Map<Card, Integer> deleteCardAll(CardKind kind) {
        return deleteCardAll(site, kind);
    }

    public boolean hasCrossTested() {
        for (Scp s : site) {
            if (s == null) {
                continue;
            }
            boolean b = (s.getAttackNumber() > 0);
            if (b) {
                return true;
            }
        }
        return false;
    }

    public void addTag(int index, String tag) {
        site.get(index).addTag(tag);
    }

    public List<Effect> getEffectList(int timing) {
        List<Effect> list = new ArrayList<>();
        for (Scp tmp : site) {
            if (tmp != null) {
                list.addAll(tmp.getEffectList(timing));
            }
        }
        return list;
    }
}
