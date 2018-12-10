package scptcg.game;

import scptcg.game.card.Card;
import scptcg.game.card.Scp;
import scptcg.game.effect.Effect;
import scptcg.game.effect.Result;

import java.util.*;

import static scptcg.game.Place.*;
import static scptcg.game.effect.EFFECT_TYPE_LIST.*;

public class Game implements ICardSetHolder {
    private final int firstPlayer;
    protected HeadCanon canon;
    private int turnPlayer;
    private int turn;
    private int xkCost = 7;
    private int nkNumber = 7;
    private K_ClassScenario kClass = null;
    private int kClassPlayer = -1;
    private Card selectEffect;
    private Scp waitingBreach;
    private boolean onActive = false;
    private boolean onActiveEffect = false;

    private List<List<Effect>> waitingEffects;

    private Player[] player = new Player[2];

    Game(String[][][] deckList, String name1, String name2) {
        int r = new Random(System.currentTimeMillis()).nextInt(2);
        if (r == 0) {
            player[0] = new Player(this, deckList[0], name1);
            player[1] = new Player(this, deckList[1], name2);
        } else {
            player[1] = new Player(this, deckList[0], name1);
            player[0] = new Player(this, deckList[1], name2);
        }
        firstPlayer = 0;
        turnPlayer = this.firstPlayer;
        waitingEffects = new ArrayList<List<Effect>>();
        waitingEffects.add(new ArrayList<Effect>());
    }

    public String getEnemyName(String name) {
        if (player[0].getName().equals(name)) {
            return player[1].getName();
        } else if (player[1].getName().equals(name)) {
            return player[0].getName();
        }
        return null;
    }

    public int getXkCost() {
        return xkCost;
    }

    public int getNkNumber() {
        return nkNumber;
    }

    private int getEnemy(int player) {
        player = player == 0 ? 1 : 0;
        return player;
    }

    public boolean isOnActive() {
        return onActive;
    }

    public boolean isOnActiveEffect() {
        return onActiveEffect;
    }

    public int getKClassPlayer() {
        return this.kClassPlayer;
    }

    public boolean isFirst(String name) {
        return player[firstPlayer].getName().equals(name);
    }

    public int getTurnPlayer() {
        return this.turnPlayer;
    }

    public void nextTurn() {
        this.turn++;
        this.turnPlayer = turnPlayer == 0 ? 1 : 0;
        for (Player p : this.player) {
            p.nextTurn();
        }
    }

    public K_ClassScenario isK_ClassScenario() {
        return this.kClass;
    }

    public String[] getMyDeckList(int player, int place) {
        return this.player[player].getMyDeckList(place);
    }

    public int[] getEmptySite(int player) {
        return this.player[player].getEmptySiteList();
    }

    public String[] getPartnerList(int player) {
        return this.player[player].getPartnerList();
    }

    public Scp selectPartner(int player, String name, int place) {
        return this.player[player].selectPartner(name, place);
    }

    public boolean canAttack(int isFirst, int i) {
        return this.player[isFirst].canAttack(i);
    }

    public void ignitionK(K_ClassScenario k, Player p) {
        this.kClass = k;
        this.kClassPlayer = this.getPlayerNumber(p);
    }

    public int getPlayerNumber(String p) {
        return p.equals(this.player[0].getName()) ? 0 : 1;
    }

    public int getEnemyNumber(String p) {
        return getPlayerNumber(p) == 1 ? 0 : 1;
    }

    public Map.Entry<Integer, Scp> crossTest(int player, int test, int ed) {
        if (player == turnPlayer) {
            System.out.println(test);
            return damage(player == 0 ? 1: 0, ed, this.player[player].crossTest(test));
        } else {
            return null;
        }
    }

    private int getPlayerNumber(Player p) {
        return p == this.player[0] ? 0 : 1;
    }

    public Scp breach(int player, int place) {
        List<Effect> e = this.player[player].breach(waitingBreach, place);
        boolean ef = e.size() > 0;
        if (ef) {
            addAllEffects(e);
        }
        Scp tmp = waitingBreach;
        waitingBreach = null;
        return tmp;
    }

    public String[] getPersonnel() {
        String[] tmp = new String[this.player.length];
        for (int i = 0; i < player.length; i++) {
            tmp[i] = player[i].getPersonnel().getName();
        }
        return tmp;
    }

    public int getCost(int isFirst) {
        return player[isFirst].getCost();
    }

    public int getSiteNumber(int isFirst) {
        return this.player[isFirst].getSiteNumber();
    }

    public int[] getSandBoxNumber(int isFirst) {
        return this.player[isFirst].getSandboxNumber();
    }

    public int personnelEffectNumber(int player) {
        selectEffect = this.player[player].personnelFile.pf;
        return selectEffect.getEffectList(SOMETIMES).size();
    }

    public int taleEffectNumber(int player, int num) {
        this.selectEffect = this.player[player].tale.tale.get(num);
        return selectEffect.getEffectList(SOMETIMES).size();
    }

