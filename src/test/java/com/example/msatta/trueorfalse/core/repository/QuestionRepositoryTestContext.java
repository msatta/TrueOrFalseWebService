package com.example.msatta.trueorfalse.core.repository;

import com.example.msatta.trueorfalse.core.repository.jpa.JpaQuestionRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;

/**
 * Created by michele on 07/11/14.
 */
@EntityScan(basePackages = "com.example.msatta.trueorfalse.core.models")
@EnableAutoConfiguration
public class QuestionRepositoryTestContext {

    @Bean
    public QuestionRepository getQuestionRepository(){
        return new JpaQuestionRepository();
    }
}
