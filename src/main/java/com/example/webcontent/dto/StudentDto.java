package com.example.webcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class StudentDto {
    @JsonProperty("student_id")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    @JsonProperty("group_id")
    private Long groupId;
}
