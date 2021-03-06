//package com.example.webcontent.mapper;
//
//import com.example.webcontent.dto.TestResultDto;
//import com.example.webcontent.model.Student;
//import com.example.webcontent.model.Test;
//import com.example.webcontent.model.TestResult;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class TestResultMapper implements BaseMapperService<TestResult, TestResultDto> {
//
//    @Override
//    public TestResult toEntity(TestResultDto dto) {
//        TestResult testResult.ftlh = new TestResult();
//        testResult.ftlh.setId(dto.getId());
//        testResult.ftlh.setResult(dto.getResult());
//        Student student = new Student();
//        student.setId(dto.getId());
//        testResult.ftlh.setStudent(student);
//        Test test = new Test();
//        test.setId(dto.getTestId());
//        testResult.ftlh.setTest(test);
//        return testResult.ftlh;
//    }
//
//    @Override
//    public TestResultDto toDto(TestResult entity) {
//        TestResultDto testResultDto = new TestResultDto();
//        testResultDto.setId(entity.getId());
//        testResultDto.setResult(entity.getResult());
//        testResultDto.setStudentId(entity.getStudent().getId());
//        testResultDto.setTestId(entity.getTest().getId());
//        return testResultDto;
//    }
//
//    @Override
//    public List<TestResult> toEntities(List<TestResultDto> dto) {
//        return null;
//    }
//
//    @Override
//    public List<TestResultDto> toDtos(List<TestResult> entity) {
//        return null;
//    }
//}
