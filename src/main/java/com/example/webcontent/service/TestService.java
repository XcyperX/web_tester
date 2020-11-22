package com.example.webcontent.service;

import com.example.webcontent.base.CRUDService;
import com.example.webcontent.dto.TestDto;

import java.util.List;

public interface TestService extends CRUDService<TestDto, Long> {
    List<TestDto> findAll();
}
