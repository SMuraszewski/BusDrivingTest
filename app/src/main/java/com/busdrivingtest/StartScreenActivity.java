//Bus Driving Test
//made by Sebastian Muraszewski and Piotr Prusik
// (C) 2020


package com.busdrivingtest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class StartScreenActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStartQuiz = findViewById(R.id.button_start_test);
        Button buttonStartLearn = findViewById(R.id.button_start_learn);

        buttonStartQuiz.setOnClickListener(this);
        buttonStartLearn.setOnClickListener(this);
    }
        //actions of buttons
        @Override
        public void onClick(View v){
            switch (v.getId()) {
                case R.id.button_start_test:
                    startQuiz();
                    break;
                case R.id.button_start_learn:
                    startLearn();
                    break;
            }
        }

    //intent to switch between screens - going to the test
    private void startQuiz() {
        Intent intent = new Intent(StartScreenActivity.this, TestActivity.class);
        startActivity(intent);
    }

    //intent to switch between screens - going to the learn mode
    private void startLearn() {
        Intent intent = new Intent(StartScreenActivity.this, LearnActivity.class);
        startActivity(intent);
    }


}
