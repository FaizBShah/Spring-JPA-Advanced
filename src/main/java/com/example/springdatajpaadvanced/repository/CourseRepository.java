package com.example.springdatajpaadvanced.repository;

import com.example.springdatajpaadvanced.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Had to implement this method because Course Entity's
    // relation with CourseMaterial has been defined as FetchType.LAZY
    // @Query("SELECT c FROM Course c JOIN FETCH c.courseMaterial")
    // List<Course> findAllCourses();

    Page<Course> findByTitleContaining(String title, Pageable pageRequest);

}
