package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.controller.requestdto.StudentRequestDTO;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@Validated
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(@RequestParam(name = "gender", required = false) String gender) {
            if(gender == null) return studentService.getAllStudents();
            return studentService.getAllStudents().stream().filter(stu -> stu.getGender().ordinal() == Integer.parseInt(gender)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.findStudentById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Student addStudent(@RequestBody @Valid Student student) {
        studentService.addStudent(student);
        return student;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable String id) {
        studentService.delete(id);
    }

    @PatchMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody @Valid StudentRequestDTO studentRequestDTO) {
        Student student = studentService.findStudentById(id);
        studentService.delete(id);
        if(studentRequestDTO.getName() != null) student.setName(studentRequestDTO.getName());
        if(studentRequestDTO.getGender() != null) student.setGender(studentRequestDTO.getGender());
        if(studentRequestDTO.getNote() != null) student.setNote(studentRequestDTO.getNote());
        studentService.addStudent(student);
        return student;
    }
}
