package ru.otus.spring.dto;

public class Question {
  private String questionLine;

    public String getQuestionLine() {
        return questionLine;
    }

    public void setQuestionLine(String questionLine) {
        this.questionLine = questionLine;
    }

    @Override
    public String toString() {
        return  questionLine + "\n";
    }
}
