package scptcg.game.card;

import scptcg.game.CardHolder;
import scptcg.game.Game;
import scptcg.game.Player;
import scptcg.game.Zone;
import scptcg.game.effect.Effect;
import scptcg.game.effect.Effects;
import scptcg.game.effect.Trigger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    protected Effects getEffects() {
        return effects;
    }

    public int effectSize(final Trigger trigger) {
        if (Objects.isNull(effects)) return 0;
        return effects.size(trigger);
    }

    public Effect getEffect(final Trigger trigger, final int index) {
        return effects.getEffect(trigger, index);
    }

    protected void setEffects(Effects effects) {
        this.effects = effects;
    }

    public CardHolder getParent() {
        return parent;
    }

    public void setParent(final CardHolder parent) {
        this.parent = parent;
        if (Objects.nonNull(effects)) {
            effects.setParent(this);
        }
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
        return parent.indexOf(this);
    }

    public void refresh() {
        if (Objects.nonNull(effects))
            effects.refresh();
    }

    private boolean fullCondition(String... condition) {
        if (condition.length <= 0) {
            return true;
        }
        return true;
    }

    public List<Effect> getEffects(Trigger trigger) {
        if (Objects.nonNull(effects)) return effects.getEffects(trigger);
        else return new ArrayList<>();
    }

    public void addEffect(Effect effects, Trigger trigger) {
        this.effects.addEffect(effects, trigger);
    }

    public boolean ownerIsFirst() {
        return getPlayer().isFirst();
    }

}
