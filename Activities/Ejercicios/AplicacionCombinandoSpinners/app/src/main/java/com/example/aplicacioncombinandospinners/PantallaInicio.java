package com.example.aplicacioncombinandospinners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PantallaInicio extends AppCompatActivity {
    Spinner spinnerInicial;
    String[] opciones = {"Spiner","ListView"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerInicial = findViewById(R.id.spinner_inicial);
        ArrayAdapter <String> adapter = new ArrayAdapter<>(PantallaInicio.this, android.R.layout.simple_spinner_dropdown_item,opciones);
        spinnerInicial.setAdapter(adapter);
        spinnerInicial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}