package ru.otus.spring.dao;

import ru.otus.spring.dto.Question;

import java.util.Map;


public interface PersonAnswerDao {

    void addAnswer( Question question, String answer);
    Map<Question, String> getPersonAnswers();


}
