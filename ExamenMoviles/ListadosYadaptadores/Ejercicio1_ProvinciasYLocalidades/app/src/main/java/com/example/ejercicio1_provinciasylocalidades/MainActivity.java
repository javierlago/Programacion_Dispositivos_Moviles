package com.example.ejercicio1_provinciasylocalidades;

import static android.R.layout.simple_dropdown_item_1line;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerProvincias;
    Spinner spinnerLocalidades;
    ArrayAdapter adapterLocalidades;
    String ciudad,localidad;
    String[] arrayLocalidades;

    String[] arrayProvincias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayProvincias = getResources().getStringArray(R.array.provincias);
        spinnerProvincias = findViewById(R.id.spiner_provincias);
        spinnerLocalidades = findViewById(R.id.spiner_localidades);
        ArrayAdapter adapterProvincias = new ArrayAdapter(this, simple_dropdown_item_1line, arrayProvincias);
        spinnerProvincias.setAdapter(adapterProvincias);
        listenersSpiners();
    }

    public void listenersSpiners() {


        spinnerProvincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ciudad=arrayProvincias[position];

                switch (position) {
                    case 0: {
                        arrayLocalidades = getResources().getStringArray(R.array.localidades_ACorunha);

                        break;
                    }
                    case 1: {
                        arrayLocalidades = getResources().getStringArray(R.array.localidades_lugo);


                        break;
                    }
                    case 2: {
                        arrayLocalidades = getResources().getStringArray(R.array.localidades_pontevedra);


                        break;
                    }
                    case 3: {
                        arrayLocalidades = getResources().getStringArray(R.array.localidades_ourense);

                        break;
                    }
                }
                adapterLocalidades = new ArrayAdapter<>(MainActivity.this, simple_dropdown_item_1line, arrayLocalidades);
                spinnerLocalidades.setAdapter(adapterLocalidades);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
        spinnerLocalidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                localidad= arrayLocalidades[position];
                Toast.makeText(MainActivity.this, ciudad+localidad, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


}