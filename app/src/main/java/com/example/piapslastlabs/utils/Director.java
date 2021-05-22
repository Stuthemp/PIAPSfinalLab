package com.example.piapslastlabs.utils;

import android.util.Log;

public class Director {

    public static void buildQuestion(QuestionBuilder builder) {
        builder.shuffleQuestions();
        Log.v("Director", "Shuffled");
        builder.setAnswers();
        Log.v("Director", "get Answered");
        builder.setResource();
        Log.v("Director", "get Recourseres");
        builder.setScore();
        Log.v("Director", "get scored");
    }

}
