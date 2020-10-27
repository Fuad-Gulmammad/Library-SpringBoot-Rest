package com.librarysystem.booklib.controller;

import com.librarysystem.booklib.dto.StudentRequestDto;
import com.librarysystem.booklib.dto.StudentResponseDto;
import com.librarysystem.booklib.mapper.StudentMapper;
import com.librarysystem.booklib.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentMapper studentMapper=StudentMapper.INSTANCE;
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<StudentResponseDto> getAllStudent(){
        return studentMapper.toStudentResponseDtoList(studentService.getAll());
    }


    @GetMapping("/{id}")
    public StudentResponseDto getById(@PathVariable Long id) {
        return studentMapper.toStudentResponseDto(studentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody StudentRequestDto studentRequestDto){

        studentService.add(studentMapper.toStudent(studentRequestDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updteStudent(@RequestBody StudentRequestDto studentRequestDto,@PathVariable Long id){
        studentService.update(id,studentMapper.toStudent(studentRequestDto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
         studentService.delete(id);
         return ResponseEntity.ok().build();
    }
}
