package com.example.piapslastlabs.model;


import java.io.Serializable;

public class QuestionMusic implements QuestionInterface, Serializable, Observer {


    private static final int NO_AUDIO_PROVIDED = -1;

    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;

    int id;

    private int cost;

    boolean isPlayed = false;

    private int audioResourceId = 0;

    private Theme theme;

    public QuestionMusic(String answer1, String answer2, String answer3, String answer4, int cost, Theme theme, int audioResourceId) {
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.cost = cost;
        this.theme = theme;
        this.audioResourceId = audioResourceId;
    }

    @Override
    public void update(int id) {
        if(id == this.id)
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

<<<<<<< Updated upstream
=======
    @Override
    public int getResourceId() {
        return audioResourceId;
    }

>>>>>>> Stashed changes
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

    boolean HAS_SOUND = true;



}
