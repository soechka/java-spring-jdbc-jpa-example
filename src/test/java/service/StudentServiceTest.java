package service;

import config.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.testspring.entities.FacultyJpa;
import ru.testspring.entities.StudentJpa;
import ru.testspring.exceptions.EntityAlreadyExistsException;
import ru.testspring.exceptions.EntityIllegalArgumentException;
import ru.testspring.exceptions.EntityNotFoundException;
import ru.testspring.service.FacultyService;
import ru.testspring.service.StudentService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    /*
    @Test
    public void findAllTest() {
        List<StudentJpa> students = studentService.findAll();
        Assert.assertEquals(students, 5);
    }
    */

    /*
    @Test
    public void findByIdTest() {
        studentService.findById(1);
    }
    */

    @Test (expected = EntityIllegalArgumentException.class)
    public void findByIdNullIdTest() {
        studentService.findById(null);
    }

    @Test (expected = EntityIllegalArgumentException.class)
    public void findByIdWrongIdFormat() {
        studentService.findById("a-=0");
    }

    @Test (expected = EntityNotFoundException.class)
    public void findByIdEmptyStudent() {
        studentService.findById(6);
    }

    /*
    @Test
    public void createTest() {
        StudentJpa student = new StudentJpa(6, facultyService.findById(1), "Emanuel", 3);
        studentService.create(student);
    }
    */

    @Test (expected = EntityIllegalArgumentException.class)
    public void createNullStudentTest() {
        studentService.create(null);
    }

    @Test (expected = EntityIllegalArgumentException.class)
    public void createNullStudentIdTest() {
        StudentJpa student = new StudentJpa(null, facultyService.findById(1), "Wow", 1);
        studentService.create(student);
    }

    @Test (expected = EntityIllegalArgumentException.class)
    public void createNullFacultyIdTest() {
        StudentJpa student = new StudentJpa(6, null, "Wow", 1);
        studentService.create(student);
    }

    @Test (expected = EntityIllegalArgumentException.class)
    public void createNullFacultyIdIdTest() {
        FacultyJpa faculty = new FacultyJpa(null, "Wow");
        StudentJpa student = new StudentJpa(6, faculty, "Wow", 1);
        studentService.create(student);
    }

    @Test (expected = EntityIllegalArgumentException.class)
    public void createNullStudentNameTest() {
        StudentJpa student = new StudentJpa(6, facultyService.findById(1), null, 1);
        studentService.create(student);
    }

    @Test (expected = EntityIllegalArgumentException.class)
    public void createNullStudentYearTest() {
        StudentJpa student = new StudentJpa(6, facultyService.findById(1), "Wow", null);
        studentService.create(student);
    }

    /*
    @Test (expected = EntityAlreadyExistsException.class)
    public void createNullTest() {
        studentService.create(new StudentJpa(1, 1, "Enrique", 2));
    }
    */

    /*
    @Test
    public void deleteTest() {
        studentService.delete(1);
    }
    */
}
