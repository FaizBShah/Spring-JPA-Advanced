package com.example.springdatajpaadvanced.controller;

import com.example.springdatajpaadvanced.entity.Teacher;
import com.example.springdatajpaadvanced.request.CreateTeacherRequest;
import com.example.springdatajpaadvanced.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public Teacher saveTeacher(@RequestBody CreateTeacherRequest teacherRequest) {
        return teacherService.saveTeacher(
                teacherRequest.getFirstName(),
                teacherRequest.getLastName(),
                teacherRequest.getCourses()
        );
    }

    @GetMapping
    public List<Teacher> fetchTeachers() {
        return teacherService.fetchTeachers();
    }
}
