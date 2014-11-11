package com.example.msatta.trueorfalse.core.repository.jpa;

import com.example.msatta.trueorfalse.core.models.Question;
import com.example.msatta.trueorfalse.core.repository.QuestionRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by michele on 07/11/14.
 */
@Repository
public class JpaQuestionRepository implements QuestionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Question create(Question question) {
        entityManager.persist(question);
        return question;
    }

    public Question findQuestion(Long id) {
        Question question = entityManager.find(Question.class, id);
        return question;
    }

    @Override
    public List<Question> getNRandomQuestion(int n) {
        Query query = entityManager.createQuery("SELECT q FROM Question q ORDER BY rand()");
        query.setMaxResults(n);
        List<Question> questions = query.getResultList();
        return  questions;
    }
}
