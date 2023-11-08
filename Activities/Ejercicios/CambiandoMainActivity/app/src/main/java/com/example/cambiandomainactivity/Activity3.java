package com.example.cambiandomainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // recuperar los datos enviados desde la Activity uno desde el Intent
        Intent intent= getIntent();
        // extrae el dato
        String datoRecibido = intent.getStringExtra("mensaje");
        // Visualizarlo en la txtView
        TextView txtViewRecepcion = findViewById(R.id.txtViewActivity3);
        // Asignacion del texto a la view
        txtViewRecepcion.setText(datoRecibido);
    }
}