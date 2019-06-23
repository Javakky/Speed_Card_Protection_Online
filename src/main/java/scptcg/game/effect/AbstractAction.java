package scptcg.game.effect;

import scptcg.game.Game;
import scptcg.game.Player;
import scptcg.game.card.Card;

import java.util.List;

public abstract class AbstractAction {

    private String action;
    private Parameter parameter;
    private Effect parent = null;

    public AbstractAction(String action) {
        this.action = action;
    }

    public abstract IActionMethod getAction();

    protected String getActionMessage() {
        return action;
    }

    public Effect getParent() {
        return parent;
    }

    protected void setParent(final Effect parent) {
        this.parent = parent;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public boolean isTargetPlayerOne() {
        switch (TargetPlayerCategory.valueOf(getParameter().getTargetPlayer())) {
            case Me:
                return true;
            case Enemy:
                return true;
            case Any:
                return false;
            case Both:
                return false;
            default:
                throw new IllegalArgumentException("プレイヤー指定が不正です。：" + getParameter().getTargetPlayer());
        }
    }

    public boolean getTargetPlayer(List<Player> result) {
        switch (TargetPlayerCategory.valueOf(getParameter().getTargetPlayer())) {
            case Me:
                result.add(getPlayer());
                return true;
            case Enemy:
                result.add(getEnemy());
                return true;
            case Any:
                result.add(getPlayer());
                result.add(getEnemy());
                return true;
            case Both:
                result.add(getPlayer());
                result.add(getEnemy());
                return false;
            default:
                throw new IllegalArgumentException("プレイヤー指定が不正です。：" + getParameter().getTargetPlayer());
        }
    }


    public TargetPlayerCategory getTargetPlayer() {
        return TargetPlayerCategory.valueOf(getParameter().getTargetPlayer());
    }


    protected Player getEnemy() {
        return getParent().getParent().getEnemy();
    }

    protected Card getCard() {
        return getParent().getParent();
    }

    protected Player getPlayer() {
        return getParent().getParent().getPlayer();
    }

    protected Game getGame() {
        return getParent().getParent().getGame();
    }

}
