package scptcg.maintenance;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import scptcg.game.card.Scp;
import scptcg.json.Deck;

import java.io.*;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static scptcg.game.card.Clazz.*;

public class OrganizeResource {

    private OrganizeResource() {
    }

    public static void main(String[] args) {

        File abs = new File("./src/main/resources");
        Deck deck = new Deck();
        for (File dir : abs.listFiles()) {
            if (dir.isDirectory()) {
                switch (dir.getName()) {
                    case "trash/Personnel":
                        deck.Personnel = getFileNames(dir);
                        break;
                    case "trash/Tale":
                        deck.Tale = getFileNames(dir);
                        break;
                    case "Exclusion":
                        deck.Exclusion = getFileNames(dir);
                        break;
                    case "Incident":
                        deck.Tale = getFileNames(dir);
                        break;
                    case "Anomalous":
                        deck.Anomalous = getFileNames(dir);
                        break;
                    case "trash/SCP":
                        List<String> keter = new LinkedList<>();
                        List<String> euclid = new LinkedList<>();
                        List<String> safe = new LinkedList<>();
                        StringBuilder sb = new StringBuilder();
                        for (File f : dir.listFiles()) {
                            if (f.isFile()) {
                                try (Scanner s = new Scanner(f)) {
                                    sb.setLength(0);
                                    while (s.hasNextLine()) {
                                        sb.append(s.nextLine());
                                    }
                                    try {
                                        Scp tmp = (new Gson()).fromJson(sb.toString(), Scp.class);
                                        if (tmp.getContainmentClass() == null) {
                                            Field field = null;
                                            try {
                                                field = Scp.class.getDeclaredField("containmentClass");
                                            } catch (NoSuchFieldException | SecurityException e) {
                                                e.printStackTrace();
                                            }

                                            field.setAccessible(true);

                                            try {
                                                field.set(tmp, Unclassed.name());
                                            } catch (IllegalArgumentException | IllegalAccessException e) {
                                                e.printStackTrace();
                                            }

                                        }
                                        switch (tmp.getContainmentClass()) {
                                            case Safe:
                                                safe.add(tmp.getName());
                                                break;
                                            case Euclid:
                                                euclid.add(tmp.getName());
                                                break;
                                            case Keter:
                                                keter.add(tmp.getName());
                                                break;
                                            default:
                                                switch (tmp.getClazz()) {
                                                    case Safe:
                                                        safe.add(tmp.getName());
                                                        break;
                                                    case Euclid:
                                                        euclid.add(tmp.getName());
                                                        break;
                                                    case Keter:
                                                        keter.add(tmp.getName());
                                                        break;
                                                }
                                        }
                                    } catch (JsonSyntaxException | NullPointerException e) {
                                        e.printStackTrace();
                                        System.out.println(sb.toString());
                                    }
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        deck.Safe = safe.toArray(new String[safe.size()]);
                        deck.Euclid = euclid.toArray(new String[euclid.size()]);
                        deck.Keter = keter.toArray(new String[keter.size()]);
                }
            }
        }
        File list = new File("./src/main/resources/list.json");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(list))) {
            bw.write((new Gson()).toJson(deck, Deck.class));
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] getFileNames(final File dir) {
        List<String> list = new LinkedList<>();
        for (File f : dir.listFiles()) {
            if (f.isFile()) list.add(getNameWithoutExtension(f));
        }
        return list.toArray(new String[list.size()]);
    }

    private static String getNameWithoutExtension(File file) {
        String fileName = file.getName();
        int index = fileName.lastIndexOf('.');
        if (index != -1) {
            return fileName.substring(0, index);
        }
        return "";
    }
}
