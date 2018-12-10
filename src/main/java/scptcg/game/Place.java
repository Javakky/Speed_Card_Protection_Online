package scptcg.game;

public enum Place {
    SITE(Site.class),
    DECOMMISSIONED(Decommissioned.class),
    SANDBOX(SandBox.class),
    EXCLUSION(Site.class),
    TALES(Tales.class),
    PERSONNEL_FILE(PersonnelFile.class),
    HEAD_CANON(HeadCanon.class),
    ANOMALOUS_ROCKER(AnomalousRocker.class);

    private Class type;

    private Place(Class type) {
        this.type = type;
    }

    public static Place create(String place) {
        switch (place) {
            case "Site":
                return SITE;
            case "Decommission":
                return DECOMMISSIONED;
            case "SandBox":
                return SANDBOX;
            case "Exclusion":
                return EXCLUSION;
            case "Tales":
                return TALES;
            case "PersonnelFile":
                return PERSONNEL_FILE;
            case "HeadCanon":
                return HEAD_CANON;
            case "AnomalousRocker":
                return ANOMALOUS_ROCKER;
            default:
                throw new NullPointerException();
        }
    }

    public Class getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.type.getSimpleName();
    }
}
