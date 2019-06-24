package scptcg.game;

import scptcg.game.card.Card;
import scptcg.game.card.CardCategory;

import java.util.Map;

public class AnomalousRocker implements CardHolder, Area {
    @Override
    public boolean hasScp(String[] condition) {
        return false;
    }

    @Override
    public Player getPlayer() {
        return null;
    }

    @Override
    public Zone getZone() {
        return null;
    }

    @Override
    public void nextTurn() {

    }

    @Override
    public void deleteCard(Card card) {

    }

    @Override
    public Card find(String cardName) {
        return null;
    }

    @Override
    public int addCard(Card c) {
        return 0;
    }

    @Override
    public Card getCard(int index) {
        return null;
    }

    @Override
    public Map<Card, Integer> deleteCardAll(CardCategory category) {
        return null;
    }

    @Override
    public int indexOf(Card card) {
        return 0;
    }
}
