package com.example.springdatajpaadvanced.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// During Lazy Fetching, Hibernate add the below 2 columns for
// to the child object for lazy fetching handling. To prevent
// these objects from getting mapped to JSON, we need to ignore them
// using the below annotation, else it will throw an error
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "courseMaterialId")
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
    private Long courseMaterialId;
    private String url;

    @OneToOne(mappedBy = "courseMaterial")
    private Course course;
}
