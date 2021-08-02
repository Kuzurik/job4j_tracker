package ru.job4j.Stream;

public class Car {

    private String name;
    private double engineVolume;
    private int cylinders;
    private String bodyType;
    private String color;
    private String fuelType;
    private int tireSize;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", engineVolume=" + engineVolume +
                ", cylinders=" + cylinders +
                ", bodyType='" + bodyType + '\'' +
                ", color='" + color + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", tireSize=" + tireSize +
                '}';
    }

    static class Builder {
        private String name;
        private double engineVolume;
        private int cylinders;
        private String bodyType;
        private String color;
        private String fuelType;
        private int tireSize;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildEngineVolume(double engineVolume) {
            this.engineVolume = engineVolume;
            return this;
        }

        Builder buildCylinders(int cylinders) {
            this.cylinders = cylinders;
            return this;
        }

        Builder buildBodyType(String bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildFuelType(String fuelType) {
            this.fuelType = fuelType;
            return this;
        }

        Builder buildTireSize(int tireSize) {
            this.tireSize = tireSize;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.name = name;
            car.engineVolume = engineVolume;
            car.cylinders = cylinders;
            car.bodyType = bodyType;
            car.color = color;
            car.fuelType = fuelType;
            car.tireSize = tireSize;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder().buildName("volvo")
                .buildEngineVolume(3.0)
                .buildCylinders(6)
                .buildBodyType("Suv")
                .buildColor("Black")
                .buildFuelType("Diesel")
                .buildTireSize(18)
                .build();
        System.out.println(car);
    }
}
