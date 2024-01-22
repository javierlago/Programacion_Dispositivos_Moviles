package com.example.creandolistados.spiners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.creandolistados.R;

public class boton1_Activity extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton1);
    idents();
    // Generamos el listener del spiner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // accedemos al String del array
                String planetaSeleccionado = spinner.getSelectedItem().toString();
                // podemos acceder a traves de la posicion del item
                String planetaselecionado2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(boton1_Activity.this, "Has seleccionado"+ planetaSeleccionado+ "\n Que es el item numero "+ planetaselecionado2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No tiene interes
            }
        });



    }
    public void idents(){
        spinner = findViewById(R.id.spnPlanetas1);


    }


}