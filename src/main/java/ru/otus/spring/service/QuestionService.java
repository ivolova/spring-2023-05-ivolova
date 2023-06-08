package ru.otus.spring.service;

import ru.otus.spring.dto.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestions();
}
