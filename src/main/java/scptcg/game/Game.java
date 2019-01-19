package scptcg.game;

import org.apache.commons.lang3.tuple.Pair;
import scptcg.game.card.Card;
import scptcg.game.card.ObjectClassKind;
import scptcg.game.card.Scp;
import scptcg.game.effect.Effect;
import scptcg.game.effect.Result;
import scptcg.log.Log4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static scptcg.game.Place.*;
import static scptcg.game.SandBox.*;
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
        Log4j.getInstance().info("player1:" + name1 + "\nplayer2:" + name2);
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

    public int getFirstPlayer() {
        return firstPlayer;
    }

    public void nextTurn() {
        Log4j.getInstance().info("next turn " + player[turnPlayer].getName());
        this.turn++;
        this.turnPlayer = turnPlayer == 0 ? 1 : 0;
        for (Player p : this.player) {
            p.nextTurn();
        }
        this.addAllEffects(this.player[turnPlayer].getEffectList(TURN_START));
        this.addAllEffects(this.player[turnPlayer == 0 ? 1 : 0].getEffectList(TURN_START));
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
        Log4j.getInstance().info("selected Partner\nplayer:" + this.player[player] + "\ncard:" + name, "\nplace:" + place);
        return this.player[player].selectPartner(name, place);
    }

    public boolean canAttack(int isFirst, int i) {
        return this.player[isFirst].canAttack(i);
    }

    public void ignitionK(K_ClassScenario k, Player p) {
        this.kClass = k;
        this.kClassPlayer = this.getPlayerNumber(p);
        Log4j.getInstance().info("ignitionK\nplayer:" + kClassPlayer + "\nScenario" + kClass.getScenario());
    }

    public int getPlayerNumber(String p) {
        return p.equals(this.player[0].getName()) ? 0 : 1;
    }

    public int getEnemyNumber(String p) {
        return getPlayerNumber(p) == 1 ? 0 : 1;
    }

    public Pair<Integer, Scp> crossTest(int player, int test, int ed) {
        if (player == turnPlayer) {
            Pair<Integer, Scp> p = damage(player == 0 ? 1 : 0, ed, this.player[player].crossTest(test));
            Log4j.getInstance().info("cross test\nplayer:" + this.player[player].getName() + "\ncard:" + this.player[player].find(SITE, test).getName() + "\nsand box:" + numberToClass(ed).getClazz());
            Log4j.getInstance().info("damage\nplayer:" + this.player[player].getName() + "\nplace:" + numberToClass(ed).getClazz() + "\ndamage:" + ((Scp) this.player[player].find(SITE, test)).getSecure());
            if (p.getValue() != null) {
                Log4j.getInstance().info("breach!\nplayer:" + this.player[getEnemy(player)].getName() + "\ncard:" + p.getValue().getName());
            }
            return p;
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
        Log4j.getInstance().info("breach\nplayer:" + this.player[player].getName() + "\ncard:" + tmp.getName() + "\nplace:" + place);
        return tmp;
    }


    public Scp breach(int player, ObjectClassKind clazz, String name, int place) {
        Pair<Scp, List<Effect>> e = this.player[player].breach(clazz, name, place, Place.SITE);
        boolean ef = e.getValue().size() > 0;
        if (ef) {
            addAllEffects(e.getValue());
        }
        Log4j.getInstance().info("breach\nplayer:" + this.player[player].getName() + "\ncard:" + name + "\nplace:" + place);
        if (e.getValue() != null) {
            for (Effect tmp : e.getValue()) {
                Log4j.getInstance().info("effect\nplayer:" + this.player[player].getName() + "\ncard:" + name + "\neffect:" + tmp.getMessage());
            }
        }
        return e.getKey();
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

    public Card decommission(int player, Place place, int index) {
        Pair<Card, List<Effect>> e = this.player[player].decommission(place, index, player);

        boolean eff = e.getValue().size() > 0;

        if (eff) {
            addAllEffects(e.getValue());
        }

        Log4j.getInstance().info("decommission\nplayer:" + this.player[player].getName() + "\ncard:" + e.getKey().getName() + "\nplace:" + index);
        if (e.getValue() != null) {
            for (Effect tmp : e.getValue()) {
                Log4j.getInstance().info("effect\nplayer:" + this.player[player].getName() + "\ncard:" + e.getKey() + "\neffect:" + tmp.getMessage());
            }
        }
        return e.getKey();
    }

    public int healSandBox(int player, int clazz, int num) {
        Log4j.getInstance().info("heal\nplayer:" + this.player[getEnemy(player)].getName() + "\nplace:" + numberToClass(clazz).getClazz() + "\npoint:" + num);
        return this.player[player].healSandBox(clazz, num);
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
        Log4j.getInstance().info("selectedEffect\nplayer:" + selectEffect.getMyPlayer().getName() + "\ncard:" + selectEffect.getName() + "\neffect:" + tmp.getMessage() + "\ncan:" + tmp.canActive());
        selectEffect = null;
        return tmp.canActive();
    }

    public void selectEffect(int player, Place place, int index) {
        selectEffect = this.player[player].find(place, index);
        Log4j.getInstance().info("selectEffect\nplayer:" + this.player[player].getName() + "\ncard:" + selectEffect.getName() + "\nplace:" + place.toString() + " " + index);
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

    public Pair<Integer, Scp> damage(int player, int ed, int damage) {
        if (damage < 0) {
            return Pair.of(0, null);
        }
        Log4j.getInstance().info("damage\nplayer:" + this.player[player].getName() + "\nplace:" + numberToClass(ed).getClazz() + "\ndamage:" + damage);
        Scp tmp = this.player[player].damage(ed, damage);
        this.waitingBreach = tmp;
        if (tmp != null) {
            Log4j.getInstance().info("breach!\nplayer:" + this.player[getEnemy(player)].getName() + "\ncard:" + tmp.getName());
        }
        return Pair.of(damage, tmp);
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
            Pair<Result[], Boolean> res = this.waitingEffects.get(0).get(0).active(param, result);
            boolean isFinish = (res == null ? true : res.getValue());
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

    public int getProtectionForceSandBox(int effectPlayer, int clazz) {
        return player[effectPlayer].getProtectionForceSandBox(clazz);
    }

    public int getCardNumberSandBox(int player, int clazz) {
        return this.player[player].getCardNumber(SANDBOX, clazz);
    }

    public int getMyTurn(Player player) {
        return this.player[0] == player ? 0 : 1;
    }
}
