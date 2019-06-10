package scptcg.game;

public enum Events {

    LOGIN("Login"),
    GET_MY_DECK("GetMyDeck"),
    SELECT_PARTNER("SelectPartner"),
    CROSS_TEST("CrossTest"),
    DAMAGE("Damage"),
    CAN_ATTACK("CanAttack"),
    BREACH("Breach"),
    GET_EFFECT("GetEffect"),
    GET_DECOMMISSIONED("GetDecommissioned"),
    GET_CAN_PARTNERS("GetCanPertners"),
    GET_EMPTY_SITE("GetEmptySite"),
    TURN_END("TurnEnd"),
    GET_PERSONNEL("GetPersonnel"),
    GET_TALE("GetTale"),
    GET_SUM_SITE_COST("GetSumSiteCost"),
    GET_SANDBOX_PROTECTION("GetSandBoxProtection"),
    ACTIVE_EFFECT("ActiveEffect"),
    DECOMMISSION("Decommission"),
    HEAL_SANDBOX("HealSandBox"),
    DAMAGE_SANDBOX("DamageSandBox"),
    GET_CARD_PARAMETER("GetCardParameters"),
    SELECT_EFFECT("SelectEffect"),
    GET_SCP_COUNT("GetSCPCount"),
    WAIT("Wait"),
    SELECT_BREACH("SelectBreach"),
    VIEW_BREACH("ViewBreach"),
    ACTIVE_TALE("ActiveTale"),
    RE_CONTAINMENT("ReContainment"),
    K_CLASS_SCENARIO("K-ClassScenario"),
    BREACH_PARTNER("BreachPartner"),
    GET_EFFECT_COUNT("GetEffectCount"),
    IMPOSSIBLE("Impossible"),
    IS_FIRST("IsFirst"),
    GET_COST("GetCost");

    private String event;

    Events(String event) {
        this.event = event;
    }

    public static Events getEventByValue(String str) {
        for (Events v : values()) {
            if (v.event.equals(str)) {
                return v;
            }
        }
        throw new IllegalArgumentException("undefined : " + str);
    }

    public String getEvent() {
        return event;
    }
}
