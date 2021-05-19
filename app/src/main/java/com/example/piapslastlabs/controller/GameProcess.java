package com.example.piapslastlabs.controller;

import com.example.piapslastlabs.model.Game;
import com.example.piapslastlabs.model.QuestionInterface;

import java.io.Serializable;

public class GameProcess implements Serializable {

    private  Game game;
    private QuestionRandomizer questionRandomizer;

    public QuestionRandomizer getQuestionRandomizer() {
        return questionRandomizer;
    }

    public void setQuestionRandomizer(QuestionRandomizer questionRandomizer) {
        this.questionRandomizer = questionRandomizer;
    }

    public  Game getGame() {
        return game;
    }

    public  void setGame(Game game) {
        this.game = game;
    }

    public GameProcess(){
        game = new Game();
        questionRandomizer = new QuestionRandomizer();
    }


    public void resetGame() {
        this.game = new Game();
    }



    public void addScore(QuestionInterface q){

        game.addScore(q.getCost());

    }

    public void fiftyFiftyPromptUsed(){
        game.setHasFiftyFiftyPrompt(false);
    }

    public void probabilityPromptUsed(){
        game.setHasProbabilityPrompt(false);
    }

    public void minusOnePrompUsed(){
        game.setHasMinusOnePrompt(false);
    }

    public void turnDone(){
        game.increaseLvl();
    }

    public boolean isScoreEnough(){
        return game.getScore() >= game.getSCORE_FOR_WIN();
    }

}
