package com.example.springdatajpaadvanced.service;

import com.example.springdatajpaadvanced.entity.CourseMaterial;
import com.example.springdatajpaadvanced.repository.CourseMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseMaterialService {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    public List<CourseMaterial> fetchCourseMaterials() {
        return courseMaterialRepository.findAll();
    }
}
