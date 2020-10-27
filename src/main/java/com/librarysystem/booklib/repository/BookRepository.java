package com.librarysystem.booklib.repository;

import com.librarysystem.booklib.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByNameIsStartingWithAndAuthorNameEndingWith(String name, String authorName);

}
