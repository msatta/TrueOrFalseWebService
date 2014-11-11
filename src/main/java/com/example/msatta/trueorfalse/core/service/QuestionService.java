package com.example.msatta.trueorfalse.core.service;

import com.example.msatta.trueorfalse.core.models.Question;
import com.example.msatta.trueorfalse.core.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by michele on 08/11/14.
 */
@Service
@Transactional
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> get20Questions() {
        int numberOfElement = 20;
        List<Question> questions = questionRepository.getNRandomQuestion(20);
        return questions;
    }
}
