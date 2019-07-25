package scptcg.game;

import scptcg.game.card.*;
import scptcg.game.effect.*;
import scptcg.game.exception.NotActivableException;
import scptcg.game.exception.NotFillConditionException;
import scptcg.json.Deck;
import scptcg.server.Events;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Game {

    protected HeadCanon canon;
    Player[] players;
    List<List<Effect>> waitEffect = new ArrayList<>(4);
    private boolean turnPlayer;
    private int turn;
    private K_Class scenario = null;
    private boolean kClassPlayer;
    private boolean isActive = false;
    private boolean isChainSolving = false;
    private boolean firstPlayer;
    private int xk = 100;
    private int nk = 7;
    private Tale activing = null;
    private List<History> history;

    public Game(String waiter, Deck waiterDeck, String visitor, Deck visitorDeck) {
        int r = new Random(System.currentTimeMillis()).nextInt(2);
        players = new Player[2];
        players[r] = new Player(this, waiter, waiterDeck, xk, nk);
        players[r == 0 ? 1 : 0] = new Player(this, visitor, visitorDeck, xk, nk);
        firstPlayer = true;
        turnPlayer = this.firstPlayer;
        canon = new HeadCanon(this, null);
        for (int i = 0; i < 4; i++) {
            waitEffect.add(new ArrayList<>());
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void ignitionK(K_Class k, Player player) {
        this.scenario = k;
        this.kClassPlayer = isFirst(player);
        List<Effect> arr = player.getEffects(Trigger.K_Class, Zone.Site);
        if (Objects.nonNull(arr))
            addWaitEffects(arr);
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

    public int getRemainSandBox(boolean isFirst, Clazz clazz) {
        return getPlayer(isFirst).getRemainSandBox(clazz);
    }

    public void selectEffect(boolean isFirst, Zone zone, int index, int effectIndex) {
        if (isFirst == turnPlayer) {
            //System.out.println("player : " + isFirst + " zone : " + zone + " index : " + index + " efIndex : " + effectIndex);
            Effect effect = getPlayer(isFirst).getEffect(zone, index, Trigger.Sometime, effectIndex);
            if (Objects.nonNull(effect)) {
                addWaitEffect(effect);
            }
            //System.out.println("effect" + effect.getMessage());
        }
    }

    private void addWaitEffect(Effect effect) {
        int addIndex = (isChainSolving ? 2 : 0) + (effect.ownerIsFirst() ? 0 : 1);
        if (Objects.nonNull(waitEffect) && (waitEffect.size() <= addIndex || Objects.isNull(waitEffect.get(addIndex))))
            waitEffect.set(addIndex, new ArrayList<>());
        waitEffect.get(addIndex).add(effect);
    }

    public boolean isChainSolving() {
        return isChainSolving;
    }


    public boolean activeEffect(Result before, List<Result> result) {
        if (!isActive) isActive = true;
        if (!isChainSolving) isChainSolving = true;
        if (!isWait()) throw new NotFillConditionException("スタックには効果が積まれていません");
        for (int i = 0; i < 4 && waitEffect.get(0).size() <= 0; i++) {
            for (int j = 0; j < waitEffect.size() - 1; j++) {
                waitEffect.set(j, waitEffect.get(j + 1));
            }
            waitEffect.set(waitEffect.size() - 1, new ArrayList<>());
            if (i == 4 - 1) {
                isChainSolving = false;
            }
        }
        boolean finish;
        try {
            waitEffect.get(0).get(0).addBefore(before);
            finish = waitEffect.get(0).get(0).active(result);

            Card card = waitEffect.get(0).get(0).getParent();
            if (card.getCategory() == CardCategory.Tale && card instanceof Tale) {
                activing = (Tale) card;
            }
        } catch (NotActivableException e) {
            ResultBuilder rb = new ResultBuilder(ActionMethod.Fail.name(), turnPlayer, null, null, null, -1);
            finish = true;
            result.add(rb.createResult());
            System.out.println("Fail Effect");
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
            System.out.println("Effect is Finish");
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
                rb.setObjects(activing.ownerIsFirst(), Zone.Tales,
                        activing,
                        activing.getName(),
                        activing.getCoordinate());
                rb.setTargetZone(Zone.Tales);
                rb.setCoordinate(activing.getCoordinate());
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
        return waitEffect.get(0).size() == 0 ? waitEffect.get(1).size() > 0 : waitEffect.get(0).size() > 0;
    }

    public int effectSize(boolean isFirst, Zone zone, int index) {
        return getPlayer(isFirst).effectSize(zone, Trigger.Sometime, index);
    }


    public boolean nextTurn() {
        if (isActive() || isChainSolving()) {
            return false;
        }
        this.turn++;
        this.turnPlayer = !turnPlayer;
        for (Player p : this.players) {
            p.nextTurn();
        }
        this.addWaitEffects(getTurnPlayer().getEffects(Trigger.TurnStart, Zone.Decommissioned, Zone.Site));
        this.addWaitEffects(getTurnPlayer().getEnemy().getEffects(Trigger.TurnEnd, Zone.Decommissioned, Zone.Site));

        return true;
    }

    private void addWaitEffects(List<Effect> effects) {
        if (Objects.isNull(effects)) {
            System.out.println("Effect is null");
            return;
        }
        //System.out.println("effectSize : " + effects.size());
        for (Effect effect : effects) {
            //System.out.println(effect.getMessage());
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
        List<Effect> arr = p.getCard(Zone.Site, testerIndex).getEffects(Trigger.CrossTest);
        if (Objects.nonNull(arr))
            addWaitEffects(arr);
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
        List<Effect> arr = c.getEffects(Trigger.Decommissioned);
        if (Objects.nonNull(arr))
            addWaitEffects(arr);
        ResultBuilder result = new ResultBuilder(
                Events.Decommission.name(),
                c.getPlayer().isFirst(),
                Zone.Decommissioned,
                c,
                c.getName(),
                c.getCoordinate()
        );
        setBefore(result.createResult());
        return c;
    }

    private void setBefore(Result result) {
        if (isActive()) {
            waitEffect.get(0).get(0).addBefore(result);
        }
    }

    public int healSandBox(boolean isFirst, Clazz clazz, int point) {
        ResultBuilder result = new ResultBuilder(ActionMethod.HealSandBox.name(), isFirst, clazzToZone(clazz), null, null, -1);
        result.setPoint(point);
        setBefore(result.createResult());
        return getPlayer(isFirst).heal(clazz, point);
    }

    public Card[] getCards(boolean isFirst, Zone zone) {
        return getPlayer(isFirst).getCards(zone);
    }

    public Player getEnemy(String name) {
        //System.out.println("player[0]: \"" + players[0].getName() + "\" player[1]: \"" + players[1].getName() + "\" player: \"" + name + "\"");
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
        return Objects.nonNull(scenario);
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
        addWaitEffects(
                Objects.requireNonNull(
                        getPlayer(player).getCard(Objects.requireNonNull(clazzToZone(clazz)), name)
                ).getEffects(Trigger.Breached));
        return getPlayer(player).breach(name, clazz, index);
    }

    private Zone clazzToZone(Clazz clazz) {
        switch (clazz) {
            case Safe:
                return Zone.SafeSandbox;
            case Euclid:
                return Zone.EuclidSandbox;
            case Keter:
                return Zone.KeterSandbox;
            default:
                return null;
        }
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

    public void reContainment(boolean isFirst, Scp card, Clazz clazz) {
        getPlayer(isFirst).reContainment(card, clazz);
    }

    public Card find(boolean isFirst, Zone zone, String name) {
        return getPlayer(isFirst).find(zone, name);
    }

    public void lostEffect(boolean isFirst, Zone zone, int index) {
        getPlayer(isFirst).lostEffect(zone, index);
    }

    public void upXKCost(int point) {
        this.xk += point;
    }

    public void cancelK() {
        this.scenario = null;
    }
}
