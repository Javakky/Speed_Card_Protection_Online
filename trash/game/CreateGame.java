package scptcg.game;

import scptcg.json.Deck;

public class CreateGame {
    final static String[][] deck = {
            {"SCP-004-JP 矛盾無き電卓",
                    "SCP-006 若さの泉",
                    "SCP-1057 サメの不在",
                    "SCP-1850 和名：ソッピースオオタカ",
                    "SCP-2008 ラムジェットエンジン・ウシ",
                    "SCP-1129-JP フライング・アヒージョ",
                    "SCP-846 ロボ男"},
            {"SCP-828 Qallupilluk",
                    "SCP-823 恐怖のお祭り",
                    "SCP-403-JP 追い炊き込みご飯風呂",
                    "SCP-240-JP 0匹のイナゴ"},
            {"SCP-076 “アベル“",
                    "SCP-938-JP たからばこ"},
            {"泣いて馬謖を斬る",
                    "アルト・クレフ、あるいはエージェント・ウクレレ、あるいはヤハウェの子アダム、あるいは堕ちた者たちの頭"},
            {"河上　涼"}
    };

    public static Game create(String name1, String[][] deck1, String name2) {
        return new Game(new String[][][]{deck1, deck}, name1, name2);
    }

    public static Game create(String name1, Deck deck1, String name2) {
        return new Game(new String[][][]{deckToString(deck1), deck}, name1, name2);
    }

    public static Game create(String name1, String name2) {
        return new Game(new String[][][]{deck, deck}, name1, name2);
    }

    public static Game create(String name1, String name2, String[][] deck2) {
        return new Game(new String[][][]{deck, deck2}, name1, name2);
    }

    public static Game create(String name1, String name2, Deck deck2) {
        return new Game(new String[][][]{deck, deckToString(deck2)}, name1, name2);
    }

    public static Game create(String name1, String[][] deck1, String name2, String[][] deck2) {
        return new Game(new String[][][]{deck1, deck2}, name1, name2);
    }

    public static Game create(String name1, Deck deck1, String name2, Deck deck2) {
        return new Game(new String[][][]{deckToString(deck1), deckToString(deck2)}, name1, name2);
    }

    public static String[][] deckToString(final Deck deck) {
        return new String[][]{
                deck.Safe,
                deck.Euclid,
                deck.Keter,
                deck.Tale,
                deck.Personnel,
                deck.Anomalous,
                deck.Exclusion
        };
    }
}
