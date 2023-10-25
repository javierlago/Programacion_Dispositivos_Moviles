package com.example.cuentaclicks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView contador;
    Button btnSumar;
    int clicks = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = findViewById(R.id.numeroDeClicks);
        btnSumar = findViewById(R.id.btnSumar);
        btnSumar.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        clicks +=1;
        contador.setText("Has pulsado " + clicks);


    }
}