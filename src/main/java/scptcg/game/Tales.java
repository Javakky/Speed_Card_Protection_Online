package scptcg.game;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.NotImplementedException;
import scptcg.game.card.Card;
import scptcg.game.card.CardCategory;
import scptcg.game.card.Tale;
import scptcg.game.effect.Effect;
import scptcg.game.effect.Trigger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Tales implements CardHolder {
    private Player parent;
    private Tale[] tales = new Tale[2];

    public Tales(Player parent, Tale... tales) {
        this.parent = parent;
        if (tales.length != 2) throw new IllegalArgumentException("テイルズに格納できるのは2枚です");
        this.tales = tales;
    }

    @Override
    public Player getPlayer() {
        return parent;
    }

    @Override
    public Zone getZone() {
        return Zone.Tales;
    }

    @Override
    public void nextTurn() {
        for (Tale t : tales) {
            if (Objects.nonNull(t)) t.refresh();
        }
    }

    @Override
    public void deleteCard(Card card) {
        for (int i = 0; i < tales.length; i++) {
            if (tales[i] == card) tales[i] = null;
        }
    }

    @Override
    public Card find(String cardName) {
        for (Tale tale : tales) {
            if (tale.getName().equals(cardName)) return tale;
        }
        return null;
    }

    @Override
    public int addCard(Card card) {
        for (int i = 0; i < tales.length; i++) {
            if (Objects.nonNull(tales[i]) && card instanceof Tale) {
                tales[i] = (Tale) card;
                return i;
            }
        }
        return -1;
    }

    @Override
    public Card getCard(int index) {
        if (index > 1 || index < 0) {
            throw new IllegalArgumentException("テイルズには2枚までしかテイルを置くことが出来ません");
        } else {
            return tales[index];
        }
    }

    @Override
    public Map<Card, Integer> deleteCardAll(CardCategory category) {
        if (category != CardCategory.Tale) throw new IllegalArgumentException("テイルズにはテイル以外のカードはありません");
        Map<Card, Integer> result = new HashMap<>();
        for (int i = 0; i < tales.length; i++) {
            if (Objects.nonNull(tales[i])) {
                result.put(tales[i], i);
                tales[i] = null;
            }
        }
        return result;
    }

    @Override
    public int indexOf(Card card) {
        for (int i = 0; i < tales.length; i++) {
            if (tales[i] == card) return i;
        }
        return -1;
    }

    @Override
    public void addTag(int index, String[] tags) {
        throw new NotImplementedException("Taleはタグを持ちません");
    }

    @Override
    public void addEffect(int index, Effect effects, Trigger trigger) {
        tales[index].addEffect(effects, trigger);
    }

    @Override
    public boolean hasCard(CardCategory category, ConditionParameter[] condition) {
        for (Card c : tales) {
            if (Objects.nonNull(c) && c.getCategory() == category)
                return true;
        }
        return false;
    }

    @Override
    public int getCardCount() {
        return 0;
    }

    @Override
    public List<Effect> getEffects(Trigger trigger) {
        return null;
    }

    @Override
    public Card[] getCards() {
        return ArrayUtils.clone(tales);
    }

    private Tale[] getTales() {
        return tales;
    }

    private void setTales(Tale[] tales) {
        this.tales = tales;
    }

    public void setParent(Player parent) {
        this.parent = parent;
    }
}
