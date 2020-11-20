package ru.testspring.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentsJdbcDemo {

    private long id;

    private int fac_id;

    private String name;

    private int year;

    public StudentsJdbcDemo(long id, int fac_id, String name, int year) {
        this.id = id;
        this.fac_id = fac_id;
        this.name = name;
        this.year = year;
    }
}
