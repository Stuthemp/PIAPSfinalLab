package com.example.piapslastlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.piapslastlabs.activities.MapActivity;

public class MainActivity extends AppCompatActivity {

    Button startButton = null;
    Button exitButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton  = (Button) findViewById(R.id.start);
        exitButton = (Button) findViewById(R.id.exit);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
            }
        });

    }
}