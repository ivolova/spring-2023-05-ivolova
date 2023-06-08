package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.otus.spring.service.PrintQuestionsService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        PrintQuestionsService service = context.getBean(PrintQuestionsService.class);
        service.printQuestions();
    }
}
