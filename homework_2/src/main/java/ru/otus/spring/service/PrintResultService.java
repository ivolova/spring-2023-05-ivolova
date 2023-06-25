package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.PersonAnswerDao;
import ru.otus.spring.dao.PersonDao;

import ru.otus.spring.dto.Question;

import java.util.Map;

@Service
public class PrintResultService {

    PersonDao personDao;
   // QuizService quizService;

    PersonAnswerDao personAnswerDao;

    public PrintResultService(PersonDao personDao, /*QuizService quizService,*/ PersonAnswerDao personAnswerDao) {
        this.personDao = personDao;
      //  this.quizService = quizService;
        this.personAnswerDao = personAnswerDao;
    }

    public void getPersonResult() {
        int result = 0;


        Map<Question, String> answers = personAnswerDao.getPersonAnswers();
        for (Map.Entry<Question, String> answer : answers.entrySet()) {
            String key = answer.getKey().getCorrectAnswer();
            String value = answer.getValue();
            if (key.trim().equals(value.trim())) {
                result++;
            }

        }
        System.out.println("Тестируемый: " + personDao.getPerson().getFirstName() + " " + personDao.getPerson().getSecondName() + "\n" +
                "Результат: кол-во правильных ответов = " + result);
    }
}
