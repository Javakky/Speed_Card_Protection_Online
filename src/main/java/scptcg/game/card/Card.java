package scptcg.game.card;

import org.apache.commons.lang3.tuple.Pair;
import scptcg.game.CardHolder;
import scptcg.game.Place;
import scptcg.game.Player;
import scptcg.game.effect.Effect;
import scptcg.game.effect.Effects;
import scptcg.game.effect.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ゲーム内に登場するあらゆるカードを表す抽象クラス
 */
public abstract class Card implements Cloneable {
    protected CardHolder parent;
    protected String type;
    protected String name;
    protected boolean canDecommission = true;
    protected Effects effects;
    protected List<Effect> tmpEffect;


    protected Card(CardHolder parent, CardKind type, String name) {
        setParent(parent);
        setType(type);
        setName(name);
    }

    public void setParent(CardHolder parent) {
        this.parent = parent;
    }

    public CardKind getType() {
        return CardKind.create(type);
    }

    protected void setType(CardKind type) {
        this.type = type.toString();
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getTurn() {
        return parent.getTurn();
    }

    public Place getPlace() {
        return parent.getPlace();
    }

    public Player getMyPlayer() {
        return this.parent.getMyPlayer();
    }

    public int getNumber() {
        return parent.getNumber(this);
    }

    protected boolean canDecommission() {
        return canDecommission;
    }

    protected List<Effect> getEffect() {
        if (effects == null) {
            return new ArrayList<>();
        }
        List<Effect> li = effects.getEffect();
        if (li == null) {
            return new ArrayList<>();
        } else {
            return li;
        }
    }

    public Effect getEffect(int timing, int num) {
        if (effects != null) {
            return effects.getEffect(timing, num);
        } else {
            return null;
        }
    }

    public Pair<Result[], Boolean> activeEffect(int timing, int num, String[] param) {
        if (effects != null) {
            return effects.activeEffect(timing, num, param);
        }
        return null;
    }

    public void addEffect(Effect e, String type, String compel) {
        e.setParent(this);
        tmpEffect.add(e);
        effects.addEffect(e, type, compel);
    }

    public void decommission() {
        parent.decommission(this);
    }

    public void refresh() {
        if (tmpEffect == null) {
            return;
        }
        for (Effect e : tmpEffect) {
            e.refresh();
        }
    }

    public abstract int reContainment();

    @Override
    public abstract Card clone();

    public void setEffectList() {
        tmpEffect = getEffect();
    }

    public int getEnemyNumber() {
        return parent.getEnemyNumber();
    }

    public int getPlayerNumber() {
        return parent.getPlayerNumber();
    }

    public List<Effect> getEffectList(int suffix) {
        return effects.getEffectList(suffix);
    }

    public Player getEnemy() {
        return parent.getEnemy();
    }
}
