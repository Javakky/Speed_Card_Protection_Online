package scptcg.game.effect;

import java.util.Arrays;

public enum ActionKind implements IActionKind {
    DECOMMISSION("Decommission"),
    SELECT("Select"),
    ADD_TAG("addTag"),
    ADD_EFFECT("AddEffect"),
    K_CLASS("K-class"),
    BREACH("Breach"),
    RECONTAINMENT("ReContainment"),
    DAMAGE_SAND_BOX("DamageSandBox"),
    HEAL_SAND_BOX("HealSandBox"),
    MINUS_SECURE("MinusSecure"),
    RECONTAINMENT_ALL("ReContainment_All");

    private final String name;

    ActionKind(String name) {
        this.name = name;
    }

    public static ActionKind getByName(String name) {
        return Arrays.stream(ActionKind.values())
                .filter(data -> data.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public String getName() {
        return name;
    }
}
