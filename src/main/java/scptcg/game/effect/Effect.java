package scptcg.game.effect;

import scptcg.game.card.Card;
import scptcg.game.exception.NotActivableException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Effect {
    private Card parent;
    private List<Condition> condition;
    private List<Action> action;
    private String message;
    private long activationsCount;
    private boolean canActive;

    private int activationCount = 0;
    private int index = 0;
    private List<Result> before = new ArrayList<>();
    private boolean isActive = false;


    public Card getParent() {
        return parent;
    }

    public void setParent(final Card parent) {
        this.parent = parent;
    }

    private List<Condition> getCondition() {
        return condition;
    }

    public void addCondition(final Condition condition) {
        this.condition.add(condition);
    }

    public List<Action> getAction() {
        return action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public long getActivationsCount() {
        return activationsCount;
    }

    public void setActivationsCount(final long activationsCount) {
        this.activationsCount = activationsCount;
    }

    public boolean isCanActive() {
        return canActive;
    }

    public void enableActive(final boolean canActive) {
        this.canActive = canActive;
    }

    public void enableActive() {
        this.canActive = true;
    }

    public void disableActive() {
        this.canActive = false;
    }

    public int getActivationCount() {
        return activationCount;
    }

    private void addActivationCount(final int activationCount) {
        this.activationCount += activationCount;
    }

    private void addActivationCount() {
        this.activationCount++;
    }

    private void resetActivationCount() {
        this.activationCount = 0;
    }

    private int getIndex() {
        return index;
    }

    private void setIndex(int index) {
        this.index = index;
    }

    private void nextIndex() {
        this.index++;
    }

    private List<Result> getBefore() {
        return before;
    }

    public void addBefore(final Result before) {
        if (Objects.nonNull(before)) this.before.add(before);
    }

    public boolean isActive() {
        return isActive;
    }

    private void activate() {
        isActive = true;
    }

    private void inactivate() {
        isActive = false;
        resetBefore();
        resetIndex();
    }

    private void resetIndex() {
        this.index = 0;
    }

    public boolean active(final List<Result> result) throws NotActivableException {

        if (isHead()) {
            if (getActivationCount() >= getActivationsCount()) {
                disableActive();
            }
            if (!canActive()) {
                throw new NotActivableException("効果の発動条件を満たしていません");
            }
            activate();
        }

        for (; index < action.size(); ) {
            Result r = action.get(index).active(this.before.get(this.before.size() - 1));
            result.add(r);
            addBefore(r);
            index++;
            if (!r.isComplete() || !isTail()) {
                return false;
            }
        }
        addActivationCount();
        inactivate();
        return true;
    }

    private boolean isTail() {
        return index == action.size();
    }

    private void resetBefore() {
        before = new ArrayList<>();
    }

    private boolean isHead() {
        return index == 0;
    }

    public boolean canActive() {
        return fulfill() && isCanActive();
    }

    private boolean fulfill() {
        for (Condition condition : this.getCondition()) {
            if (!condition.fulfill(this)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return message;
    }

    public boolean firstTime() {
        return activationCount == 0;
    }

    public void refresh() {
        activationsCount = 0;
    }

    public boolean ownerIsFirst() {
        return getParent().ownerIsFirst();
    }
}
