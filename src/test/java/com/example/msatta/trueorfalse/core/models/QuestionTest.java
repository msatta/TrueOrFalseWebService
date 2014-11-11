package com.example.msatta.trueorfalse.core.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by michele on 07/11/14.
 */
public class QuestionTest {

    private Question question;

    @Before
    public void setUp() throws Exception {
        question = new Question();
    }

    @Test
    public void testIdGetterAndSetter() throws Exception {
        Long id = 1L;
        question.setId(id);

        assertEquals(id, question.getId());
    }

    @Test
    public void testTextGetterAndSetter() throws Exception {
        String text = "Question test text";
        question.setText(text);

        assertEquals(text, question.getText());
    }

    @Test
    public void testAnswerGetterAndSetter() throws Exception {
        Boolean answer = true;
        question.setAnswer(answer);

        assertEquals(answer, question.getAnswer());
    }
}
