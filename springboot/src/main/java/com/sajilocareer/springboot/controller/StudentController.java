package com.sajilocareer.springboot.controller;

import com.sajilocareer.springboot.model.Student;
import com.sajilocareer.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/") // GET
    public String index() {
        Student student = new Student(1,"Sanjeev", "Boudha");
        Student student1 = new Student(2,"Dolma", "Boudha");
        this.studentService.addStudent(student);
        this.studentService.addStudent(student1);
        List<Student> studentList = this.studentService.getStudentList();

        studentList.forEach(studentObj -> {
            System.out.println(studentObj.getName());
        });

        return "index"; //determines which page to render
    }

    @GetMapping("/getStudents")
    public String getStudents() {
        return "studentlist";
    }
}
