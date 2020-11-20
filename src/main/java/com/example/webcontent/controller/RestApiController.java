package com.example.webcontent.controller;

import com.example.webcontent.dto.GroupDto;
import com.example.webcontent.dto.TeacherDto;
import com.example.webcontent.service.GroupService;
import com.example.webcontent.service.TeacherService;
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

    @PostMapping("/groups")
    public GroupDto groupSave(@RequestBody @Valid GroupDto groupDto) {
        return groupService.save(groupDto);
    }

    @PostMapping("/registrations")
    public TeacherDto teacherDto(@RequestBody @Valid TeacherDto teacherDto) {
        return teacherService.save(teacherDto);
    }
}
