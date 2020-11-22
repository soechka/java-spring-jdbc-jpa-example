package ru.testspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testspring.entities.FacultyJpa;
import ru.testspring.entities.StudentJpa;
import ru.testspring.exceptions.EntityAlreadyExistsException;
import ru.testspring.exceptions.EntityIllegalArgumentException;
import ru.testspring.exceptions.EntityNotFoundException;
import ru.testspring.jpa.FacultyJpaRepository;
import ru.testspring.jpa.StudentJpaRepository;

import java.util.List;

@Service
public class StudentService {

    private final FacultyJpaRepository facultyJpaRepository;

    private final StudentJpaRepository studentJpaRepository;

    @Autowired
    public StudentService(FacultyJpaRepository facultyJpaRepository, StudentJpaRepository studentJpaRepository) {
        this.facultyJpaRepository = facultyJpaRepository;
        this.studentJpaRepository = studentJpaRepository;
    }

    public List<StudentJpa> findAll() {
        return studentJpaRepository.findAll();
    }

    public StudentJpa findById(Object id) {
        StudentJpa student;
        if (id == null) {
            throw new EntityIllegalArgumentException("Идентификатор объекта не может быть null");
        }
        Integer parseId;
        try {
            parseId = Integer.valueOf(id.toString());
        } catch (NumberFormatException ex) {
            throw new EntityIllegalArgumentException(String.format("Не удалось преобразовать идентификатор " +
                    "к нужному типу, текст ошибки: %s", ex));
        }

        student = studentJpaRepository.findStudentJpaById(parseId); ////// mda

        if (student == null) {
            throw new EntityNotFoundException(FacultyJpa.TYPE_NAME, parseId);
        }

        return student;
    }

    public StudentJpa create(StudentJpa student) {
        if (student == null) {
            throw new EntityIllegalArgumentException("Создаваемый объект не может быть null");
        }
        if (student.getId() == null) {
            throw new EntityIllegalArgumentException("Идентификатор объекта не может быть null");
        }
        if (student.getFacId() == null) {
            throw new EntityIllegalArgumentException("Факультет не может быть null");
        }
        if (student.getFacId().getId() == null) {
            throw new EntityIllegalArgumentException("Идентификатор продукта не может быть null");
        }
        if (student.getName() == null) {
            throw new EntityIllegalArgumentException("Имя студента не может быть null");
        }
        if (student.getYear() == null) {
            throw new EntityIllegalArgumentException("Год обучения студента не может быть null");
        }
        StudentJpa existedStudent = studentJpaRepository.findStudentJpaById(student.getId());
        if (existedStudent != null) {
            throw new EntityAlreadyExistsException(StudentJpa.TYPE_NAME, existedStudent.getId());
        }
        return studentJpaRepository.save(student);
    }

    public void delete(Object id) {
        StudentJpa student = findById(id);
        studentJpaRepository.delete(student);
    }
}
