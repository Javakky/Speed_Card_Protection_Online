package scptcg.game.card;

public enum CardCategory {
    SCP(Scp.class),
    Anomalous(Anomalous.class),
    Personnel(Personnel.class),
    Incident(Incident.class),
    Tale(Tale.class),
    Canon(Canon.class);

    private Class<? extends Card> clazz;

    CardCategory(Class<? extends Card> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends Card> toClass() {
        return clazz;
    }
}
