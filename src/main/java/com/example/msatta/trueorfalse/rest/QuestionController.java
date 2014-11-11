package com.example.msatta.trueorfalse.rest;

import com.example.msatta.trueorfalse.core.models.Question;
import com.example.msatta.trueorfalse.core.models.User;
import com.example.msatta.trueorfalse.core.service.QuestionService;
import com.example.msatta.trueorfalse.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michele on 09/11/14.
 */
@RestController
@RequestMapping("/game")
public class QuestionController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/question/{uid}")
    public @ResponseBody
    List<Question> sendQuestionList(@PathVariable long uid){
        List<Question> questions = new ArrayList<Question>();

        if(userService.getUser(uid) != null){
            questions = questionService.get20Questions();
        }

        return questions;
    }

    @RequestMapping("/score/{uid}/{score}")
    public @ResponseBody
    List<User> sendQuestionList(@PathVariable long uid, @PathVariable int score){
        List<User> topTen = new ArrayList<User>();

        if(userService.getUser(uid) != null){
            userService.updateScore(uid, score);

            topTen = userService.getTopTen();
        }

        return topTen;
    }

}
