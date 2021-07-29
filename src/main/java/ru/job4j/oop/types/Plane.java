package ru.job4j.oop.types;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("I'm flying");
    }
}
