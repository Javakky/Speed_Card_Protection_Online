package scptcg.game.effect;

public abstract class AbstractAction {

    protected String action;
    protected String[] param;

    public AbstractAction(String action) {
        this.action = action;
    }

    public AbstractAction(String action, String[] param) {
        this(action);
        this.param = param;
    }

    public abstract IActionKind getAction();

    public String[] getParam() {
        return param;
    }

}