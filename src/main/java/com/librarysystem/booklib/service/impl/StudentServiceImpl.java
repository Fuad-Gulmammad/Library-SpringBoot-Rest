package com.librarysystem.booklib.service.impl;

import com.librarysystem.booklib.model.Student;
import com.librarysystem.booklib.repository.StudentRepository;
import com.librarysystem.booklib.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void add(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Long id,Student student) {
        Student studentDb=studentRepository.findById(id).get();
        studentDb.setName(student.getName());
        studentDb.setEmail(student.getEmail());
        studentDb.setSurname(student.getSurname());
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        Optional<Student> student=studentRepository.findById(id);
        if (student.isPresent())
        studentRepository.delete(student.get());
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }


}
