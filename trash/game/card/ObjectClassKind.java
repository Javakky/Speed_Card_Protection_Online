package scptcg.game.card;

import java.util.Arrays;

public enum ObjectClassKind {
    SAFE("Safe"),
    EUCLID("Euclid"),
    KETER("Keter"),
    NEUTRALIZED("Neutralized"),
    THAUMIEL("Thaumiel"),
    UNCLASSED("Unclassed"),
    EXPLAINED("Explained");

    private String clazz;

    ObjectClassKind(String clazz) {
        this.clazz = clazz;
    }

    public static ObjectClassKind getByName(String clazz) {
        return Arrays.stream(ObjectClassKind.values())
                .filter(data -> data.getClazz().equals(clazz))
                .findFirst()
                .orElse(null);
    }

    public String getClazz() {
        return this.clazz;
    }
}
