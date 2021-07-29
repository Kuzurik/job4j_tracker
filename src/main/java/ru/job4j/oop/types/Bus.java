package ru.job4j.oop.types;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("I start moving along the road");
    }
}
