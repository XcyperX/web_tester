package com.example.webcontent.controller;

import com.example.webcontent.dto.GroupDto;
import com.example.webcontent.dto.StudentDto;
import com.example.webcontent.dto.TeacherDto;
import com.example.webcontent.dto.TestDto;
import com.example.webcontent.service.GroupService;
import com.example.webcontent.service.StudentService;
import com.example.webcontent.service.TeacherService;
import com.example.webcontent.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
