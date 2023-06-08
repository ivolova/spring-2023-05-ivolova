package ru.otus.spring.dao;

import ru.otus.spring.dto.Question;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    private String csvName;

    @Override
    public void setCsvName(String csvName) {
        this.csvName = csvName;
    }

    public String getCsvName() {
        return csvName;
    }

    @Override
    public List<Question> getQuestions() {
        List<Question> result = new ArrayList<>();

        try {
            //File file = new ClassPathResource(csvName).getFile();
            InputStream is = getClass().getClassLoader().getResourceAsStream(csvName);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    Question question = new Question();
                    question.setQuestionLine(line);
                    result.add(question);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
