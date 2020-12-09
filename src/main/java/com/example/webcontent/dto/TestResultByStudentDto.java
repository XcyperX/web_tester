package com.example.webcontent.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class TestResultByStudentDto {
    @NotNull
    private String name;

    @NotNull
    private String nameTest;

    @NotNull
    private Integer result;
}
