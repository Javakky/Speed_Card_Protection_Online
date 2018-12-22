package scptcg.json;

import java.util.Arrays;

public class Data {
    public String[] name;
    public String player;
    public int[] place;
    public String event;
    public int isFirst;
    public int ObjectClass;
    public String effect;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("receive = [\tplayer:")
                .append(player)
                .append("\n\tevent:")
                .append(event)
                .append("\n\tisFirst:")
                .append(isFirst)
                .append("\n\tname:")
                .append(Arrays.toString(name))
                .append("\n\tplace:")
                .append(Arrays.toString(place))
                .append("\n]");
        return sb.toString();
    }
}
