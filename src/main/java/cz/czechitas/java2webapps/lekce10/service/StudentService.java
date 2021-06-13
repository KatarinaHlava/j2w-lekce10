package cz.czechitas.java2webapps.lekce10.service;

import cz.czechitas.java2webapps.lekce10.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
@Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Object dejJednoho(int id) {
    return studentRepository.getOne(id);
    }
}
