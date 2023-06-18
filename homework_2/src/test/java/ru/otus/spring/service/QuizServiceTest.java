package ru.otus.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.dao.PersonAnswerDaoImpl;
import ru.otus.spring.dao.PersonDaoImpl;
import ru.otus.spring.dto.Question;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuizServiceTest {


    @InjectMocks
    private QuizServiceImpl quizService;

    @Mock
    QuestionServiceImpl questionService;
    @Mock
    PersonDaoImpl personDao;
    @Mock
    PersonAnswerDaoImpl personAnswerDao;

    @BeforeEach
    public void setUp() {
//        MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void startQuiz() {


        // Given
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);

        when(quizService.getQuestionService().getQuestions()).thenReturn(
                List.of(new Question().setQuestion("Q1")
//                        ,
//                        new Question().setQuestion("Q2"),
//                        new Question().setQuestion("Q3")
                ));


        // When
        quizService.startQuiz();


        // Then
        verify(quizService.getPersonAnswerDao(), times(1))
                .addAnswer(new Question().setQuestion("Q1"), "1");


    }
}