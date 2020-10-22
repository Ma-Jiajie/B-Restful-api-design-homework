package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dataBaseTest.StudentsDataBase;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.selfexception.UserIsExistingException;
import com.thoughtworks.capability.gtb.restfulapidesign.selfexception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public List<Student> getAllStudents() {
        return StudentsDataBase.studentsProvider();
    }
    public void updateStudent(Student student) {
        delete(student.getId());
        addStudent(student);
    }
    public void addStudent(Student student) {
        if(StudentsDataBase.findStudentById(student.getId()) != null) throw new UserIsExistingException("该用户已存在");
        StudentsDataBase.add(student);
    }
    public void delete(String id) {
        if(StudentsDataBase.findStudentById(id) == null) throw new UserNotFoundException("该用户不存在");
        StudentsDataBase.delete(id);
    }
    public Student findStudentById(String id) {
        Student student = StudentsDataBase.findStudentById(id);
        if(student != null) throw new UserNotFoundException("该用户不存在");
        return student;
    }
}
