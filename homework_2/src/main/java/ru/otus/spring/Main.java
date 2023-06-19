package ru.otus.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

//import ru.otus.spring.dao.CsvQuestionDao;
import ru.otus.spring.dao.PersonDao;
import ru.otus.spring.dto.Person;
import ru.otus.spring.service.IOServiceImpl;
import ru.otus.spring.service.PrintResultService;
import ru.otus.spring.service.QuizService;

@ComponentScan
public class Main {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        var ioService = new IOServiceImpl();

        QuizService service = context.getBean(QuizService.class);
        service.startQuiz();

    }
}
