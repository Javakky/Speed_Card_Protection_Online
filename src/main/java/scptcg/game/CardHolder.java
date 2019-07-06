package scptcg.game;

import org.apache.commons.lang3.NotImplementedException;
import scptcg.game.card.Card;
import scptcg.game.card.CardCategory;
import scptcg.game.card.Scp;
import scptcg.game.effect.ConditionParameter;
import scptcg.game.effect.Effect;
import scptcg.game.effect.Trigger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface CardHolder {

    static void deleteCard(final Card card, final List<? extends Card> list) {
        list.set(list.indexOf(card), null);
    }

    static Card find(final String cardName, final List<? extends Card> list) {
        for (Card c : list) {
            if (c != null) {
                if (c.getName().equals(cardName)) {
                    return c;
                }
            }
        }
        return null;
    }

    static int indexOf(final Card card, final List<? extends Card> list) {
        return list.indexOf(card);
    }

    static boolean hasCard(CardCategory category, ConditionParameter[] condition, List<? extends Card> list) {
        for (Card card : list) {
            if (Objects.nonNull(card) && card.getCategory() == category) {
                boolean flag = true;
                for (ConditionParameter c : condition) {
                    switch (SelectCondition.valueOf(c.getName())) {
                        case Cost:
                            if (((Scp) card).getCost() != c.getPoint()) flag = false;
                            break;
                        case Secure:
                            if (((Scp) card).getSecure() != c.getPoint()) flag = false;
                            break;
                        case NotPartner:
                            if (((Scp) card).isPartner()) flag = false;
                            break;
                        case CrossTested:
                            if (((Scp) card).getCrossTestCount() <= 0) flag = false;
                            break;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }

    static Card getCard(int index, List<? extends Card> list) {
        return list.get(index);
    }

    static List<Effect> getEffects(Trigger trigger, List<? extends Card> list) {
        List<Effect> tmp = new ArrayList<>();
        for (Card c : list) {
            if (Objects.nonNull(c)) {
                tmp.addAll(c.getEffects(trigger));
            }
        }
        return tmp;
    }

    Player getPlayer();

    default Effect getEffect(int cardIndex, Trigger trigger, int effectIndex) {
        return getCard(cardIndex).getEffect(trigger, effectIndex);
    }

    default int getTurn() {
        try {
            return getPlayer().getTurn();
        } catch (NotImplementedException e) {
            return getGame().getTurn();
        }
    }

    Zone getZone();

    default void decommission(Card card) {
        getPlayer().decommission(getZone(), card);
    }

    void nextTurn();

    default int effectSize(int cardIndex, Trigger trigger) {
        return getCard(cardIndex).effectSize(trigger);
    }

    default Game getGame() {
        Player player = getPlayer();
        if (Objects.nonNull(player)) {
            return player.getGame();
        }
        throw new NotImplementedException("getGameがオーバーライドされていない、かつ、getPlayerがnullです");
    }

    void deleteCard(Card card);

    Card find(String cardName);

    default Player getEnemy() {
        return getPlayer().getEnemy();
    }

    default boolean isMyTurn() {
        return getPlayer().isMyTurn();
    }

    Map<Card, Integer> deleteCardAll(CardCategory category);

    default void addCardAll(Card... adds) {
        for (Card c : adds) {
            addCard(c);
        }
    }

    int addCard(Card c);

    Card getCard(int index);

    int indexOf(Card card);

    void addTag(int index, String[] tags);

    void addEffect(int index, Effect effect, Trigger trigger);

    boolean hasCard(CardCategory category, ConditionParameter[] condition);

    int getCardCount();

    List<Effect> getEffects(Trigger trigger);

    default Card pick(int index) {
        Card c = getCard(index);
        deleteCard(c);
        return c;
    }

    default Card pick(String name) {
        Card c = find(name);
        deleteCard(c);
        return c;
    }

    default List<Effect> getEffects(int index, Trigger trigger) {
        return getCard(index).getEffects(trigger);
    }

    Card[] getCards();

    default Card getTop() {
        return getCard(0);
    }

}
