package com.example.webcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class TestResultDto {
    @JsonProperty("test_result_id")
    private Long id;

    @NotNull
    @JsonProperty("test_id")
    private Long testId;

    @NotNull
    @JsonProperty("student_id")
    private Long studentId;

    @NotNull
    private Integer result;
}
