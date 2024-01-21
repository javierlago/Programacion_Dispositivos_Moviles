package com.example.creandolistados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Activity_autocompletar_provincias extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocompletar_provincias);
        autoCompleteTextView = findViewById(R.id.txt_view_atucompletar_prov);
        spinner = findViewById(R.id.spn_auto_ciudades);
        ArrayList<String> listaDeCiudades = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,listaDeCiudades);
        ArrayAdapter<String> stringAdapterView = new ArrayAdapter<>(Activity_autocompletar_provincias.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Provincias_segundo_ejercicio));
        autoCompleteTextView.setAdapter(stringAdapterView);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String provincia = autoCompleteTextView.getText().toString();
                switch (provincia) {
                    case "Pontevedra":
                        listaDeCiudades.clear();
                        listaDeCiudades.addAll(Arrays.asList(getResources().getStringArray(R.array.CiudadesPontevedra)));
                        break;
                    case "A Coruña":
                        listaDeCiudades.clear();
                        listaDeCiudades.addAll(Arrays.asList(getResources().getStringArray(R.array.CiudadesCorunha)));
                        break;
                    case "Lugo":
                        listaDeCiudades.clear();
                        listaDeCiudades.addAll(Arrays.asList(getResources().getStringArray(R.array.CiudadesLugo)));
                        break;
                    case "Ourense":
                        listaDeCiudades.clear();
                        listaDeCiudades.addAll(Arrays.asList(getResources().getStringArray(R.array.CiudadesOurense)));
                        break;
                    default:
                        listaDeCiudades.clear();
                        listaDeCiudades.add("No tenemos ciudades");
                        break;

                }
                // Mueve la línea fuera del switch
                adapter.notifyDataSetChanged(); // Añadido para notificar al adaptador que los datos cambiaron
            }
        });
        spinner.setAdapter(adapter);

// Mueve la línea fuera del onItemClick

        // Generamos el listener del spiner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // accedemos al String del array
                String localaliidadSeleccionada = spinner.getSelectedItem().toString();
                // podemos acceder a traves de la posicion del item
                Toast.makeText(Activity_autocompletar_provincias.this, "Has seleccionado"+ localaliidadSeleccionada+ "\n Que es el item numero "+ autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No tiene interes
            }
        });



    }
}