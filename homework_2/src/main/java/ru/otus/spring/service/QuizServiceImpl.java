package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.PersonAnswerDao;
import ru.otus.spring.dao.PersonDao;
import ru.otus.spring.dto.Question;


import java.util.*;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuestionService questionService;
    private final PersonAnswerDao personAnswerDao;

  // private final Map<Question, String> answers = new LinkedHashMap<>();

    public QuizServiceImpl(QuestionService questionService, PersonAnswerDao personAnswerDao) {
        this.questionService = questionService;
        this.personAnswerDao = personAnswerDao;
    }

    @Override
    public void startQuiz() {
        List<Question> questions = questionService.getQuestions();


        for (Question question : questions) {
            System.out.println("Ответьте на вопрос:" + question.getQuestion());
            System.out.println("Варианты ответов:" + question.getAnswer() + "\n");
            String answer = getAnswer();
            personAnswerDao.addAnswer(question, answer);
        }

    }
     String getAnswer() {
        Scanner scanner = new Scanner(System.in);
         return scanner.nextLine();
    }

    public PersonAnswerDao getPersonAnswerDao(){
        return this.personAnswerDao;
    }

    public QuestionService getQuestionService() {
        return questionService;
    }
}
