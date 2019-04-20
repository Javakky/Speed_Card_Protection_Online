package scptcg.json;

import com.google.gson.Gson;
import lombok.ToString;

@ToString
public class Data {
    public String PlayerName;
    public String Event;
    public String DeckName;
    public String[] CardName;
    public int[][] Coordinate;
    public int SandBox;
    public String[] Zone;
    public boolean Player;
    public int Index;
    public int[] Order;
    public int ObjectClass;
    public int Count;
    public boolean BeAbleTo;
    public String Scenario;
    public int Secure;
    public int Cost;
    public int[] Point;

    public String toJson() {
        return new Gson().toJson(this);
    }
}
