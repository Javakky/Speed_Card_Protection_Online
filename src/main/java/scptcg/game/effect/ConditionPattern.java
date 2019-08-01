package scptcg.game.effect;

public enum ConditionPattern implements IActionMethod {
    NonPartner,
    HasPersonnel,
    HasSCP,
    FirstTimeInTurn,
    DidntCrossTest,
    MyTurn,
    SecureIsZero,
    SecureNonZero,
    SecureIs,
    SecureNon,
    SecureUnder,
    SumSiteCostOver,
    ScenarioIs,
    SecureOver,
    ScenarioNon
}
