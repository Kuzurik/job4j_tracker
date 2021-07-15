package ru.job4j.oop.types;

public class Train implements Vehicle{
    @Override
    public void move() {
        System.out.println("I'm moving on rails");
    }
}
