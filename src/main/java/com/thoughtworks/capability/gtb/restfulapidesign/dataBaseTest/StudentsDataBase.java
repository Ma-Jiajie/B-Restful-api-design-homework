package com.thoughtworks.capability.gtb.restfulapidesign.dataBaseTest;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;

import java.util.List;

public class StudentsDataBase {
    private static List<Student> students;
    private static boolean isInitialized = false;

    private static void makeData() {
        isInitialized = true;
        students.add(new Student("1", "张飞", Gender.Female, ""));
        students.add(new Student("2", "云中君", Gender.Female, ""));
        students.add(new Student("3", "后羿", Gender.Male, ""));
        students.add(new Student("4", "百里玄策", Gender.Male, ""));
        students.add(new Student("5", "百里守约", Gender.Male, ""));
        students.add(new Student("6", "阿骨朵", Gender.Female, ""));
        students.add(new Student("7", "孙悟空", Gender.Male, ""));
        students.add(new Student("8", "韩信", Gender.Female, ""));
        students.add(new Student("9", "猪八戒", Gender.Female, ""));
        students.add(new Student("10", "太乙真人", Gender.Male, ""));
        students.add(new Student("11", "达摩", Gender.Female, ""));
        students.add(new Student("12", "姜子牙", Gender.Male, ""));
        students.add(new Student("13", "干将莫邪", Gender.Female, ""));
    }

    public List<Student> studentsProvider() {
        if(!isInitialized) makeData();
        return students;
    }

    public void add(Student student) {
        students.add(student);
    }
}
