package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dataBaseTest.StudentsDataBase;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public List<Student> getAllStudents() {
        return StudentsDataBase.studentsProvider();
    }
    public void addStudent(Student student) {
        StudentsDataBase.add(student);
    }
    public void delete(String id) {
        StudentsDataBase.delete(id);
    }
}
