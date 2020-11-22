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
import ru.testspring.exceptions.EntityAlreadyExistsException;
import ru.testspring.exceptions.EntityHasDetailsException;
import ru.testspring.exceptions.EntityIllegalArgumentException;
import ru.testspring.exceptions.EntityNotFoundException;
import ru.testspring.service.FacultyService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class FacultyServiceTest {

    @Autowired
    private FacultyService facultyService;

    @Test
    public void findAllTest() {
        List<FacultyJpa> faculties = facultyService.findAll();
        Assert.assertEquals(faculties.size(), 2);
    }

    @Test
    public void findByIdTest() {
        facultyService.findById(1);
    }

    @Test (expected = EntityIllegalArgumentException.class)
    public void findByIdNullIdException() {
        facultyService.findById(null);
    }

    @Test (expected = EntityIllegalArgumentException.class)
    public void findByIdIllegalIdException() {
        facultyService.findById("ao0");
    }

    /*
    @Test (expected = EntityNotFoundException.class)
    public void findByIdEmptyEntityException() {
        facultyService.findById(4);
    }
    */

    @Test
    public void createTest() {
        FacultyJpa faculty = new FacultyJpa(3, "TEST");
        facultyService.create(faculty);
    }

    @Test (expected = EntityIllegalArgumentException.class)
    public void createNullFacultyExceptionTest() {
        facultyService.create(null);
    }

    @Test (expected = EntityIllegalArgumentException.class)
    public void createNullFacultyIdExceptionTest() {
        FacultyJpa faculty = new FacultyJpa(3, "TEST");
        faculty.setId(null);
        facultyService.create(faculty);
    }

    @Test (expected = EntityAlreadyExistsException.class)
    public void createExistsEntityException() {
        FacultyJpa faculty = new FacultyJpa(1, "MM");
        facultyService.create(faculty);
    }

    /*
    @Test
    public void deleteTest() {
        facultyService.delete((Object) 3);
    }
    */

    @Test (expected = EntityHasDetailsException.class)
    public void deleteEntityHasDetailsTest() {
        facultyService.delete((Object) 1);
    }
}
