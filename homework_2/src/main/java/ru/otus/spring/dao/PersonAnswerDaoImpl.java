package ru.otus.spring.dao;

import org.springframework.stereotype.Component;
import ru.otus.spring.dto.Person;
import ru.otus.spring.dto.Question;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class PersonAnswerDaoImpl implements PersonAnswerDao{

    private final Map<Question, String> answers = new LinkedHashMap<>();;
    @Override
    public void addAnswer( Question question, String answer) {
        answers.put(question, answer);
    }
    @Override
    public Map<Question, String> getPersonAnswers(){
        return answers;
    }

}
