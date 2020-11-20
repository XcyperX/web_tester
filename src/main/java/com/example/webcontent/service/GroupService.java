package com.example.webcontent.service;

import com.example.webcontent.base.CRUDService;
import com.example.webcontent.dto.GroupDto;

import java.util.List;

public interface GroupService extends CRUDService<GroupDto, Long> {
    List<GroupDto> findAll();
}
