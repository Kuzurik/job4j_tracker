package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public void drive() {

    }

    @Override
    public void passengers(int amount) {

    }

    @Override
    public double getPatrol(int amount) {
        return amount * 2.01;
    }
}
