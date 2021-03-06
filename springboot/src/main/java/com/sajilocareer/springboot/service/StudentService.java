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
        studentDao.save(student);
    }

    public List<Student> getStudentList() {
        return (List<Student>) this.studentDao.findAll();
    }

    public Student findById(Integer id) {
        return this.studentDao.findById(id).get();
    }

    public void deleteById(Integer id) {
        this.studentDao.deleteById(id);
    }

    public List<Student> findByName(String name) {
        return this.studentDao.findByName(name);
    }
}
