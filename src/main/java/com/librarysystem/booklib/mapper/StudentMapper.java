package com.librarysystem.booklib.mapper;

import com.librarysystem.booklib.dto.StudentRequestDto;
import com.librarysystem.booklib.dto.StudentResponseDto;
import com.librarysystem.booklib.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentResponseDto toStudentResponseDto(Student student);

    List<StudentResponseDto> toStudentResponseDtoList(List<Student> studentList);

    Student toStudent(StudentRequestDto studentRequestDto);
}
