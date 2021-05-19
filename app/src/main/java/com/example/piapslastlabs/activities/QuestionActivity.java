package com.example.piapslastlabs.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.piapslastlabs.MainActivity;
import com.example.piapslastlabs.R;
import com.example.piapslastlabs.controller.GameProcess;
import com.example.piapslastlabs.controller.QuestionRandomizer;
import com.example.piapslastlabs.model.QuestionInterface;
import com.example.piapslastlabs.model.QuestionMusic;
import com.example.piapslastlabs.model.QuestionText;
import com.example.piapslastlabs.utils.Director;
import com.example.piapslastlabs.utils.QuestionBuilder;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionActivity extends AppCompatActivity {

    GameProcess gameProcess = null;
    QuestionInterface question = null;

    Button answer1;
    Button answer2;
    Button answer3;
    Button answer4;
    Button points;
    Button level;

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                        //Старт активити с победой
                    }
                    Intent intent = new Intent(QuestionActivity.this, MapActivity.class);
                    intent.putExtra(GameProcess.class.getSimpleName(), gameProcess);
                    startActivity(intent);
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
                        //Старт активити с победой
                    }
                    Intent intent = new Intent(QuestionActivity.this, MapActivity.class);
                    intent.putExtra(GameProcess.class.getSimpleName(), gameProcess);
                    startActivity(intent);
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
                        //Старт активити с победой
                    }
                    Intent intent = new Intent(QuestionActivity.this, MapActivity.class);
                    intent.putExtra(GameProcess.class.getSimpleName(), gameProcess);
                    startActivity(intent);
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
                        //Старт активити с победой
                    }

                    Intent intent = new Intent(QuestionActivity.this, MapActivity.class);
                    intent.putExtra(GameProcess.class.getSimpleName(), gameProcess);
                    startActivity(intent);
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
            level = (Button) findViewById(R.id.level);
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
        Button pb;
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
            level = (Button) findViewById(R.id.level);
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

            pb = (Button) findViewById(R.id.play_button);
            pb.setOnClickListener(new View.OnClickListener() {
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
            level = (Button) findViewById(R.id.level);
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


    }



}
