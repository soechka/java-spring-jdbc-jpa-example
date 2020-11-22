package ru.testspring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Getter
@Setter
public class StudentJpa {

    public static String TYPE_NAME = "Студент";

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_seq")
    @SequenceGenerator(name = "student_id_seq", sequenceName = "student_id_seq", allocationSize = 1)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "fac_id", referencedColumnName = "id", nullable = false)
    private FacultyJpa fac_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "year", nullable = false)
    private Integer year;

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

    public FacultyJpa getFac_id() {
        return fac_id;
    }

    public void setFac_id(FacultyJpa fac_id) {
        this.fac_id = fac_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
