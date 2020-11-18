package com.example.webcontent.dto;

import com.example.webcontent.model.Question;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class AnswerDto {
    @JsonProperty("answer_id")
    private Long id;

    @NotNull
    private String text;

    @NotNull
    @JsonProperty("is_correct")
    private Boolean isCorrect;

    @JsonProperty("question_id")
    private Long questionId;
}
