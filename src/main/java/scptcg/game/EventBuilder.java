package scptcg.game;

import scptcg.game.card.Card;
import scptcg.server.Events;

public class EventBuilder {
    private Events events;
    private boolean subjectPlayer;
    private Zone subjectZone;
    private Card subject;
    private int subjectCoordinate;
    private boolean objectPlayer;
    private Zone objectZone;
    private Card object;
    private int objectCoordinate;
    private int point;
    private int count;
    private boolean isEffect;

    public EventBuilder setEvents(Events events) {
        this.events = events;
        return this;
    }

    public EventBuilder setSubjectPlayer(boolean subjectPlayer) {
        this.subjectPlayer = subjectPlayer;
        return this;
    }

    public EventBuilder setSubjectZone(Zone subjectZone) {
        this.subjectZone = subjectZone;
        return this;
    }

    public EventBuilder setSubject(Card subject) {
        this.subject = subject;
        return this;
    }

    public EventBuilder setSubjectCoordinate(int subjectCoordinate) {
        this.subjectCoordinate = subjectCoordinate;
        return this;
    }

    public EventBuilder setObjectPlayer(boolean objectPlayer) {
        this.objectPlayer = objectPlayer;
        return this;
    }

    public EventBuilder setObjectZone(Zone objectZone) {
        this.objectZone = objectZone;
        return this;
    }

    public EventBuilder setObject(Card object) {
        this.object = object;
        return this;
    }

    public EventBuilder setObjectCoordinate(int objectCoordinate) {
        this.objectCoordinate = objectCoordinate;
        return this;
    }

    public EventBuilder setPoint(int point) {
        this.point = point;
        return this;
    }

    public EventBuilder setCount(int count) {
        this.count = count;
        return this;
    }

    public EventBuilder setIsEffect(boolean isEffect) {
        this.isEffect = isEffect;
        return this;
    }

    public Event createEvent() {
        return new Event(events, subjectPlayer, subjectZone, subject, subjectCoordinate, objectPlayer, objectZone, object, objectCoordinate, point, count, isEffect());
    }

    public boolean isEffect() {
        return isEffect;
    }
}