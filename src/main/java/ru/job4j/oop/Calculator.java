package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) +divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int sum = sum(10);
        System.out.println(sum);
        int multiple = calculator.multiply(10);
        System.out.println(multiple);
        int minus = minus(10);
        System.out.println(minus);
        int divide = calculator.divide(10);
        System.out.println(divide);
        int sumAll = calculator.sumAllOperation(10);
        System.out.println(sumAll);
    }
}
