package ru.testspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.testspring.entity.StudentsJdbcDemo;
import ru.testspring.jdbc.StudentsJdbcRepository;
import ru.testspring.entity.StudentJpa;
import ru.testspring.jpa.StudentJpaRepository;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class Controller {

    private final StudentsJdbcRepository studentsJdbcRepository;
    private final StudentJpaRepository studentJpaRepository;

    @Autowired
    public Controller(StudentsJdbcRepository studentsJdbcRepository, StudentJpaRepository studentJpaRepository) {
        this.studentsJdbcRepository = studentsJdbcRepository;
        this.studentJpaRepository = studentJpaRepository;
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
    public List<StudentJpa> getStudentsJpa() {
        return studentJpaRepository.findAll();
    }

    @PostMapping("/students/jpa")
    public StudentJpa addStudentJpa(@RequestBody StudentJpa studentJpa) {
        return studentJpaRepository.save(studentJpa);
    }
}
