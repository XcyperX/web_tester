package com.example.webcontent.service.impl;

import com.example.webcontent.dto.GroupDto;
import com.example.webcontent.dto.StudentDto;
import com.example.webcontent.mapper.GroupMapper;
import com.example.webcontent.mapper.Mapper;
import com.example.webcontent.model.Group;
import com.example.webcontent.model.Student;
import com.example.webcontent.repository.GroupRepo;
import com.example.webcontent.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private Mapper mapper;

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

    @Override
    public List<GroupDto> findAll() {
        List<GroupDto> groupDtos = new ArrayList<>();
        groupRepo.findAll().forEach(group -> groupDtos.add(mapper.groupMapper.toDto(group)));
        return groupDtos;
    }
}
