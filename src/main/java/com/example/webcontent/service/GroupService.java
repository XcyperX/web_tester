package com.example.webcontent.service;

import com.example.webcontent.base.CRUDService;
import com.example.webcontent.dto.GroupDto;
import com.example.webcontent.dto.StudentDto;
import com.example.webcontent.model.Group;

import java.util.List;

public interface GroupService extends CRUDService<GroupDto, Long> {
    List<GroupDto> findAll();
}
