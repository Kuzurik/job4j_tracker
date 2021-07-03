package ru.job4j.oop.ballStory;

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

    public void printInfo() {
        System.out.println(this.active);
        System.out.println(this.status);
        System.out.println(this.message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error1 = new Error(true, 1, "Hello");
        Error error2 = new Error(false, 5, "Goodbye");
        error.printInfo();
        error1.printInfo();
        error2.printInfo();
    }
}
