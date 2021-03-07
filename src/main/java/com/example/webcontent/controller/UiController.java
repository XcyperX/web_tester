package com.example.webcontent.controller;

import com.example.webcontent.model.Role;
import com.example.webcontent.model.Teacher;
import com.example.webcontent.report.PDFGenerator;
import com.example.webcontent.service.*;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;

@Controller
public class UiController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TestService testService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TestResultService testResultService;

    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }

//    Формирование станицы студентов
    @GetMapping("/students")
    public String students(@AuthenticationPrincipal Teacher teacher, Model model) {
        model.addAttribute("teacher", teacher.getId());
        model.addAttribute("groups", teacherService.getById(teacher.getId()).getGroups());
        model.addAttribute("students", teacherService.findAllStudents(teacher.getId()));
        return "/students";
    }

//    Формирование страницы регистрации
    @GetMapping("/registration")
    public String registration(Model model) throws TemplateModelException {
        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.example.webcontent.model.Role");
        model.addAttribute("roles", myRoles);
        return "/registration";
    }

//    Формирование страницы со списком сотрудников
    @GetMapping("/teachers")
    public String listTeachers(Model model) throws TemplateModelException {
        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.example.webcontent.model.Role");
        model.addAttribute("roles", myRoles);
        model.addAttribute("teachers", teacherService.findAll());
        return "listTeachers";
    }

//    Формирование страницы со списком тестов
    @GetMapping("/tests")
    public String tests(@AuthenticationPrincipal Teacher teacher, Model model) {
        model.addAttribute("teacher", teacher.getId());
        model.addAttribute("tests", teacherService.findAllTests(teacher.getId()));
        return "createTests";
    }

//    Формирование страницы для прохождения тестирования
    @GetMapping("/take/tests")
    public String takeTest(Model model) {
        model.addAttribute("tests", testService.findAll());
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("teachers", teacherService.findAllTeacherByRole(Role.ADMIN));
        model.addAttribute("students", studentService.findAll());
        return "tests";
    }

//    Формирование страницы с результатами тестирования
    @GetMapping("/result")
    public String resultTest(@AuthenticationPrincipal Teacher teacher, Model model) {
        model.addAttribute("teacher", teacher.getId());
        model.addAttribute("students", teacherService.findAllStudents(teacher.getId()));
        model.addAttribute("groups", teacherService.getById(teacher.getId()).getGroups());
        model.addAttribute("result", testResultService.findAll());
        return "testResult";
    }

//    Формирование pdf отчета
    @GetMapping(value = "/pdf/request", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> profitReport(@AuthenticationPrincipal Teacher teacher){
        PDFGenerator pdfGenerator = new PDFGenerator();
        ByteArrayInputStream bis = pdfGenerator.PDFReport(teacher, testResultService.findByTeacherId(teacher.getId()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Результаты тестирования.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
