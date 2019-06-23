package scptcg.game;

import scptcg.game.card.Card;
import scptcg.game.effect.Effect;

public class Player {
    Game parent;

    public boolean isFirst() {
        return parent.isFirst(this);
    }

    public boolean HasPersonnel() {
    }

    public boolean isMyTurn() {
        return parent.isTurnPlayer(this);
    }

    public Player getEnemy() {
        return parent.getEnemy(this);
    }

    public Game getGame() {
        return parent;
    }

    public boolean hasSCP(Zone targetZone, boolean there, String[] condition) {
    }

    public int reContainment(Card card) {
    }

    public int[] getSelectableCoordinate(Zone targetZone, boolean there, String reference) {
    }

    public void addTag(Zone zone, Integer index, String[] tags) {
    }

    public void addEffect(Zone zone, Integer index, Effect[] effects) {
    }

    public void decommission(Zone targetZone, Card card) {
    }

    public int getTurn() {
        return getGame().getTurn();
    }
}
