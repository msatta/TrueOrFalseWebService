package com.example.msatta.trueorfalse.core.repository;

import com.example.msatta.trueorfalse.core.models.Question;
import com.example.msatta.trueorfalse.core.repository.QuestionRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by michele on 07/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = QuestionRepositoryTestContext.class)
@TestExecutionListeners(listeners = {
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@Transactional
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;


    @Test
    @DatabaseSetup("questionRepositorySetup.xml")
    @ExpectedDatabase("questionRepositoryCreateExpected.xml")
    public void shouldCreateNewQuestion() throws Exception {
        Question testQuestion = new Question();
        testQuestion.setText("Is the sky blue?");
        testQuestion.setAnswer(true);

        questionRepository.create(testQuestion);
    }

    @Test
    @DatabaseSetup("questionRepositorySetup.xml")
    public void shouldFindTestQuestion() throws Exception {
        Question actualQuestion = questionRepository.findQuestion(1L);

        String questionText = "Is this a question?";

        assertEquals(questionText, actualQuestion.getText());
    }

    @Test
    @DatabaseSetup("questionRepositorySetup.xml")
    public void shouldGetRandomNQuestionReturnNElements() throws Exception {
        int expectedElementNumber = 2;
        List<Question> questions = questionRepository.getNRandomQuestion(expectedElementNumber);

        assertEquals(expectedElementNumber, questions.size());
    }

    @Test
    @DatabaseSetup("questionRepositorySetup.xml")
    public void shouldGetRandomNQuestionReturnDifferentElements() throws Exception {
        int elementNumber = 2;
        List<Question> questions = questionRepository.getNRandomQuestion(elementNumber);

        Question firstElement = questions.get(0);
        Question lastElement = questions.get(1);
        assertNotEquals(firstElement, lastElement);
    }
}
