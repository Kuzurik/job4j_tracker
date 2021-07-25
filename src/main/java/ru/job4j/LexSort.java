package ru.job4j;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        Integer lefNum = Integer.parseInt(left.split("\\.")[0]);
        Integer rightNum = Integer.parseInt(right.split("\\.")[0]);
        return lefNum.compareTo(rightNum);
    }
}
