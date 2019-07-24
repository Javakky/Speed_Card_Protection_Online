package scptcg.game;

import scptcg.game.card.Card;
import scptcg.server.Events;

public class Event implements IResult {
    private final Events events;
    private final boolean subjectPlayer;
    private final Zone subjectZone;
    private final Card subject;
    private final int subjectCoordinate;
    private final boolean objectPlayer;
    private final Zone objectZone;
    private final Card object;
    private final int objectCoordinate;
    private final int point;
    private final int count;
    private final boolean isEffect;

    public Event(Events events, boolean subjectPlayer, Zone subjectZone, Card subject, int subjectCoordinate, boolean objectPlayer, Zone objectZone, Card object, int objectCoordinate, int point, int count, boolean isEffect) {
        this.events = events;
        this.subjectPlayer = subjectPlayer;
        this.subjectZone = subjectZone;
        this.subject = subject;
        this.subjectCoordinate = subjectCoordinate;
        this.objectPlayer = objectPlayer;
        this.objectZone = objectZone;
        this.object = object;
        this.objectCoordinate = objectCoordinate;
        this.point = point;
        this.count = count;
        this.isEffect = isEffect;
    }

}
