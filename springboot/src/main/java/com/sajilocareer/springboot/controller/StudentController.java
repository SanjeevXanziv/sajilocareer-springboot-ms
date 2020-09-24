package com.sajilocareer.springboot.controller;

import com.sajilocareer.springboot.model.Student;
import com.sajilocareer.springboot.service.StudentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        return "index"; //determines which page to render
    }

    @GetMapping("/listStudent")
    public ModelAndView listStudent(ModelAndView modelAndView) {
        List<Student> studentList = this.studentService.getStudentList();
        modelAndView.addObject("studentList", studentList); //passing the model to the view
        modelAndView.setViewName("studentlist"); // resolves the template
        return modelAndView;
    }

    @PostMapping("/addStudent")
    public ModelAndView addStudent(@ModelAttribute Student student, ModelAndView modelAndView) {
        this.studentService.addStudent(student);
        modelAndView.addObject("studentList", this.studentService.getStudentList()); //passing the model to the view
        modelAndView.setViewName("studentlist"); // resolves the template
        return modelAndView;
    }

    @GetMapping("/addStudentForm")
    public ModelAndView addStudent(ModelAndView modelAndView) {
        modelAndView.addObject("student", new Student());
        modelAndView.setViewName("addStudent");
        return modelAndView;
    }

    @GetMapping("/updateStudentForm")
    public ModelAndView updateStudentForm(@RequestParam("id") Integer id, ModelAndView modelAndView) throws NotFoundException {
        Student student = this.studentService.findById(id);
        if (student == null) {
            throw new NotFoundException("Student Could not be found");
        }

        modelAndView.addObject("student", student);
        modelAndView.setViewName("updateStudentForm");
        return modelAndView;
    }

    @PostMapping("updateStudent")
    public ModelAndView updateStudent(@ModelAttribute Student student, ModelAndView modelAndView) {
        this.studentService.addStudent(student);
        modelAndView.addObject("studentList", this.studentService.getStudentList()); //passing the model to the view
        modelAndView.setViewName("studentlist"); // resolves the template
        return modelAndView;
    }

    @GetMapping("/deleteStudent")
    public ModelAndView deleteStudent(@RequestParam("id") Integer id, ModelAndView modelAndView) {
        this.studentService.deleteById(id);
        modelAndView.addObject("studentList", this.studentService.getStudentList()); //passing the model to the view
        modelAndView.setViewName("studentlist"); // resolves the template
        return modelAndView;
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam("name") String name, ModelAndView modelAndView) {
        List<Student> studentList = this.studentService.findByName(name);
        modelAndView.addObject("studentList", studentList); //passing the model to the view
        modelAndView.setViewName("studentlist"); // resolves the template
        return modelAndView;
    }
}
