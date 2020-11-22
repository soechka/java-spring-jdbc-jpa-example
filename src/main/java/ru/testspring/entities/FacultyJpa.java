package ru.testspring.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
@NoArgsConstructor
@Getter
@Setter
public class FacultyJpa {

    public static String TYPE_NAME = "Факультет";

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    public FacultyJpa(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    //

    public static String getTypeName() {
        return TYPE_NAME;
    }

    public static void setTypeName(String typeName) {
        TYPE_NAME = typeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
