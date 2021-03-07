package com.example.webcontent.mapper;

import com.example.webcontent.dto.TestResultByStudentDto;
import com.example.webcontent.model.TestResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestResultByStudentMapper implements BaseMapperService<TestResult, TestResultByStudentDto> {


    @Override
    public TestResult toEntity(TestResultByStudentDto dto) {
        return null;
    }

    @Override
    public TestResultByStudentDto toDto(TestResult entity) {
        TestResultByStudentDto testResultByStudentDto = new TestResultByStudentDto();
        testResultByStudentDto.setName(entity.getStudent().getName());
        testResultByStudentDto.setSurname(entity.getStudent().getSurname());
        testResultByStudentDto.setNameTest(entity.getTest().getName());
        testResultByStudentDto.setResult(entity.getResult());
        return testResultByStudentDto;
    }

    @Override
    public List<TestResult> toEntities(List<TestResultByStudentDto> dto) {
        return null;
    }

    @Override
    public List<TestResultByStudentDto> toDtos(List<TestResult> entity) {
        List<TestResultByStudentDto> testResultByStudentDtos = new ArrayList<>();
        entity.forEach(testResult -> testResultByStudentDtos.add(toDto(testResult)));
        return testResultByStudentDtos;
    }
}
