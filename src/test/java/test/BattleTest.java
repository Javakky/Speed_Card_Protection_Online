package test;

import com.google.gson.Gson;
import scptcg.game.CreateGame;
import scptcg.game.Game;
import scptcg.game.card.Card;
import scptcg.game.card.CardFactory;
import scptcg.json.Deck;

import java.io.IOException;
import java.util.Scanner;

public class BattleTest {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Game game = CreateGame.create("java", loadDeck("DeckA"), "tip", loadDeck("DeckA"));
        game.selectPartner(0, s.nextLine(), s.nextInt());
        game.selectPartner(1,  s.nextLine(), s.nextInt());
        System.out.println("finish");
    }

    private static Deck loadDeck(String fileName){

        StringBuilder sb = new StringBuilder();

        try (Scanner s = new Scanner(
                CardFactory.class
                        .getResource("/" + fileName + ".json")
                        .openStream())) {

            while (s.hasNextLine()) {
                sb.append(s.nextLine());
            }

            return (new Gson()).fromJson(sb.toString(), Deck.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Deck();
    }
}
