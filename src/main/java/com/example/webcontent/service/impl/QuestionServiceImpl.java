package com.example.webcontent.service.impl;

import com.example.webcontent.dto.QuestionDto;
import com.example.webcontent.mapper.QuestionMapper;
import com.example.webcontent.model.Question;
import com.example.webcontent.repository.QuestionRepo;
import com.example.webcontent.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionRepo questionRepo;
    @Override
    public QuestionDto getById(Long id) {
        Optional<Question> questionOptional = questionRepo.findById(id);
        if (questionOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого вопроса!");
        }
        return questionMapper.toDto(questionOptional.get());
    }

    @Override
    public QuestionDto save(QuestionDto questionDto) {
        Question question = questionMapper.toEntity(questionDto);
        return questionMapper.toDto(questionRepo.save(question));
    }

    @Override
    public QuestionDto update(QuestionDto questionDto) {
        Optional<Question> questionOptional = questionRepo.findById(questionDto.getId());
        if (questionOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого вопроса!");
        }
        Question question = questionMapper.toEntity(questionDto);
        return questionMapper.toDto(questionRepo.save(question));
    }

    @Override
    public void delete(Long id) {
        Optional<Question> questionOptional = questionRepo.findById(id);
        if (questionOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого вопроса!");
        }
        questionRepo.deleteById(id);
    }
}
