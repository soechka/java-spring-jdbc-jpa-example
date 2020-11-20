package ru.testspring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testspring.entity.StudentsJpaDemo;

@Repository
public interface StudentsJpaRepository extends JpaRepository<StudentsJpaDemo, Long> {
}
