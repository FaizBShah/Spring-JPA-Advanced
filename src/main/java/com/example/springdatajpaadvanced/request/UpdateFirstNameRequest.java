package com.example.springdatajpaadvanced.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UpdateFirstNameRequest {
    private final String firstName;
    private final String email;
}
