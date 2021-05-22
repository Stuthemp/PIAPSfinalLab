package com.example.piapslastlabs.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.piapslastlabs.R;
import com.example.piapslastlabs.controller.GameProcess;
import com.example.piapslastlabs.model.QuestionInterface;

public class MapActivity extends AppCompatActivity {

    GameProcess gameProcess = null;

   // List<QuestionImage> questionList = new ArrayList<>();

    LinearLayout easyListView = null;
    LinearLayout normalListView = null;
    LinearLayout hardListView = null;

    ImageView easyImageView = null;
    ImageView normalImageView = null;
    ImageView hardImageView = null;


    TextView easyCost = null;
    TextView normalCost = null;
    TextView hardCost = null;

    Button score = null;

    LinearLayout easyChoice = null;
    LinearLayout normalChoice = null;
    LinearLayout hardChoice = null;

    QuestionInterface easyQuestion;
    QuestionInterface normalQuestion;
    QuestionInterface hardQuestion;

//    QuestionRandomizer questionRandomizer = new QuestionRandomizer();

   //ImageView mapImage = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);



//        questionList.add(new QuestionImage("Один","Два","Три","Четыре",100, ThemeFactory.createTheme(ThemeType.ENTERTAINMENT),R.drawable.family_older_brother));
//        questionList.add(new QuestionImage("Один","Два","Три","Четыре",200,ThemeFactory.createTheme(ThemeType.GEOGRAPHY),R.drawable.family_older_brother));
//        questionList.add(new QuestionImage("Один","Два","Три","Четыре",400,ThemeFactory.createTheme(ThemeType.HISTORY),R.drawable.family_older_brother));

        Bundle arguments = getIntent().getExtras();


        if(arguments != null){
            gameProcess = (GameProcess) arguments.getSerializable(GameProcess.class.getSimpleName());
            generateMap(gameProcess);
        }

        GameProcess finalGame = gameProcess;
        easyChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalGame.getGame().NotifyObservers(easyQuestion);
                Intent intent = new Intent(MapActivity.this,QuestionActivity.class);
                intent.putExtra(GameProcess.class.getSimpleName(), finalGame);
                intent.putExtra(QuestionInterface.class.getSimpleName(),easyQuestion);
                startActivity(intent);
            }
        });

        normalChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalGame.getGame().NotifyObservers(normalQuestion);
                Intent intent = new Intent(MapActivity.this,QuestionActivity.class);
                intent.putExtra(GameProcess.class.getSimpleName(), finalGame);
                intent.putExtra(QuestionInterface.class.getSimpleName(),normalQuestion);
                startActivity(intent);
            }
        });

        hardChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finalGame.getGame().NotifyObservers(hardQuestion);
                Intent intent = new Intent(MapActivity.this,QuestionActivity.class);
                intent.putExtra(GameProcess.class.getSimpleName(), finalGame);
                intent.putExtra(QuestionInterface.class.getSimpleName(),hardQuestion);
                startActivity(intent);
            }
        });
    }



    /** Генерим окно с картой выбора вопроса. Выбираем из базы вопросы трех разных сложностей,
     * Из вопроса узнаем стоимость(она по сути известна исходя из сложности)  и тему, оттуда
     * берем параметры для оформления.
     * @param game - Текущая игра, получаем оттуда какой сейчас ход и сколько у насочков */
    //TODO Это все вероятно надо выбросить в отдельный класс, как раз с каким-нить паттреном

    private void generateMap(GameProcess game){

        score = (Button) findViewById(R.id.score);


        score.setText(String.valueOf(game.getGame().getScore()));

        easyQuestion = game.getQuestionRandomizer().getEasyQuestion();
        normalQuestion = game.getQuestionRandomizer().getNormalQuestion();
        hardQuestion = game.getQuestionRandomizer().getHardQuestion();

        easyListView = (LinearLayout) findViewById(R.id.easy_question);
        normalListView = (LinearLayout) findViewById(R.id.normal_question);
        hardListView = (LinearLayout) findViewById(R.id.hard_question);


        easyImageView = (ImageView) findViewById(R.id.easy_image);
        normalImageView = (ImageView) findViewById(R.id.normal_image);
        hardImageView = (ImageView) findViewById(R.id.hard_image);


        easyCost = (TextView) findViewById(R.id.easy_cost);
        normalCost = (TextView) findViewById(R.id.normal_cost);
        hardCost = (TextView) findViewById(R.id.hard_cost);


        easyImageView.setImageResource(easyQuestion.getTheme().getImage());
        easyCost.setText(String.valueOf(easyQuestion.getCost()));

        normalImageView.setImageResource(normalQuestion.getTheme().getImage());
        normalCost.setText(String.valueOf(normalQuestion.getCost()));

        hardImageView.setImageResource(hardQuestion.getTheme().getImage());
        hardCost.setText(String.valueOf(hardQuestion.getCost()));


        //TODO Возможно добавить цвета для тем и раскрашивать кнопки в них
        easyChoice =  findViewById(R.id.easy_question);
        normalChoice =  findViewById(R.id.normal_question);
        hardChoice =  findViewById(R.id.hard_question);

//        easyCost.setBackgroundColor(getResources().getColor(easyQuestion.getTheme().getColor()));
//        normalCost.setBackgroundColor(getResources().getColor(normalQuestion.getTheme().getColor()));
        //hardChoice.setBackgroundColor(getResources().getColor(hardQuestion.getTheme().getColor()));

        //mapImage.setImageResource(R.drawable.doors2);

    }

    //TODO ВСЕ МЕТОДЫ НИЖЕ ЭТО ГАВНО ЗАГЛУШКИ И БУДУТ ПЕРЕДЕЛАНЫ

//    private QuestionImage getEasyQuestion() {
//        QuestionImage result = null;
//
//        for (int i = 0; i < questionList.size(); i++) {
//            if(questionList.get(i).getCost() == 100) {
//                result = questionList.get(i);
//                break;
//            }
//        }
//
//        return result;
//    }
//
//    private QuestionImage getNormalQuestion() {
//        QuestionImage result = null;
//
//        for (int i = 0; i < questionList.size(); i++) {
//            if(questionList.get(i).getCost() == 200) {
//                result = questionList.get(i);
//                break;
//            }
//        }
//
//        return result;
//    }
//
//    private QuestionImage getHardQuestion() {
//        QuestionImage result = null;
//
//        for (int i = 0; i < questionList.size(); i++) {
//            if(questionList.get(i).getCost() == 400) {
//                result = questionList.get(i);
//                break;
//            }
//        }
//
//        return result;
//    }


}