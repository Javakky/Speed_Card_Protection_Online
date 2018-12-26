package test;

import com.google.gson.Gson;
import scptcg.game.CreateGame;
import scptcg.game.Game;
import scptcg.game.Place;
import scptcg.game.card.Card;
import scptcg.game.card.CardFactory;
import scptcg.json.Deck;

import java.io.IOException;
import java.util.Scanner;

import static scptcg.game.Place.*;

public class BattleTest {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Game game = CreateGame.create("java", loadDeck("DeckA"), "tip", loadDeck("DeckA"));
        game.selectPartner(0, "SCP-006 若さの泉", 0);
        game.selectPartner(1,  "SCP-1057 サメの不在", 0);
        game.selectEffect(0, SITE, 0);
        game.selectedEffect(0);
        game.activeEffects(null, null);
        game.crossTest(0, 0, 0);
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
