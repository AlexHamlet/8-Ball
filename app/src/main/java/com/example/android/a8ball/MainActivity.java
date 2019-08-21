package com.example.android.a8ball;

import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> answer = new ArrayList<>();
    private static final int SHAKE_THRESHOLD = 800;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAnswers();
    }

    private void initAnswers(){
        answer.add("It is certain.");
        answer.add("It is decidedly so.");
        answer.add("Without a doubt.");
        answer.add("Yes - Definitely");
        answer.add("You may rely on it.");

        answer.add("As I see it, yes");
        answer.add("Most likely.");
        answer.add("Outlook good.");
        answer.add("Yes.");
        answer.add("Signs point to yes.");

        answer.add("Reply hazy, try again.");
        answer.add("Ask again later.");
        answer.add("Better not tell you now.");
        answer.add("Cannot predict now.");
        answer.add("Concentrate and ask again.");

        answer.add("Don't count on it");
        answer.add("My reply is no.");
        answer.add("My sources say no.");
        answer.add("Outlook not so good.");
        answer.add("Very doubtful.");
    }

    public void showAnswer(View v){
        TextView tv = findViewById(R.id.txtvAnswer);
        tv.setText(answer.get((int)Math.floor(Math.random() * answer.size())));
    }
}
