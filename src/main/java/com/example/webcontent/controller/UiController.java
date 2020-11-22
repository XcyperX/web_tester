package com.example.webcontent.controller;

import com.example.webcontent.model.Role;
import com.example.webcontent.service.GroupService;
import com.example.webcontent.service.StudentService;
import com.example.webcontent.service.TestService;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UiController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TestService testService;

    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("students", studentService.findAll());
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
    public String tests(Model model) {
        model.addAttribute("tests", testService.findAll());
        return "/tests";
    }

    @GetMapping("tests/{id}")
    public String addQuestions(@PathVariable("id") Long id, Model model) {

        return "questions";
    }
}
