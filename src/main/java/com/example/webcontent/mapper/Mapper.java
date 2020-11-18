package com.example.webcontent.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    @Autowired
    public AnswerMapper answerMapper;
    @Autowired
    public QuestionMapper questionMapper;
    @Autowired
    public TestMapper testMapper;
    @Autowired
    public StudentMapper studentMapper;
    @Autowired
    public GroupMapper groupMapper;
}
