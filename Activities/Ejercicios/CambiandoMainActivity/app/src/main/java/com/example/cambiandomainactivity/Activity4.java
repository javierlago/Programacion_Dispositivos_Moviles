package com.example.cambiandomainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        // recuperamos datos mediante Bundle
        Intent intent = getIntent();
        // Extraemos el Bundle
        Bundle bundle = intent.getExtras();
        // recuperamos el dato del paquete
        String datoRecibido = bundle.getString("mensaje");
        TextView textView = findViewById(R.id.txtViewActivity4);
        textView.setText(datoRecibido);




    }
}