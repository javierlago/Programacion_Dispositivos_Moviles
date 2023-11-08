package com.example.cambiandomainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity5 extends AppCompatActivity {
    private Button btnRetorno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        btnRetorno = findViewById(R.id.btn_enviar_respueta);
        btnRetorno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // volver a la actividad uno enviandole un dato
                String datoRespuesta = "Esto es la respuesta de la actividad 5";
                // Creamos en Intent para devolver los datos
                Intent intent = new Intent();
                // Metemos el dato a enviar dentro del Intent
                intent.putExtra("mensaje", datoRespuesta);
                // Seteamos el resultado
                setResult(RESULT_OK,intent);
                // Destruimos la activity
                finish();

            }
        });
    }



}