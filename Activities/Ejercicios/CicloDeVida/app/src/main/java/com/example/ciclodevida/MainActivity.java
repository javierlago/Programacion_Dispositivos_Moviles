package com.example.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"Se ejecuta on create",Toast.LENGTH_SHORT).show();

        setContentView(R.layout.activity_main);
        Log.i("cicloDevida","Ejecuto on Crate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Se ejecuta on start",Toast.LENGTH_SHORT).show();
        Log.i("cicloDevida","Ejecuto on Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"Se ejecuta on stop",Toast.LENGTH_SHORT).show();
        Log.i("cicloDevida","Ejecuto on Stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"Se ejecuta on restarr",Toast.LENGTH_SHORT).show();
        Log.i("cicloDevida","Ejecuto on Restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"Se ejecuta on Pause",Toast.LENGTH_SHORT).show();
        Log.i("cicloDevida","Ejecuto on Pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Se ejecuta on Destroy",Toast.LENGTH_SHORT).show();
        Log.i("cicloDevida","Ejecuto on Destroy");

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Toast.makeText(this,"Se ejecuta on Resume",Toast.LENGTH_SHORT).show();
        Log.i("cicloDevida","Ejecuto on Resume");
    }

    public void finalizer(View view) {
        finish();
    }
}