package ru.otus.spring.dao;

import com.opencsv.CSVReader;
import ru.otus.spring.dto.Question;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvQuestionDao implements QuestionDao {
    private final String csvName;

    public CsvQuestionDao(String csvName) {
        this.csvName = csvName;
    }

    public String getCsvName() {
        return csvName;
    }

    @Override
    public List<Question> getQuestions() {
        List<Question> result = new ArrayList<>();
        InputStream is = getClass().getClassLoader().getResourceAsStream(csvName);
        if (is != null) {
            try (CSVReader csvReader = new CSVReader(
                    new BufferedReader(
                            new InputStreamReader(is, StandardCharsets.UTF_8)), ';')) {
                String line;

                for (String[] row : csvReader.readAll()) {
                    String questionRow = "";
                    List<String> answers = new ArrayList<>();
                    if (row.length > 0) {
                        questionRow = row[0];
                        answers.addAll(Arrays.asList(row).subList(1, row.length));
                    }
                    Question question = new Question();
                    question.setQuestion(questionRow);
                    question.setAnswers(answers);
                    result.add(question);
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return result;

    }
}
