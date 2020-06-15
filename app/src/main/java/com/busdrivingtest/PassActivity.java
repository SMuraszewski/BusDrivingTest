package com.busdrivingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassActivity extends AppCompatActivity {

    private TextView textViewScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);

        Intent data = getIntent();

        int score = data.getIntExtra(TestActivity.NEW_SCORE, 0);
        textViewScore = findViewById(R.id.text_view_score);

        textViewScore.setText("Uzyskano " + score + " punktów, test zaliczony.");

        Button buttonStartQuiz = findViewById(R.id.button_start_screen);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScreen();
            }
        });
    }

    //intent to switch between screens - going to the start screen
    private void startScreen() {
        Intent intent = new Intent(PassActivity.this, StartScreenActivity.class);
        startActivity(intent);
    }

}

