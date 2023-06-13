package ru.otus.spring.service;

import ru.otus.spring.dto.Question;

import java.util.List;

public class PrintQuestionServiceImpl implements PrintQuestionsService{
    private final QuestionService questionService;
    @Override
    public void printQuestions() {
        List<Question> questions = questionService.getQuestions();

        for (Question question : questions) {
            System.out.println(question);
        }
    }

    PrintQuestionServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

}
