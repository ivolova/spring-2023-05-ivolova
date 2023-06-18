package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.dto.Question;


import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
   private QuestionDao dao;

    @Override
    public List<Question> getQuestions() {
        return dao.getQuestions();
    }

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }


}
