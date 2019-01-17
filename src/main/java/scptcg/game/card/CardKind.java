package scptcg.game.card;

public enum CardKind {
    SCP("Scp"),
    TALE("Tale"),
    INCIDENT("Incident"),
    PERSONNEL("Personnel"),
    CANON("Canon"),
    ANOMALOUS("Anomalous");

    private String type;

    CardKind(String type) {
        this.type = type;
    }

    public static CardKind create(String place) {
        switch (place) {
            case "SCP":
                return SCP;
            case "Incident":
                return INCIDENT;
            case "Tale":
                return TALE;
            case "Personnel":
                return PERSONNEL;
            case "Canon":
                return CANON;
            case "Anomalous":
                return ANOMALOUS;
            default:
                throw new NullPointerException();
        }
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
