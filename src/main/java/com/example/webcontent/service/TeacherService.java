package com.example.webcontent.service;

import com.example.webcontent.base.CRUDService;
import com.example.webcontent.dto.TeacherDto;

import java.util.List;

public interface TeacherService extends CRUDService<TeacherDto, Long> {
    List<TeacherDto> findAll();
}
