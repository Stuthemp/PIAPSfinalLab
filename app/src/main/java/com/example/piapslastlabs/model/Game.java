package com.example.piapslastlabs.model;

import com.example.piapslastlabs.utils.Observable;
import com.example.piapslastlabs.utils.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable, Observable {

    private final int SCORE_FOR_WIN = 1600;

    private int score = 0;




    //Это колисество ходов
    private int level = 1;

    List<Observer> observers;



    private boolean hasFiftyFiftyPrompt;
    private boolean hasProbabilityPrompt;

    private boolean hasMinusOnePrompt;

    public Game() {

        observers = new ArrayList<>();

    }

    public void addScore(int score){
        this.score += score;
    }

    @Override
    public void RegisterObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void RemoveObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void NotifyObservers(QuestionInterface  questionInterface) {
        for (Observer o: observers)
        {
            o.update(questionInterface);
        }
    }


    public void increaseLvl(){
        level++;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSCORE_FOR_WIN() {
        return SCORE_FOR_WIN;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isHasFiftyFiftyPrompt() {
        return hasFiftyFiftyPrompt;
    }

    public void setHasFiftyFiftyPrompt(boolean hasFiftyFiftyPrompt) {
        this.hasFiftyFiftyPrompt = hasFiftyFiftyPrompt;
    }

    public boolean isHasProbabilityPrompt() {
        return hasProbabilityPrompt;
    }

    public void setHasProbabilityPrompt(boolean hasProbabilityPrompt) {
        this.hasProbabilityPrompt = hasProbabilityPrompt;
    }

    public boolean isHasMinusOnePrompt() {
        return hasMinusOnePrompt;
    }

    public void setHasMinusOnePrompt(boolean hasMinusOnePrompt) {
        this.hasMinusOnePrompt = hasMinusOnePrompt;
    }


}
