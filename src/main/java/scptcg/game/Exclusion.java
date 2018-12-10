package scptcg.game;

import scptcg.game.card.Card;

import java.util.ArrayList;
import java.util.List;

import static scptcg.game.Place.*;

public class Exclusion extends CardHolder {

    protected List<Card> ex = new ArrayList<>(4);

    public Exclusion(Player parent) {
        super(parent);
        for (int i = 0; i < 4; i++) {
            ex.set(i, null);
        }
    }

    @Override
    public Place getPlace() {
        return EXCLUSION;
    }

    @Override
    public int getNumber(Card parent) {
        return ex.indexOf(parent);
    }

    @Override
    public int[] select(String full) {
        return super.select(full, ex);
    }

    @Override
    public void deleteCard(Card card) {
        ex.remove(card);
    }

    @Override
    public void decommission(Card card) {
        throw new RuntimeException("can't decommission");
    }

    @Override
    public Card findCard(String s) {
        return super.findCard(s, ex);
    }

    @Override
    public int addCard(Card c) {
        if (c != null) {
            ex.add(c);
            c.setParent(this);
        }
        return ex.size();
    }

    @Override
    public Card getCard(int i) {
        return super.getCard(i, ex);
    }
}
