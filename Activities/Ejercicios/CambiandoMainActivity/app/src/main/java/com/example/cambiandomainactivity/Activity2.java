package com.example.cambiandomainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Log.i("cicloDevida","Ejecuto onCrate activity 2");
    }
    protected void onStart() {
        super.onStart();
        Log.i("cicloDevida","Ejecuto on Start Activity 2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("cicloDevida","Ejecuto on Stop Activity 2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("cicloDevida","Ejecuto on Restart Activity 2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("cicloDevida","Ejecuto on Pause Activity 2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("cicloDevida","Ejecuto on Destroy Activity 2");

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i("cicloDevida","Ejecuto on Resume Activity 2");
    }
}