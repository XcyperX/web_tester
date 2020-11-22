package com.example.webcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class TeacherDto {
    @JsonProperty("teacher_id")
    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String password;

    @NotBlank
//    @JsonProperty("role_id")
    private String role;

//    private List<GroupDto> groups;
//
//    private List<TestDto> tests;
}
