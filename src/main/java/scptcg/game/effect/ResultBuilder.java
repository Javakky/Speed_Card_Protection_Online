package scptcg.game.effect;

import scptcg.game.Zone;
import scptcg.game.card.Card;

public class ResultBuilder {
    private boolean subjectPlayer;
    private Zone subjectZone;
    private Card subject;
    private String subjectName;
    private int subjectCoordinate;
    private boolean objectPlayer;
    private boolean objectPlayerIsOne;
    private Zone[][] objectZone;
    private Card[][] object;
    private String[][] objectName;
    private int[][] objectCoordinate;
    private int[][] coordinate;
    private String nextAction;
    private int point;
    private int count;
    private boolean overlap;
    private String message;
    private boolean isComplete;
    private boolean targetPlayer;
    private String action;
    private Zone targetZone;

    public ResultBuilder(final String action, final boolean subjectPlayer, final Zone subjectZone, final Card subject, final String subjectName, final int subjectCoordinate) {
        this.subjectPlayer = subjectPlayer;
        this.subjectZone = subjectZone;
        this.subject = subject;
        this.subjectName = subjectName;
        this.subjectCoordinate = subjectCoordinate;
        this.action = action;
    }

    public ResultBuilder setObjects(final boolean objectPlayer, final Zone objectZone, final Card object, final String objectName, final int objectCoordinate) {
        this.objectPlayerIsOne = true;
        this.objectPlayer = objectPlayer;
        this.objectZone = new Zone[][]{{objectZone}};
        this.object = new Card[][]{{object}};
        this.objectName = new String[][]{{objectName}};
        this.objectCoordinate = new int[][]{{objectCoordinate}};
        return this;
    }

    public ResultBuilder setObjects(final boolean objectPlayer, final Zone[] objectZone, final Card[] object, final String[] objectName, final int[] objectCoordinate) {
        this.objectPlayerIsOne = true;
        this.objectPlayer = objectPlayer;
        this.objectZone = new Zone[][]{objectZone};
        this.object = new Card[][]{object};
        this.objectName = new String[][]{objectName};
        this.objectCoordinate = new int[][]{objectCoordinate};
        return this;
    }

    public ResultBuilder setObjects(final Zone[][] objectZone, final Card[][] object, final String[][] objectName, final int[][] objectCoordinate) {
        this.objectPlayerIsOne = false;
        this.objectZone = objectZone;
        this.object = object;
        this.objectName = objectName;
        this.objectCoordinate = objectCoordinate;
        return this;
    }

    public ResultBuilder objectEqualSubject() {
        return setObjects(
                subjectPlayer,
                subjectZone,
                subject,
                subjectName,
                subjectCoordinate
        );
    }

    public ResultBuilder setNextAction(final String nextAction) {
        this.nextAction = nextAction;
        return this;
    }

    public ResultBuilder setPoint(final int point) {
        this.point = point;
        return this;
    }

    public ResultBuilder setCount(final int count) {
        this.count = count;
        return this;
    }

    public ResultBuilder setOverlap(final boolean overlap) {
        this.overlap = overlap;
        return this;
    }

    public ResultBuilder setMessage(final String message) {
        this.message = message;
        return this;
    }

    public ResultBuilder setIsComplete(final boolean isComplete) {
        this.isComplete = isComplete;
        return this;
    }

    public Result createResult() {
        return new Result(subjectZone, subjectPlayer, subject, subjectName, subjectCoordinate, objectPlayer, objectPlayerIsOne, objectZone, object, objectName, objectCoordinate, coordinate, nextAction, point, count, overlap, message, isComplete, targetPlayer, action, targetZone);
    }

    public void setCoordinate(final int[][] coordinate) {
        this.coordinate = coordinate;
    }

    public void setCoordinate(final int[] coordinate) {
        this.coordinate = new int[][]{coordinate};
    }

    public void setCoordinate(final int coordinate) {
        this.coordinate = new int[][]{{coordinate}};
    }

    public void setTargetPlayer(final boolean targetPlayer) {
        this.targetPlayer = targetPlayer;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setSubjectZone(Zone decommissioned) {
        this.subjectZone = decommissioned;
    }

    public void setTargetZone(Zone whereZone) {
        this.targetZone = whereZone;
    }
}