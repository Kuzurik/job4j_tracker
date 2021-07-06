package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book ball = new Book("Ball", 100);
        Book redCap = new Book("Little Red Riding Hood", 150);
        Book threePigs = new Book("Three pigs", 90);
        Book cleanCode = new Book("Clean code", 700);
        Book[] books = new Book[] {ball, redCap, threePigs, cleanCode};
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPages());
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.println(books[i].getName() + " - " + books[i].getPages());
                break;
            }
        }

    }
}
