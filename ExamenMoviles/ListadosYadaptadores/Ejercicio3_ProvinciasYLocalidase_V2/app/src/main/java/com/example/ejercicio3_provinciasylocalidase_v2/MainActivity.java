package com.example.ejercicio3_provinciasylocalidase_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextViewProvincias;
    Spinner spinnerLocalidades;

    String[] arrayDeProvincias;
    ArrayList<String> listaDeCiudades = new ArrayList<>();
    String[] arrayDeLocalidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextViewProvincias = findViewById(R.id.auto_complete_text_view_provincias);
        spinnerLocalidades = findViewById(R.id.spiner_localidades);
        arrayDeProvincias= getResources().getStringArray(R.array.provincias);
        ArrayAdapter <String> arrayAdapterProvincias = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,arrayDeProvincias);
        // Todo se puede declarar un Adapter sin array de datos y luego mas tarde añadirle los datos que veamo convenientes
        ArrayAdapter<String> adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item);
        spinnerLocalidades.setAdapter(adapter);
        autoCompleteTextViewProvincias.setAdapter(arrayAdapterProvincias);

        autoCompleteTextViewProvincias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String provinciaSeleccionada = autoCompleteTextViewProvincias.getText().toString();
                switch (provinciaSeleccionada){
                    case "A Coruña":{

                        arrayDeLocalidades=getResources().getStringArray(R.array.localidades_ACorunha);
                        break;
                    }
                    case "Lugo":{
                        arrayDeLocalidades=getResources().getStringArray(R.array.localidades_lugo);
                        break;

                    }
                    case "Pontevedra":{
                        arrayDeLocalidades=getResources().getStringArray(R.array.localidades_pontevedra);
                        break;

                    }
                    case "Ourense":{
                        arrayDeLocalidades=getResources().getStringArray(R.array.localidades_ourense);
                        break;

                    } default: arrayDeLocalidades= new String[]{"No tenemos localidades"};


                }
                // Todo necesitamos usar esto a mayores ya que el notifyDataSetChange puede que no
                //  detecte algun cambio en el adapter como en este caso
                adapter.clear();
                adapter.addAll(arrayDeLocalidades);
                adapter.notifyDataSetChanged();


            }

        });
        //Todo Para recuperar el valor de un spiner podemos usar
        // el spiner.getItemSelected.toString() para que nos devuelva un String con el item seleccionado
        spinnerLocalidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String localidadSeleccionada = spinnerLocalidades.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, localidadSeleccionada, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






    }



}