package com.example.webcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TestResultDto {
    @JsonProperty("test_result_id")
    private Long id;

    @JsonProperty("test_id")
    private Long testId;

    @JsonProperty("student_id")
    private Long studentId;

    private Integer result;
}
