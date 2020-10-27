package com.librarysystem.booklib.service;

import com.librarysystem.booklib.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();
    void add(Student student);
    void update(Long id,Student student);
    void delete(Long id);
    Student getById(Long id);

}
