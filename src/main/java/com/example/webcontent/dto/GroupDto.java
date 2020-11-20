package com.example.webcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class GroupDto {
    @JsonProperty("group_id")
    private Long id;

    @NotNull
    private String name;

//    private List<StudentDto> students;

    @JsonProperty("teacher_id")
    private Long teacherId;
}
