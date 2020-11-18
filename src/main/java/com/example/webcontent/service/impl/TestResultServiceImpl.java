package com.example.webcontent.service.impl;

import com.example.webcontent.dto.TestResultDto;
import com.example.webcontent.mapper.TestResultMapper;
import com.example.webcontent.model.TestResult;
import com.example.webcontent.repository.TestResultRepo;
import com.example.webcontent.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TestResultServiceImpl implements TestResultService {
    @Autowired
    private TestResultMapper testResultMapper;
    @Autowired
    private TestResultRepo testResultRepo;
    @Override
    public TestResultDto getById(Long id) {
        Optional<TestResult> testResultOptional = testResultRepo.findById(id);
        if (testResultOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого результата!");
        }
        return testResultMapper.toDto(testResultOptional.get());
    }

    @Override
    public TestResultDto save(TestResultDto testResultDto) {
        TestResult testResult = testResultMapper.toEntity(testResultDto);
        return testResultMapper.toDto(testResultRepo.save(testResult));
    }

    @Override
    public TestResultDto update(TestResultDto testResultDto) {
        Optional<TestResult> testResultOptional = testResultRepo.findById(testResultDto.getId());
        if (testResultOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого результата!");
        }
        TestResult testResult = testResultMapper.toEntity(testResultDto);
        return testResultMapper.toDto(testResultRepo.save(testResult));
    }

    @Override
    public void delete(Long id) {
        Optional<TestResult> testResultOptional = testResultRepo.findById(id);
        if (testResultOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого результата!");
        }
        testResultRepo.deleteById(id);
    }
}
