package com.sajilocareer.springboot.service;

import com.sajilocareer.springboot.dao.StudentDao;
import com.sajilocareer.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    public List<Student> getStudentList() {
        return this.studentDao.getStudentList();
    }
}
