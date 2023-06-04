package ru.otus.spring_2023_05.dto;

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
        return "Question{" +
                "questionLine='" + questionLine + '\'' +
                '}';
    }
}
