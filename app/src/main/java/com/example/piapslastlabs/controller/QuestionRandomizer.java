package com.example.piapslastlabs.controller;

import com.example.piapslastlabs.data.QuestionsDatabase;
import com.example.piapslastlabs.model.QuestionImage;
import com.example.piapslastlabs.model.QuestionInterface;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class QuestionRandomizer implements Serializable {

    QuestionsDatabase questionsDatabase = QuestionsDatabase.getInstance();
    List<QuestionInterface> questionList = questionsDatabase.questionsList;

    public List<QuestionInterface> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionInterface> questionList) {
        this.questionList = questionList;
    }

    public QuestionInterface getEasyQuestion() {
        QuestionInterface result = null;
        Collections.shuffle(questionList);

        for (int i = 0; i < questionList.size(); i++) {
            if(questionList.get(i).getCost() == 100 && questionList.get(i).isAvailable()) {
                result = questionList.get(i);
                questionList.get(i).setAvailability(true);
                break;
            }
        }

        return result;
    }

    public QuestionInterface getNormalQuestion() {
        QuestionInterface result = null;
        Collections.shuffle(questionList);

        for (int i = 0; i < questionList.size(); i++) {
            if(questionList.get(i).getCost() == 200 && questionList.get(i).isAvailable()) {
                result = questionList.get(i);
                questionList.get(i).setAvailability(true);
                break;
            }
        }

        return result;
    }

    public QuestionInterface getHardQuestion() {
        QuestionInterface result = null;
        Collections.shuffle(questionList);

        for (int i = 0; i < questionList.size(); i++) {
            if(questionList.get(i).getCost() == 400 && questionList.get(i).isAvailable() && questionList.get(i).hasVideo()) {
                result = questionList.get(i);
                questionList.get(i).setAvailability(true);
                break;
            }
        }

        return result;
    }


}
