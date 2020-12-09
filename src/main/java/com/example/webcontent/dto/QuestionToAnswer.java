package com.example.webcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionToAnswer {
    @JsonProperty("question_id")
    private Long questionId;

    @JsonProperty("answer_id")
    private Long answerId;
}
