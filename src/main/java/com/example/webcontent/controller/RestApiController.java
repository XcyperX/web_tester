package com.example.webcontent.controller;

import com.example.webcontent.dto.*;
import com.example.webcontent.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TestService testService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private TestResultService testResultService;

    @PostMapping("/groups")
    public GroupDto groupSave(@RequestBody @Valid GroupDto groupDto) {
        return groupService.save(groupDto);
    }

    @PostMapping("/registrations")
    public TeacherDto teacherDto(@RequestBody @Valid TeacherDto teacherDto) {
        return teacherService.save(teacherDto);
    }

    @PostMapping("/students")
    public StudentDto studentDto(@RequestBody @Valid StudentDto studentDto) {
        return studentService.save(studentDto);
    }

    @PostMapping("/tests")
    public TestDto testDto(@RequestBody @Valid TestDto testDto) {
        return testService.save(testDto);
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<?> getTeacher(@PathVariable("id") Long id) {
        return ResponseEntity.ok(teacherService.getById(id));
    }

    @PostMapping("/test/result")
    public TestResultDto testResultDto(@RequestBody @Valid TestResultDto testResultDto) {
        return testResultService.save(testResultDto);
    }
}
