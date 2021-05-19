package com.example.piapslastlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.piapslastlabs.activities.MapActivity;
import com.example.piapslastlabs.model.Game;

public class MainActivity extends AppCompatActivity {

    Button startButton = null;
    Button exitButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton  = (Button) findViewById(R.id.start);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game newGame = new Game();
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                intent.putExtra(Game.class.getSimpleName(),newGame);
                startActivity(intent);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

    }
}