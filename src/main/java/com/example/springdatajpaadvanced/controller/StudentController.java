package com.example.springdatajpaadvanced.controller;

import com.example.springdatajpaadvanced.entity.Student;
import com.example.springdatajpaadvanced.request.CreateStudentRequest;
import com.example.springdatajpaadvanced.request.UpdateFirstNameRequest;
import com.example.springdatajpaadvanced.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student saveStudent(@RequestBody CreateStudentRequest studentRequest) {
        return studentService.saveStudent(studentRequest);
    }

    @GetMapping
    public List<Student> fetchStudents() {
        return studentService.fetchStudents();
    }

    @GetMapping("/name/{firstName}")
    public List<Student> fetchStudentsByFirstName(@PathVariable("firstName") String firstName) {
        return studentService.fetchStudentsByFirstName(firstName);
    }

    @GetMapping("/search/{namePattern}")
    public List<Student> fetchStudentsByNamePattern(@PathVariable("namePattern") String namePattern) {
        return studentService.fetchStudentsByNamePattern(namePattern);
    }

    @GetMapping("/guardian-name/{guardianName}")
    public List<Student> fetchStudentsByGuardianName(@PathVariable("guardianName") String guardianName) {
        return studentService.fetchStudentsByGuardianName(guardianName);
    }

    @GetMapping("/email/{emailId}")
    public Student fetchStudentByEmail(@PathVariable("emailId") String emailId) {
        return studentService.fetchStudentByEmail(emailId);
    }

    @PutMapping("/update-firstname")
    public Student updateStudentFirstNameByEmail(@RequestBody UpdateFirstNameRequest updateFirstNameRequest) {
        return studentService.updateStudentFirstNameByEmail(
                updateFirstNameRequest.getFirstName(),
                updateFirstNameRequest.getEmail()
        );
    }
}
