package com.example.creandolistados;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class boton5_Activity extends AppCompatActivity implements View.OnClickListener {

    Button botonAceptar;
    Spinner spinerPlanetas;
    EditText textoIntroducir;


    ArrayList<String> arrayListPlanetas;

    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton5);
        idents();
        listeners();
        arrayListPlanetas = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrayListPlanetas);
        spinerPlanetas.setAdapter(adapter);
        spinerPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // accedemos al String del array
                String planetaSeleccionado = spinerPlanetas.getSelectedItem().toString();
                // podemos acceder a traves de la posicion del item
                String planetaselecionado2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(boton5_Activity.this, "Has seleccionado" + planetaSeleccionado + "\n Que es el item numero " + planetaselecionado2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No tiene interes
            }
        });


    }

    public void idents() {
        botonAceptar = findViewById(R.id.botonAceptar);
        spinerPlanetas = findViewById(R.id.spiner5);
        textoIntroducir = findViewById(R.id.texto_anadir);

    }

    public void listeners() {
        botonAceptar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == botonAceptar.getId() & textoIntroducir.getText().toString().equals("")) {
            Toast.makeText(this, "Debes de introducir un valor en la caja de texto", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == botonAceptar.getId() & !textoIntroducir.getText().toString().equals("")) {
            arrayListPlanetas.add(textoIntroducir.getText().toString());
            if (spinerPlanetas.getVisibility() == View.GONE)
                spinerPlanetas.setVisibility(View.VISIBLE);
            textoIntroducir.setText("");
            adapter.notifyDataSetChanged();
        }
    }
}