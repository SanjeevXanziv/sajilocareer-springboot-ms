package com.sajilocareer.springboot.dao;

import com.sajilocareer.springboot.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao {

    private List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }
}
