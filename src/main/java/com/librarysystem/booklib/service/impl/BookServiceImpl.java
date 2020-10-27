package com.librarysystem.booklib.service.impl;

import com.librarysystem.booklib.model.Book;
import com.librarysystem.booklib.repository.BookRepository;
import com.librarysystem.booklib.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void update(Long id, Book book) {
        Book bookDb=bookRepository.findById(id).get();
            bookDb.setName(book.getName());
            bookDb.setAuthorName(book.getAuthorName());
            bookDb.setAbout(book.getAbout());
            bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        Optional<Book> book=bookRepository.findById(id);
        if (book.isPresent())
        bookRepository.delete(book.get());
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getBookByNameAndAuthorName(String name, String authorName) {
        return bookRepository.findByNameIsStartingWithAndAuthorNameEndingWith(name, authorName);
    }


}
