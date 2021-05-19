package com.example.piapslastlabs.utils;

import com.example.piapslastlabs.model.QuestionInterface;

import java.util.ArrayList;

public interface QuestionBuilder {


    void setAnswers();
    void setResource();
    void setScore();
    void setLevel();
    ArrayList<String> shuffleQuestions();

}
