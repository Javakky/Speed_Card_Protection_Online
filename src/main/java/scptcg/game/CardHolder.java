package scptcg.game;

import org.apache.commons.lang3.NotImplementedException;
import scptcg.game.card.Card;
import scptcg.game.card.CardCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    static Card getCard(int index, List<? extends Card> list) {
        return list.get(index);
    }

    static Map<Card, Integer> deleteCardAll(CardCategory category, List<? extends Card> list) {
        Map<Card, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Card c = list.get(i);
            if (c != null) {
                if (category == null || category == c.getCategory())
                    map.put(c, i);
            }
        }
        for (Card c : map.keySet()) {
            deleteCard(c, list);
        }
        return map;
    }

    static int getCoordinate(final Card card, final List<? extends Card> list) {
        return list.indexOf(card);
    }

    Player getPlayer();

    Game getGame();

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

    void deleteCard(final Card card);

    Card find(final String cardName);

    int addCard(final Card c);

    Card getCard(final int index);

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

    int getCoordinate(Card card);
}
