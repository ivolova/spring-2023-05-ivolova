package ru.otus.spring_2023_05.dao;

import com.opencsv.CSVReader;
import ru.otus.spring_2023_05.dto.Question;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        InputStream is = getClass().getClassLoader().getResourceAsStream(csvName);
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(is, StandardCharsets.UTF_8), ';')) {
            List<String[]> rows = csvReader.readAll();

            for (String[] string : rows) {
                StringBuilder line = new StringBuilder();
                Question dto = new Question();
                for (String s : string) {
                    line.append(s).append(";");
                }
                dto.setQuestionLine(line.toString());
                result.add(dto);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
