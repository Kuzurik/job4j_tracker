package ru.job4j.collection;

import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        List<String> left = List.of(o1.split("/"));
        List<String> right = List.of(o2.split("/"));
        int comp = right.get(0).compareTo(left.get(0));
        if (comp == 0) {
            for (int i = 1; i < Math.min(left.size(), right.size()); i++) {
                comp = left.get(0).compareTo(right.get(0));
                if (comp != 0) {
                    return comp;
                }
            }
        } else {
            return comp;
        }
        return Integer.compare(left.size(), right.size());
    }
}
