package com.example.springdatajpaadvanced.service;

import com.example.springdatajpaadvanced.entity.Course;
import com.example.springdatajpaadvanced.entity.CourseMaterial;
import com.example.springdatajpaadvanced.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(String courseTitle, Integer courseCredit, String courseMaterialUrl) {
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url(courseMaterialUrl)
                .build();

        Course course = Course.builder()
                .title(courseTitle)
                .credit(courseCredit)
                .courseMaterial(courseMaterial)
                .build();

        return courseRepository.save(course);
    }

    public List<Course> fetchCourses() {
        return courseRepository.findAll();
    }

    public List<Course> fetchPaginatedCourses() {
        Pageable firstPage = PageRequest.of(0, 3);
        Pageable secondPage = PageRequest.of(1, 2);

        List<Course> courses1 = courseRepository.findAll(firstPage).getContent();
        List<Course> courses2 = courseRepository.findAll(secondPage).getContent();

        courses1.addAll(courses2);

        return courses1;
    }

    public List<Course> fetchCoursesSortedByTitle() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));

        Pageable sortByCreditDescending = PageRequest.of(0, 2, Sort.by("credit").descending());

        Pageable sortByTitleDescendingAndCredit = PageRequest.of(
                0,
                2,
                Sort.by("title")
                        .descending()
                        .and(Sort.by("credit"))
        );

        return courseRepository.findAll(sortByTitle).getContent();
    }

    public List<Course> fetchCoursesByTitle(String title) {
        Pageable firstPage = PageRequest.of(0, 10);
        return courseRepository.findByTitleContaining(title, firstPage).getContent();
    }
}
