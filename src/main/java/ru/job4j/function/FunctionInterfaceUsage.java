package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {

    public static void main(String[] args) {
        Supplier<String> sup = () -> "New String For Interface";
        Supplier<String> supTwo = () -> " and Second String";
        BiConsumer<String, String> consumer = (s, s1) -> System.out.println(s + s1);
        consumer.accept(sup.get(), supTwo.get());

        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supTree = () -> new HashSet<>(list);
        BiConsumer<Integer, String> consumerTwo = (s, s1) -> System.out.println(s + s1);
        Set<String> strings = supTree.get();
        int i = 1;
        for (String s : strings) {
            consumerTwo.accept(i++, " is " + s);
        }

        BiPredicate<String, Integer> cond = (s, j) -> s.contains(j.toString());
        System.out.println("Строка содержит подстроку: " + cond.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + cond.test("Name", 123));
    }
}
