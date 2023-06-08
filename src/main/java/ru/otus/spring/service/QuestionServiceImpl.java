package ru.otus.spring.service;

import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.dto.Question;
import ru.otus.spring.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
   private QuestionDao dao;

    @Override
    public void setDao(QuestionDao dao) {
        this.dao = dao;
    }

    public QuestionDao getDao() {
        return dao;
    }

    @Override
    public List<Question> getQuestions() {
        return dao.getQuestions();
    }
}
