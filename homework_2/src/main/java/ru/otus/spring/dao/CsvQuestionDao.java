package ru.otus.spring.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.spring.dto.Question;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@PropertySource("classpath:application.properties")
@Component
public class CsvQuestionDao implements QuestionDao {

    private final String csvName;

    public CsvQuestionDao(@Value("${csvName}")String csvName) {
        this.csvName = csvName;
    }

    public String getCsvName() {
        return csvName;
    }

    @Override
    public List<Question> getQuestions() {
        List<Question> result = new ArrayList<>();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(csvName)) {
            if (is != null) {
                CSVReader csvReader = new CSVReader(
                        new BufferedReader(
                                new InputStreamReader(is, StandardCharsets.UTF_8)), ';');
                    for (String[] row : csvReader.readAll()) {
                        String questionRow = "";
                        String correctAnswer = "";
                        List<String> answers = new ArrayList<>();
                        if (row.length > 0) {
                            questionRow = row[0];
                            correctAnswer = row[1];
                            answers.addAll(Arrays.asList(row).subList(2, row.length));
                        }
                        Question question = new Question();
    //                    question.setQuestion(questionRow);
    //                    question.setCorrectAnswer(correctAnswer);
    //                    question.setAnswers(answers);
                        question.setQuestionData(questionRow, correctAnswer, answers);

                        result.add(question);
                    }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
