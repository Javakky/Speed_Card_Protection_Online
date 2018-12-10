package scptcg.game;

public enum K_ClassScenario {
    XK("XK"),
    NK("NK"),
    ZK("ZK"),
    IK("IK");

    private String scenario;

    private K_ClassScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getScenario() {
        return this.scenario;
    }
}
