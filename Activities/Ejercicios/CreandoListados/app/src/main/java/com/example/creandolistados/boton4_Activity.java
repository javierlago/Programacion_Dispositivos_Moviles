package com.example.creandolistados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class boton4_Activity extends AppCompatActivity {
        Spinner spinner;
        ArrayList<String> arrayListPlanetas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton4);
        idents();
        // simulacion de la carga dinamica del Array
        arrayListPlanetas = new ArrayList<>();
        arrayListPlanetas.add("Mecurio");
        arrayListPlanetas.add("Marte");
        arrayListPlanetas.add("Pluton");
        arrayListPlanetas.add("Jupiter");
        arrayListPlanetas.add("venus");
        arrayListPlanetas.add("Urano");
        arrayListPlanetas.add("Neptuno");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrayListPlanetas);
        spinner.setAdapter(adapter);

        // Generamos el listener del spiner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // accedemos al String del array
                String planetaSeleccionado = spinner.getSelectedItem().toString();
                // podemos acceder a traves de la posicion del item
                String planetaselecionado2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(boton4_Activity.this, "Has seleccionado"+ planetaSeleccionado+ "\n Que es el item numero "+ planetaselecionado2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No tiene interes
            }
        });





    }
    public void idents(){
        spinner = findViewById(R.id.spiner4);
    }
}