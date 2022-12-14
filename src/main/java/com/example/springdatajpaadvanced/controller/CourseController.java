package com.example.springdatajpaadvanced.controller;

import com.example.springdatajpaadvanced.entity.Course;
import com.example.springdatajpaadvanced.request.CreateCourseRequest;
import com.example.springdatajpaadvanced.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course saveCourse(@RequestBody CreateCourseRequest courseRequest) {
        return courseService.saveCourse(
                courseRequest.getCourseTitle(),
                courseRequest.getCourseCredit(),
                courseRequest.getCourseMaterialUrl());
    }

    @GetMapping
    public List<Course> fetchCourses() {
        return courseService.fetchCourses();
    }
}
