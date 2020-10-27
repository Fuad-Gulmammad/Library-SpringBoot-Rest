package com.librarysystem.booklib.service;

import com.librarysystem.booklib.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();
    void add(Book book);
    void update(Long id, Book book);
    void delete(Long id);
    Book getById(Long id);
    List<Book> getBookByNameAndAuthorName(String name, String authorName);
}
