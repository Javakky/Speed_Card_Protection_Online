package scptcg.game.effect;

import scptcg.game.Place;
import scptcg.game.card.Card;

public class Result {
    private Card[] object;
    private Place subjectPlace;
    private Card subject;
    private Place[] objectPlace;
    private String[] resStr;
    private int[] resInt;
    private int turn;
    private int subjectPlayer;
    private String action;

    public Result(int turn, int subjectPlayer, Place subjectPlace, String action, Card subject) {
        this.turn = turn;
        this.subjectPlayer = subjectPlayer;
        this.subjectPlace = subjectPlace;
        this.action = action;
        this.subject = subject;
    }

    public void setParam(Card[] object, Place[] objectPlace, String[] resStr, int[] resInt) {
        this.objectPlace = objectPlace;
        this.resStr = resStr;
        this.resInt = resInt;
        this.object = object;
    }

    public String getAction() {
        return action;
    }

    public Card[] getObject() {
        return object;
    }

    public Place getSubjectPlace() {
        return subjectPlace;
    }

    public Card getSubject() {
        return subject;
    }

    public Place[] getObjectPlace() {
        return objectPlace;
    }

    public String[] getResStr() {
        return resStr;
    }

    public int[] getResInt() {
        return resInt;
    }

    public int getTurn() {
        return turn;
    }

    public int getSubjectPlayer() {
        return subjectPlayer;
    }
}
