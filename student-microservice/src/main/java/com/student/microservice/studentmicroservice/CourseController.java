package com.student.microservice.studentmicroservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/course")
    public List<String> getAllCourses() {
        List<String> courses = Arrays.asList("Java", "Python", "Database");
        return courses;
    }
}
