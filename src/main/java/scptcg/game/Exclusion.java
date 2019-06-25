package scptcg.game;

import scptcg.game.card.Card;
import scptcg.game.card.CardCategory;
import scptcg.game.card.Scp;
import scptcg.game.effect.Effect;
import scptcg.game.effect.Trigger;

import java.util.*;

public class Exclusion implements CardHolder {

    private Player parent;
    private List<Card> exclusion = new ArrayList<>();

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
        for (Card card : exclusion) {
            card.refresh();
        }
    }

    @Override
    public void deleteCard(final Card card) {
        CardHolder.deleteCard(card, exclusion);
    }

    @Override
    public Card find(final String cardName) {
        return CardHolder.find(cardName, exclusion);
    }

    @Override
    public int addCard(final Card card) {
        exclusion.add(card);
        return exclusion.size() - 1;
    }

    @Override
    public Card getCard(int index) {
        return CardHolder.getCard(index, exclusion);
    }

    @Override
    public Map<Card, Integer> deleteCardAll(CardCategory category) {
        Map<Card, Integer> map = new HashMap<>();
        Card[] tmp = exclusion.toArray(new Card[0]);
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].getCategory() == category) {
                map.put(tmp[i], i);
                tmp[i] = null;
            }
        }
        List<Card> finalEx = Arrays.asList(tmp);
        finalEx.removeAll(Collections.singleton(null));
        exclusion = finalEx;
        return map;
    }

    @Override
    public int indexOf(Card card) {
        return CardHolder.indexOf(card, exclusion);
    }

    @Override
    public void addTag(int index, String[] tags) {
        if (!(exclusion.get(index) instanceof Scp))
            throw new IllegalArgumentException("その座標にあるカードはSCPではないため、タグを追加することはできません");
        ((Scp) exclusion.get(index)).addTags(tags);
    }

    @Override
    public void addEffect(int index, Effect effect, Trigger trigger) {
        exclusion.get(index).addEffect(effect, trigger);
    }

    @Override
    public boolean hasCard(CardCategory category, ConditionParameter[] condition) {
        return CardHolder.hasCard(category, condition, exclusion);
    }

    @Override
    public int getCardCount() {
        return exclusion.size();
    }

    @Override
    public List<Effect> getEffects(Trigger trigger) {
        return CardHolder.getEffects(trigger, exclusion);
    }

    @Override
    public Card[] getCards() {
        return exclusion.toArray(new Card[0]);
    }

    public void setParent(Player parent) {
        this.parent = parent;
    }

    private List<Card> getExclusion() {
        return exclusion;
    }

    public void setExclusion(List<Card> exclusion) {
        this.exclusion = exclusion;
    }

    public Card getTop() {
        return exclusion.size() <= 0 ? null : exclusion.get(exclusion.size() - 1);
    }

    public Card pop() {
        return exclusion.size() <= 0 ? null : exclusion.remove(exclusion.size() - 1);
    }
}
