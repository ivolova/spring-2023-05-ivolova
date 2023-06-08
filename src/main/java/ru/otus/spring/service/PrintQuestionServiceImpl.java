package ru.otus.spring.service;

import ru.otus.spring.dto.Question;

import java.util.List;

public class PrintQuestionServiceImpl implements PrintQuestionsService{
    private QuestionService questionService;
    @Override
    public void printQuestions() {
        List<Question> questions = questionService.getQuestions();

        for (Question question : questions) {
            System.out.println(question);
        }
    }

    public QuestionService getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }
}
