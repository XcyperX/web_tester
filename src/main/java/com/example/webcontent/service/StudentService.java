package com.example.webcontent.service;

import com.example.webcontent.base.CRUDService;
import com.example.webcontent.dto.StudentDto;

import java.util.List;

public interface StudentService extends CRUDService<StudentDto, Long> {
    List<StudentDto> findAll();
}
