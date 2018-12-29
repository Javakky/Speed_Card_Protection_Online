package test;

import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scptcg.game.CreateGame;
import scptcg.game.Game;
import scptcg.game.Place;
import scptcg.game.SandBox;
import scptcg.game.card.Card;
import scptcg.game.card.CardFactory;
import scptcg.json.Deck;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;
import static scptcg.game.Place.*;

public class BattleTest {

    private Game game = null;
    private static final String deck1 = "DeckA";
    private static final String deck2 = deck1;
    private static final String user1 = "java";
    private static final String user2 = "tip";

    @Before
    public void createGame(){
        game = CreateGame.create(user1, loadDeck(deck1), user2, loadDeck(deck2));
    }

    @Test
    public void 若さの泉_効果発動_体力最大(){
        final int effectPlayer = 0;
        final int effectSandBox = 0;
        game.selectPartner(effectPlayer, "SCP-006 若さの泉", 0);
        game.selectPartner(effectPlayer == 0 ? 1: 0,  "SCP-006 若さの泉", 0);
        game.selectEffect(effectPlayer, SITE, effectSandBox);
        game.selectedEffect(effectPlayer);
        game.activeEffects(null, null);
        assertEquals(SandBox.SAFE_PROTECTION_FORCE, game.getProtectionForceSandBox(effectPlayer, effectSandBox));
    }

    @Test
    public void 若さの泉_効果発動(){
        final int effectPlayer = 0;
        final int effectSandBox = 0;
        game.selectPartner(effectPlayer, "SCP-006 若さの泉", 0);
        game.selectPartner(effectPlayer == 0 ? 1: 0,  "SCP-006 若さの泉", 0);
        game.damage(effectPlayer, effectSandBox, 2);
        assertEquals(SandBox.SAFE_PROTECTION_FORCE - 2, game.getProtectionForceSandBox(effectPlayer, effectSandBox));
        game.selectEffect(effectPlayer, SITE, effectSandBox);
        game.selectedEffect(effectPlayer);
        game.activeEffects(null, null)[0].toString();
        assertEquals(SandBox.SAFE_PROTECTION_FORCE - 1, game.getProtectionForceSandBox(effectPlayer, effectSandBox));
    }

    @After
    public void fin(){
        game = null;
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
