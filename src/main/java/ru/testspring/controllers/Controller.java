package ru.testspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.testspring.entity.StudentsJdbcDemo;
import ru.testspring.jdbc.StudentsJdbcRepository;
import ru.testspring.entity.StudentsJpaDemo;
import ru.testspring.jpa.StudentsJpaRepository;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class Controller {

    private final StudentsJdbcRepository studentsJdbcRepository;
    private final StudentsJpaRepository studentsJpaRepository;

    @Autowired
    public Controller(StudentsJdbcRepository studentsJdbcRepository, StudentsJpaRepository studentsJpaRepository) {
        this.studentsJdbcRepository = studentsJdbcRepository;
        this.studentsJpaRepository = studentsJpaRepository;
    }

    // JDBC mapping

    @GetMapping("/students/count")
    public Integer getStudentsCountJDBC() {
        return studentsJdbcRepository.count();
    }

    @GetMapping("/students")
    public List<StudentsJdbcDemo> getStudentsJDBC() {
        return studentsJdbcRepository.getStudents();
    }

    @GetMapping("/faculties/students")
    public List<StudentsJdbcDemo> getFacultyStudentsJDBC() { return studentsJdbcRepository.getFacultyStudents(1); }

    // JPA mapping

    @GetMapping("/students/jpa")
    public List<StudentsJpaDemo> getStudentsJpa() {
        return studentsJpaRepository.findAll();
    }

    @PostMapping("/students/jpa")
    public StudentsJpaDemo addStudentJpa(@RequestBody StudentsJpaDemo studentsJpaDemo) {
        return studentsJpaRepository.save(studentsJpaDemo);
    }
}
