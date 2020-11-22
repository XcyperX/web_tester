package com.example.webcontent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class TestDto {
    @JsonProperty("test_id")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private List<QuestionDto> questions;

    @NotNull
    @JsonProperty("owner_id")
    private Long ownerId;
}
