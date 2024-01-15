package com.example.creandolistados;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClickBtnListados(View view) {
        Intent i = new Intent();
        switch(view.getId()){
            case R.id.button1:
                i.setClass(this, boton1_Activity.class);
                break;

            case R.id.button2:
                i.setClass(this, boton2_Activity.class);
                break;
            case R.id.button3:
                i.setClass(this, boton3_Activity.class);
                break;
            case R.id.button4:
                i.setClass(this, boton4_Activity.class);
                break;
            case R.id.button5:
                i.setClass(this, boton5_Activity.class);
                break;

        }//startActiviy
        startActivity(i);
        
        

    }
}