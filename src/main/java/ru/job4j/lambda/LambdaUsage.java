package ru.job4j.lambda;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };
        List<String> array = asList("one", "two", "three", "four");
        System.out.println(array);
        array.sort(cmpDescSize);
        System.out.println(array);
    }
}
