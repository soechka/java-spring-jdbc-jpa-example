package ru.testspring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testspring.entities.FacultyJpa;

import java.util.List;

@Repository
public interface FacultyJpaRepository extends JpaRepository<FacultyJpa, Long> {

    List<FacultyJpa> findByName(String name);

    FacultyJpa findFacultyJpaById(Integer id);
}
