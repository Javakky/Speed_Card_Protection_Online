package scptcg.game;

import scptcg.game.card.Card;
import scptcg.game.effect.ActionMethod;
import scptcg.game.effect.Result;
import scptcg.json.Data;
import scptcg.server.Events;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Event> result;
    private boolean turnPlayer;
    private EventBuilder tmp;
    private boolean writing = false;
    private Game parent;

    public History(boolean isFirst, Game parent, List<Event> result) {
        this(isFirst, parent);
        this.result.addAll(result);
    }

    public History(boolean isFirst, Game parent) {
        this.result = new ArrayList<>();
        turnPlayer = isFirst;
        this.parent = parent;
    }

    public boolean isWriting() {
        return writing;
    }

    public synchronized void add(IResult result) {
        if (!isWriting()) {
            tmp = new EventBuilder();
            writing = true;
        }

        if (result instanceof Result) {
            addResult((Result) result);
        } else if (result instanceof Event) {
            addEvent((Event) result);
        } else if (result instanceof Data) {
            addData((Data) result);
        }
    }

    private void addData(Data result) {

    }

    private void addResult(Result result) {

        switch (ActionMethod.valueOf(result.getAction())) {
            case Decommission:
                decommission(result);
        }


    }

    private void beforeSetResult(Result result) {
        if (!tmp.isEffect()) {
            tmp.setIsEffect(true);
            tmp.setSubject(result.getSubject())
                    .setSubjectPlayer(result.getSubjectPlayer())
                    .setSubjectZone(result.getSubjectZone())
                    .setSubjectCoordinate(result.getSubjectCoordinate());
        }
    }

    private void afterSetResult(Result result) {
        if (result.isComplete()) {
            this.result.add(tmp.createEvent());
            tmp = null;
        }
    }

    private void decommission(Result result) {
        Card[][] resultObject = result.getObject();
        for (int i = 0; i < resultObject.length; i++) {
            Card[] player = resultObject[i];
            for (int j = 0; j < player.length; j++) {
                beforeSetResult(result);
                tmp.setEvents(Events.Decommission)
                        .setObject(player[j])
                        .setObjectCoordinate(result.getObjectCoordinate()[i][j])
                        .setObjectPlayer(
                                result.objectPlayerIsOne()
                                        ? result.getObjectPlayer()
                                        : result.getSubjectPlayer() ^ i == 0
                        )
                        .setObjectZone(result.getSubjectZone());
                afterSetResult(result);
            }
        }
    }

    private Game getGame() {
        return parent;
    }

    private void addEvent(Event result) {
        this.result.add(result);
        writing = false;
    }
}
