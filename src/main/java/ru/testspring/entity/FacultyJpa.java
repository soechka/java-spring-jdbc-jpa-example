package ru.testspring.entity;

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
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fac_name", nullable = false)
    private String fac_name;
}
