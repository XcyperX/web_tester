package com.example.webcontent.dto;

import com.example.webcontent.model.Question;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerDto {
    @JsonProperty("answer_id")
    private Long id;

    private String text;

    @JsonProperty("is_correct")
    private Boolean isCorrect;

    @JsonProperty("question_id")
    private Long questionId;
}
