package com.librarysystem.booklib.repository;

import com.librarysystem.booklib.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student, Long> {

}
