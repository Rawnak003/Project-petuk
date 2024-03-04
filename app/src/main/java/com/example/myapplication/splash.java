package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
public class splash extends AppCompatActivity {
    ProgressBar progressBar;
    int time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        progressBar = findViewById(R.id.progressBarId);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });
        thread.start();
    }
    public void doWork(){
        for(time=2; time<=100; time+=2){
            try {
                Thread.sleep(40);
                progressBar.setProgress(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void startApp(){
        Intent intent = new Intent(splash.this, appLogin.class);
        startActivity(intent);
        finish();
    }
}