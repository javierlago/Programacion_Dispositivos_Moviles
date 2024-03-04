package com.example.ejercicio_tres;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button botonSelecionaColor,botonReseteaDeCero;
    View viewQueCambiaColor;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int[] arrayColores;

    int numeroColor;
    // Todo asignacion de los colores en el onCreate para que no tenga problemas a la hora de recuperarlos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        editor = sharedPreferences.edit();
        identificadores();
        listeners();
        viewQueCambiaColor.setBackgroundColor(sharedPreferences.getInt("color", ContextCompat.getColor(this,R.color.black)));
        arrayColores  = new int[]{ContextCompat.getColor(this, R.color.red),
                ContextCompat.getColor(this, R.color.blue),
                ContextCompat.getColor(this, R.color.Green),
                ContextCompat.getColor(this, R.color.Yellow)};

    }


    public void identificadores(){
        botonSelecionaColor = findViewById(R.id.boton_seleccion_color);
        botonReseteaDeCero = findViewById(R.id.boton_resetear_color);
        viewQueCambiaColor = findViewById(R.id.linea_que_cambia_de_color);


    }
    public void listeners(){
        botonSelecionaColor.setOnClickListener(MainActivity.this);
        botonReseteaDeCero.setOnClickListener(MainActivity.this);


    }




    @Override
    public void onClick(View v) {

        if(v==botonSelecionaColor){

            String[] colores = {"Rojo","Azul","Verde","Amarillo"};
            AlertDialog.Builder ventana = new AlertDialog.Builder(this);
            ventana.setCancelable(false);
            ventana.setTitle("Elige Color");
            ventana.setSingleChoiceItems(colores, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    numeroColor = which;
                    Toast.makeText(MainActivity.this,"Boton radio "+ String.valueOf(which), Toast.LENGTH_SHORT).show();
                }});
            ventana.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this,"Boton ok" +String.valueOf(numeroColor), Toast.LENGTH_SHORT).show();
                    editor.putInt("color",arrayColores[numeroColor]);
                    editor.apply();
                    viewQueCambiaColor.setBackgroundColor(arrayColores[numeroColor]);
                    dialog.cancel();
                }
            });

            ventana.show();

        } else if (v==botonReseteaDeCero) {
            editor.putInt("color",ContextCompat.getColor(this,R.color.black));
            editor.apply();
            viewQueCambiaColor.setBackgroundColor(ContextCompat.getColor(this,R.color.black));
        }


    }




}