package com.example.webcontent.mapper;

import com.example.webcontent.dto.TestDto;
import com.example.webcontent.model.Answer;
import com.example.webcontent.model.Question;
import com.example.webcontent.model.Teacher;
import com.example.webcontent.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public static Test toEntity(TestDto testDto) {
        var test = new Test();
        test.setId(testDto.getId());
        test.setName(testDto.getName());
        var owner = new Teacher();
        owner.setId(testDto.getOwnerId());
        test.setOwner(owner);
        List<Question> questions = new ArrayList<>();
        testDto.getQuestions().forEach(questionDto -> {
            var question = new Question();
            question.setId(questionDto.getId());
            List<Answer> answers = new ArrayList<>();
            questionDto.getAnswers().forEach(answerDto -> {
                var answer = new Answer();
                answer.setId(answerDto.getId());
                answer.setIsCorrect(answerDto.getIsCorrect());
                answer.setText(answerDto.getText());
                question.setTest(test);
                question.setText(questionDto.getText());
                question.setAnswers(Collections.emptyList());
                answer.setQuestion(question);
                answers.add(answer);
            });
            question.setAnswers(answers);
            question.setTest(test);
            question.setText(questionDto.getText());
            questions.add(question);
        });
        test.setQuestions(questions);
        return test;
    }
}
