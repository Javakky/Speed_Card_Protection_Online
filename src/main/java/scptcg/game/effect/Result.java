package scptcg.game.effect;

import scptcg.game.Place;
import scptcg.game.card.Card;

public class Result {
    public Card[] object;
    public Place subjectPlace;
    public Card subject;
    public Place[] objectPlace;
    public String[] resStr;
    public int[] resInt;
    int turn;
    int subjectPlayer;
    String action;

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
}
