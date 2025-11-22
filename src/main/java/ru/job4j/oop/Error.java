package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void print() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        new Error().print();
        new Error(false, 25, "Hello").print();
        new Error(true, 12, "Attention").print();
        new Error(true, 13, "Super").print();
    }
}
