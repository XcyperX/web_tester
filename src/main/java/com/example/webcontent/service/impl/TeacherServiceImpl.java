package com.example.webcontent.service.impl;

import com.example.webcontent.dto.TeacherDto;
import com.example.webcontent.mapper.TeacherMapper;
import com.example.webcontent.model.Teacher;
import com.example.webcontent.repository.TeacherRepo;
import com.example.webcontent.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public TeacherDto getById(Long id) {
        Optional<Teacher> teacherOptional = teacherRepo.findById(id);
        if (teacherOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого препода!");
        }
        return teacherMapper.toDto(teacherOptional.get());
    }

    @Override
    public TeacherDto save(TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.toEntity(teacherDto);
        return teacherMapper.toDto(teacherRepo.save(teacher));
    }

    @Override
    public TeacherDto update(TeacherDto teacherDto) {
        Optional<Teacher> teacherOptional = teacherRepo.findById(teacherDto.getId());
        if (teacherOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого препода!");
        }
        Teacher teacher = teacherMapper.toEntity(teacherDto);
        return teacherMapper.toDto(teacherRepo.save(teacher));
    }

    @Override
    public void delete(Long id) {
        Optional<Teacher> teacherOptional = teacherRepo.findById(id);
        if (teacherOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого препода!");
        }
        teacherRepo.deleteById(id);
    }

    @Override
    public List<TeacherDto> findAll() {
        List<TeacherDto> teacherDtos = new ArrayList<>();
        teacherRepo.findAll().forEach(teacher -> teacherDtos.add(teacherMapper.toDto(teacher)));
        return teacherDtos;
    }
}
