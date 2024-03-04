package com.example.ejercicio_uno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button botonGuardarDatos,botonMostrarDatos;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonGuardarDatos = findViewById(R.id.boton_guardar);
        botonMostrarDatos = findViewById(R.id.boton_mostrar);
        botonMostrarDatos.setOnClickListener(this);
        botonGuardarDatos.setOnClickListener(this);
        // todo esto tiene que ir en el oncreate para que nos de un nullpointexception
        sharedPreferences  = PreferenceManager.getDefaultSharedPreferences(this);
    }



    public void insertarDatos(SharedPreferences sharedPreferences){
        // Todo ahora necesitamos declarar un editor para poder asignar datos
        SharedPreferences.Editor editorDePreferenciasCompartidas = sharedPreferences.edit();
        editorDePreferenciasCompartidas.putString("email","correo@correo");
        editorDePreferenciasCompartidas.putString("nombre","Javier");
        editorDePreferenciasCompartidas.apply();
        Toast.makeText(this, "Se han guardado los datos", Toast.LENGTH_SHORT).show();

    }
    public void recuperarDatos(SharedPreferences sharedPreferences){

        Toast.makeText(this, "Correo-> "+sharedPreferences.getString("email","No hay datos")+"Nombre->"+sharedPreferences.getString("nombre","No hay datos"), Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onClick(View v) {
        if(v==botonGuardarDatos){
            insertarDatos(sharedPreferences);
        }else if(v==botonMostrarDatos){
            recuperarDatos(sharedPreferences);
        }
    }
}