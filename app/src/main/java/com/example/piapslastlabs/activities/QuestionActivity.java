package com.example.piapslastlabs.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.piapslastlabs.R;

public class QuestionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< Updated upstream
        setContentView(R.layout.question_theme);
=======
        setContentView(R.layout.question_layout);

        Bundle arguments = getIntent().getExtras();

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        if(arguments != null){
            gameProcess = (GameProcess) arguments.getSerializable(GameProcess.class.getSimpleName());
            question = (QuestionInterface) arguments.getSerializable(QuestionInterface.class.getSimpleName());
            Log.v("Question",  question.getAnswer1());
            if(question.hasImage())
                Director.buildQuestion(new ImageQuestionBuilder());
            else if(question.hasSound())
                Director.buildQuestion(new SoundQuestionBuilder());
            else if(question.hasText())
                Director.buildQuestion(new TextQuestionBuilder());
            else
                Log.e("Question build", "No text no sound no image :(");
        }


        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(answer1.getText()).equals(question.getAnswer1())){
                    gameProcess.addScore(question);
                    if(gameProcess.isScoreEnough()){
                        winDialog();
                    }
                    else {
                        Intent intent = new Intent(QuestionActivity.this, MapActivity.class);
                        intent.putExtra(GameProcess.class.getSimpleName(), gameProcess);
                        startActivity(intent);}
                } else {
                    lostDialog();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(answer2.getText()).equals(question.getAnswer1())){
                    gameProcess.addScore(question);
                    //Старт активити с некст мапой, или концом игры
                    if(gameProcess.isScoreEnough()){
                        winDialog();
                    }
                    else {
                        Intent intent = new Intent(QuestionActivity.this, MapActivity.class);
                        intent.putExtra(GameProcess.class.getSimpleName(), gameProcess);
                        startActivity(intent);}
                } else {
                    //Старт активити с кликером или поражением
                    lostDialog();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(answer3.getText()).equals(question.getAnswer1())){
                    gameProcess.addScore(question);
                    //Старт активити с некст мапой, или концом игры
                    if(gameProcess.isScoreEnough()){
                        winDialog();
                    }
                    else {
                    Intent intent = new Intent(QuestionActivity.this, MapActivity.class);
                    intent.putExtra(GameProcess.class.getSimpleName(), gameProcess);
                    startActivity(intent);}
                } else {
                    //Старт активити с кликером или поражением
                    lostDialog();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(answer4.getText()).equals(question.getAnswer1())){
                    gameProcess.addScore(question);
                    //Старт активити с некст мапой, или концом игры
                    if(gameProcess.isScoreEnough()){
                        winDialog();
                    }
                    else {
                        Intent intent = new Intent(QuestionActivity.this, MapActivity.class);
                        intent.putExtra(GameProcess.class.getSimpleName(), gameProcess);
                        startActivity(intent);}
                } else {
                    //Старт активити с кликером или поражением
                    lostDialog();
                }
            }
        });




    }



    public void lostDialog(){
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
        View view = layoutInflaterAndroid.inflate(R.layout.lost_layout, null);

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(QuestionActivity.this);
        alertDialogBuilderUserInput.setView(view);
        lostSound();

        alertDialogBuilderUserInput
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void winDialog(){
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
        View view = layoutInflaterAndroid.inflate(R.layout.win_layout, null);

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(QuestionActivity.this);
        alertDialogBuilderUserInput.setView(view);
        lostSound();

        alertDialogBuilderUserInput
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public class ImageQuestionBuilder implements QuestionBuilder {

        TextView tv;
        ArrayList<String> answerList;
        ImageView iv;


        @Override
        public void setAnswers() {
            answer1 = (Button) findViewById(R.id.answer1);
            answer2 = (Button) findViewById(R.id.answer2);
            answer3 = (Button) findViewById(R.id.answer3);
            answer4 = (Button) findViewById(R.id.answer4);

            if(answer1 != null) {
                answer1.setText(answerList.get(0));
                answer2.setText(answerList.get(1));
                answer3.setText(answerList.get(2));
                answer4.setText(answerList.get(3));
            }
        }

        @Override
        public void setResource() {
            tv = (TextView) findViewById(R.id.image);
            tv.setVisibility(View.INVISIBLE);
            iv = (ImageView) findViewById(R.id.actual_image);
            Drawable img = getResources().getDrawable(question.getResourceId());
            iv.setImageDrawable(img);
            //iv.setImageResource(question.getResourceId());

        }

        @Override
        public void setScore() {
            points = (Button) findViewById(R.id.points_question);
            points.setText(String.valueOf(gameProcess.getGame().getScore()));
        }

        @Override
        public void setLevel() {
            level.setText(String.valueOf(gameProcess.getGame().getLevel()));
        }

        @Override
        public ArrayList<String> shuffleQuestions() {
            answerList = new ArrayList<>(4);
            Log.v("isQNull",question.getAnswer1());
            answerList.add(question.getAnswer1());
            answerList.add(question.getAnswer2());
            answerList.add(question.getAnswer3());
            answerList.add(question.getAnswer4());
            Collections.shuffle(answerList);
            return answerList;
        }
    }

    private boolean checkAnswer(Button button){
        return String.valueOf(button.getText()).equals(question.getAnswer1());
    }

    public class SoundQuestionBuilder implements QuestionBuilder {

        QuestionMusic qi;
        ImageView iv;
        TextView tv;
        ArrayList<String> answerList;

        @Override
        public void setAnswers() {
            answer1 = (Button) findViewById(R.id.answer1);
            answer2 = (Button) findViewById(R.id.answer2);
            answer3 = (Button) findViewById(R.id.answer3);
            answer4 = (Button) findViewById(R.id.answer4);

            if(answer1 != null) {
                answer1.setText(answerList.get(0));
                answer2.setText(answerList.get(1));
                answer3.setText(answerList.get(2));
                answer4.setText(answerList.get(3));
            }
        }


        @Override
        public void setScore() {
            points = (Button) findViewById(R.id.points_question);
            points.setText(String.valueOf(gameProcess.getGame().getScore()));
        }

        @Override
        public void setLevel() {
            level.setText(String.valueOf(gameProcess.getGame().getLevel()));
        }

        @Override
        public ArrayList<String> shuffleQuestions() {
            answerList = new ArrayList<>(4);
            Log.v("isQNull",question.getAnswer1());
            answerList.add(question.getAnswer1());
            answerList.add(question.getAnswer2());
            answerList.add(question.getAnswer3());
            answerList.add(question.getAnswer4());
            Collections.shuffle(answerList);
            return answerList;
        }

        @Override
        public void setResource() {
            tv = (TextView) findViewById(R.id.image);
            tv.setVisibility(View.INVISIBLE);
            iv = (ImageView) findViewById(R.id.actual_image);
            Drawable img = getResources().getDrawable(R.drawable.note_img);


            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    releaseMediaPlayer();
                    int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                            AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        // We have audio focus now.

                        // Create and setup the {@link MediaPlayer} for the audio resource associated
                        // with the current word
                        mMediaPlayer = MediaPlayer.create(QuestionActivity.this, question.getResourceId());

                        // Start the audio file
                        mMediaPlayer.start();

                        // Setup a listener on the media player, so that we can stop and release the
                        // media player once the sound has finished playing.
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }
            });
            iv.setImageDrawable(img);
        }

    }

    public class TextQuestionBuilder implements QuestionBuilder {

        QuestionText qi;
        ArrayList<String> answerList;
        TextView tv;
        ImageView iv;

        @Override
        public void setAnswers() {
            answer1 = (Button) findViewById(R.id.answer1);
            answer2 = (Button) findViewById(R.id.answer2);
            answer3 = (Button) findViewById(R.id.answer3);
            answer4 = (Button) findViewById(R.id.answer4);

            if(answer1 != null) {
                answer1.setText(answerList.get(0));
                answer2.setText(answerList.get(1));
                answer3.setText(answerList.get(2));
                answer4.setText(answerList.get(3));
            }
        }


        @Override
        public void setScore() {
            points = (Button) findViewById(R.id.points_question);
            points.setText(String.valueOf(gameProcess.getGame().getScore()));
        }

        @Override
        public void setLevel() {
            level.setText(String.valueOf(gameProcess.getGame().getLevel()));
        }

        @Override
        public ArrayList<String> shuffleQuestions() {
            answerList = new ArrayList<>(4);
            Log.v("isQNull",question.getAnswer1());
            answerList.add(question.getAnswer1());
            answerList.add(question.getAnswer2());
            answerList.add(question.getAnswer3());
            answerList.add(question.getAnswer4());
            Collections.shuffle(answerList);
            return answerList;
        }

        @Override
        public void setResource() {
            iv = (ImageView) findViewById(R.id.actual_image);
            tv = (TextView) findViewById(R.id.image);
            tv.setText(question.getText());
        }

>>>>>>> Stashed changes

    }

public void lostSound(){
    releaseMediaPlayer();
    int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
            AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
        // We have audio focus now.

<<<<<<< Updated upstream
=======
        // Create and setup the {@link MediaPlayer} for the audio resource associated
        // with the current word
        mMediaPlayer = MediaPlayer.create(QuestionActivity.this, R.raw.lost_sound);

        // Start the audio file
        mMediaPlayer.start();

        // Setup a listener on the media player, so that we can stop and release the
        // media player once the sound has finished playing.
        mMediaPlayer.setOnCompletionListener(mCompletionListener);
    }
}

>>>>>>> Stashed changes
}
