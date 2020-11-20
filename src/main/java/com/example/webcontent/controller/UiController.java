package com.example.webcontent.controller;

import com.example.webcontent.model.Role;
import com.example.webcontent.service.GroupService;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("groups", groupService.findAll());
        return "/students";
    }

    @GetMapping("/registration")
    public String registration(Model model) throws TemplateModelException {
        TemplateHashModel roles = BeansWrapper.getDefaultInstance().getEnumModels();
        TemplateHashModel myRoles = (TemplateHashModel) roles.get("com.example.webcontent.model.Role");
        model.addAttribute("roles", myRoles);
        return "/registration";
    }
}
