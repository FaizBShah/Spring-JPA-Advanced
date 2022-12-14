package com.example.springdatajpaadvanced.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CreateStudentRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String guardianName;
    private final String guardianEmail;
    private final String guardianMobile;
}
