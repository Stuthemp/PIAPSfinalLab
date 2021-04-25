package com.example.piapslastlabs.model;


import java.io.Serializable;

public interface QuestionInterface extends Serializable , Observer {

    @Override
    public void update(int id);

    public int getCost();

    public void setCost(int cost);

    public String getAnswer1();

    public void setAnswer1(String answer1);

    public String getAnswer2();

    public void setAnswer2(String answer2);

    public String getAnswer3();

    public void setAnswer3(String answer3);

    public String getAnswer4();

    public void setAnswer4(String answer4);

    public int getAudioResourceId();

    public void setAudioResourceId(int audioResourceId);

    public Theme getTheme();

    public void setTheme(Theme theme);

    boolean HAS_SOUND = false;



}
