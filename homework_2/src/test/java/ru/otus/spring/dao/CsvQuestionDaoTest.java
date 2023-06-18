package ru.otus.spring.dao;

import config.TestingConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.spring.dto.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {TestingConfig.class})
@ExtendWith(SpringExtension.class)
class CsvQuestionDaoTest {
    @Autowired CsvQuestionDao csvQuestionDao;

    @Test
    void getQuestions() {
        List<Question> questions = csvQuestionDao.getQuestions();

        List<Question> expectedQuestions = List.of(
                new Question().setQuestion("Вопрос1"),
                new Question().setQuestion("Вопрос2"),
                new Question().setQuestion("Вопрос3")
        );

        assertEquals(expectedQuestions, questions);

    }
}