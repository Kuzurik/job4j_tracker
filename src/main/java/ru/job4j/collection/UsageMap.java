package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("alex.beltexno@gmail.com", "Alexandr Kuzura");
        map.put("dizain1252mail.ru", "Irina Kaznouskaya");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
