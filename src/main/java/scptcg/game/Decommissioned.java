package scptcg.game;

import scptcg.game.card.Card;
import scptcg.game.card.CardCategory;
import scptcg.game.card.Scp;
import scptcg.game.effect.Effect;
import scptcg.game.effect.Trigger;

import java.util.*;

public class Decommissioned implements CardHolder {


    private Player parent;
    private List<Card> decommissioned = new Stack<>();

    @Override
    public Player getPlayer() {
        return parent;
    }

    @Override
    public Zone getZone() {
        return Zone.Exclusion;
    }

    @Override
    public void nextTurn() {
        for (Card card : decommissioned) {
            card.refresh();
        }
    }

    @Override
    public void deleteCard(final Card card) {
        CardHolder.deleteCard(card, decommissioned);
    }

    @Override
    public Card find(final String cardName) {
        return CardHolder.find(cardName, decommissioned);
    }

    @Override
    public int addCard(final Card card) {
        decommissioned.add(card);
        return decommissioned.size() - 1;
    }

    @Override
    public Card getCard(int index) {
        return CardHolder.getCard(index, decommissioned);
    }

    @Override
    public Map<Card, Integer> deleteCardAll(CardCategory category) {
        Map<Card, Integer> map = new HashMap<>();
        Card[] tmp = decommissioned.toArray(new Card[0]);
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].getCategory() == category) {
                map.put(tmp[i], i);
                tmp[i] = null;
            }
        }
        List<Card> finalDec = Arrays.asList(tmp);
        finalDec.removeAll(Collections.singleton(null));
        decommissioned = finalDec;
        return map;
    }

    @Override
    public int indexOf(Card card) {
        return CardHolder.indexOf(card, decommissioned);
    }

    @Override
    public void addTag(int index, String[] tags) {
        if (!(decommissioned.get(index) instanceof Scp))
            throw new IllegalArgumentException("その座標にあるカードはSCPではないため、タグを追加することはできません");
        ((Scp) decommissioned.get(index)).addTags(tags);
    }

    @Override
    public void addEffect(int index, Effect effect, Trigger trigger) {
        decommissioned.get(index).addEffect(effect, trigger);
    }

    @Override
    public boolean hasCard(CardCategory category, ConditionParameter[] condition) {
        return CardHolder.hasCard(category, condition, decommissioned);
    }

    @Override
    public int getCardCount() {
        return decommissioned.size();
    }

    @Override
    public List<Effect> getEffects(Trigger trigger) {
        return CardHolder.getEffects(trigger, decommissioned);
    }

    public void setParent(Player parent) {
        this.parent = parent;
    }

    private List<Card> getDecommissioned() {
        return decommissioned;
    }

    public void setDecommissioned(List<Card> decommissioned) {
        this.decommissioned = decommissioned;
    }

    public Card getTop() {
        return decommissioned.size() <= 0 ? null : decommissioned.get(decommissioned.size() - 1);
    }

    public Card pop() {
        return decommissioned.size() <= 0 ? null : decommissioned.remove(decommissioned.size() - 1);
    }

}
