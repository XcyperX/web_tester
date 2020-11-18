package com.example.webcontent.mapper;

import com.example.webcontent.dto.TestDto;
import com.example.webcontent.model.Teacher;
import com.example.webcontent.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestMapper implements BaseMapperService<Test, TestDto>{
    @Autowired
    private Mapper mapper;

    @Override
    public Test toEntity(TestDto dto) {
        Test test = new Test();
        test.setId(dto.getId());
        test.setName(dto.getName());
        Teacher teacher = new Teacher();
        teacher.setId(dto.getOwnerId());
        test.setOwner(teacher);
        test.setQuestions(mapper.questionMapper.toEntities(dto.getQuestions()));
        return test;
    }

    @Override
    public TestDto toDto(Test entity) {
        TestDto testDto = new TestDto();
        testDto.setId(entity.getId());
        testDto.setName(entity.getName());
        testDto.setOwnerId(entity.getOwner().getId());
        testDto.setQuestions(mapper.questionMapper.toDtos(entity.getQuestions()));
        return testDto;
    }

    @Override
    public List<Test> toEntities(List<TestDto> dto) {
        List<Test> tests = new ArrayList<>();
        dto.forEach(testDto -> tests.add(toEntity(testDto)));
        return tests;
    }

    @Override
    public List<TestDto> toDtos(List<Test> entity) {
        List<TestDto> testDtos = new ArrayList<>();
        entity.forEach(test -> testDtos.add(toDto(test)));
        return testDtos;
    }
}
