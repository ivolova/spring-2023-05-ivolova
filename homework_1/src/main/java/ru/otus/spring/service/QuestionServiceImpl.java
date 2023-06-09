package ru.otus.spring.service;

import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.dto.Question;


import java.util.List;

public class QuestionServiceImpl implements QuestionService {
   private final QuestionDao dao;

    @Override
    public List<Question> getQuestions() {
        return dao.getQuestions();
    }

    QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }
}
