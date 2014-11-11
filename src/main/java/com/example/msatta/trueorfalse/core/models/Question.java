package com.example.msatta.trueorfalse.core.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by michele on 07/11/14.
 */
@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    private String text;
    private Boolean answer;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public Boolean getAnswer() {
        return answer;
    }
}
