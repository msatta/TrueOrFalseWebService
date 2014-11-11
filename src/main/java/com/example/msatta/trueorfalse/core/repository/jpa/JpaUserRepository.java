package com.example.msatta.trueorfalse.core.repository.jpa;

import com.example.msatta.trueorfalse.core.models.User;
import com.example.msatta.trueorfalse.core.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by michele on 07/11/14.
 */
@Repository
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsersTopN(int n) {
        Query query = entityManager.createQuery("SELECT u FROM User u ORDER BY BESTSCORE DESC");
        query.setMaxResults(n);
        List<User> userList = query.getResultList();
        return userList;
    }

    @Override
    public User findUser(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public User findUserByUid(Long uid) {
        User user;
        try {
            Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.uid=?1");
            query.setParameter(1, uid);
            user = (User) query.getSingleResult();
        }catch(NoResultException exception){
            user = null;
        }
        return user;
    }

    @Override
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User findUserByName(String userName) {
        User user;
        try {
            Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.name=?1");
            query.setParameter(1, userName);
            user = (User) query.getSingleResult();
        }catch(NoResultException exception){
            user = null;
        }
        return user;
    }

    @Override
    public User updateUserScore(Long userUid, Integer score) {
        User user = findUserByUid(userUid);
        if(score > user.getBestScore()) {
            user.setBestScore(score);
            entityManager.flush();
        }
        return user;
    }
}
