package com.question.service;

import com.question.question.Question;

import java.util.List;

public interface QuestionService {

    Question create(Question question);
    List<Question> get();
    Question getById(Long id);

    List<Question> getQuestionOfQuiz(Long quizId);
}
