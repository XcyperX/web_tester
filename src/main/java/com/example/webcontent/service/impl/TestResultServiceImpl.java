package com.example.webcontent.service.impl;

import com.example.webcontent.dto.QuestionToAnswer;
import com.example.webcontent.dto.StudentDto;
import com.example.webcontent.dto.TestResultByStudentDto;
import com.example.webcontent.dto.TestResultDto;
//import com.example.webcontent.mapper.TestResultMapper;
import com.example.webcontent.mapper.Mapper;
import com.example.webcontent.model.*;
import com.example.webcontent.repository.GroupRepo;
import com.example.webcontent.repository.StudentRepo;
import com.example.webcontent.repository.TestRepo;
import com.example.webcontent.repository.TestResultRepo;
import com.example.webcontent.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestResultServiceImpl implements TestResultService{
    @Autowired
    private Mapper mapper;
    @Autowired
    private TestService testService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private TestResultRepo testResultRepo;
    @Autowired
    private GroupService groupService;
    @Autowired
    private GroupRepo groupRepo;

    @Override
    public TestResultDto getById(Long aLong) {
        return null;
    }

    @Override
    public TestResultDto save(TestResultDto testResultDto) {
        TestResult testResult = new TestResult();
        testResult.setStudent(mapper.studentMapper.toEntity(studentService.getById(testResultDto.getStudentId())));
        testResult.setTest(mapper.testMapper.toEntity(testService.getById(testResultDto.getTestId())));
        float correct = 0;
        float anCorrect = 0;
        for (QuestionToAnswer questionToAnswer : testResultDto.getResult()) {
            if (answerService.getById(questionToAnswer.getAnswerId()).getIsCorrect()) {
                correct++;
            } else {
                anCorrect++;
            }
        }
        float result = (correct / (anCorrect + correct)) * 100;

        if (result < 50.0) {
            testResult.setResult(2);
        } else if (result >= 50.0 && result < 75.0) {
            testResult.setResult(3);
        } else if (result >= 75.0 && result < 90.0) {
            testResult.setResult(4);
        } else {
            testResult.setResult(5);
        }
        testResultRepo.save(testResult);
        return null;
    }

    @Override
    public TestResultDto update(TestResultDto testResultDto) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<TestResult> findAll() {
        return testResultRepo.findAll();
    }

    @Override
    public List<TestResultByStudentDto> findByStudentId(Long id) {
        return mapper.testResultByStudentMapper.toDtos(testResultRepo.findAllByStudentId(id));
    }

    @Override
    public List<TestResultByStudentDto> findByTeacherId(Long id) {
        List<Group> groups = groupRepo.findAllByTeacherId(id);
        List<Student> students = new ArrayList<>();
        List<TestResultByStudentDto> testResultByStudentDtos = new ArrayList<>();
        groups.forEach(group -> {
            students.addAll(studentRepo.findAllByGroupId(group.getId()));
        });
        students.forEach(student -> {
            testResultByStudentDtos.addAll(mapper.testResultByStudentMapper.toDtos(testResultRepo.findAllByStudentId(student.getId())));
        });
        return testResultByStudentDtos;
    }
}
