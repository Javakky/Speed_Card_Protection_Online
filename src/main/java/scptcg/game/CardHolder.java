package scptcg.game;

import scptcg.game.card.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class CardHolder {
    protected ICardSetHolder parent;

    public CardHolder(ICardSetHolder parent) {
        this.parent = parent;
    }

    public ICardSetHolder getParent() {
        return this.parent;
    }

    public int getTurn() {
        if (parent instanceof Player) {
            return ((Player) parent).getTurn();
        } else if (parent instanceof Game) {
            return ((Game) parent).getTurn();
        } else {
            throw new RuntimeException("parent is unknown");
        }
    }

    public abstract Place getPlace();

    public abstract int getNumber(Card parent);

    public Player getMyPlayer() {
        if (parent instanceof Player) {
            return (Player) parent;
        }
        throw new RuntimeException("parent is not player");
    }

    public abstract int[] select(String full);

    protected int[] select(String full, List list) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) != null) == (full.equals("Full"))) {
                li.add(i);
            }
        }
        int[] res = new int[li.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = li.get(i);
        }
        return res;
    }

    public void decommission(Card card) {
        if (parent instanceof Player) {
            ((Player) parent).decommission(card);
        } else {
            throw new RuntimeException("can't decommission");
        }
    }

    public abstract void deleteCard(Card card);

    protected void deleteCard(Card card, List<? extends Card> list) {
        list.set(list.indexOf(card), null);
    }

    public abstract Card findCard(String s);

    public Card findCard(String s, List<? extends Card> list) {
        for (Card c : list) {
            if (c != null) {
                if (c.getName().equals(s)) {
                    return c;
                }
            }
        }
        return null;
    }

    public abstract int addCard(Card c);

    public int getEnemyNumber() {
        if (parent instanceof Player) {
            return ((Player) parent).getEnemyNumber();
        } else {
            throw new RuntimeException("parent isn't player");
        }
    }

    public int getPlayerNumber() {
        if (parent instanceof Player) {
            return ((Player) parent).getPlayerNumber();
        } else {
            throw new RuntimeException("parent isn't player");
        }
    }

    public abstract Card getCard(int i);

    protected Card getCard(int i, List<? extends Card> list) {
        return list.get(i);
    }

    public Player getEnemy() {
        if(parent instanceof Player){
            return ((Player) parent).getEnemy();
        }else {
            throw new RuntimeException("parent isn't player");
        }
    }
}
