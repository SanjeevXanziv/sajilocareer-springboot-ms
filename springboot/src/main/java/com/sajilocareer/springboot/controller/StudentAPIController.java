package com.sajilocareer.springboot.controller;

import com.sajilocareer.springboot.model.Student;
import com.sajilocareer.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentAPIController {

    private StudentService studentService;

    @Autowired
    public StudentAPIController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return this.studentService.getStudentList();
    }

    @PostMapping
    public HttpStatus saveStudent(@RequestBody Student student) {
       this.studentService.addStudent(student);
       return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public HttpStatus saveStudent(@PathVariable("id") Integer id) {
        this.studentService.deleteById(id);
        return HttpStatus.OK;
    }

    @GetMapping("/courses")
    public List getAllCourses() {
        return new RestTemplate().getForObject("http://localhost:9999/course", List.class);
    }
}
