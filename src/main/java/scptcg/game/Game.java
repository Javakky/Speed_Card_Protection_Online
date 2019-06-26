package scptcg.game;

import scptcg.game.card.Card;
import scptcg.game.card.Clazz;
import scptcg.game.card.Scp;
import scptcg.game.card.Tale;
import scptcg.game.effect.*;
import scptcg.game.exception.NotActivableException;
import scptcg.game.exception.NotFillConditionException;
import scptcg.json.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Game {

    protected HeadCanon canon;
    Player[] players;
    List<List<Effect>> waitEffect = new ArrayList<>(4);
    List<Scp> waitBreach = new ArrayList<>();
    private boolean turnPlayer;
    private int turn;
    private K_Class scenario = null;
    private boolean kClassPlayer;
    private boolean isActive = false;
    private boolean isChainSolving = false;
    private boolean firstPlayer;
    private int xk = 7;
    private int nk = 7;
    private Tale activing = null;

    public Game(String waiter, Deck waiterDeck, String visitor, Deck visitorDeck) {
        int r = new Random(System.currentTimeMillis()).nextInt(2);
        players = new Player[2];
        players[r] = new Player(this, waiter, waiterDeck, xk, nk);
        players[r == 0 ? 1 : 0] = new Player(this, waiter, waiterDeck, xk, nk);
        firstPlayer = true;
        turnPlayer = this.firstPlayer;
        canon = new HeadCanon(this, null);
    }

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

    public void selectEffect(boolean isFirst, Zone zone, int index, int effectIndex, List<Result> result) {
        if (isFirst == turnPlayer) {
            Effect effect = getPlayer(isFirst).getEffect(zone, index, Trigger.Sometime, effectIndex);
            if (Objects.nonNull(effect)) {
                addWaitEffect(effect);
                if (effect.getParent().whereZone() == Zone.Tales && Objects.nonNull(result)) {
                    activing = (Tale) effect.getParent();
                    ResultBuilder rb = new ResultBuilder(
                            ActionMethod.ActiveTale.name(),
                            activing.ownerIsFirst(),
                            Zone.Tales,
                            activing,
                            activing.getName(),
                            activing.getCoordinate()
                    );
                    result.add(rb.createResult());
                }
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
        boolean finish;
        try {
            waitEffect.get(0).get(0).addBefore(before);
            finish = waitEffect.get(0).get(0).active(result);
        } catch (NotActivableException e) {
            ResultBuilder rb = new ResultBuilder(ActionMethod.Fail.name(), turnPlayer, null, null, null, -1);
            finish = true;
            result.add(rb.createResult());
        }
        if (finish) {
            return finishEffect(result);
        }
        return true;
    }

    private List<Effect> getWaitEffct() {
        return waitEffect.get(0);
    }

    public void sortEffect(int[] indexes) {
        List<Effect> tmp = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++) {
            tmp.set(i, waitEffect.get(0).get(indexes[i]));
        }
        waitEffect.set(0, tmp);
    }

    public void cancelEffect() {
        finishEffect(null);
    }

    private boolean finishEffect(List<Result> result) {
        if (isActive) {
            isActive = false;
            waitEffect.get(0).remove(0);
            if (Objects.nonNull(activing) && Objects.nonNull(result)) {
                ResultBuilder rb = new ResultBuilder(
                        ActionMethod.Decommission.name(),
                        activing.ownerIsFirst(),
                        Zone.Tales,
                        activing,
                        activing.getName(),
                        activing.getCoordinate()
                );
                Result r = rb.createResult();
                result.add(r);
                decommission(r.getSubjectPlayer(), Zone.Tales, r.getSubjectCoordinate());
                activing = null;
            }
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

    public Scp breachPartner(boolean isFirst, String name, int index) {
        return getPlayer(isFirst).breachPartner(name, index);
    }

    public boolean canCrossTest(boolean isFirst, int index) {
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

    public Player getEnemy(String name) {
        return players[0].getName().equals(name) ? players[1] : players[0];
    }

    public String getEnemyName(String name) {
        return getEnemy(name).getName();
    }

    private Player getPlayer(String name) {
        return players[0].getName().equals(name) ? players[0] : players[1];
    }

    public boolean isFirst(String playerName) {
        return isFirst(getPlayer(playerName));
    }

    public boolean isK() {
        return Objects.isNull(scenario);
    }

    public K_Class getScenario() {
        return scenario;
    }

    public boolean getKClassPlayerIsFirst() {
        return kClassPlayer;
    }

    public Card getCard(boolean player, Zone zone, int index) {
        return getPlayer(player).getCard(zone, index);
    }

    public int getSumSiteCost(boolean isFirst) {
        return getPlayer(isFirst).getSumSiteCost();
    }

    public Scp breach(boolean player, String name, Clazz clazz, int index) {
        return getPlayer(player).breach(name, clazz, index);
    }

    public int getSCPCount(boolean player) {
        return getPlayer(player).getSCPCount();
    }

    public int[] getSandBoxProtection(boolean isFirst) {
        return getPlayer(isFirst).getSandBoxProtection();
    }

    public Card getDecommisionedTop(boolean isFirst) {
        return getPlayer(isFirst).getTop(Zone.Decommissioned);
    }
}
