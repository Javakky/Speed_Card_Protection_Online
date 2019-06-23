package scptcg.game.card;

import com.google.gson.Gson;
import scptcg.game.CardHolder;
import scptcg.game.effect.Effect;

import java.io.IOException;
import java.util.Scanner;

public class CardFactory {

    public static Card create(CardHolder parent, String name, CardKind kind)
            throws NullPointerException {
        Card tmp = null;
        Class clazz;
        try {
            switch (kind) {
                case ANOMALOUS:
                    clazz = Anomalous.class;
                    break;
                case SCP:
                    clazz = Scp.class;
                    break;
                case CANON:
                    clazz = Canon.class;
                    break;
                case INCIDENT:
                    clazz = Incident.class;
                    break;
                case PERSONNEL:
                    clazz = Personnel.class;
                    break;
                case TALE:
                    clazz = Tale.class;
                    break;
                default:
                    clazz = Card.class;
                    break;
            }
            tmp = create(kind.getType(), name, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (tmp == null) {
            throw new NullPointerException(name + " is null");
        }

        tmp.setParent(parent);
        tmp.setEffectList();

        for (Effect e : tmp.getEffect()) {
            e.setParent(tmp);
        }

        return tmp;
    }

    private static Card create(String path, String name, Class<? extends Card> clazz) throws IOException {
        StringBuilder sb = new StringBuilder();
        Scanner s = null;
        try {
            s =
                    new Scanner(
                            CardFactory.class.getResource(
                                    "/" + path + "/" + name + ".json"
                            ).openStream());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("/" + path + "/" + name);
        }

        while (s.hasNextLine()) {
            sb.append(s.nextLine());
        }
        s.close();

        Card tmp = (new Gson()).fromJson(sb.toString(), clazz);

        if (tmp == null) {
            throw new RuntimeException("cannot read card");
        }

        return tmp;
    }
}