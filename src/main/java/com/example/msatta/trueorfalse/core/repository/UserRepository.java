package com.example.msatta.trueorfalse.core.repository;

import com.example.msatta.trueorfalse.core.models.User;

import java.util.List;

/**
 * Created by michele on 07/11/14.
 */
public interface UserRepository {

    public List<User> getUsersTopN(int n);
    public User findUser(Long id);
    public User findUserByUid(Long uid);

    public User createUser(User user);

    public User findUserByName(String user);

    public User updateUserScore(Long userUid, Integer score);
}
