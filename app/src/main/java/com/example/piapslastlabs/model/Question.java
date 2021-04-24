package com.example.piapslastlabs.model;


public class Question {

    private static final int NO_AUDIO_PROVIDED = -1;

    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;

    private int audioResourceId = NO_AUDIO_PROVIDED;

    Theme theme;



    boolean HAS_SOUND = false;


}
