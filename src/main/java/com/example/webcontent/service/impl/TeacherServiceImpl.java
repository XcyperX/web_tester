package com.example.webcontent.service.impl;

import com.example.webcontent.dto.StudentDto;
import com.example.webcontent.dto.TeacherDto;
import com.example.webcontent.dto.TestDto;
import com.example.webcontent.mapper.TeacherMapper;
import com.example.webcontent.model.Role;
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

//    Получение преподавателя по id
    @Override
    public TeacherDto getById(Long id) {
        Optional<Teacher> teacherOptional = teacherRepo.findById(id);
        if (teacherOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого преподавателя!");
        }
        return teacherMapper.toDto(teacherOptional.get());
    }

//    Сохранение преподавателя
    @Override
    public TeacherDto save(TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.toEntity(teacherDto);
        return teacherMapper.toDto(teacherRepo.save(teacher));
    }

//    Обновление данных преподавателя
    @Override
    public TeacherDto update(TeacherDto teacherDto) {
        Optional<Teacher> teacherOptional = teacherRepo.findById(teacherDto.getId());
        if (teacherOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого препода!");
        }
        Teacher teacher = teacherMapper.toEntity(teacherDto);
        return teacherMapper.toDto(teacherRepo.save(teacher));
    }

//    Удаление преподавателя по id
    @Override
    public void delete(Long id) {
        Optional<Teacher> teacherOptional = teacherRepo.findById(id);
        if (teacherOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого препода!");
        }
        teacherRepo.deleteById(id);
    }

//    Получение списка всех сотрудников системы
    @Override
    public List<TeacherDto> findAll() {
        List<TeacherDto> teacherDtos = new ArrayList<>();
        teacherRepo.findAll().forEach(teacher -> teacherDtos.add(teacherMapper.toDto(teacher)));
        return teacherDtos;
    }

//    Получение списка студентов у преподавателя по его id
    @Override
    public List<StudentDto> findAllStudents(Long id) {
        List<StudentDto> studentDtos = new ArrayList<>();
        getById(id).getGroups().forEach(groupDto -> studentDtos.addAll(groupDto.getStudents()));
        return studentDtos;
    }

//    Получение списка тестов преподавателя по его id
    @Override
    public List<TestDto> findAllTests(Long id) {
        List<TestDto> testDtos = new ArrayList<>(getById(id).getTests());
        return testDtos;
    }

//    Получение спика сотрудников по его роли
    @Override
    public List<TeacherDto> findAllTeacherByRole(Role role) {
        List<TeacherDto> teacherDtos = new ArrayList<>();
        teacherRepo.findAllByRole(role).forEach(teacher -> teacherDtos.add(teacherMapper.toDto(teacher)));
        return teacherDtos;
    }
}
