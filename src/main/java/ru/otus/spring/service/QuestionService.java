package ru.otus.spring.service;

import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.dto.Question;

import java.util.List;

public interface QuestionService {
void setDao(QuestionDao dao);

    List<Question> getQuestions();
}
