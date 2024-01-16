package com.example.creandolistados;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Provincias_Activity extends AppCompatActivity {
    Spinner spinnerProvincias;
    Spinner spinnerCiudades;
    ArrayAdapter<String> adaptadorProvincias;
    ArrayAdapter<String> adaptadorCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provincias);
        spinnerProvincias = findViewById(R.id.spinerProvincias);
        spinnerCiudades = findViewById(R.id.spinerCiudades);
        ArrayList<String> ciudades = new ArrayList<>();
        adaptadorProvincias = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.Provincias));
        spinnerProvincias.setAdapter(adaptadorProvincias);
        spinnerProvincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        spinnerCiudades.setAdapter(adaptadorCiudades);
                        ciudades.addAll(Arrays.asList(getResources().getStringArray(R.array.CiudadesPontevedra)));
                        adaptadorCiudades= new ArrayAdapter<String>(Provincias_Activity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.CiudadesPontevedra));
                        break;
                    case 1:
                        adaptadorCiudades = new ArrayAdapter<String>(Provincias_Activity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.CiudadesCorunha));
                        spinnerCiudades.setAdapter(adaptadorCiudades);
                        break;
                    case 2:
                        adaptadorCiudades = new ArrayAdapter<String>(Provincias_Activity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.CiudadesLugo));
                        spinnerCiudades.setAdapter(adaptadorCiudades);
                        break;
                    case 3:
                        adaptadorCiudades = new ArrayAdapter<String>(Provincias_Activity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.CiudadesOurense));
                        spinnerCiudades.setAdapter(adaptadorCiudades);                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + spinnerCiudades.getSelectedItemPosition());
                }
                Toast.makeText(Provincias_Activity.this, "Ciudad  " + spinnerProvincias.getSelectedItem().toString() + "  Localidad  " + spinnerCiudades.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No tiene interes
            }
        });

        spinnerCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Provincias_Activity.this, "Ciudad  " + spinnerProvincias.getSelectedItem().toString() + "  Localidad  " + spinnerCiudades.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No tiene interes
            }
        });




    }
}