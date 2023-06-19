package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.PersonAnswerDao;
import ru.otus.spring.dao.PersonDao;
import ru.otus.spring.dto.Person;
import ru.otus.spring.dto.Question;


import java.util.*;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuestionService questionService;
    private final PersonAnswerDao personAnswerDao;
    private final IOService ioService;

    private final PersonDao personDao;

    private final PrintResultService printResultService;


  // private final Map<Question, String> answers = new LinkedHashMap<>();


//    public QuizServiceImpl(QuestionService questionService, PersonAnswerDao personAnswerDao, IOService ioService) {
//        this.questionService = questionService;
//        this.personAnswerDao = personAnswerDao;
//        this.ioService = ioService;
//    }


//    public QuizServiceImpl(QuestionService questionService, PersonAnswerDao personAnswerDao, IOService ioService, Person person) {
//        this.questionService = questionService;
//        this.personAnswerDao = personAnswerDao;
//        this.ioService = ioService;
//    }


    public QuizServiceImpl(QuestionService questionService, PersonAnswerDao personAnswerDao, IOService ioService, PersonDao personDao, PrintResultService printResultService) {
        this.questionService = questionService;
        this.personAnswerDao = personAnswerDao;
        this.ioService = ioService;
        this.personDao = personDao;
        this.printResultService = printResultService;
    }

    @Override
    public void startQuiz() {

        Person person = personDao.getPerson();

        List<Question> questions = questionService.getQuestions();

        for (Question question : questions) {
            System.out.println("Ответьте на вопрос:" + question.getQuestion());
            System.out.println("Варианты ответов:" + question.getAnswer() + "\n");
            String answer = getAnswer();
            personAnswerDao.addAnswer(question, answer);
        }

        printResultService.getPersonResult();

    }
     String getAnswer() {
         return ioService.readStringWithPrompt("");

     }

    public PersonAnswerDao getPersonAnswerDao(){
        return this.personAnswerDao;
    }

    public QuestionService getQuestionService() {
        return questionService;
    }
}
