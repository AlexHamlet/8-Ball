package com.example.android.a8ball;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> answer = new ArrayList<>();
    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAnswers();

        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
                TextView tv = findViewById(R.id.txtvAnswer);
                tv.setText(answer.get((int)Math.floor(Math.random() * answer.size())));
                //handleShakeEvent(count);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
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
