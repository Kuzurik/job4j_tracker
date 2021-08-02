package ru.job4j.Stream;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Generate {

    public static void main(String[] args) {
        List<Card> cardDeck = new ArrayList<>();
        Stream.of(Suit.values()).flatMap(suit -> Stream.of(Value.values())
                .map(value -> new Card(suit, value)))
                .forEach(cardDeck::add);
        cardDeck.forEach(System.out::println);

    }
}
