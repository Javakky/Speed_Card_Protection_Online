package test;

import org.junit.Test;
import scptcg.game.card.CardCategory;
import scptcg.game.card.CardFactory;
import scptcg.game.card.Scp;

import static org.junit.Assert.*;

public class CardFactoryTest {
    @Test
    public void createCard() {
        String name = "SCP-004-JP 矛盾無き電卓";
        Scp card = (Scp) CardFactory.create(name, CardCategory.SCP);
        assertEquals(name, card.getName());
        assertEquals(CardCategory.SCP, card.getCategory());
        assertEquals(1, card.getCost());
        assertEquals(3, card.getSecure());
        assertTrue(card.canPartner());
        assertTrue(card.canDecommission());
        assertTrue(card.canCrossTest());
        assertEquals(1, card.getCrossTestsCount());
        assertTrue(card.getTag().contains("scp-jp"));
        assertTrue(card.getTag().contains("数学"));
        assertTrue(card.getTag().contains("未来予知"));
        assertTrue(card.getTag().contains("道具"));
        assertTrue(card.getTag().contains("電子デバイス"));
    }
}
