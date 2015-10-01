package euler.euler22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Admin on 18.08.14.
 */
public class NamesScores {

    public static void main(String[] args) {
        NamesScores ns = new NamesScores();
        System.out.println(ns.namesScores(ns.inic()));
    }

    public long namesScores(String text) {
        long scores = 0;
        String[] list = text.split(",");

        Arrays.sort(list);

        System.out.println();
        for (int i = 0; i < list.length; i++) {
            long sumChar = 0;
            for (int j = 1; j < list[i].length() - 1; j++) {
                sumChar += (list[i].codePointAt(j) - 64);
            }
            scores += sumChar * (i + 1);
        }
        return scores;
    }

    public String inic() {
        String txt = "";
        StringBuilder text = new StringBuilder();
        try {
            Scanner scan = new Scanner(new File("/home/dreaminteam/IdeaProjects/HelloIdea/src/euler/euler22/p022_names.txt"));
            if (scan.hasNextLine()) {
                text.append(scan.nextLine());
            }
        } catch (FileNotFoundException e) {

            System.out.println(e.getMessage());
            System.exit(0);
        }
        txt += text;
        return txt;
    }
}
