package com.librarysystem.booklib.controller;


import com.librarysystem.booklib.dto.BookRequestDto;
import com.librarysystem.booklib.dto.BookResponseDto;
import com.librarysystem.booklib.mapper.BookMapper;
import com.librarysystem.booklib.model.Book;
import com.librarysystem.booklib.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookMapper bookMapper=BookMapper.INSTANCE;
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponseDto> getAllBook(){
        return bookMapper.toBookResponseDtoList(bookService.getAll());
    }

    @GetMapping("/{id}")
    public BookResponseDto getById(@PathVariable Long id){
        return bookMapper.toBookResponseDto(bookService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody BookRequestDto bookRequestDto){
        bookService.add(bookMapper.toBook(bookRequestDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@RequestBody BookRequestDto bookRequestDto, @PathVariable Long id){
        bookService.update(id,bookMapper.toBook(bookRequestDto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filter")
    public List<BookResponseDto> getBookByNameAndAuthorName(@RequestParam String name, @RequestParam String authorName){
        List<Book> book= bookService.getBookByNameAndAuthorName(name, authorName);
        List<BookResponseDto> bookResponseDtoList=bookMapper.toBookResponseDtoList(book);
        return bookResponseDtoList;
    }


}



