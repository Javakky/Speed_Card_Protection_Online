package scptcg.game;

import org.apache.commons.lang3.NotImplementedException;
import scptcg.game.card.Canon;
import scptcg.game.card.Card;
import scptcg.game.card.CardCategory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HeadCanon implements CardHolder {

    private Canon canon;
    private Game parent;

    public HeadCanon(Canon canon, Game parent) {
        this.canon = canon;
        this.parent = parent;
    }

    @Override
    public Player getPlayer() {
        throw new NotImplementedException("ヘッドカノンはプレイヤーとは紐づけされません");
    }

    @Override
    public Game getGame() {
        return parent;
    }

    @Override
    public Zone getZone() {
        return Zone.HeadCanon;
    }

    @Override
    public void decommission(Card card) {
        throw new NotImplementedException("カノンを墓地へ送ることはできません");
    }

    @Override
    public void nextTurn() {
        if (Objects.nonNull(canon)) {
            canon.refresh();
        }
    }

    @Override
    public void deleteCard(Card card) {
        if (card == canon) {
            deleteCard();
        }
    }

    public boolean hasCanon() {
        return canon != null;
    }

    @Override
    public Card find(String cardName) {
        return canon.getName().equals(cardName) ? canon : null;
    }

    @Override
    public int addCard(Card card) {
        if (Objects.isNull(canon) && card instanceof Canon) {
            canon = (Canon) card;
            return 0;
        }
        return -1;
    }

    @Override
    public Card getCard(int index) {
        if (index != 0) {
            throw new IllegalArgumentException("ヘッドカノン存在するカードは1枚のみです");
        }
        return canon;
    }

    @Override
    public Map<Card, Integer> deleteCardAll(CardCategory category) {
        if (category != CardCategory.Canon) throw new IllegalArgumentException("ヘッドカノンにはカノン以外のカードはありません");
        if (Objects.nonNull(canon)) {
            deleteCard();
            Map<Card, Integer> result = new HashMap<>();
            result.put(canon, 0);
            return result;
        }
        return new HashMap<>();
    }

    public void deleteCard() {
        canon = null;
    }

    @Override
    public int getCoordinate(Card card) {
        if (canon == card) {
            return 0;
        }
        return -1;
    }

    @Override
    public void addCardAll(Card... cards) {
        if (cards.length > 1 || canon != null) throw new IllegalArgumentException("ヘッドカノンに追加できるカードは1枚です");
        else if (cards.length == 1) addCard(cards[0]);
    }

    public Canon getCanon() {
        return canon;
    }

    private void setCanon(Canon canon) {
        this.canon = canon;
    }

    private void setParent(Game parent) {
        this.parent = parent;
    }
}
