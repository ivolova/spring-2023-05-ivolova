package ru.otus.spring_2023_05;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring_2023_05.dto.Question;
import ru.otus.spring_2023_05.service.QuestionService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService service = context.getBean(QuestionService.class);
        List<Question> questions = service.getQuestions();

        for (Question question : questions) {
            System.out.println(question);
        }

    }
}
