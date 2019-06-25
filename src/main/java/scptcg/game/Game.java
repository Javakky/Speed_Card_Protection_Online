package scptcg.game;

import scptcg.game.card.Card;
import scptcg.game.card.Clazz;
import scptcg.game.card.Scp;
import scptcg.game.effect.*;
import scptcg.game.exception.NotActivableException;
import scptcg.game.exception.NotFillConditionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    protected HeadCanon canon;
    Player[] players;
    List<List<Effect>> waitEffect = new ArrayList<>(4);
    private int firstPlayer;
    private boolean turnPlayer;
    private int turn;
    private K_Class scenario = null;
    private boolean kClassPlayer;
    private boolean isActive = false;
    private boolean isChainSolving = false;

    public void ignitionK(K_Class k, Player player) {
        this.scenario = k;
        this.kClassPlayer = isFirst(player);
    }

    public boolean isFirst(Player player) {
        return players[0] == player;
    }

    public boolean isTurnPlayer(Player player) {
        return players[turnPlayer ? 0 : 1] == player;
    }

    public Player getEnemy(Player player) {
        return isFirst(player) ? players[1] : players[0];
    }

    public Player getEnemy(boolean isFirst) {
        return players[isFirst ? 1 : 0];
    }

    public Player getPlayer(boolean isFirst) {
        return players[isFirst ? 0 : 1];
    }

    public String getEnemyName(boolean isFirst) {
        return players[isFirst ? 1 : 0].getName();
    }

    public String getPlayerName(boolean isFirst) {
        return players[isFirst ? 0 : 1].getName();
    }

    public int getTurn() {
        return turn;
    }

    public void selectEffect(boolean isFirst, Zone zone, int index, int effectIndex) {
        if (isFirst == turnPlayer) {
            Effect effect = getPlayer(isFirst).getEffect(zone, index, Trigger.Sometime, effectIndex);
            if (Objects.nonNull(effect)) {
                addWaitEffect(effect);
            }
        }
    }

    private void addWaitEffect(Effect effect) {
        int addIndex = (isChainSolving ? 2 : 0) + (effect.ownerIsFirst() ? 0 : 1);
        if (Objects.isNull(waitEffect.get(addIndex))) waitEffect.set(addIndex, new ArrayList<>());
        waitEffect.get(addIndex).add(effect);
    }

    public boolean activeEffect(Result before, List<Result> result) {
        if (!isActive) isActive = true;
        if (!isChainSolving) isChainSolving = true;
        if (!isWait()) throw new NotFillConditionException("スタックには効果が積まれていません");
        boolean finish = false;
        try {
            waitEffect.get(0).get(0).addBefore(before);
            finish = waitEffect.get(0).get(0).active(result);
        } catch (NotActivableException e) {
            ResultBuilder rb = new ResultBuilder(turnPlayer, null, null, null, -1);
            rb.setAction(ActionMethod.Fail.name());
            finish = true;
            result.add(rb.createResult());
        }
        if (finish) {
            return finishEffect();
        }
        return true;
    }

    private List<Effect> getWaitEffct() {
        return waitEffect.get(0);
    }

    private void sortEffect(int[] indexes) {
        List<Effect> tmp = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++) {
            tmp.set(i, waitEffect.get(0).get(indexes[i]));
        }
    }

    private void cancelEffect() {
        finishEffect();
    }

    private boolean finishEffect() {
        if (isActive) {
            isActive = false;
            waitEffect.get(0).remove(0);
            boolean flag = waitEffect.get(0).size() <= 0;
            for (int i = 0; i < 4 && waitEffect.get(0).size() <= 0; i++) {
                for (int j = 0; j < waitEffect.size() - 1; j++) {
                    waitEffect.set(j, waitEffect.get(j + 1));
                }
                waitEffect.set(waitEffect.size() - 1, new ArrayList<>());
                if (i == 4 - 1) {
                    isChainSolving = false;
                }
            }
            return !flag || !isChainSolving || waitEffect.get(0).size() <= 1;
        }
        return true;
    }

    public boolean isWait() {
        if (isChainSolving) return true;
        return waitEffect.get(0).size() > 0;
    }

    public int effectSize(boolean isFirst, Zone zone, int index) {
        return getPlayer(isFirst).effectSize(zone, Trigger.Sometime, index);
    }


    public void nextTurn() {
        this.turn++;
        this.turnPlayer = !turnPlayer;
        for (Player p : this.players) {
            p.nextTurn();
        }
        this.addWaitEffects(getTurnPlayer().getEffects(Trigger.TurnStart));
        this.addWaitEffects(getTurnPlayer().getEffects(Trigger.TurnEnd));
    }

    private void addWaitEffects(List<Effect> effects) {
        for (Effect effect : effects) {
            addWaitEffect(effect);
        }
    }

    public int[] getEmptySite(boolean isFirst) {
        return getPlayer(isFirst).getSelectables(
                false,
                new ConditionParameter[0]
        );
    }

    public Card[] getPartnerables(boolean isFirst) {
        return getPlayer(isFirst).getPartnerables();
    }

    public Player getTurnPlayer() {
        return getPlayer(turnPlayer);
    }

    public void breachPartner(boolean isFirst, String name, int index) {
        getPlayer(isFirst).breachPartner(name, index);
    }

    public boolean canClossTest(boolean isFirst, int index) {
        return getPlayer(isFirst).canCrossTest(index);
    }

    public int crossTest(boolean isFirst, int testerIndex, Clazz sandBox, List<Scp> breached) {
        Player p = getPlayer(isFirst);
        int point = p.crossTest(testerIndex);
        p.getEffects(Zone.Site, testerIndex, Trigger.CrossTest);
        damage(!isFirst, sandBox, point, breached);
        return point;
    }

    public void damage(boolean isFirst, Clazz sandBox, int point, List<Scp> breached) {
        getPlayer(isFirst).damage(sandBox, point, breached);
    }

    private boolean isTurnPlayer(boolean isFirst) {
        return isFirst == turnPlayer;
    }


    public Card decommission(boolean isFirst, Zone zone, int index) {
        Card c = getPlayer(isFirst).decommission(zone, index);
        addWaitEffects(c.getEffects(Trigger.Decommissioned));
        return c;
    }

    public void healSandBox(boolean isFirst, Clazz clazz, int point) {
        getPlayer(isFirst).heal(clazz, point);
    }

    public Card[] getCards(boolean isFirst, Zone zone) {
        return getPlayer(isFirst).getCards(zone);
    }

}
