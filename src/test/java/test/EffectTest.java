package test;

import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scptcg.game.Game;
import scptcg.game.SandBox;
import scptcg.game.Zone;
import scptcg.game.card.Card;
import scptcg.game.card.CardFactory;
import scptcg.game.card.Scp;
import scptcg.game.effect.Result;
import scptcg.json.Deck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;
import static scptcg.game.K_Class.*;
import static scptcg.game.Zone.*;
import static scptcg.game.card.Clazz.*;

public class EffectTest {

    private Game game = null;
    private static final String deck1 = "DeckA";
    private static final String deck2 = deck1;
    private static final String user1 = "java";
    private static final String user2 = "tip";

    @Before
    public void createGame() {
        game = new Game(user1, loadDeck(deck1), user2, loadDeck(deck2));
    }

    /*
        @Test
        public void 不死身の爬虫類() {
            final boolean effectPlayer = true;
            game.breach(effectPlayer, "SCP-682 不死身の爬虫類", Keter, 0);
            List<Result> results = new ArrayList<>();
            game.activeEffect(null, results);
            Result res = results.get(0);
            game.damage(res.getObjectPlayer(), Safe, res.getPoint(), new ArrayList<>());
            game.damage(res.getObjectPlayer(), Euclid, res.getPoint(), new ArrayList<>());
            results = new ArrayList<>();
            game.activeEffect(null, results);
            res = results.get(0);
            game.damage(res.getObjectPlayer(), Safe, res.getPoint(), new ArrayList<>());
            game.damage(res.getObjectPlayer(), Euclid, res.getPoint(), new ArrayList<>());
            assertEquals(SandBox.SAFE_CARD_NUMBER - 1, game.getRemainSandBox(effectPlayer, Safe));
            assertEquals(SandBox.EUCLID_CARD_NUMBER - 1, game.getRemainSandBox(effectPlayer, Euclid));
            assertEquals(SandBox.SAFE_CARD_NUMBER - 1, game.getRemainSandBox(effectPlayer, Safe));
            assertEquals(SandBox.EUCLID_CARD_NUMBER - 1, game.getRemainSandBox(effectPlayer, Euclid));
        }
    */
    @Test
    public void アルトクレフ略() {
        final boolean effectPlayer = true;
        List<Result> results = new ArrayList<>();
        game.selectEffect(effectPlayer, Tales, 0, 0);
        game.activeEffect(null, results);
        Result res = results.get(0);
        game.decommission(effectPlayer, PersonnelFile, 0);
        results = new ArrayList<>();
        game.activeEffect(null, results);
        assertTrue(game.isK());
        assertEquals(game.getScenario(), IK);
    }

    @Test
    public void サメの不在() {
        final boolean effectPlayer = true;
        game.breachPartner(effectPlayer, "SCP-1057 サメの不在", 0);
        game.selectEffect(effectPlayer, Site, 0, 0);
        List<Result> results = new ArrayList<>();
        game.activeEffect(null, results);
        Result res = results.get(0);
        game.damage(!res.getSubjectPlayer(), Safe, res.getPoint(), new ArrayList<>());
        assertEquals(SandBox.SAFE_PROTECTION_FORCE - 3, game.getSandBoxProtection(!effectPlayer)[0]);
        game.activeEffect(null, results);
    }


    @Test
    public void 暴走取締車() {
        final boolean effectPlayer = false;
        game.breach(!effectPlayer, "SCP-010-J Keterクラスオブジェクトなんて存在しない。いいね？", Safe, 0);
        game.crossTest(!effectPlayer, 0, Safe, new ArrayList<>());
        game.breach(effectPlayer, "SCP-541-JP-GOI 暴走取締車", Euclid, 0);
        List<Result> results = new ArrayList<>();
        game.activeEffect(null, results);
        Result res = results.get(0);
        assertTrue(res.getCoordinate()[1].length > 0);
        game.decommission(!effectPlayer, Zone.valueOf(res.getTargetZone()), res.getCoordinate()[1][0]);
        Card tmp = game.getCard(!effectPlayer, Zone.Decommissioned, 0);
        assertNotNull(tmp);
        assertEquals(tmp.getName(), "SCP-010-J Keterクラスオブジェクトなんて存在しない。いいね？");
        game.activeEffect(null, results);
    }

    @Test
    public void アベル_召喚時() {
        final boolean effectPlayer = true;
        game.breach(!effectPlayer, "SCP-1057 サメの不在", Safe, 0);
        game.breach(effectPlayer, "SCP-076 “アベル“", Keter, 0);
        List<Result> results = new ArrayList<>();
        game.activeEffect(null, results);
        Result res = results.get(0);
        assertTrue(res.getCoordinate()[1].length > 0);
        game.decommission(!effectPlayer, Zone.valueOf(res.getTargetZone()), 0);
        Card tmp = game.getCard(!effectPlayer, Zone.Decommissioned, 0);
        assertNotNull(tmp);
        assertEquals(tmp.getName(), "SCP-1057 サメの不在");
        game.activeEffect(null, results);
    }

