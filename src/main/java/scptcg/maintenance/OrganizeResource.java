package scptcg.maintenance;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import scptcg.game.card.Scp;
import scptcg.json.Deck;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class OrganizeResource {

    private OrganizeResource() {
    }

    public static void main(String[] args) {

        File abs = new File("./src/main/resources");
        Deck deck = new Deck();
        for (File dir : Objects.requireNonNull(abs.listFiles())) {
            if (dir.isDirectory()) {
                switch (dir.getName()) {
                    case "Personnel":
                        deck.Personnel = getFileNames(dir);
                        break;
                    case "Tale":
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
                    case "SCP":
                        List<String> keter = new LinkedList<>();
                        List<String> euclid = new LinkedList<>();
                        List<String> safe = new LinkedList<>();
                        StringBuilder sb = new StringBuilder();
                        for (File f : Objects.requireNonNull(dir.listFiles())) {
                            if (f.isFile()) {
                                try (Scanner s = new Scanner(f)) {
                                    sb.setLength(0);
                                    while (s.hasNextLine()) {
                                        sb.append(s.nextLine());
                                    }
                                    try {
                                        Scp tmp = (new Gson()).fromJson(sb.toString(), Scp.class);

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
        for (File f : Objects.requireNonNull(dir.listFiles())) {
            if (f.isFile()) list.add(getNameWithoutExtension(f));
        }
        return list.toArray(new String[0]);
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
