package com.example.webcontent.mapper;

import com.example.webcontent.dto.TeacherDto;
import com.example.webcontent.model.Role;
import com.example.webcontent.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherMapper implements BaseMapperService<Teacher, TeacherDto> {
    @Autowired
    private Mapper mapper;

    @Override
    public Teacher toEntity(TeacherDto dto) {
        Teacher teacher = new Teacher();
        teacher.setId(dto.getId());
        teacher.setName(dto.getName());
        teacher.setSurname(dto.getSurname());
        teacher.setPassword(dto.getPassword());
        teacher.setRole(Role.valueOf(dto.getRole()));
        teacher.setGroups(mapper.groupMapper.toEntities(dto.getGroups()));
        teacher.setTests(mapper.testMapper.toEntities(dto.getTests()));
        return teacher;
    }

    @Override
    public TeacherDto toDto(Teacher entity) {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(entity.getId());
        teacherDto.setName(entity.getName());
        teacherDto.setSurname(entity.getSurname());
        teacherDto.setPassword(entity.getPassword());
        teacherDto.setRole(entity.getRole().name());
        teacherDto.setGroups(mapper.groupMapper.toDtos(entity.getGroups()));
        teacherDto.setTests(mapper.testMapper.toDtos(entity.getTests()));
        return teacherDto;
    }

    @Override
    public List<Teacher> toEntities(List<TeacherDto> dto) {
        return null;
    }

    @Override
    public List<TeacherDto> toDtos(List<Teacher> entity) {
        return null;
    }
}
