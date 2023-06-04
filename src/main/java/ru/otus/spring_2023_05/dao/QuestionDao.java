package ru.otus.spring_2023_05.dao;

import ru.otus.spring_2023_05.dto.Question;

import java.util.List;

public interface QuestionDao {
  void setCsvName(String csvName);

  List<Question> getQuestions();


}
