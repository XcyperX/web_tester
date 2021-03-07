package com.example.webcontent.controller;

import com.example.webcontent.dto.*;
import com.example.webcontent.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TestService testService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private TestResultService testResultService;

//    Сохранение группы
    @PostMapping("/groups")
    public GroupDto groupSave(@RequestBody @Valid GroupDto groupDto) {
        return groupService.save(groupDto);
    }

//    Регистрация сотрудника
    @PostMapping("/registrations")
    public TeacherDto teacherDto(@RequestBody @Valid TeacherDto teacherDto) {
        return teacherService.save(teacherDto);
    }

//    Обновление информации по сотруднику
    @PutMapping("/teachers/{id}")
    public TeacherDto updateTeacherDto(@PathVariable("id") Long id, @RequestBody @Valid TeacherDto teacherDto) {
        teacherDto.setId(id);
        return teacherService.save(teacherDto);
    }

//    Удаление сотрудника
    @DeleteMapping("/teachers/{id}")
    public void deleteTeacherDto(@PathVariable("id") Long id) {
        teacherService.delete(id);
    }

//    Добавление студента
    @PostMapping("/students")
    public StudentDto studentDto(@RequestBody @Valid StudentDto studentDto) {
        return studentService.save(studentDto);
    }

//    Обновление студента
    @PutMapping("/students/{id}")
    public StudentDto updateStudent(@PathVariable("id") Long id, @RequestBody @Valid StudentDto studentDto) {
        studentDto.setId(id);
        return studentService.update(studentDto);
    }

//    Удаление студента
    @DeleteMapping("/students/{id}")
    public void deleteStudentDto(@PathVariable("id") Long id) {
        studentService.delete(id);
    }

//    Добавление теста
    @PostMapping("/tests")
    public TestDto testDto(@RequestBody @Valid TestDto testDto) {
        return testService.save(testDto);
    }

//    Получить информацию по сотруднику
    @GetMapping("/teachers/{id}")
    public ResponseEntity<?> getTeacher(@PathVariable("id") Long id) {
        return ResponseEntity.ok(teacherService.getById(id));
    }

//    Получить результаты тестирования по id студента
    @GetMapping("/students/{id}/result")
    public ResponseEntity<?> getStudentResult(@PathVariable("id") Long id) {
        return ResponseEntity.ok(testResultService.findByStudentId(id));
    }

//    Получить список всех результатов
    @PostMapping("/tests/result")
    public TestResultDto testResultDto(@RequestBody @Valid TestResultDto testResultDto) {
        return testResultService.save(testResultDto);
    }
}