    public int siteEffectNumber(int isFirst, int i) {
        this.selectEffect = this.player[isFirst].getCard(SITE, i);
        if (selectEffect == null) {
            return 0;
        }
        List<Effect> effect = selectEffect.getEffectList(SOMETIMES);
        return effect.size();
    }

    public void addEffects(Effect e) {
        if (waitingEffects.size() == 0) {
            waitingEffects.add(new ArrayList());
        }
        waitingEffects.get(waitingEffects.size() - 1).add(e);
    }

    private void addAllEffects(List<Effect> e) {
        if (waitingEffects.size() == 0) {
            waitingEffects.add(new ArrayList());
        }
        waitingEffects.get(waitingEffects.size() - 1).addAll(e);
    }

    public int getTurn() {
        return turn;
    }

    public Card decommission(int player, String place, int index) {
        Map.Entry<Card, List<Effect>> e = this.player[player].decommission(Place.create(place), index, player);

        boolean eff = e.getValue().size() > 0;

        if (eff) {
            addAllEffects(e.getValue());
        }

        return e.getKey();
    }

    public int healSandBox(int player, int clazz, int num) {
        return this.player[player].HealSandBox(clazz, num);
    }

    public String[] getTale(int player) {
        String[] tmp = new String[this.player[player].tale.size];
        for (int i = 0; i < this.player[player].tale.size; i++) {
            tmp[i] = this.player[player].getTale(i);
        }
        return tmp;
    }

    public Card getSelectEffect() {
        return selectEffect;
    }

    public void setSelectEffect(Card selectEffect) {
        this.selectEffect = selectEffect;
    }

    public boolean selectedEffect(int index) {
        Effect tmp = selectEffect.getEffect(SOMETIMES, index);
        addEffects(tmp);
        selectEffect = null;
        return tmp.canActive();
    }

    public void selectEffect(int player, Place place, int index) {
        selectEffect = this.player[player].find(place, index);
    }

    public Place getSelectEffectPlace() {
        if (selectEffect == null) {
            return null;
        }
        return selectEffect.getPlace();
    }

    public int find(int isFirst, Place place, Card selectEffect) {
        return player[isFirst].find(place, selectEffect);
    }

    public Card getCard(int isFirst, String s) {
        return player[isFirst].findCard(s);
    }

    public Map.Entry<Integer, Scp> damage(int player, int ed, int damage) {
        if (damage < 0) {
            return new AbstractMap.SimpleEntry<>(0, null);
        }
        Scp tmp = this.player[player].damage(ed, damage);
        this.waitingBreach = tmp;
        return new AbstractMap.SimpleEntry<>(damage, tmp);
    }

    public Card getCard(int isFirst, String s, int i) {
        Place p = Place.create(s);
        switch (p) {
            case SITE:
                return player[isFirst].site.scp.get(i);
        }
        return null;
    }

    public String getName(int i) {
        return this.player[i].getName();
    }

    public String[] getDecommissioned(int i) {
        return this.player[i].getDecommissinoed();
    }

    public Player getEnemy(Player player) {
        return this.player[(this.player[0] == player) ? 1 : 0];
    }

    public Player getPlayer(int i) {
        return player[i];
    }

    public int getWaitingEffectNumber() {
        int num = 0;
        for (List<Effect> tmp : waitingEffects) {
            if (tmp != null) {
                num += tmp.size();
            }
        }
        return num;
    }

    public Result[] activeEffects(String[] param, Result result) {
        if (hasWaitEffects()) {
            onActive = true;
            onActiveEffect = true;
            Map.Entry<Result[], Boolean> res = this.waitingEffects.get(0).get(0).active(param, result);
            boolean isFinish = (res == null? true: res.getValue());
            ajustWaitEffects(isFinish);
            return res.getKey();
        }
        return null;
    }

    public boolean hasWaitEffects() {
        return waitingEffects.get(0).size() > 0;
    }

    private void ajustWaitEffects(boolean fin) {
        if (fin) {
            waitingEffects.get(0).remove(0);
            onActiveEffect = false;
            if (waitingEffects.get(0).size() <= 0) {
                waitingEffects.remove(0);
                waitingEffects.add(new ArrayList<>());
                if (hasWaitEffects()) onActive = false;
            }
        }
    }

    public Card[] getWaitingEffectsCard() {
        Card[] tmp = new Card[waitingEffects.size()];
        for (int i = 0; i < tmp.length; i++) tmp[i] = waitingEffects.get(0).get(i).getParent();
        return tmp;
    }

    public void sortWaitingEffects(int[] order) {
        List<Effect> list = new ArrayList<>(order.length);
        for (int i = 0; i < order.length; i++) list.add(null);
        for (int i = 0; i < order.length; i++) {
            list.set(order[i], waitingEffects.get(0).get(order[i]));
        }
        waitingEffects.set(0, list);
    }
}
