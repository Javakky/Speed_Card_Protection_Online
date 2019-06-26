package scptcg.game;

import scptcg.game.card.Anomalous;
import scptcg.game.card.Card;
import scptcg.game.card.CardCategory;
import scptcg.game.card.Scp;
import scptcg.game.effect.Effect;
import scptcg.game.effect.Trigger;

import java.util.*;

public class AnomalousRocker implements CardHolder {
    private List<Anomalous> rocker = new ArrayList<>();
    private Player parent;

    public AnomalousRocker(Player player, Card[] card) {
        for (Card c : card) c.setParent(this);
        parent = player;
        rocker.addAll(Arrays.asList((Anomalous[]) card));
    }

    @Override
    public Player getPlayer() {
        return parent;
    }

    @Override
    public Zone getZone() {
        return Zone.AnomalousRocker;
    }

    @Override
    public void nextTurn() {

    }

    @Override
    public void deleteCard(Card card) {
        CardHolder.deleteCard(card, rocker);
    }

    @Override
    public Card find(String cardName) {
        return CardHolder.find(cardName, rocker);
    }

    @Override
    public Map<Card, Integer> deleteCardAll(CardCategory category) {
        Map<Card, Integer> map = new HashMap<>();
        Anomalous[] tmp = rocker.toArray(new Anomalous[0]);
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].getCategory() == category) {
                map.put(tmp[i], i);
                tmp[i] = null;
            }
        }
        List<Anomalous> finalDec = Arrays.asList(tmp);
        finalDec.removeAll(Collections.singleton(null));
        rocker = finalDec;
        return map;
    }


    @Override
    public int addCard(Card card) {
        if (card instanceof Scp) {
            rocker.add((Anomalous) card);
            return rocker.size() - 1;
        }
        throw new IllegalArgumentException("cardはAnomalousではありません");
    }

    @Override
    public Card getCard(int index) {
        return CardHolder.getCard(index, rocker);
    }

    @Override
    public int indexOf(Card card) {
        return CardHolder.indexOf(card, rocker);
    }


    @Override
    public void addTag(int index, String[] tags) {
        rocker.get(index).addTags(tags);
    }


    @Override
    public void addEffect(int index, Effect effect, Trigger trigger) {
        rocker.get(index).addEffect(effect, trigger);
    }

    @Override
    public boolean hasCard(CardCategory category, ConditionParameter[] condition) {
        for (Card card : rocker) {
            if (Objects.nonNull(card) && card.getCategory() == category) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getCardCount() {
        return rocker.size();
    }

    @Override
    public List<Effect> getEffects(Trigger trigger) {
        return CardHolder.getEffects(trigger, rocker);
    }

    @Override
    public Card[] getCards() {
        return rocker.toArray(new Card[0]);
    }

    private List<Anomalous> getRocker() {
        return rocker;
    }

    private void setRocker(List<Anomalous> rocker) {
        this.rocker = rocker;
    }

    public void setParent(Player parent) {
        this.parent = parent;
    }
}
