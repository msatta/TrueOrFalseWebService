package com.example.msatta.trueorfalse.rest;

import com.example.msatta.trueorfalse.core.models.User;
import com.example.msatta.trueorfalse.core.service.QuestionService;
import com.example.msatta.trueorfalse.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by michele on 08/11/14.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/auth/{uid}")
    public @ResponseBody User checkUserAuthentication(@PathVariable long uid){

        User user = userService.getUser(uid);

        if(user == null) {
            user = new User();
            user.setUid(uid);
        }

        return user;
    }

    @RequestMapping("/user/registration/{uid}/{name}")
    public @ResponseBody User checkNameNewUser(@PathVariable long uid, @PathVariable String name){
        User user = new User();
        user.setName(name);
        user.setUid(uid);
        user.setBestScore(0);

        if(!userService.checkName(name)) {
            user = userService.createUser(user);
        }

        return user;
    }


}
