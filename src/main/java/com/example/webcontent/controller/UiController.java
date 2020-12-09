package com.example.webcontent.controller;

import com.example.webcontent.model.Teacher;
import com.example.webcontent.service.*;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/students")
    public String students(@AuthenticationPrincipal Teacher teacher, Model model) {
        model.addAttribute("teacher", teacher.getId());
        model.addAttribute("groups", teacherService.getById(teacher.getId()).getGroups());
        model.addAttribute("students", teacherService.findAllStudents(teacher.getId()));
        return "/students";
    }

    @GetMapping("/registration")
    public String registration(Model model) throws TemplateModelException {
        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.example.webcontent.model.Role");
        model.addAttribute("roles", myRoles);
        return "/registration";
    }

    @GetMapping("/tests")
    public String tests(@AuthenticationPrincipal Teacher teacher, Model model) {
        model.addAttribute("teacher", teacher.getId());
        model.addAttribute("tests", teacherService.findAllTests(teacher.getId()));
        return "createTests";
    }

    @GetMapping("/take/tests")
    public String takeTest(Model model) {
        model.addAttribute("tests", testService.findAll());
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("students", studentService.findAll());
        return "tests";
    }

    @GetMapping("/result")
    public String resultTest(@AuthenticationPrincipal Teacher teacher, Model model) {
        model.addAttribute("teacher", teacher.getId());
        model.addAttribute("students", teacherService.findAllStudents(teacher.getId()));
        model.addAttribute("groups", teacherService.getById(teacher.getId()).getGroups());
        model.addAttribute("result", testResultService.findAll());
        return "testResult";
    }
}
