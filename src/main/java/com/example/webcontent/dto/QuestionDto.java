package com.example.webcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class QuestionDto {
    @JsonProperty("question_id")
    private Long id;

    @NotNull
    private String text;

    @NotNull
    private List<AnswerDto> answers;

    @NotNull
    @JsonProperty("test_id")
    private Long testId;
}
