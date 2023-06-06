package ru.otus.spring.dao;

import ru.otus.spring.dto.Question;

import java.util.List;

public interface QuestionDao {
  void setCsvName(String csvName);

  List<Question> getQuestions();


}
