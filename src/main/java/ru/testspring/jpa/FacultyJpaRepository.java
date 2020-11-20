package ru.testspring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testspring.entity.FacultyJpa;

@Repository
public interface FacultyJpaRepository extends JpaRepository<FacultyJpa, Long> {
}
