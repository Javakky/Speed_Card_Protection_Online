package scptcg.game;

public enum Zone {
    Site(scptcg.game.Site.class),
    Decommissioned(scptcg.game.Decommissioned.class),
    SafeSandbox(scptcg.game.SandBox.class),
    EuclidSandbox(scptcg.game.SandBox.class),
    KeterSandbox(scptcg.game.SandBox.class),
    Exclusion(scptcg.game.Exclusion.class),
    Tales(scptcg.game.Tales.class),
    PersonnelFile(scptcg.game.PersonnelFile.class),
    HeadCanon(scptcg.game.HeadCanon.class),
    AnomalousRocker(scptcg.game.AnomalousRocker.class);

    private Class clazz;

    Zone(Class clazz) {
        this.clazz = clazz;
    }

}
