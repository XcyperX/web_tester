package com.example.webcontent.service;

import com.example.webcontent.base.CRUDService;
import com.example.webcontent.dto.StudentDto;
import com.example.webcontent.dto.TestResultByStudentDto;
import com.example.webcontent.dto.TestResultDto;
import com.example.webcontent.model.Group;
import com.example.webcontent.model.TestResult;

import java.util.List;

public interface TestResultService extends CRUDService<TestResultDto, Long> {
    List<TestResult> findAll();
    List<TestResultByStudentDto> findByStudentId(Long id);
    List<TestResultByStudentDto> findByTeacherId(Long id);
}
