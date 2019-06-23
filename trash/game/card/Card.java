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

/**
 * ゲーム内に登場するあらゆるカードを表す抽象クラス。
 */
public abstract class Card implements Cloneable {
    protected CardHolder parent;
    /**
     * カードの種類。<br />
     * 内訳は{@link scptcg.game.card.CardKind}を参照。<br />
     * 内部情報としてはStringで保持しているが、getType・setTypeで変換を行う。
     */
    protected String type;
    protected String name;
    protected boolean canDecommission = true;
    protected Effects effects;
    protected List<Effect> tmpEffect;

    /**
     * @param parent このカードが最初に置かれる場所(オブジェクト)への参照
     * @param type   カードの種類
     * @param name   カードの名前
     */
    protected Card(CardHolder parent, CardKind type, String name) {
        setParent(parent);
        setType(type);
        setName(name);
    }

    /**
     * カードが移動したときに呼ぶべきメソッド。
     * 自身を保持するオブジェクトの参照を変更する。
     *
     * @param parent
     */
    public void setParent(CardHolder parent) {
        this.parent = parent;
    }

    /**
     * カードの種類を得るメソッド
     * 内部情報を{@link scptcg.game.card.CardKind}に変換する。
     *
     * @return カードの種類
     */
    public CardKind getType() {
        return CardKind.getByName(type);
    }

    protected void setType(final CardKind type) {
        this.type = type.toString();
    }

    /**
     * カード名。
     */
    public String getName() {
        return name;
    }

    protected void setName(final String name) {
        this.name = name;
    }

    public int getTurn() {
        return getParent().getTurn();
    }

    public Place getPlace() {
        return getParent().getPlace();
    }

    public Player getMyPlayer() {
        return this.getParent().getMyPlayer();
    }

    public int getNumber() {
        return getParent().getNumber(this);
    }

    protected boolean canDecommission() {
        return isCanDecommission();
    }

    protected List<Effect> getEffect() {
        if (getEffects() == null) {
            return new ArrayList<>();
        }
        List<Effect> li = getEffects().getEffect();
        if (li == null) {
            return new ArrayList<>();
        } else {
            return li;
        }
    }

    public Effect getEffect(int timing, int num) {
        if (getEffects() != null) {
            return getEffects().getEffect(timing, num);
        } else {
            return null;
        }
    }

    public Pair<Result[], Boolean> activeEffect(int timing, int num, String[] param) {
        if (getEffects() != null) {
            return getEffects().activeEffect(timing, num, param);
        }
        return null;
    }

    public void addEffect(Effect e, String type, String compel) {
        e.setParent(this);
        getTmpEffect().add(e);
        getEffects().addEffect(e, type, compel);
    }

    public List<Effect> decommission() {
        return getParent().decommission(this);
    }

    public void refresh() {
        if (getTmpEffect() == null) {
            return;
        }
        for (Effect e : getTmpEffect()) {
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
        return getParent().getEnemyNumber();
    }

    public int getPlayerNumber() {
        return getParent().getPlayerNumber();
    }

    public List<Effect> getEffectList(int suffix) {
        return getEffects().getEffectList(suffix);
    }

    public Player getEnemy() {
        return getParent().getEnemy();
    }

    public boolean isMyTurn() {
        return getParent().isMyTurn();
    }

    /**
     * このカードを保持しているオブジェクトへの参照。
     */
    public CardHolder getParent() {
        return parent;
    }

    /**
     * 破壊する(Decommissionする)ことが可能であるかどうか。
     */
    public boolean isCanDecommission() {
        return canDecommission;
    }

    /**
     * 保持する効果を体系的にまとめたオブジェクト。
     */
    public Effects getEffects() {
        return effects;
    }

    /**
     * 利便性のため、全効果オブジェクトへの参照をリストとして保持するためのフィールド。
     */
    public List<Effect> getTmpEffect() {
        return tmpEffect;
    }
}
