package test;

import com.google.gson.Gson;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scptcg.game.Game;
import scptcg.game.Zone;
import scptcg.game.card.Card;
import scptcg.game.card.CardFactory;
import scptcg.game.card.Clazz;
import scptcg.game.card.Scp;
import scptcg.json.Deck;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PlayTest {

    private static final String deck1 = "DeckA";
    private static final String deck2 = deck1;
    private static final String user1 = "java";
    private static final String user2 = "tip";
    private Game game = null;

    private static Deck loadDeck(String fileName) {
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

    @Before
    public void createGame() {
        game = new Game(user1, loadDeck(deck1), user2, loadDeck(deck2));
    }

    @Test
    public void breachPartner() {
        Card[] partners = game.getPartnerables(true);
        assertNotNull(partners);
        game.breachPartner(true, "SCP-010-J Keterクラスオブジェクトなんて存在しない。いいね？", 0);
        Card tmp = game.getCard(true, Zone.Site, 0);
        assertNotNull(tmp);
        assertEquals(tmp.getName(), "SCP-010-J Keterクラスオブジェクトなんて存在しない。いいね？");
    }

    @Test
    public void breach() {
        game.breach(true, "SCP-010-J Keterクラスオブジェクトなんて存在しない。いいね？", Clazz.Safe, 0);
        Card tmp = game.getCard(true, Zone.Site, 0);
        assertNotNull(tmp);
        assertEquals(tmp.getName(), "SCP-010-J Keterクラスオブジェクトなんて存在しない。いいね？");
    }

    @Test
    public void decommission() {
        breach();
        game.decommission(true, Zone.Site, 0);
        Card tmp = game.getCard(true, Zone.Decommissioned, 0);
        assertNotNull(tmp);
        assertEquals(tmp.getName(), "SCP-010-J Keterクラスオブジェクトなんて存在しない。いいね？");
    }

    @Test
    public void reContainment() {
        decommission();
        Scp tmp = (Scp) game.getCard(true, Zone.Decommissioned, 0);
        game.reContainment(true, tmp, null);
        Card[] list = game.getCards(true, Zone.SafeSandbox);
        assertTrue(ArrayUtils.contains(list, tmp));
    }

    @After
    public void fin() {
        game = null;
    }
}
