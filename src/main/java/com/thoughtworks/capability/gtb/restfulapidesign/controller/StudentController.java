package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Validated
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return student;
    }

    @DeleteMapping(value = "/student/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.delete(id);
    }
}
