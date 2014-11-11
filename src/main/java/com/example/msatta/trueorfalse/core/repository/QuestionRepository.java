package com.example.msatta.trueorfalse.core.repository;

import com.example.msatta.trueorfalse.core.models.Question;

import java.util.List;

/**
 * Created by michele on 07/11/14.
 */
public interface QuestionRepository {

    public Question create(Question question);
    public Question findQuestion(Long id);

    public List<Question> getNRandomQuestion(int n);
}
