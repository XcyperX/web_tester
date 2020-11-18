package com.example.webcontent.mapper;

import com.example.webcontent.dto.StudentDto;
import com.example.webcontent.model.Group;
import com.example.webcontent.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper implements BaseMapperService<Student, StudentDto> {
    @Override
    public Student toEntity(StudentDto dto) {
        Student student = new Student();
        student.setId(dto.getId());
        Group group = new Group();
        group.setId(dto.getGroupId());
        student.setGroup(group);
        student.setName(dto.getName());
        student.setSurname(dto.getSurname());
        return student;
    }

    @Override
    public StudentDto toDto(Student entity) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(entity.getId());
        studentDto.setGroupId(entity.getGroup().getId());
        studentDto.setName(entity.getName());
        studentDto.setSurname(entity.getSurname());
        return studentDto;
    }

    @Override
    public List<Student> toEntities(List<StudentDto> dto) {
        List<Student> students = new ArrayList<>();
        dto.forEach(studentDto -> students.add(toEntity(studentDto)));
        return students;
    }

    @Override
    public List<StudentDto> toDtos(List<Student> entity) {
        List<StudentDto> studentDtos = new ArrayList<>();
        entity.forEach(student -> studentDtos.add(toDto(student)));
        return studentDtos;
    }
}
