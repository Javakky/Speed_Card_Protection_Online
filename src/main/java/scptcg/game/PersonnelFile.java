package scptcg.game;

import org.apache.commons.lang3.NotImplementedException;
import scptcg.game.card.Canon;
import scptcg.game.card.Card;
import scptcg.game.card.CardCategory;
import scptcg.game.card.Personnel;
import scptcg.game.effect.ConditionParameter;
import scptcg.game.effect.Effect;
import scptcg.game.effect.Trigger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PersonnelFile implements CardHolder {
    private Personnel personnel;

    private Player parent;

    public PersonnelFile(Player player, Card[] card) {
        for (Card c : card) c.setParent(this);
        parent = player;
        personnel = (Personnel) card[0];
    }

    @Override
    public Player getPlayer() {
        return parent;
    }

    @Override
    public Zone getZone() {
        return Zone.PersonnelFile;
    }

    @Override
    public void deleteCard(Card card) {
        deleteCard();
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
    public int indexOf(Card card) {
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

    private Personnel getPersonnel() {
        return personnel;
    }

    private void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    private void setParent(Player parent) {
        this.parent = parent;
    }

    @Override
    public void nextTurn() {
        if (personnel != null) {
            personnel.refresh();
        }
    }


    @Override
    public void addTag(int index, String[] tags) {
        throw new NotImplementedException("人事ファイルはタグを持ちません");
    }

    @Override
    public void addEffect(int index, Effect effect, Trigger trigger) {
        personnel.addEffect(effect, trigger);
    }

    @Override
    public boolean hasCard(CardCategory category, ConditionParameter[] condition) {
        return Objects.isNull(personnel) && category == CardCategory.Personnel;
    }

    @Override
    public int getCardCount() {
        return Objects.isNull(personnel) ? 0 : 1;
    }

    @Override
    public List<Effect> getEffects(Trigger trigger) {
        return personnel.getEffects(trigger);
    }

    @Override
    public Card[] getCards() {
        return new Card[]{personnel};
    }

}
