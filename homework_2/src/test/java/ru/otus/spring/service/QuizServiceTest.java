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
    @Mock
    IOService   ioService;
    @Mock
    PrintResultService printResultService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void startQuiz() {


        // Given
        when(quizService.getAnswer()).thenReturn("1").thenReturn("2");


        when(quizService.getQuestionService().getQuestions()).thenReturn(
                List.of(new Question().setQuestion("Q1"),
                        new Question().setQuestion("Q2")

                ));

        // When
        quizService.startQuiz();

        // Then
        verify(quizService.getPersonAnswerDao(), times(1))
                .addAnswer(new Question().setQuestion("Q1"), "1") ;
        verify(quizService.getPersonAnswerDao(), times(1))
                .addAnswer(new Question().setQuestion("Q2"), "2") ;

    }
}