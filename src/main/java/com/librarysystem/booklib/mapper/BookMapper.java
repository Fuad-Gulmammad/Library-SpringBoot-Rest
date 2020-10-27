package com.librarysystem.booklib.mapper;

import com.librarysystem.booklib.dto.BookRequestDto;
import com.librarysystem.booklib.dto.BookResponseDto;
import com.librarysystem.booklib.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookResponseDto toBookResponseDto(Book book);
    List<BookResponseDto> toBookResponseDtoList(List<Book> books);

    Book toBook(BookRequestDto bookRequestDto);


}
