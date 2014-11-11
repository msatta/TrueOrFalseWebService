package com.example.msatta.trueorfalse.core.service;

import com.example.msatta.trueorfalse.core.models.Question;
import com.example.msatta.trueorfalse.core.repository.QuestionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by michele on 08/11/14.
 */
@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

    @Test
    public void shouldGet100QuestionsCallGetNRandomQuestionsWithN100() throws Exception {
        ArgumentCaptor<Integer> argument =ArgumentCaptor.forClass(Integer.class);
        when(questionRepository.getNRandomQuestion(argument.capture())).thenReturn(new ArrayList<Question>());

        List<Question> questions = questionService.get20Questions();

        Integer expectedNumberOfElement = 20;
        assertEquals(expectedNumberOfElement, argument.getValue());
    }

    @Test
    public void shouldGet100QuestionsReturnValueNotNull() throws Exception {
        when(questionRepository.getNRandomQuestion(anyInt())).thenReturn(new ArrayList<Question>());

        List<Question> questions = questionService.get20Questions();

        assertNotNull(questions);
    }

}
