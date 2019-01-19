package scptcg.game.effect;

import java.util.Arrays;

public enum TermKind implements IActionKind {
    NOT_PARTNER("notPartner"),
    HAS_PERSONNEL("hasPersonnel"),
    HAS_SCP("hasSCP"),
    FIRST_TIME_BY_TURN("firstTimeTurn"),
    MY_TURN("myTurn");

    private String name;

    TermKind(String name) {
        this.name = name;
    }

    public static TermKind getByName(String name) {
        return Arrays.stream(TermKind.values())
                .filter(data -> data.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getName() {
        return name;
    }
}
