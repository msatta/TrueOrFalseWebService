package com.example.msatta.trueorfalse.core.service;

import com.example.msatta.trueorfalse.core.models.User;
import com.example.msatta.trueorfalse.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by michele on 08/11/14.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUser(Long uid) {
        User user = userRepository.findUserByUid(uid);
        return user;
    }

    public boolean checkName(String name) {
        User user = userRepository.findUserByName(name);
        boolean check = (user != null);
        return check;
    }

    public void updateScore(Long uid, Integer score) {
        userRepository.updateUserScore(uid, score);
    }

    public User createUser(User user) {
        User createdUser = userRepository.createUser(user);

        return createdUser;
    }

    public List<User> getTopTen() {
        int elements = 10;
        List<User> userList = userRepository.getUsersTopN(elements);

        return userList;
    }
}
