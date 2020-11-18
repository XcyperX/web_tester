package com.example.webcontent.mapper;

import com.example.webcontent.dto.AnswerDto;
import com.example.webcontent.model.Answer;
import com.example.webcontent.model.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnswerMapper implements BaseMapperService<Answer, AnswerDto>{
    @Override
    public Answer toEntity(AnswerDto dto) {
        Answer answer = new Answer();
        answer.setId(dto.getId());
        answer.setText(dto.getText());
        answer.setIsCorrect(dto.getIsCorrect());
        Question question = new Question();
        question.setId(dto.getQuestionId());
        answer.setQuestion(question);
        return answer;
    }

    @Override
    public AnswerDto toDto(Answer entity) {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setId(entity.getId());
        answerDto.setText(entity.getText());
        answerDto.setIsCorrect(entity.getIsCorrect());
        answerDto.setQuestionId(entity.getQuestion().getId());
        return answerDto;
    }

    @Override
    public List<Answer> toEntities(List<AnswerDto> dto) {
        List<Answer> answers = new ArrayList<>();
        dto.forEach(answerDto -> answers.add(toEntity(answerDto)));
        return answers;
    }

    @Override
    public List<AnswerDto> toDtos(List<Answer> entity) {
        List<AnswerDto> answerDtos = new ArrayList<>();
        entity.forEach(answer -> answerDtos.add(toDto(answer)));
        return answerDtos;
    }
}
