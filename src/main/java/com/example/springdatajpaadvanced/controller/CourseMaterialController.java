package com.example.springdatajpaadvanced.controller;

import com.example.springdatajpaadvanced.entity.CourseMaterial;
import com.example.springdatajpaadvanced.service.CourseMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course-materials")
public class CourseMaterialController {

    @Autowired
    private CourseMaterialService courseMaterialService;

    @GetMapping
    public List<CourseMaterial> fetchCourseMaterials() {
        return courseMaterialService.fetchCourseMaterials();
    }
}
