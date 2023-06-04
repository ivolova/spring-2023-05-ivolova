package ru.otus.spring_2023_05.service;

import ru.otus.spring_2023_05.dao.QuestionDao;
import ru.otus.spring_2023_05.dto.Question;

import java.util.List;

public interface QuestionService {
void setDao(QuestionDao dao);

    List<Question> getQuestions();
}
