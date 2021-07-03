package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchange(Battery another) {
       another.load = another.load + this.load;
       this.load = 0;

    }


    public static void main(String[] args) {
        Battery battery = new Battery(5);
        Battery battery1 = new Battery(7);
        System.out.println(battery.load + " " + battery1.load);
        battery1.exchange(battery);
        System.out.println(battery.load + " " + battery1.load);
    }
}
