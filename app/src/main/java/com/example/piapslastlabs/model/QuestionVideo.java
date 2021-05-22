package com.example.piapslastlabs.model;


import com.example.piapslastlabs.utils.Observer;

import java.io.Serializable;

public class QuestionVideo implements Serializable, Observer, QuestionInterface {


    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;

    int videoId;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    int id;

    private int cost;

    boolean isPlayed = false;

    private Theme theme;

    public QuestionVideo(String answer1, String answer2, String answer3, String answer4, int cost, Theme theme, int resourceId) {
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.cost = cost;
        this.theme = theme;
        videoId = resourceId;
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
        return videoId;
    }

    @Override
    public void setAvailability(boolean b) {
        isPlayed = b;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getText() {
        return "No text provided";
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
        return false;
    }

    @Override
    public boolean hasImage() {
        return false;
    }

    @Override
    public boolean hasVideo() {
        return true;
    }


}
