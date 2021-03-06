package com.example.piapslastlabs.model;

import com.example.piapslastlabs.utils.Observer;

import java.io.Serializable;

public class QuestionText implements QuestionInterface, Serializable, Observer {

    private static final int NO_AUDIO_PROVIDED = -1;

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;

    int id;

    private int cost;

    boolean isPlayed = false;

    private int audioResourceId = NO_AUDIO_PROVIDED;

    private Theme theme;


    public QuestionText(String question,String answer1, String answer2, String answer3, String answer4, int cost, Theme theme) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.cost = cost;
        this.theme = theme;
    }

    @Override
    public void update(QuestionInterface questionInterface) {
        if(questionInterface.equals(this))
            isPlayed = true;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public static int getNoAudioProvided() {
        return NO_AUDIO_PROVIDED;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String answer1) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    @Override
    public int getResourceId() {
        return 0;
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }

    public void setAudioResourceId(int audioResourceId) {
        this.audioResourceId = audioResourceId;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public void setAvailability(boolean b) {
        isPlayed = b;
    }

    @Override
    public String getText() {
        return question;
    }

    @Override
    public boolean isAvailable() {
        return !isPlayed;
    }

    @Override
    public boolean hasSound() {
        return false;
    }

    @Override
    public boolean hasText() {
        return true;
    }


    @Override
    public boolean hasImage() {
        return false;
    }

    boolean HAS_SOUND = false;



}
