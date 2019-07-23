package scptcg.game.card;

import scptcg.exception.UnsupportedAnnotationException;
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
    private CardCategory category;
    private String name;
    private boolean canDecommission;

    private Effects effects;

    protected Card(final CardHolder parent, final CardCategory category) {
        this(category);
        setParent(parent);
    }

    protected Card(final CardCategory category) {
        setParent(null);
        scptcg.annotation.Card card = getClass().getAnnotation(scptcg.annotation.Card.class);
        if (Objects.isNull(card)) {
            throw new UnsupportedAnnotationException(scptcg.annotation.Card.class.getName() + "アノテーションのないクラス:" + getClass().getName());
        }
        setName(card.value());

        scptcg.annotation.DisableDecommission disablePartner = getClass().getAnnotation(scptcg.annotation.DisableDecommission.class);
        if (Objects.nonNull(disablePartner)) {
            disableDecommission();
        } else {
            enableDecommission();
        }

        setParent(parent);
        setCategory(category);
        initializeEffects();
    }

    protected Effects getEffects() {
        return effects;
    }

    protected void setEffects(Effects effects) {
        this.effects = effects;
    }

    protected abstract void initializeEffects();

    public CardCategory getCategory() {
        return category;
    }

    public void setCategory(final CardCategory category) {
        this.category = category;
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

    public int effectSize(final Trigger trigger) {
        if (Objects.isNull(getEffects())) return 0;
        return getEffects().size(trigger);
    }

    public CardHolder getParent() {
        return parent;
    }

    public void setParent(final CardHolder parent) {
        this.parent = parent;
        if (Objects.nonNull(getEffects())) {
            getEffects().setParent(this);
        }
    }

    @Override
    public Card clone() {
        Card card = null;
        try {
            card = (Card) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        card.setCategory(getCategory());
        card.setName(getName());
        card.enableDecommission(canDecommission());
        card.setEffects(getEffects());
        return card;
    }

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
        if (Objects.nonNull(getEffects()))
            getEffects().refresh();
    }

    private boolean fullCondition(String... condition) {
        if (condition.length <= 0) {
            return true;
        }
        return true;
    }

    public List<Effect> getEffects(Trigger trigger) {
        if (Objects.nonNull(getEffects())) return getEffects().getEffects(trigger);
        else return new ArrayList<>();
    }

    public void addEffect(Effect effects, Trigger trigger) {
        this.getEffects().addEffect(effects, trigger);
    }

    public boolean ownerIsFirst() {
        return getPlayer().isFirst();
    }

    public Effect getEffect(Trigger trigger, int index) {
        return getEffects().getEffect(trigger, index);
    }

}