    @Test
    public void アベル_自己参照() {
        final boolean effectPlayer = true;
        game.breach(effectPlayer, "SCP-1057 サメの不在", Safe, 0);
        game.breach(effectPlayer, "SCP-076 “アベル“", Keter, 1);
        List<Result> results = new ArrayList<>();
        game.activeEffect(null, results);
        Result res = results.get(0);
        assertTrue(res.getCoordinate()[0].length > 1);
        game.decommission(effectPlayer, Zone.valueOf(res.getTargetZone()), 1);
        Card tmp = game.getCard(effectPlayer, Zone.Decommissioned, 0);
        assertNotNull(tmp);
        assertEquals(tmp.getName(), "SCP-076 “アベル“");
        results = new ArrayList<>();
        game.activeEffect(null, null);
        game.activeEffect(null, results);
        assertNull(game.find(effectPlayer, Decommissioned, "SCP-076 “アベル“"));
        assertNotNull(game.find(effectPlayer, KeterSandbox, "SCP-076 “アベル“"));
    }

    @Test
    public void 若さの泉() {
        final boolean effectPlayer = true;
        game.breachPartner(effectPlayer, "SCP-006 若さの泉", 0);
        game.damage(effectPlayer, Safe, 2, new ArrayList<>());
        assertEquals(SandBox.SAFE_PROTECTION_FORCE - 2, game.getSandBoxProtection(effectPlayer)[0]);
        game.selectEffect(effectPlayer, Site, 0, 0);
        List<Result> results = new ArrayList<>();
        game.activeEffect(null, results);
        Result res = results.get(0);
        game.healSandBox(res.getTargetPlayer(), Safe, res.getPoint());
        assertEquals(SandBox.SAFE_PROTECTION_FORCE - 1, game.getSandBoxProtection(effectPlayer)[0]);
        game.activeEffect(null, results);
    }

    @Test
    public void 追い炊き込みご飯風呂() {
        final boolean effectPlayer = true;
        game.breach(effectPlayer, "SCP-403-JP 追い炊き込みご飯風呂", Euclid, 0);
        game.damage(effectPlayer, Keter, 4, new ArrayList<>());
        assertEquals(SandBox.KETER_PROTECTION_FORCE - 4, game.getSandBoxProtection(effectPlayer)[2]);
        game.selectEffect(effectPlayer, Site, 0, 0);
        List<Result> results = new ArrayList<>();
        game.activeEffect(null, results);
        Result res = results.get(0);
        Card tmp = game.getCard(effectPlayer, Zone.Decommissioned, 0);
        assertNotNull(tmp);
        assertEquals(tmp.getName(), "Dクラス職員");
        results = new ArrayList<>();
        game.activeEffect(null, results);
        res = results.get(0);
        game.healSandBox(res.getTargetPlayer(), Keter, res.getPoint());
        assertEquals(SandBox.KETER_PROTECTION_FORCE - 1, game.getSandBoxProtection(effectPlayer)[2]);
        game.activeEffect(null, results);
    }

    @Test
    public void フライング_アヒージョ() {
        final boolean effectPlayer = true;
        game.breach(effectPlayer, "SCP-1129-JP フライング・アヒージョ", Safe, 0);
        game.damage(effectPlayer, Keter, 6, new ArrayList<>());
        assertEquals(SandBox.KETER_PROTECTION_FORCE - 6, game.getSandBoxProtection(effectPlayer)[2]);
        game.selectEffect(effectPlayer, Site, 0, 0);
        List<Result> results = new ArrayList<>();
        game.activeEffect(null, results);
        game.activeEffect(null, results);
        Result res = results.get(1);
        game.healSandBox(res.getTargetPlayer(), Keter, res.getPoint());
        Card tmp = game.getCard(effectPlayer, Zone.Decommissioned, 0);
        assertNotNull(tmp);
        assertEquals(tmp.getName(), "SCP-1129-JP フライング・アヒージョ");
        assertEquals(SandBox.KETER_PROTECTION_FORCE - 1, game.getSandBoxProtection(effectPlayer)[2]);
        game.activeEffect(null, results);
    }

    @Test
    public void 生乾きのタオル() {
        final boolean effectPlayer = true;
        game.breach(effectPlayer, "SCP-1129-JP フライング・アヒージョ", Safe, 0);
        game.breach(effectPlayer, "SCP-1198-JP　生乾きのタオル", Safe, 1);
        game.breach(!effectPlayer, "SCP-1129-JP フライング・アヒージョ", Safe, 0);
        List<Result> results = new ArrayList<>();
        game.activeEffect(null, results);
        game.activeEffect(null, results);
        assertTrue(((Scp) game.find(effectPlayer, Site, "SCP-1129-JP フライング・アヒージョ")).getTag().contains("液体"));
        assertTrue(((Scp) game.find(!effectPlayer, Site, "SCP-1129-JP フライング・アヒージョ")).getTag().contains("液体"));
    }

    @Test
    public void _0匹のイナゴ() {
        final boolean effectPlayer = true;
        game.breach(effectPlayer, "SCP-240-JP 0匹のイナゴ", Euclid, 0);
        List<Result> results = new ArrayList<>();
        game.activeEffect(null, results);
        game.activeEffect(null, results);
        Card tmp = game.getCard(effectPlayer, Zone.Decommissioned, 0);
        assertNotNull(tmp);
        assertEquals(tmp.getName(), "SCP-240-JP 0匹のイナゴ");
    }


    @After
    public void fin() {
        assertFalse(game.isChainSolving());
        game = null;
    }

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
}