package scptcg.game;

import scptcg.game.card.Card;
import scptcg.game.card.CardFactory;
import scptcg.game.card.CardKind;
import scptcg.game.card.Personnel;

import static scptcg.game.Place.*;

public class PersonnelFile extends CardHolder {

    protected Personnel pf;

    private PersonnelFile(Player parent) {
        super(parent);
    }

    static PersonnelFile create(Player parent, String name) {
        PersonnelFile tmp = new PersonnelFile(parent);
        tmp.setCard(name);
        return tmp;
    }

    protected void setCard(String name) {
        pf = (Personnel) CardFactory.create(this, name, CardKind.PERSONNEL);
    }

    @Override
    public int[] select(String full) {
        return pf == null ? new int[0] : new int[]{0};
    }

    String getPersonnelName() {
        return this.pf.getName();
    }

    @Override
    public Place getPlace() {
        return PERSONNEL_FILE;
    }

    @Override
    public int getNumber(Card parent) {
        return pf == parent ? 0 : -1;
    }

    public Personnel getPersonnel() {
        return pf;
    }

    public boolean hasPersonnel() {
        return pf != null;
    }

    @Override
    public void deleteCard(Card card) {
        this.pf = null;
    }

    @Override
    public Card findCard(String s) {
        if (pf != null) {
            if (pf.getName().equals(s)) {
                return pf;
            }
        }
        return null;
    }

    @Override
    public int addCard(Card c) {
        if (pf == null) {
            pf = (Personnel) c;
            c.setParent(this);
            return 0;
        }
        throw new RuntimeException("Out of Bounds");
    }

    @Override
    public Card getCard(int i) {
        return pf;
    }

    public Personnel decommission() {
        Personnel tmp = pf;
        pf = null;
        return tmp;
    }

    public void nextTurn() {
        if (pf != null) {
            pf.refresh();
        }
    }

}
