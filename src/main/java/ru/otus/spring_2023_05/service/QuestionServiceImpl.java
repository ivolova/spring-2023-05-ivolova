package ru.otus.spring_2023_05.service;

import ru.otus.spring_2023_05.dao.QuestionDao;
import ru.otus.spring_2023_05.dto.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService{
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
