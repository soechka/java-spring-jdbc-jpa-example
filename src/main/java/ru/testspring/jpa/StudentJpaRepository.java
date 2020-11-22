package ru.testspring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.testspring.entities.FacultyJpa;
import ru.testspring.entities.StudentJpa;

import java.util.List;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentJpa, Long> {

    // avoiding hibernate bug
    // @Query(value = "SELECT id, facid, name, year FROM student WHERE facid = ?1", nativeQuery = true)
    List<StudentJpa> findStudentJpaByFacId(FacultyJpa faculty);

    @Query(value = "SELECT id, facid, name, year FROM student WHERE id = ?1", nativeQuery = true)
    StudentJpa findStudentJpaById(Integer id);
}
