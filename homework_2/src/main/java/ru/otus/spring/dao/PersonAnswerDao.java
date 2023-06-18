package ru.otus.spring.dao;

import org.springframework.stereotype.Component;
import ru.otus.spring.dto.Person;
import ru.otus.spring.dto.Question;

import java.util.Map;


public interface PersonAnswerDao {

    void addAnswer( Question question, String answer);
    Map<Question, String> getPersonAnswers();


}
