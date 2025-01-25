package com.jarvis.authexample.service;

import com.jarvis.authexample.model.Student;
import com.jarvis.authexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student registerStudent(Student student){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepository.save(student);
        System.out.println("Student Registered");
        return student;
    }

    public List<Student> fetchStudents(){
        System.out.println("Fetching from DB");
        return studentRepository.findAll();
    }
}