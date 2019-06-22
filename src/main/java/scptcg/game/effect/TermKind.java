package scptcg.game.effect;

public enum TermKind implements IActionKind {
    NOT_PARTNER("notPartner"),
    HAS_PERSONNEL("hasPersonnel"),
    HAS_SCP("hasSCP"),
    FIRST_TIME_BY_TURN("firstTimeTurn"),
    MY_TURN("myTurn"),
    HAVE_PERSONNEL("havePersonnel"),
    HAS_SECURE("hasSecure"),
    DECOMMISSIONED_SCP("decommissinoedSCP");

    private String name;

    TermKind(String name) {
        this.name = name;
    }

    public static TermKind getByName(String name) {
        for (TermKind v : TermKind.values()) {
            if (v.getName().equals(name)) return v;
        }
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}
