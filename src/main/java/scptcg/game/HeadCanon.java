package scptcg.game;

import scptcg.game.card.Canon;
import scptcg.game.card.Card;
import scptcg.game.card.CardFactory;

import static scptcg.game.Place.*;
import static scptcg.game.card.CardKind.*;

public class HeadCanon extends CardHolder {

    private Canon canon;

    private HeadCanon(Game parent) {
        super(parent);
    }

    public HeadCanon create(Game parent, String name) {
        HeadCanon tmp = new HeadCanon(parent);
        tmp.setCard(name);
        return tmp;
    }

    @Override
    public int getNumber(Card parent) {
        return canon == parent ? 0 : -1;
    }

    @Override
    public Place getPlace() {
        return HEAD_CANON;
    }

    @Override
    public int[] select(String full) {
        return canon == null ? new int[0] : new int[]{0};
    }

    protected void setCard(String name) {
        canon = (Canon) CardFactory.create(this, name, CANON);
    }

    @Override
    public void deleteCard(Card card) {
        this.canon = null;
    }

    @Override
    public Card findCard(String s) {
        if (canon != null) {
            if (canon.getName().equals(s)) {
                return canon;
            }
        }
        return null;
    }

    @Override
    public int addCard(Card c) {
        throw new RuntimeException("cannot add");
    }

    @Override
    public Card getCard(int i) {
        return canon;
    }
}
