package com.example.creandolistados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class boton3_Activity extends AppCompatActivity {
    private Spinner spPlanteas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton3);
        idents();
        // metodo create from resource
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.planetas, android.R.layout.simple_spinner_dropdown_item);
        //
        // Array Adapter Tipado
        ArrayAdapter<String> adaptadorUno = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.planetas));


        spPlanteas.setAdapter(adaptadorUno);



        // Generamos el listener del spiner
        spPlanteas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // accedemos al String del array
                String planetaSeleccionado = spPlanteas.getSelectedItem().toString();
                // podemos acceder a traves de la posicion del item
                String planetaselecionado2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(boton3_Activity.this, "Has seleccionado"+ planetaSeleccionado+ "\n Que es el item numero "+ planetaselecionado2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No tiene interes
            }
        });




    }

    public void idents(){

        spPlanteas = findViewById(R.id.spnPlanetas3);

    }
}