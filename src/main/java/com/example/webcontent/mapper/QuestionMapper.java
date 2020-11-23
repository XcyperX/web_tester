package com.example.webcontent.mapper;

import com.example.webcontent.dto.AnswerDto;
import com.example.webcontent.dto.QuestionDto;
import com.example.webcontent.model.Answer;
import com.example.webcontent.model.Question;
import com.example.webcontent.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionMapper implements BaseMapperService<Question, QuestionDto>{
    @Autowired
    private Mapper mapper;

    @Override
    public Question toEntity(QuestionDto dto) {
        Question question = new Question();
        question.setId(dto.getId());
        question.setAnswers(mapper.answerMapper.toEntities(dto.getAnswers()));
        Test test = new Test();
        test.setId(dto.getTestId());
        question.setTest(null);
        question.setText(dto.getText());
        return question;
    }

    @Override
    public QuestionDto toDto(Question entity) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(entity.getId());
        questionDto.setAnswers(mapper.answerMapper.toDtos(entity.getAnswers()));
        questionDto.setTestId(entity.getTest().getId());
        questionDto.setText(entity.getText());
        return questionDto;
    }

    @Override
    public List<Question> toEntities(List<QuestionDto> dto) {
        List<Question> questions = new ArrayList<>();
        dto.forEach(questionDto -> questions.add(toEntity(questionDto)));
        return questions;
    }

    @Override
    public List<QuestionDto> toDtos(List<Question> entity) {
        List<QuestionDto> questionDtos = new ArrayList<>();
        entity.forEach(question -> questionDtos.add(toDto(question)));
        return questionDtos;
    }
}
