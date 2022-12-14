package com.example.springdatajpaadvanced.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CreateCourseRequest {
    private final String courseTitle;
    private final Integer courseCredit;
    private final String courseMaterialUrl;
}
