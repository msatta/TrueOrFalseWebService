package com.example.msatta.trueorfalse.core.repository;

import com.example.msatta.trueorfalse.core.models.User;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
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
import static org.junit.Assert.assertNull;

/**
 * Created by michele on 07/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {UserRepositoryTestContext.class})
@TestExecutionListeners(listeners = {
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@Transactional
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DatabaseSetup("userRepositorySetup.xml")
    @ExpectedDatabase("userRepositoryCreateExpected.xml")
    public void shouldCreateTheUser() throws Exception {
        User testUser = new User();
        testUser.setUid(300L);
        testUser.setName("User3");
        testUser.setBestScore(30);

        userRepository.createUser(testUser);
    }

    @Test
    @DatabaseSetup("userRepositorySetup.xml")
    public void shouldFindTheTestUserById() throws Exception {
        User actualUser = userRepository.findUser(1L);

        int expectedBestScore = 10;

        assertEquals(expectedBestScore, actualUser.getBestScore());
    }

    @Test
    @DatabaseSetup("userRepositorySetup.xml")
    public void shouldFindTheTestUserByUid() throws Exception {
        User actualUser = userRepository.findUserByUid(200L);

        int expectedBestScore = 20;

        assertEquals(expectedBestScore, actualUser.getBestScore());
    }

    @Test
    @DatabaseSetup("userRepositorySetup.xml")
    public void shouldFindTheTestUserByName() throws Exception {
        User actualUser = userRepository.findUserByName("User2");

        int expectedBestScore = 20;

        assertEquals(expectedBestScore, actualUser.getBestScore());
    }

    @Test
    @DatabaseSetup("userRepositorySetup.xml")
    public void shouldNotFindUserByNameWrongName() throws Exception {
        User actualUser = userRepository.findUserByName("Wrong Name");

         assertNull(actualUser);
    }

    @Test
    @DatabaseSetup("userRepositorySetup.xml")
    public void shouldFirstTopTwoElementHasMaxBestScore() throws Exception {
        List<User> topTwo = userRepository.getUsersTopN(2);

        int expectedMaxBestScore = 20;

        assertEquals(expectedMaxBestScore, topTwo.get(0).getBestScore());
    }

    @Test
    @DatabaseSetup("userRepositorySetup.xml")
    public void shouldLastTopTwoElementHasMaxBestScore() throws Exception {
        List<User> topTwo = userRepository.getUsersTopN(2);

        int expectedMaxBestScore = 10;

        assertEquals(expectedMaxBestScore, topTwo.get(topTwo.size() - 1).getBestScore());
    }

    @Test
    @DatabaseSetup("userRepositorySetup.xml")
    public void shouldTopTwoElementHas2Elements() throws Exception {
        List<User> topTwo = userRepository.getUsersTopN(2);
        int expectedSize = 2;
        assertEquals(expectedSize, topTwo.size());
    }

    @Test
    @DatabaseSetup("userRepositorySetup.xml")
    public void shouldReturnNullWithInvalidUid() throws Exception {
        User actualUser = userRepository.findUserByUid(1200L);

        assertNull(actualUser);
    }

    @Test
    @DatabaseSetup("userRepositorySetup.xml")
    @ExpectedDatabase("userRepositoryUpdated.xml")
    public void shouldUpdateTheBestScoreOfUser(){
        User updatedUser = userRepository.updateUserScore(200L, 50);
        assertEquals(50, updatedUser.getBestScore());
    }

    @Test
    @DatabaseSetup("userRepositorySetup.xml")
    @ExpectedDatabase("userRepositorySetup.xml")
    public void shouldNotUpdateTheBestScoreOfUser(){
        User updatedUser = userRepository.updateUserScore(200L, 10);
        assertEquals(20, updatedUser.getBestScore());
    }

}
