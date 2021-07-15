package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public void drive() {
        System.out.println("I started driving");
    }

    @Override
    public void passengers(int amount) {
        int full = 20;
        if (amount >= full) {
            drive();
        }
    }

    @Override
    public double getPatrol(int amount) {
        double cost = 2.01;
        return amount * cost;
    }
}
