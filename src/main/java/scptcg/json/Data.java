package scptcg.json;

import com.google.gson.Gson;
import scptcg.game.IResult;

public class Data implements IResult {
    public String PlayerName;
    public String Event;
    public String[] Type;
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
    public String[] After;
    public String Text;
    public boolean Continue;
    public String Status;

    public String toJson() {
        return new Gson().toJson(this);
    }
}
