package com.example.webcontent.service.impl;

import com.example.webcontent.dto.TestDto;
import com.example.webcontent.mapper.TestMapper;
import com.example.webcontent.model.Test;
import com.example.webcontent.repository.TestRepo;
import com.example.webcontent.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private TestRepo testRepo;

    @Override
    public TestDto getById(Long id) {
        Optional<Test> testOptional = testRepo.findById(id);
        if (testOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого теста!");
        }
        return testMapper.toDto(testOptional.get());
    }

    @Override
    public TestDto save(TestDto testDto) {
        Test test = testMapper.toEntity(testDto);
        return testMapper.toDto(testRepo.save(test));
    }

    @Override
    public TestDto update(TestDto testDto) {
        Optional<Test> testOptional = testRepo.findById(testDto.getId());
        if (testOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого теста!");
        }
        Test test = testMapper.toEntity(testDto);
        return testMapper.toDto(testRepo.save(test));
    }

    @Override
    public void delete(Long id) {
        Optional<Test> testOptional = testRepo.findById(id);
        if (testOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого теста!");
        }
        testRepo.deleteById(id);
    }
}
