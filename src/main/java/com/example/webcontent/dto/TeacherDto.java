package com.example.webcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class TeacherDto {
    @JsonProperty("teacher_id")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String password;

    @NotNull
//    @JsonProperty("role_id")
    private String role;

//    private List<GroupDto> groups;
//
//    private List<TestDto> tests;
}
