package ru.otus.spring.service;

import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.dto.Question;


import java.util.List;

public class QuestionServiceImpl implements QuestionService {
   private QuestionDao dao;

    public QuestionDao getDao() {
        return dao;
    }

    @Override
    public List<Question> getQuestions() {
        return dao.getQuestions();
    }

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }
}
