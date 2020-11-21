package ru.testspring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testspring.entity.StudentJpa;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentJpa, Long> {
}
