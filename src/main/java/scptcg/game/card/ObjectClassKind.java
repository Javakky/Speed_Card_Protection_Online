package scptcg.game.card;

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

    public static ObjectClassKind create(String clazz) {
        switch (clazz) {
            case "Safe":
                return SAFE;
            case "Euclid":
                return EUCLID;
            case "Keter":
                return KETER;
            case "Neutralized":
                return NEUTRALIZED;
            case "Thaumiel":
                return THAUMIEL;
            case "Explained":
                return EXPLAINED;
            case "Unclassed":
                return UNCLASSED;
            default:
                throw new NullPointerException();
        }
    }

    public String getClazz() {
        return this.clazz;
    }
}
