package com.example.cuentaclicks;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
        // recuperar datos desde el parameetro bunlde del metodo onCreate
        if (savedInstanceState != null) {
            clicks = savedInstanceState.getInt("contador");
            contador.setText("Has pulsado " + clicks);
        }


    }


    @Override
    public void onSaveInstanceState( @NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("contador", clicks);
    }

    //  @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        clicks = savedInstanceState.getInt("contador");
//        contador.setText("Has pulsado " + clicks);
//
//    }
    @Override
    public void onClick(View view) {
        clicks++;
        contador.setText("Has pulsado " + clicks);


    }


}