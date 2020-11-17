package com.example.webcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TeacherDto {
    @JsonProperty("teacher_id")
    private Long id;

    private String name;

    private String surname;

    private String password;

    private String role;

    private List<GroupDto> groups;

    private List<TestDto> tests;
}
