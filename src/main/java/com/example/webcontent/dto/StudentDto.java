package com.example.webcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class StudentDto {
    @JsonProperty("student_id")
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @JsonProperty("group_id")
    private Long groupId;
}
