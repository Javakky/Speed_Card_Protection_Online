package scptcg.game.card.impl.scp;

import scptcg.annotation.Card;
import scptcg.game.card.Clazz;
import scptcg.game.card.Scp;
import scptcg.game.effect.Effects;

@Card("SCP-004-JP 矛盾無き電卓")
@scptcg.annotation.Scp(cost = 1, secure = 3, clazz = Clazz.Safe,
        tag = {"scp-jp", "数学", "未来予知", "道具", "電子デバイス"})
public class SCP_004_JP extends Scp {

    @Override
    protected void initializeEffects() {
        setEffects(new Effects());
    }
}
