package scptcg.game.card;

public enum CardKind {
    SCP("trash/SCP"),
    TALE("trash/Tale"),
    INCIDENT("Incident"),
    PERSONNEL("trash/Personnel"),
    CANON("Canon"),
    ANOMALOUS("Anomalous");

    private String type;

    CardKind(String type) {
        this.type = type;
    }

    public static CardKind getByName(String name) {
        for (CardKind k : values()) {
            if (name.equals(k.type)) {
                return k;
            }
        }
        return null;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}