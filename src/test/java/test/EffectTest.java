package test;

import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scptcg.game.CreateGame;
import scptcg.game.Game;
import scptcg.game.Place;
import scptcg.game.SandBox;
import scptcg.game.card.CardFactory;
import scptcg.game.card.Scp;
import scptcg.game.effect.Result;
import scptcg.json.Deck;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static scptcg.game.Place.*;
import static scptcg.game.card.ObjectClassKind.*;

public class EffectTest {

    private Game game = null;
    private static final String deck1 = "DeckA";
    private static final String deck2 = deck1;
    private static final String user1 = "java";
    private static final String user2 = "tip";

    @Before
    public void createGame() {
        game = CreateGame.create(user1, loadDeck(deck1), user2, loadDeck(deck2));
    }

    @Test
    public void 不死身の爬虫類() {
        final int effectPlayer = 0;
        final int effectSandBox = 0;
        game.breach(effectPlayer, KETER, "SCP-682 不死身の爬虫類", 0);
        Result res = game.activeEffects(null, null)[0];
        game.damage(res.getResInt()[1] == 0 ? 1 : 0, effectSandBox, res.getResInt()[0]);
        res = game.activeEffects(null, null)[0];
        game.damage(res.getResInt()[1], effectSandBox, res.getResInt()[0]);
        game.damage(res.getResInt()[1], effectSandBox + 1, res.getResInt()[0]);
        game.damage(res.getResInt()[1] == 0 ? 1 : 0, effectSandBox, res.getResInt()[0]);
        game.damage(res.getResInt()[1] == 0 ? 1 : 0, effectSandBox + 1, res.getResInt()[0]);
        assertEquals(SandBox.SAFE_CARD_NUMBER - 1, game.getCardNumberSandBox(effectPlayer, effectSandBox));
        assertEquals(SandBox.EUCLID_CARD_NUMBER - 1, game.getCardNumberSandBox(effectPlayer, effectSandBox + 1));
        assertEquals(SandBox.SAFE_CARD_NUMBER - 1, game.getCardNumberSandBox(effectPlayer == 0 ? 1: 0, effectSandBox));
        assertEquals(SandBox.EUCLID_CARD_NUMBER - 1, game.getCardNumberSandBox(effectPlayer == 0 ? 1: 0, effectSandBox + 1));
    }

    @Test
    public void アルトクレフ略() {
        final int effectPlayer = 0;
        game.selectEffect(effectPlayer, TALES, 0);
        game.selectedEffect(effectPlayer);
        Result res = game.activeEffects(null, null)[0];
        game.decommission(effectPlayer, PERSONNEL_FILE, 0);
        game.activeEffects(null, null);
        assertNotNull(game.isK_ClassScenario());
    }

    @Test
    public void サメの不在() {
        final int effectPlayer = 0;
        final int effectSandBox = 0;
        game.selectPartner(effectPlayer, "SCP-1057 サメの不在", 0);
        game.selectEffect(effectPlayer, SITE, 0);
        game.selectedEffect(effectPlayer);
        Result res = game.activeEffects(null, null)[0];
        game.damage(res.getResInt()[1] == 0 ? 1 : 0, effectSandBox, res.getResInt()[0]);
        assertEquals(SandBox.SAFE_PROTECTION_FORCE - 3, game.getProtectionForceSandBox(effectPlayer, effectSandBox));
    }


    @Test
    public void 暴走取締車_1() {
        final int effectPlayer = 0;
        game.breach(0, SAFE, "SCP-004-JP 矛盾無き電卓", 0);
        game.crossTest(0, 0, 0);
        game.breach(1, EUCLID, "SCP-541-JP-GOI 暴走取締車", 1);
        Result res = game.activeEffects(null, null)[0];
        game.decommission(0, Place.create(res.getResStr()[1]), 0);
        assertThat(asList(toObject(game.getEmptySite(0))), hasItem(0));
    }

    @Test
    public void 暴走取締車_2() {
        final int effectPlayer = 0;
        game.breach(0, SAFE, "SCP-004-JP 矛盾無き電卓", 0);
        game.crossTest(0, 0, 0);
        game.breach(0, EUCLID, "SCP-541-JP-GOI 暴走取締車", 1);
        Result res = game.activeEffects(null, null)[0];
        game.decommission(parseInt(res.getResStr()[2]), Place.create(res.getResStr()[1]), 0);
        assertThat(asList(toObject(game.getEmptySite(0))), hasItem(0));
    }


    @Test
    public void アベル_召喚時() {
        final int effectPlayer = 0;
        game.breach(0, SAFE, "SCP-1057 サメの不在", 0);
        game.breach(0, KETER, "SCP-076 “アベル“", 1);
        Result res = game.activeEffects(null, null)[0];
        game.decommission(parseInt(res.getResStr()[2]), Place.create(res.getResStr()[1]), 0);
        assertThat(asList(toObject(game.getEmptySite(0))), hasItem(0));
    }


