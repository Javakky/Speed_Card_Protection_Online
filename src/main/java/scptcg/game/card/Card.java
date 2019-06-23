package scptcg.game.card;

import scptcg.game.CardHolder;
import scptcg.game.Game;
import scptcg.game.Player;
import scptcg.game.Zone;
import scptcg.game.effect.Effects;

public abstract class Card implements Cloneable {

    private CardHolder parent;
    private String category;
    private String name;
    private boolean canDecommission;
    private Effects effects;

    protected Card(final CardHolder parent, final String category, final String name, final boolean canDecommission, final Effects effects) {
        this.parent = parent;
        this.category = category;
        this.name = name;
        this.canDecommission = canDecommission;
        this.effects = effects;
    }

    public CardCategory getCategory() {
        return CardCategory.valueOf(category);
    }

    public void setCategory(final CardCategory category) {
        this.category = category.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public boolean canDecommission() {
        return canDecommission;
    }

    public void enableDecommission() {
        this.canDecommission = true;
    }

    public void disableDecommission() {
        this.canDecommission = true;
    }

    public void enableDecommission(final boolean canDecommission) {
        this.canDecommission = canDecommission;
    }

    public Effects getEffects() {
        return effects;
    }

    protected void setEffects(Effects effects) {
        this.effects = effects;
    }

    public CardHolder getParent() {
        return parent;
    }

    public void setParent(final CardHolder parent) {
        this.parent = parent;
    }

    @Override
    public abstract Card clone();

    public Player getEnemy() {
        return getPlayer().getEnemy();
    }

    public Player getPlayer() {
        return parent.getPlayer();
    }

    public Game getGame() {
        return getPlayer().getGame();
    }

    public Zone whereZone() {
        return parent.getZone();
    }

    public int getCoordinate() {
        return parent.getCoordinate(this);
    }

    public abstract void refresh();
}
