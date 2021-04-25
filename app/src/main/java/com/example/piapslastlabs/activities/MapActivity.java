package com.example.piapslastlabs.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.piapslastlabs.R;
import com.example.piapslastlabs.model.*;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity {


    List<QuestionInterface> questionList = new ArrayList<>();

    LinearLayout easyListView = null;
    LinearLayout normalListView = null;
    LinearLayout hardListView = null;

    ImageView easyImageView = null;
    ImageView normalImageView = null;
    ImageView hardImageView = null;

    TextView easyTextView = null;
    TextView normalTextView = null;
    TextView hardTextView = null;

    TextView easyCost = null;
    TextView normalCost = null;
    TextView hardCost = null;

    Button score = null;
    Button level = null;

    Button easyChoice = null;
    Button normalChoice = null;
    Button hardChoice = null;

    QuestionInterface easyQuestion;
    QuestionInterface normalQuestion;
    QuestionInterface hardQuestion;

   //ImageView mapImage = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        questionList.add(new QuestionText("Один","Два","Три","Четыре",100,new Theme("Математика",R.drawable.family_father,R.color.category_math)));
        questionList.add(new QuestionText("Один","Два","Три","Четыре",200,new Theme("Математика",R.drawable.family_daughter,R.color.category_math)));
        questionList.add(new QuestionText("Один","Два","Три","Четыре",400,new Theme("Математика",R.drawable.family_grandfather,R.color.category_math)));

        Bundle arguments = getIntent().getExtras();
        Game game = null;

        if(arguments != null){
            game = (Game) arguments.getSerializable(Game.class.getSimpleName());
            generateMap(game);
        }

        Game finalGame = game;
        easyChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this,QuestionActivity.class);
                intent.putExtra(Game.class.getSimpleName(), finalGame);
                intent.putExtra(QuestionInterface.class.getSimpleName(),easyQuestion);
                startActivity(intent);
            }
        });
    }



    /** Генерим окно с картой выбора вопроса. Выбираем из базы вопросы трех разных сложностей,
     * Из вопроса узнаем стоимость(она по сути известна исходя из сложности)  и тему, оттуда
     * берем параметры для оформления.
     * @param game - Текущая игра, получаем оттуда какой сейчас ход и сколько у насочков */
    //TODO Это все вероятно надо выбросить в отдельный класс, как раз с каким-нить паттреном

    private void generateMap(Game game){

        score = (Button) findViewById(R.id.score);
        level = (Button) findViewById(R.id.level);

        score.setText(String.valueOf(game.getScore()));
        level.setText(String.valueOf(game.getLevel()));

        easyQuestion = getEasyQuestion();
        normalQuestion = getNormalQuestion();
        hardQuestion = getHardQuestion();

        easyListView = (LinearLayout) findViewById(R.id.easy_question);
        normalListView = (LinearLayout) findViewById(R.id.normal_question);
        hardListView = (LinearLayout) findViewById(R.id.hard_question);


        easyImageView = (ImageView) findViewById(R.id.easy_image);
        normalImageView = (ImageView) findViewById(R.id.normal_image);
        hardImageView = (ImageView) findViewById(R.id.hard_image);

        easyTextView = (TextView) findViewById(R.id.easy_theme_name);
        normalTextView = (TextView) findViewById(R.id.normal_theme_name);
        hardTextView = (TextView) findViewById(R.id.hard_theme_name);

        easyCost = (TextView) findViewById(R.id.easy_cost);
        normalCost = (TextView) findViewById(R.id.normal_cost);
        hardCost = (TextView) findViewById(R.id.hard_cost);

        easyImageView.setImageResource(easyQuestion.getTheme().getImage());
        easyTextView.setText(easyQuestion.getTheme().getName());
        easyCost.setText(String.valueOf(easyQuestion.getCost()));

        normalImageView.setImageResource(normalQuestion.getTheme().getImage());
        normalTextView.setText(normalQuestion.getTheme().getName());
        normalCost.setText(String.valueOf(normalQuestion.getCost()));

        hardImageView.setImageResource(hardQuestion.getTheme().getImage());
        hardTextView.setText(hardQuestion.getTheme().getName());
        hardCost.setText(String.valueOf(hardQuestion.getCost()));


        //TODO Возможно добавить цвета для тем и раскрашивать кнопки в них
        easyChoice = (Button) findViewById(R.id.easy_choice);
        normalChoice = (Button) findViewById(R.id.normal_choice);
        hardChoice = (Button) findViewById(R.id.hard_choice);

        easyChoice.setBackgroundColor(getResources().getColor(easyQuestion.getTheme().getColor()));
        normalChoice.setBackgroundColor(getResources().getColor(normalQuestion.getTheme().getColor()));
        hardChoice.setBackgroundColor(getResources().getColor(hardQuestion.getTheme().getColor()));

        //mapImage.setImageResource(R.drawable.doors2);

    }

    //TODO ВСЕ МЕТОДЫ НИЖЕ ЭТО ГАВНО ЗАГЛУШКИ И БУДУТ ПЕРЕДЕЛАНЫ

    private QuestionInterface getEasyQuestion() {
        QuestionInterface result = null;

        for (int i = 0; i < questionList.size(); i++) {
            if(questionList.get(i).getCost() == 100) {
                result = questionList.get(i);
                break;
            }
        }

        return result;
    }

    private QuestionInterface getNormalQuestion() {
        QuestionInterface result = null;

        for (int i = 0; i < questionList.size(); i++) {
            if(questionList.get(i).getCost() == 200) {
                result = questionList.get(i);
                break;
            }
        }

        return result;
    }

    private QuestionInterface getHardQuestion() {
        QuestionInterface result = null;

        for (int i = 0; i < questionList.size(); i++) {
            if(questionList.get(i).getCost() == 400) {
                result = questionList.get(i);
                break;
            }
        }

        return result;
    }


}