    @Test
    public void アベル_破壊時() {
        final int effectPlayer = 0;
        game.breach(0, SAFE, "SCP-1057 サメの不在", 0);
        game.breach(0, KETER, "SCP-076 “アベル“", 1);
        Result res = game.activeEffects(null, null)[0];
        game.decommission(parseInt(res.getResStr()[2]), Place.create(res.getResStr()[1]), 0);
        assertThat(asList(toObject(game.getEmptySite(0))), hasItem(0));
        game.decommission(0, SITE, 1);
        game.activeEffects(null, null);
        assertThat(asList(game.getDecommissioned(0)), not(hasItem("SCP-076 “アベル“")));
        assertThat(asList(game.getMyDeckList(0, 2)), hasItem("SCP-076 “アベル“"));
    }

    @Test
    public void アベル_自己参照() {
        final int effectPlayer = 0;
        game.breach(0, KETER, "SCP-076 “アベル“", 0);
        Result res = game.activeEffects(null, null)[0];
        game.decommission(parseInt(res.getResStr()[2]), Place.create(res.getResStr()[1]), 0);
        assertThat(asList(toObject(game.getEmptySite(0))), hasItem(0));
        game.activeEffects(null, null);
        assertThat(asList(game.getDecommissioned(0)), not(hasItem("SCP-076 “アベル“")));
        assertThat(asList(game.getMyDeckList(0, 2)), hasItem("SCP-076 “アベル“"));
    }

    @Test
    public void 若さの泉() {
        final int effectPlayer = 0;
        final int effectSandBox = 0;
        game.selectPartner(effectPlayer, "SCP-006 若さの泉", 0);
        game.damage(effectPlayer, effectSandBox, 2);
        assertEquals(SandBox.SAFE_PROTECTION_FORCE - 2, game.getProtectionForceSandBox(effectPlayer, effectSandBox));
        game.selectEffect(effectPlayer, SITE, 0);
        game.selectedEffect(effectPlayer);
        Result res = game.activeEffects(null, null)[0];
        game.healSandBox(res.getResInt()[1], effectSandBox, res.getResInt()[0]);
        assertEquals(SandBox.SAFE_PROTECTION_FORCE - 1, game.getProtectionForceSandBox(effectPlayer, effectSandBox));
    }

    @Test
    public void 追い炊き込みご飯風呂() {
        final int effectPlayer = 0;
        final int effectSandBox = 2;
        game.breach(effectPlayer, EUCLID, "SCP-403-JP 追い炊き込みご飯風呂", 0);
        game.damage(effectPlayer, effectSandBox, 4);
        assertEquals(SandBox.KETER_PROTECTION_FORCE - 4, game.getProtectionForceSandBox(effectPlayer, effectSandBox));
        game.selectEffect(effectPlayer, SITE, 0);
        game.selectedEffect(effectPlayer);
        Result res = game.activeEffects(null, null)[1];
        game.healSandBox(res.getResInt()[1], effectSandBox, res.getResInt()[0]);
        assertEquals(SandBox.KETER_PROTECTION_FORCE - 1, game.getProtectionForceSandBox(effectPlayer, effectSandBox));
    }

    @Test
    public void フライング_アヒージョ() {
        final int effectPlayer = 0;
        final int effectSandBox = 2;
        game.breach(effectPlayer, SAFE, "SCP-1129-JP フライング・アヒージョ", 0);
        game.damage(effectPlayer, effectSandBox, 6);
        assertEquals(SandBox.KETER_PROTECTION_FORCE - 6, game.getProtectionForceSandBox(effectPlayer, effectSandBox));
        game.selectEffect(effectPlayer, SITE, 0);
        game.selectedEffect(effectPlayer);
        Result res = game.activeEffects(null, null)[1];
        game.healSandBox(res.getResInt()[1], effectSandBox, res.getResInt()[0]);
        assertThat(asList(game.getDecommissioned(0)), hasItem("SCP-1129-JP フライング・アヒージョ"));
        assertEquals(SandBox.KETER_PROTECTION_FORCE - 1, game.getProtectionForceSandBox(effectPlayer, effectSandBox));
    }

    @Test
    public void 生乾きのタオル() {
        final int effectPlayer = 0;
        final int effectSandBox = 2;
        game.breach(effectPlayer, SAFE, "SCP-1129-JP フライング・アヒージョ", 0);
        game.breach(effectPlayer == 0 ? 1: 0, SAFE, "SCP-1129-JP フライング・アヒージョ", 0);
        game.breach(effectPlayer, SAFE, "SCP-1198-JP　生乾きのタオル", 1);
        game.activeEffects(null, null);
        assertThat(((Scp)game.getCard(0, "SCP-1129-JP フライング・アヒージョ")).getTags(), hasItem("液体"));
        assertThat(((Scp)game.getCard(1, "SCP-1129-JP フライング・アヒージョ")).getTags(), hasItem("液体"));
        assertThat(((Scp)game.getCard(0, "SCP-1198-JP　生乾きのタオル")).getTags(), hasItem("液体"));
    }

    @Test
    public void _0匹のイナゴ() {
        final int effectPlayer = 0;
        game.breach(effectPlayer, EUCLID, "SCP-240-JP 0匹のイナゴ", 0);
        game.activeEffects(null, null);
        assertThat(asList(game.getDecommissioned(0)), hasItem("SCP-240-JP 0匹のイナゴ"));
    }

    @After
    public void fin() {
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
