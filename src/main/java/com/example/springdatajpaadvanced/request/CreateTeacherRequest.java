package com.example.springdatajpaadvanced.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CreateTeacherRequest {
    private final String firstName;
    private final String lastName;
    private final List<CreateCourseRequest> courses;
}
