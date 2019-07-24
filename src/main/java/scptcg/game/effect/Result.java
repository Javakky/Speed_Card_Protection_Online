package scptcg.game.effect;

import scptcg.game.IResult;
import scptcg.game.Zone;
import scptcg.game.card.Card;

public final class Result implements IResult {
    private final String action;
    private final boolean subjectPlayer;
    private final Zone subjectZone;
    private final Card subject;
    private final String subjectName;
    private final int subjectCoordinate;
    private final boolean objectPlayer;
    private final boolean objectPlayerIsOne;
    private final Zone[][] objectZone;
    private final Zone targetZone;
    private final Card[][] object;
    private final String[][] objectName;
    private final int[][] objectCoordinate;
    private final String nextAction;
    private final int point;
    private final int count;
    private final boolean overlap;
    private final String message;
    private final boolean isComplete;
    private final boolean targetPlayer;
    private int[][] coordinate;

    public Result(final Zone subjectZone, final boolean subjectPlayer, final Card subject, final String subjectName, final int subjectCoordinate, final boolean objectPlayer, final boolean objectPlayerIsOne, final Zone[][] objectZone, final Card[][] object, final String[][] objectName, final int[][] objectCoordinate, final int[][] coordinate, final String nextAction, final int point, final int count, final boolean overlap, final String message, final boolean isComplete, final boolean targetPlayer, String action, Zone targetZone) {
        this.subjectPlayer = subjectPlayer;
        this.subjectZone = subjectZone;
        this.subject = subject;
        this.subjectName = subjectName;
        this.subjectCoordinate = subjectCoordinate;
        this.objectPlayer = objectPlayer;
        this.objectPlayerIsOne = objectPlayerIsOne;
        this.objectZone = objectZone;
        this.object = object;
        this.objectName = objectName;
        this.objectCoordinate = objectCoordinate;
        this.nextAction = nextAction;
        this.point = point;
        this.count = count;
        this.overlap = overlap;
        this.message = message;
        this.isComplete = isComplete;
        this.coordinate = coordinate;
        this.targetPlayer = targetPlayer;
        this.action = action;
        this.targetZone = targetZone;
    }

    public boolean getSubjectPlayer() {
        return subjectPlayer;
    }

    public Zone getSubjectZone() {
        return subjectZone;
    }

    public Card getSubject() {
        return subject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getSubjectCoordinate() {
        return subjectCoordinate;
    }

    public boolean getObjectPlayer() {
        return objectPlayer;
    }

    public boolean objectPlayerIsOne() {
        return objectPlayerIsOne;
    }

    public Zone[][] getObjectZone() {
        return objectZone;
    }

    public Card[][] getObject() {
        return object;
    }

    public String[][] getObjectName() {
        return objectName;
    }

    public int[][] getObjectCoordinate() {
        return objectCoordinate;
    }

    public String getNextAction() {
        return nextAction;
    }

    public int getPoint() {
        return point;
    }

    public int getCount() {
        return count;
    }

    public boolean canOverlap() {
        return overlap;
    }

    public String getMessage() {
        return message;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public int[][] getCoordinate() {
        return coordinate;
    }

    public boolean getTargetPlayer() {
        return targetPlayer;
    }

    public boolean isObjectPlayerIsOne() {
        return objectPlayerIsOne;
    }

    public String getAction() {
        return action;
    }

    public String getTargetZone() {
        return targetZone.name();
    }

}
