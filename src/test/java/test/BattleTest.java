package test;

import com.google.gson.Gson;
import scptcg.game.CreateGame;
import scptcg.game.Game;
import scptcg.game.card.Card;
import scptcg.game.card.CardFactory;

import java.util.Scanner;

public class BattleTest {
    public static void main(String[] args){
        Game game = CreateGame.create("java", loadDeck("DeckA.json"), "tip", loadDeck("DeckA.json"));
    }

    private static String[][] loadDeck(String fileName){
        StringBuilder sb = new StringBuilder();

        Scanner s =
                new Scanner(
                        CardFactory.class.getResource(
                                "/" + path + "/" + name + ".json"
                        ).openStream());

        while (s.hasNextLine()) {
            sb.append(s.nextLine());
        }
        s.close();

        Card tmp = (new Gson()).fromJson(sb.toString(), clazz);

        return null;
    }
}
