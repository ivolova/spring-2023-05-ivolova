package ru.otus.spring.dto;

import java.util.List;
import java.util.Objects;

public class Question {
    private String question;

    private String correctAnswer;
    private List<String> answers;

    public String getQuestion() {
        return question;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public List<String> getAnswer() {
        return answers;
    }

    public void setQuestionData(String question, String correctAnswer, List<String> answers){
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answers = answers;
    }




    public Question setQuestion(String question) {
        this.question = question; return this;
    }
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Вопрос: " + question +
                ", варианты ответов: " + answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return question.equals(question1.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question);
    }
}
