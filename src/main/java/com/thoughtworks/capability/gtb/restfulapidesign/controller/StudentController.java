package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.controller.requestdto.StudentRequestDTO;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    @ResponseBody
    public List<Student> getAllStudents(@RequestParam(name = "gender", required = false) String gender,
                                        @RequestParam(name = "id", required = false) String id) {
        if(gender == null && id == null) return studentService.getAllStudents();
        if(gender == null) return Collections.singletonList(studentService.findStudentById(id));
        return studentService.getAllStudents().stream().filter(stu -> stu.getGender().ordinal() == Integer.parseInt(gender)).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return student;
    }

    @DeleteMapping(value = "/student/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.delete(id);
    }

    @PatchMapping(value = "/student/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody StudentRequestDTO studentRequestDTO) {
        Student student = studentService.findStudentById(id);
        studentService.delete(id);
        if(studentRequestDTO.getName() != null) student.setName(studentRequestDTO.getName());
        if(studentRequestDTO.getGender() != null) student.setGender(studentRequestDTO.getGender());
        if(studentRequestDTO.getNote() != null) student.setNote(studentRequestDTO.getNote());
        studentService.addStudent(student);
        return student;
    }
}
