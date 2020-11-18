package com.example.webcontent.mapper;

import com.example.webcontent.dto.GroupDto;
import com.example.webcontent.model.Group;
import com.example.webcontent.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupMapper implements BaseMapperService<Group, GroupDto>{
    @Autowired
    private Mapper mapper;
    @Override
    public Group toEntity(GroupDto dto) {
        Group group = new Group();
        group.setId(dto.getId());
        group.setName(dto.getName());
        group.setStudents(mapper.studentMapper.toEntities(dto.getStudents()));
        Teacher teacher = new Teacher();
        teacher.setId(dto.getTeacherId());
        group.setTeacher(teacher);
        return group;
    }

    @Override
    public GroupDto toDto(Group entity) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(entity.getId());
        groupDto.setName(entity.getName());
        groupDto.setStudents(mapper.studentMapper.toDtos(entity.getStudents()));
        groupDto.setTeacherId(entity.getTeacher().getId());
        return groupDto;
    }

    @Override
    public List<Group> toEntities(List<GroupDto> dto) {
        List<Group> groups = new ArrayList<>();
        dto.forEach(groupDto -> groups.add(toEntity(groupDto)));
        return groups;
    }

    @Override
    public List<GroupDto> toDtos(List<Group> entity) {
        List<GroupDto> groupDtos = new ArrayList<>();
        entity.forEach(group -> groupDtos.add(toDto(group)));
        return groupDtos;
    }
}
