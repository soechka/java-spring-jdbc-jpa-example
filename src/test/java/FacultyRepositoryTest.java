import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.testspring.entity.FacultyJpa;
import ru.testspring.jpa.FacultyJpaRepository;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestConfig.class})
public class FacultyRepositoryTest {

    @Autowired
    private FacultyJpaRepository facultyJpaRepository;

    @Before
    public void createFacultyTest() {
        FacultyJpa faculty = new FacultyJpa(3, "IPF");
        facultyJpaRepository.save(faculty);
        Optional<FacultyJpa> facultyJpaFromRepo = facultyJpaRepository.findOne(Example.of(faculty));
    }

    @Test
    public void findAllTest() {
        List<FacultyJpa> faculties = facultyJpaRepository.findAll();
        Assert.assertEquals(faculties.size(), 3);
    }

    @Test
    public void findByNameTest() {
        List<FacultyJpa> faculties = facultyJpaRepository.findByName("MM");
        Assert.assertNotNull(faculties);
        Assert.assertEquals(faculties.size(), 1);
    }

    @After
    public void deleteFacultyTest() {
        FacultyJpa faculty = new FacultyJpa(3, "IPF");
        facultyJpaRepository.delete(faculty);
        List<FacultyJpa> faculties = facultyJpaRepository.findAll();
        Assert.assertNotNull(faculties);
        Assert.assertEquals(faculties.size(), 2);
    }
}
