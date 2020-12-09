package com.example.webcontent.service;

import com.example.webcontent.base.CRUDService;
import com.example.webcontent.dto.StudentDto;
import com.example.webcontent.dto.TeacherDto;
import com.example.webcontent.dto.TestDto;

import java.util.List;

public interface TeacherService extends CRUDService<TeacherDto, Long> {
    List<TeacherDto> findAll();
    List<StudentDto> findAllStudents(Long id);
    List<TestDto> findAllTests(Long id);
}
