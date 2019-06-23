package scptcg.game.effect;

public enum ConditionPattern implements IActionMethod {
    NonPartner,
    HasPersonnel,
    HasSCP,
    FirstTimeInTurn,
    MyTurn,
    SecureIsZero,
    SecureNonZero,
}
