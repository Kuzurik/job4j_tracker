package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        student.setName("Кузура Александр Васильевич");
        student.setGroup(1);
        student.setCreated(LocalDateTime.now());
        System.out.println(student.getName() + System.lineSeparator()
                           + student.getGroup() + System.lineSeparator()
                           + student.getCreated().format(formatter));
    }
}
