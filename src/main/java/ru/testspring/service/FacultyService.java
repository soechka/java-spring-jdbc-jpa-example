package ru.testspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testspring.entities.FacultyJpa;
import ru.testspring.entities.StudentJpa;
import ru.testspring.exceptions.EntityAlreadyExistsException;
import ru.testspring.exceptions.EntityHasDetailsException;
import ru.testspring.exceptions.EntityIllegalArgumentException;
import ru.testspring.exceptions.EntityNotFoundException;
import ru.testspring.jpa.FacultyJpaRepository;
import ru.testspring.jpa.StudentJpaRepository;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyJpaRepository facultyJpaRepository;

    private final StudentJpaRepository studentJpaRepository;

    @Autowired
    public FacultyService(FacultyJpaRepository facultyJpaRepository, StudentJpaRepository studentJpaRepository) {
        this.facultyJpaRepository = facultyJpaRepository;
        this.studentJpaRepository = studentJpaRepository;
    }

    public List<FacultyJpa> findAll() {
        return facultyJpaRepository.findAll();
    }

    public FacultyJpa findById(Object id) {
        FacultyJpa faculty;
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

        faculty = facultyJpaRepository.findFacultyJpaById(parseId); ////// mda

        if (faculty == null) {
            throw new EntityNotFoundException(FacultyJpa.TYPE_NAME, parseId);
        }

        return faculty;
    }

    public FacultyJpa create(FacultyJpa faculty) {
        if (faculty == null) {
            throw new EntityIllegalArgumentException("Создаваемый объект не может быть null");
        }
        if (faculty.getId() == null) {
            throw new EntityIllegalArgumentException("Идентификатор объекта не может быть null");
        }
        FacultyJpa existedFaculty = facultyJpaRepository.findFacultyJpaById(faculty.getId());
        if (existedFaculty != null) {
            throw new EntityAlreadyExistsException(FacultyJpa.TYPE_NAME, faculty.getId());
        }
        return facultyJpaRepository.save(faculty);
    }

    public void delete(Object id) {
        FacultyJpa faculty = findById(id);
        List<StudentJpa> students = studentJpaRepository.findStudentJpaByFacId(faculty);
        if (students.size() > 0) {
            throw new EntityHasDetailsException(StudentJpa.TYPE_NAME, faculty.getId());
        }
        facultyJpaRepository.delete(faculty);
    }
}
