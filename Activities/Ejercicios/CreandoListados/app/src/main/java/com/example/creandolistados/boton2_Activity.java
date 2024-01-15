package com.example.creandolistados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class boton2_Activity extends AppCompatActivity {
    Spinner spiner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton2);
        idents();
        String[] arrayPlanetas ={"Mercurio","Venus","Tierra","Marte","Júpiter","Saturno","Urano","Neptuno"};

        // Array Adapter Tipado
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,arrayPlanetas);
        //asignar el adapatador al spiner
        spiner2.setAdapter(adaptador);

        spiner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // accedemos al String del array
                String planetaSeleccionado = spiner2.getSelectedItem().toString();
                // podemos acceder a traves de la posicion del item
                String planetaselecionado2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(boton2_Activity.this, "Has seleccionado"+ planetaSeleccionado+ "\n Que es el item numero "+ planetaselecionado2, Toast.LENGTH_SHORT).show();



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No tiene interes
            }
        });

    }

    public void idents(){
        spiner2 = findViewById(R.id.spnPlanetas2);


    }

}