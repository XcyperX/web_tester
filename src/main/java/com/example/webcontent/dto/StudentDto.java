package com.example.webcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDto {
    @JsonProperty("student_id")
    private Long id;

    private String name;

    private String surname;

    @JsonProperty("group_id")
    private Long groupId;
}
