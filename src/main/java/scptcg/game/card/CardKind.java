package scptcg.game.card;

import java.util.Arrays;

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

    public static CardKind getByName(String name) {
        return Arrays.stream(CardKind.values())
                .filter(data -> data.getType().equals(name))
                .findFirst()
                .orElse(null);

    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
