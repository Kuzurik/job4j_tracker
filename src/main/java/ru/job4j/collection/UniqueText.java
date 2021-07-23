package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {

    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String word: origin) {
            check.add(word);
        }
        for (String word: text) {
           boolean checkWord = check.contains(word);
           if (!checkWord) {
               rsl = false;
               break;
           }
        }
        return rsl;
    }
}
