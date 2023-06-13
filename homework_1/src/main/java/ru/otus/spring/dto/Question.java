package ru.otus.spring.dto;

import java.util.List;

public class Question {
    private String question;
    private List<String> answers;

    public String getQuestion() {
        return question;
    }
    public List<String> getAnswer() {
        return answers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Вопрос: " + question +
                ", варианты ответов: " + answers;
    }
}
