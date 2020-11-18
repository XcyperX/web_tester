package com.example.webcontent.service.impl;

import com.example.webcontent.dto.StudentDto;
import com.example.webcontent.mapper.StudentMapper;
import com.example.webcontent.model.Student;
import com.example.webcontent.repository.StudentRepo;
import com.example.webcontent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public StudentDto getById(Long id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого студента!");
        }
        return studentMapper.toDto(studentOptional.get());
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        return studentMapper.toDto(studentRepo.save(student));
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        Optional<Student> studentOptional = studentRepo.findById(studentDto.getId());
        if (studentOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого студента!");
        }
        Student student = studentMapper.toEntity(studentDto);
        return studentMapper.toDto(studentRepo.save(student));
    }

    @Override
    public void delete(Long id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isEmpty()) {
            throw new RuntimeException("Ошибка, нет такого студента!");
        }
        studentRepo.deleteById(id);
    }
}
