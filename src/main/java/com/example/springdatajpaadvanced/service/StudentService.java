package com.example.springdatajpaadvanced.service;

import com.example.springdatajpaadvanced.entity.Guardian;
import com.example.springdatajpaadvanced.entity.Student;
import com.example.springdatajpaadvanced.repository.StudentRepository;
import com.example.springdatajpaadvanced.request.CreateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Student saveStudent(CreateStudentRequest studentRequest) {
        Guardian guardian = Guardian.builder()
                .name(studentRequest.getGuardianName())
                .email(studentRequest.getGuardianEmail())
                .mobile(studentRequest.getGuardianMobile())
                .build();

        Student student = Student.builder()
                .firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .emailId(studentRequest.getEmail())
                .guardian(guardian)
                .build();

        return studentRepository.save(student);
    }

    public List<Student> fetchStudents() {
        return studentRepository.findAll();
    }

    public List<Student> fetchStudentsByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    public List<Student> fetchStudentsByNamePattern(String namePattern) {
        return studentRepository.findByFirstNameContaining(namePattern);
    }

    public List<Student> fetchStudentsByGuardianName(String guardianName) {
        return studentRepository.findByGuardianName(guardianName);
    }

    public Student fetchStudentByEmail(String emailId) {
        return studentRepository.getStudentByEmailAddress(emailId);
    }

    @Transactional
    public Student updateStudentFirstNameByEmail(String firstName, String email) {
        studentRepository.updateStudentNameByEmail(firstName, email);
        return fetchStudentByEmail(email);
    }
}
