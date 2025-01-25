package com.jarvis.authexample.controller;

import com.jarvis.authexample.model.Student;
import com.jarvis.authexample.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student){
        return studentService.registerStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getStudent(){
        return studentService.fetchStudents();
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}