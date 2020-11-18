package com.example.webcontent.service.impl;

import com.example.webcontent.dto.AnswerDto;
import com.example.webcontent.mapper.AnswerMapper;
import com.example.webcontent.model.Answer;
import com.example.webcontent.repository.AnswerRepo;
import com.example.webcontent.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private AnswerRepo answerRepo;

    @Override
    public AnswerDto getById(Long id) {
        Optional<Answer> answerOptional = answerRepo.findById(id);
        if (answerOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого ответа!");
        }
        return answerMapper.toDto(answerOptional.get());
    }

    @Override
    public AnswerDto save(AnswerDto answerDto) {
        Answer answer = answerMapper.toEntity(answerDto);
        return answerMapper.toDto(answerRepo.save(answer));
    }

    @Override
    public AnswerDto update(AnswerDto answerDto) {
        Optional<Answer> answerOptional = answerRepo.findById(answerDto.getId());
        if (answerOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого ответа!");
        }
        Answer answer = answerMapper.toEntity(answerDto);
        return answerMapper.toDto(answerRepo.save(answer));
    }

    @Override
    public void delete(Long id) {
        Optional<Answer> answerOptional = answerRepo.findById(id);
        if (answerOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого ответа!");
        }
        answerRepo.deleteById(id);
    }
}
