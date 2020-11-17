package com.example.webcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class QuestionDto {
    @JsonProperty("question_id")
    private Long id;

    private String text;

    private List<AnswerDto> answers;

    @JsonProperty("test_id")
    private Long testId;
}
