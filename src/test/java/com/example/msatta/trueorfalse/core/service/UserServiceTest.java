package com.example.msatta.trueorfalse.core.service;

import com.example.msatta.trueorfalse.core.models.User;
import com.example.msatta.trueorfalse.core.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * Created by michele on 08/11/14.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldGetUserReturnUserWithValidUid() throws Exception {
        Long validUid = 1L;
        when(userRepository.findUserByUid(validUid)).thenReturn(new User());

        User user = userService.getUser(validUid);

        assertNotNull(user);
    }

    @Test
    public void shouldGetUserReturnsNullWithInvalidUid() throws Exception {
        Long invalidUid = 2L;
        when(userRepository.findUserByUid(invalidUid)).thenReturn(null);

        User user = userService.getUser(invalidUid);

        assertNull(user);
    }

    @Test
    public void shouldCheckNameReturnFalseWhenNameAlreadyExists() throws Exception{
        String name = "name";
        when(userRepository.findUserByName(name)).thenReturn(new User());

        boolean nameExists = userService.checkName(name);

        assertTrue(nameExists);
    }

    @Test
    public void shouldCheckNameReturnTrueWhenNameDoesNotExists() throws Exception{
        String name = "name";
        when(userRepository.findUserByName(name)).thenReturn(null);

        boolean nameExists = userService.checkName(name);

        assertFalse(nameExists);
    }

    @Test
    public void shouldUpdateTheBestScoreWithTheCorrectUid() throws Exception{
        ArgumentCaptor<Long> argumentUid = ArgumentCaptor.forClass(Long.class);
        when(userRepository.updateUserScore(argumentUid.capture(), anyInt())).thenReturn(new User());

        Long uid = 1L;
        Integer score = 1;

        userService.updateScore(uid, score);

        assertEquals(uid, argumentUid.getValue());
    }

    @Test
    public void shouldUpdateTheBestScoreWithTheCorrectScore() throws Exception{
        ArgumentCaptor<Integer> argumentScore = ArgumentCaptor.forClass(Integer.class);
        when(userRepository.updateUserScore(anyLong(), argumentScore.capture())).thenReturn(new User());

        Long uid = 1L;
        Integer score = 1;

        userService.updateScore(uid, score);

        assertEquals(score, argumentScore.getValue());
    }

    @Test
    public void shouldCreateUser(){
        User user = new User();

        user.setId(10L);
        user.setUid(100L);
        user.setBestScore(90);
        user.setName("My Name");

        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        when(userRepository.createUser(argument.capture())).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertEquals(createdUser, argument.getValue());
    }

    @Test
    public void shoudreturnTopTen(){
        ArgumentCaptor<Integer> argument = ArgumentCaptor.forClass(Integer.class);
        when(userRepository.getUsersTopN(argument.capture())).thenReturn(new ArrayList<User>());

        List<User> userList = userService.getTopTen();

        Integer elements = 10;

        assertEquals(elements, argument.getValue());

    }
}
