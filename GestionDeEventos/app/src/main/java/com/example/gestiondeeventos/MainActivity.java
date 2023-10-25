package com.example.gestiondeeventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvMensaje;
    Button btnSi, btnNo, btnAveces, btnNose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMensaje = findViewById(R.id.tvMsg);
        btnSi = findViewById(R.id.btnSi);
        btnNo = findViewById(R.id.btnNo);
        btnNose = findViewById(R.id.btnNose);
        btnAveces = findViewById(R.id.btnAveces);
        // Instaciamoos el objeto de la clase auxiliar (que implementa la interfaz) ->> Objeto escuchador
        Auxiliar listener = new Auxiliar();
        // Asignamos el listener a la vista correspondiente
        btnSi.setOnClickListener(listener);
        btnNo.setOnClickListener(listenerNo);
        // METODO 3(3 n 1) Creacion del escuchador y asignacion a la view en una sola sentencia

        btnAveces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMensaje.setText("Has puldado a veces");
            }
        });

        // METODO 4 Se ha creado directamente en la propia clase impementando la interface
        btnNose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        tvMensaje.setText("Has puldado a nose");
    }

    // Metodo 1 Crear una clase aux para implementar la interfaz
    private class Auxiliar implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            tvMensaje.setText("Has pulsado si");

        }


    }

    // Metodo 2 Crear un objeto escuchador mediante una clase anonima
    private View.OnClickListener listenerNo = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tvMensaje.setText("Has puldado no");

        }
    };


}