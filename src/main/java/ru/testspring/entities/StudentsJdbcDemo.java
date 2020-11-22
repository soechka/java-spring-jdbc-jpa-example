package ru.testspring.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentsJdbcDemo {

    private long id;

    private int facId;

    private String name;

    private int year;

    public StudentsJdbcDemo(long id, int facId, String name, int year) {
        this.id = id;
        this.facId = facId;
        this.name = name;
        this.year = year;
    }
}
