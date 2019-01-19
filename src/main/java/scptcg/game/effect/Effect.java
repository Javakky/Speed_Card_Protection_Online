package scptcg.game.effect;

import org.apache.commons.lang3.tuple.Pair;
import scptcg.game.Place;
import scptcg.game.Player;
import scptcg.game.card.Card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static scptcg.game.Place.*;

public class Effect implements Serializable {
    protected Card parent;
    protected Term[] terms;
    protected Action[] action;
    protected int point;
    Result before = null;
    private int number;
    private String message;
    private long activeNum;
    private boolean canActive = true;
    private int already = 0;
    private boolean isActive = false;
    private String compel;

    private Effect(String[] action) {
        for (int i = 0; i < action.length; i++) {
            this.action[i] = new Action(action[i]);
        }
    }

    public Effect(String message, String compel, int activeNum, boolean canActive, String[] terms, Map<String, String[]> action) {
        this.message = message;
        this.activeNum = activeNum;
        this.canActive = canActive;
        this.compel = compel;
        List<Term> term = new ArrayList<>();
        for (String s : terms) {
            term.add(new Term(s));
        }
        this.terms = new Term[term.size()];
        for (int i = 0; i < term.size(); i++) {
            this.terms[i] = term.get(i);
        }
        List<Action> act = new ArrayList<>();
        for (Map.Entry<String, String[]> entry : action.entrySet()) {
            act.add(new Action(entry.getKey(), entry.getValue()));
        }
        this.action = act.toArray(new Action[act.size()]);
    }

    public EFFECT_COMPEL_LIST getCompel() {
        return EFFECT_COMPEL_LIST.valueOf(compel);
    }

    public boolean isActive() {
        return isActive;
    }

    public String getMessage() {
        return message;
    }

    public long getActiveNum() {
        return activeNum;
    }

    public String getBeforeAction() {
        return action[point].getAction().getName();
    }

    public String getAction() {
        return action[point + 1].getAction().getName();
    }

    public int getNumber() {
        return number;
    }

    public int getAlready() {
        return already;
    }

    public Card getCard() {
        return parent;
    }

    public Player getMyPlayer() {
        return parent.getMyPlayer();
    }

    public Pair<Result[], Boolean> active(String[] param, Result result) {
        List<Result> li = new ArrayList<Result>();
        li.add(null);
        if (result != null) before = result;
        if (activeNum <= 0) {
            canActive = false;
        }

        if (!canActive()) {
            return Pair.of(null, true);
        }

        Player p = parent.getMyPlayer();

        if (parent.getPlace() == TALES && p.getActiveTaleNumber() >= 1) {
            return null;
        }

        isActive = true;

        int i = 0;
        for (; point < action.length; point++) {
            Result res = action[point].active(param == null || i >= param.length ? null : param[i], this, before);
            li.add(res);
            before = res;
            if (res.getObject() == null && point != action.length - 1) {
                point++;
                return Pair.of(li.toArray(new Result[li.size()]), false);
            }
            i++;
        }

        Result r = new Result(
                parent.getTurn(),
                parent.getPlayerNumber(),
                parent.getPlace(),
                "finish",
                parent.clone());
        r.setParam(new Card[]{parent},
                new Place[]{parent.getPlace()},
                null,
                new int[]{parent.getNumber()});
        li.add(r);

        if (parent.getPlace() == TALES) {
            parent.decommission();
            p.activeTale();
        }
        activeNum--;
        already++;
        point = 0;
        isActive = false;
        return Pair.of(li.toArray(new Result[li.size()]), true);
    }

    public boolean canActive() {
        return fulfill() && canActive;
    }

    private boolean fulfill() {
        System.out.println(terms == null);
        if (terms == null) {
            return canActive;
        }
        if (!canActive) {
            return false;
        }
        for (int i = 0; i < terms.length; i++) {
            System.out.println("term:" + terms[i].getAction());
            boolean can = terms[i].fulfill(this);
            if (!can) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return message;
    }

    public void refresh() {
        this.already = 0;
    }

    public Card getParent() {
        return parent;
    }

    public void setParent(Card parent) {
        this.parent = parent;
    }

    public boolean isMyTurn() {
        return parent.isMyTurn();
    }
}
