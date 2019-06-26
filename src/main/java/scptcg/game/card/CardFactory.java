package scptcg.game.card;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class CardFactory {

    public static Card create(String name, CardCategory category)
            throws NullPointerException {
        Card tmp = null;
        Class clazz;
        try {
            switch (category) {
                case Anomalous:
                    clazz = Anomalous.class;
                    break;
                case SCP:
                    clazz = Scp.class;
                    break;
                case Canon:
                    clazz = Canon.class;
                    break;
                case Incident:
                    clazz = Incident.class;
                    break;
                case Personnel:
                    clazz = Personnel.class;
                    break;
                case Tale:
                    clazz = Tale.class;
                    break;
                default:
                    clazz = Card.class;
                    break;
            }
            tmp = create(category.name(), name, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (tmp == null) {
            throw new NullPointerException(name + " is null");
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