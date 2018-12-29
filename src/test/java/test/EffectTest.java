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
import scptcg.game.effect.Result;
import scptcg.json.Deck;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;
import static scptcg.game.Place.*;

public class EffectTest {

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
    public void 若さの泉_体力最大(){
        final int effectPlayer = 0;
        final int effectSandBox = 0;
        game.selectPartner(effectPlayer, "SCP-006 若さの泉", 0);
        game.selectEffect(effectPlayer, SITE, effectSandBox);
        game.selectedEffect(effectPlayer);
        Result res = game.activeEffects(null, null)[1];
        game.healSandBox(res.resInt[1], effectSandBox, res.resInt[0]);
        assertEquals(SandBox.SAFE_PROTECTION_FORCE, game.getProtectionForceSandBox(effectPlayer, effectSandBox));
    }

    @Test
    public void サメの不在(){
        final int effectPlayer = 0;
        final int effectSandBox = 0;
        game.selectPartner(effectPlayer, "SCP-1057 サメの不在", 0);
        game.selectEffect(effectPlayer, SITE, effectSandBox);
        game.selectedEffect(effectPlayer);
        Result res = game.activeEffects(null, null)[1];
        game.damage(res.resInt[1], effectSandBox, res.resInt[0]);
        assertEquals(SandBox.SAFE_PROTECTION_FORCE - 3, game.getProtectionForceSandBox(effectPlayer, effectSandBox));
    }

    @Test
    public void 若さの泉(){
        final int effectPlayer = 0;
        final int effectSandBox = 0;
        game.selectPartner(effectPlayer, "SCP-006 若さの泉", 0);
        game.damage(effectPlayer, effectSandBox, 2);
        assertEquals(SandBox.SAFE_PROTECTION_FORCE - 2, game.getProtectionForceSandBox(effectPlayer, effectSandBox));
        game.selectEffect(effectPlayer, SITE, effectSandBox);
        game.selectedEffect(effectPlayer);
        Result res = game.activeEffects(null, null)[1];
        game.healSandBox(res.resInt[1], effectSandBox, res.resInt[0]);
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
