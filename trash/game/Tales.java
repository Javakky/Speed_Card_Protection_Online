package scptcg.game;

import scptcg.game.card.Card;
import scptcg.game.card.CardFactory;
import scptcg.game.card.CardKind;
import scptcg.game.card.Tale;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static scptcg.game.Place.*;

public class Tales extends CardHolder {

    protected List<Tale> tale = new ArrayList<>(2);
    protected int size = 2;

    private Tales(Player parent) {
        super(parent);
    }

    static Tales create(Player parent, String... name) {
        Tales tmp = new Tales(parent);
        for (int i = 0; i < 2; i++) {
            tmp.tale.add(null);
        }
        tmp.setCard(name);
        return tmp;
    }

    protected void setCard(String... name) {
        for (int i = 0; i < name.length; i++) {
            tale.set(i, (Tale) CardFactory.create(this, name[i], CardKind.TALE));
        }
    }

    @Override
    public Place getPlace() {
        return TALES;
    }

    @Override
    public int getNumber(Card parent) {
        return tale.indexOf(parent);
    }

    @Override
    public int[] select(String full) {
        return super.select(full, tale);
    }

    @Override
    public void deleteCard(Card card) {
        super.deleteCard(card, tale);
    }

    @Override
    public Card findCard(String s) {
        return super.findCard(s, tale);
    }

    @Override
    public int addCard(Card c) {
        int i = 0;
        for (; i < tale.size(); i++) {
            if (tale.get(i) == null) {
                c.setParent(this);
                tale.set(i, (Tale) c);
                return i;
            }
        }
        throw new RuntimeException("Out of Bounds");
    }

    @Override
    public Card getCard(int i) {
        return super.getCard(i, tale);
    }

    @Override
    public Map<Card, Integer> deleteCardAll(CardKind kind) {
        return deleteCardAll(tale, kind);
    }

    public void nextTurn() {
        for (Tale t : tale) {
            if (t != null) {
                t.refresh();
            }
        }
    }

    public Tale decommission(Tale c) {
        int index = tale.indexOf(c);
        Tale tmp = tale.get(index);
        tale.set(index, null);
        return tmp;
    }

}
