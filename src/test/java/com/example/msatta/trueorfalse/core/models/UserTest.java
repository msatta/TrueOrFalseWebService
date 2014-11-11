package com.example.msatta.trueorfalse.core.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by michele on 07/11/14.
 */
public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void testIdGetterAndSetter() throws Exception {
        Long id = 1L;
        user.setId(id);

        assertEquals(id, user.getId());
    }

    @Test
    public void testUidGetterAndSetter() throws Exception {
        Long uid = 2L;
        user.setUid(uid);

        assertEquals(uid, user.getUid());
    }

    @Test
    public void testBestScoreGetterAndSetter() throws Exception {
        int bestScore = 100;
        user.setBestScore(bestScore);

        assertEquals(bestScore, user.getBestScore());
    }

    @Test
    public void testNameGetterAndSetter() throws Exception {
        String name = "Name";
        user.setName(name);

        assertEquals(name, user.getName());

    }
}
