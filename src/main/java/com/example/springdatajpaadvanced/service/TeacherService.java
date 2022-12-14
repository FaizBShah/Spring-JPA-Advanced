package com.example.springdatajpaadvanced.service;

import com.example.springdatajpaadvanced.entity.Course;
import com.example.springdatajpaadvanced.entity.CourseMaterial;
import com.example.springdatajpaadvanced.entity.Teacher;
import com.example.springdatajpaadvanced.repository.TeacherRepository;
import com.example.springdatajpaadvanced.request.CreateCourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional
    public Teacher saveTeacher(String firstName, String lastName, List<CreateCourseRequest> courses) {
        List<Course> newCourses = new ArrayList<>();

        for (CreateCourseRequest course: courses) {
            CourseMaterial courseMaterial = CourseMaterial.builder()
                    .url(course.getCourseMaterialUrl())
                    .build();

            Course newCourse = Course.builder()
                    .title(course.getCourseTitle())
                    .credit(course.getCourseCredit())
                    .courseMaterial(courseMaterial)
                    .build();

            newCourses.add(newCourse);
        }

        Teacher teacher = Teacher.builder()
                .firstName(firstName)
                .lastName(lastName)
                //.courses(newCourses) Commented this since we are now shifting to ManyToOne relationship
                .build();

        return teacherRepository.save(teacher);
    }

    public List<Teacher> fetchTeachers() {
        return teacherRepository.findAll();
    }
}
