package com.example.webcontent.service.impl;

import com.example.webcontent.dto.GroupDto;
import com.example.webcontent.mapper.GroupMapper;
import com.example.webcontent.model.Group;
import com.example.webcontent.repository.GroupRepo;
import com.example.webcontent.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private GroupRepo groupRepo;
    @Override
    public GroupDto getById(Long id) {
        Optional<Group> groupOptional = groupRepo.findById(id);
        if (groupOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такой группы!");
        }
        return groupMapper.toDto(groupOptional.get());
    }

    @Override
    public GroupDto save(GroupDto groupDto) {
        Group group = groupMapper.toEntity(groupDto);
        return groupMapper.toDto(groupRepo.save(group));
    }

    @Override
    public GroupDto update(GroupDto groupDto) {
        Optional<Group> groupOptional = groupRepo.findById(groupDto.getId());
        if (groupOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такой группы!");
        }
        Group group = groupMapper.toEntity(groupDto);
        return groupMapper.toDto(groupRepo.save(group));
    }

    @Override
    public void delete(Long id) {
        Optional<Group> groupOptional = groupRepo.findById(id);
        if (groupOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такой группы!");
        }
        groupRepo.deleteById(id);
    }
}
