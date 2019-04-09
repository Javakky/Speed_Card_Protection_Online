package scptcg.game;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import scptcg.game.card.Card;
import scptcg.game.card.Scp;
import scptcg.game.effect.Result;
import scptcg.json.Data;
import scptcg.json.Deck;
import type.Union;

import java.io.IOException;

import static scptcg.game.Place.*;

public final class GM {

    private Game game = null;

    public GM(String p1_name, Deck p1_deck, String p2_name, Deck p2_deck) {
        game = (CreateGame.create(p1_name, p1_deck, p2_name, p2_deck));
    }

    public Union MainProcess(Data data) throws IOException {
        switch (data.event) {
            case "selectPartner":
                return new Union<Scp>(game.selectPartner(data.isFirst, data.name[0], data.place[0]));

            case "crossTest":
            case "damage":
                Pair<Integer, Scp> result;
                int player;
                if (data.event.equals("damage")) {
                    result = game.damage(data.isFirst, data.place[0], Integer.parseInt(data.name[0]));
                    player = data.isFirst;
                } else {
                    result = game.crossTest(data.isFirst, data.place[0], data.place[1]);
                    player = data.isFirst == 0 ? 1 : 0;
                }
                return new Union<Triple<Integer, Integer, Scp>>(Triple.of(player, result.getKey(), result.getValue()));

            case "breach":
                return new Union<Scp>(game.breach(data.isFirst, data.place[0]));

            case "turnEnd":
                game.nextTurn();
                return new Union<Object>(new Object());

            case "getEffect":
                int len = 0;
                switch (data.name[0]) {
                    case "PersonnelFile":
                        len = game.personnelEffectNumber(data.isFirst);
                        break;
                    case "Tales":
                        len = game.taleEffectNumber(data.isFirst, data.place[0]);
                        break;
                    case "Site":
                        len = game.siteEffectNumber(data.isFirst, data.place[0]);
                }
                return new Union<Integer>(len);

            case "activeEffect":
                boolean canSelect = game.selectedEffect(data.place[0]);

                return new Union<Boolean>(canSelect);

            case "decommission":
                return new Union<Card>(game.decommission(data.isFirst, create(data.name[0]), data.place[0]));

            case "HealSandBox":
                return new Union<Integer>(game.healSandBox(Integer.parseInt(data.name[1]), data.place[0], Integer.parseInt(data.name[2])));

            case "DamageSandBox":
                return new Union<Pair<Integer, Scp>>(game.damage(Integer.parseInt(data.name[1]) == 0 ? 1 : 0, data.place[0], Integer.parseInt(data.name[0])));

            case "selectEffect":
                game.sortWaitingEffects(data.place);
                return new Union<Object>(null);
            default:
                return new Union<Object>(null);
        }
    }

    public Result[] activeEffect() {
        if (!game.isOnActiveEffect() && game.hasWaitEffects()) {
            Result[] r = game.activeEffects(null, null);
            return r;
        }
        return null;
    }

    public Game getGame() {
        return this.game;
    }
}

/*
package scptcg.game;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import scptcg.game.card.Card;
import scptcg.game.card.Scp;
import scptcg.game.effect.Result;
import scptcg.json.Data;
import scptcg.json.Deck;
import type.Union;

import java.io.IOException;

import static scptcg.game.Place.*;

public final class GM {

    private Game game = null;

    public GM(String p1_name, Deck p1_deck, String p2_name, Deck p2_deck) {
        game = (CreateGame.getByName(p1_name, p1_deck, p2_name, p2_deck));
    }

    public Union MainProcess(Data data) throws IOException {
        switch (data.event) {
            case "selectPartner":
                return new Union<Scp>(game.selectPartner(data.isFirst, data.name[0], data.place[0]));

            case "crossTest":
            case "damage":
                Pair<Integer, Scp> result;
                int player;
                if (data.event.equals("damage")) {
                    result = game.damage(data.isFirst, data.place[1], Integer.parseInt(data.name[0]));
                    player = data.isFirst;
                } else {
                    result = game.crossTest(data.isFirst, data.place[0], data.place[1]);
                    player = data.isFirst == 0 ? 1 : 0;
                }
                return new Union<Triple<Integer, Integer, Scp>>(Triple.of(player, result.getKey(), result.getValue()));

            case "breach":
                return new Union<Scp>(game.breach(data.isFirst, data.place[0]));

            case "turnEnd":
                game.nextTurn();
                return new Union<Object>(null);

            case "getEffect":
                int len = 0;
                switch (data.name[0]) {
                    case "PersonnelFiles":
                        len = game.personnelEffectNumber(data.isFirst);
                        break;
                    case "Tales":
                        len = game.taleEffectNumber(data.isFirst, data.place[0]);
                        break;
                    case "Site":
                        len = game.siteEffectNumber(data.isFirst, data.place[0]);
                }
                return new Union<Integer>(len);

            case "activeEffect":
                boolean canSelect = game.selectedEffect(data.place[0]);

                return new Union<Boolean>(canSelect);

            case "decommission":
                return new Union<Card>(game.decommission(data.isFirst, getByName(data.name[0]), data.place[0]));

            case "HealSandBox":
                return new Union<Integer>(game.healSandBox(Integer.parseInt(data.name[1]), data.place[0], Integer.parseInt(data.name[2])));

            case "damageSandBox":
                return new Union<Pair<Integer, Scp>>(game.damage(Integer.parseInt(data.name[1]) == 0 ? 1 : 0, data.place[0], Integer.parseInt(data.name[0])));

            case "selectEffect":
                game.sortWaitingEffects(data.place);
                return new Union<Object>(null);
            default:
                return new Union<Object>(null);
        }
    }

    public Result[] activeEffect() {
        if (!game.isOnActiveEffect() && game.hasWaitEffects()) {
            Result[] r = game.activeEffects(null, null);
            return r;
        }
        return null;
    }

    public Game getGame() {
        return this.game;
    }
}
 */