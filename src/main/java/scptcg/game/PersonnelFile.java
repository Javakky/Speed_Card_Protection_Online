package scptcg.game;

import scptcg.game.card.Canon;
import scptcg.game.card.Card;
import scptcg.game.card.CardCategory;
import scptcg.game.card.Personnel;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PersonnelFile implements CardHolder {
    private Personnel personnel;

    private Player parent;

    public PersonnelFile(Personnel personnel, Player parent) {
        this.personnel = personnel;
        this.parent = parent;
    }

    @Override
    public Player getPlayer() {
        return parent;
    }

    @Override
    public Game getGame() {
        return parent.getGame();
    }

    @Override
    public Zone getZone() {
        return Zone.PersonnelFile;
    }

    @Override
    public void deleteCard(Card card) {
        if (card == personnel) {
            deleteCard();
        }
    }

    @Override
    public Card find(String cardName) {
        return personnel.getName().equals(cardName) ? personnel : null;
    }

    @Override
    public int addCard(Card card) {
        if (Objects.isNull(personnel) && card instanceof Canon) {
            personnel = (Personnel) card;
            return 0;
        }
        return -1;
    }

    @Override
    public Card getCard(int index) {
        if (index != 0) {
            throw new IllegalArgumentException("ヘッドカノン存在するカードは1枚のみです");
        }
        return personnel;
    }

    @Override
    public Map<Card, Integer> deleteCardAll(CardCategory category) {
        if (category != CardCategory.Personnel) throw new IllegalArgumentException("人事ファイルには人事以外のカードはありません");
        if (Objects.nonNull(personnel)) {
            deleteCard();
            Map<Card, Integer> result = new HashMap<>();
            result.put(personnel, 0);
            return result;
        }
        return new HashMap<>();
    }

    public void deleteCard() {
        personnel = null;
    }

    @Override
    public int getCoordinate(Card card) {
        if (personnel == card) {
            return 0;
        }
        return -1;
    }

    @Override
    public void addCardAll(Card... cards) {
        if (cards.length > 1 || personnel != null) throw new IllegalArgumentException("人事ファイルに追加できるカードは1枚です");
        else if (cards.length == 1) addCard(cards[0]);
    }

    public boolean hasPersonnel() {
        return personnel != null;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    private void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    private void setParent(Player parent) {
        this.parent = parent;
    }

    public void nextTurn() {
        if (personnel != null) {
            personnel.refresh();
        }
    }
}
