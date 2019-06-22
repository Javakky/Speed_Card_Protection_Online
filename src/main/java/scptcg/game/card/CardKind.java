package scptcg.game.card;

public enum CardKind {
    SCP("SCP"),
    TALE("Tale"),
    INCIDENT("Incident"),
    PERSONNEL("Personnel"),
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
