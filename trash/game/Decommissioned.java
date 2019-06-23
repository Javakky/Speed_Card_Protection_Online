package scptcg.game;

import scptcg.game.card.Card;
import scptcg.game.card.CardKind;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static scptcg.game.Place.*;

public class Decommissioned extends CardHolder {

    protected List<Card> decommissioned = new ArrayList<Card>();

    public Decommissioned(Player parent) {
        super(parent);
    }

    @Override
    public Place getPlace() {
        return DECOMMISSIONED;
    }

    @Override
    public int getNumber(Card parent) {
        return decommissioned.indexOf(parent);
    }

    @Override
    public int[] select(String full) {
        return super.select(full, decommissioned);
    }

    public int addCard(Card c) {
        if (c != null) {
            decommissioned.add(c);
            c.setParent(this);
        }
        return decommissioned.size();
    }

    @Override
    public Card getCard(int i) {
        return super.getCard(i, decommissioned);
    }

    @Override
    public Map<Card, Integer> deleteCardAll(CardKind kind) {
        return super.deleteCardAll(decommissioned, kind);
    }

    @Override
    public void deleteCard(Card card) {
        decommissioned.remove(card);
    }

    @Override
    public Card findCard(String s) {
        return super.findCard(s, decommissioned);
    }

    public String[] getDecommissionedString() {
        String[] str = new String[decommissioned.size()];
        for (int i = 0; i < decommissioned.size(); i++) {
            str[i] = this.decommissioned.get(i).getName();
        }
        return str;
    }

    public Card getTop() {
        return decommissioned.size() <= 0 ? null : decommissioned.get(decommissioned.size() - 1);
    }
}
