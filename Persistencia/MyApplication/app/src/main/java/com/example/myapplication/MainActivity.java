package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int posicion;
    private SharedPreferences sharedPreferences;

    //colors.add = {getResources().getColor(R.color.verde),getResources().getColor(R.color.rojo),getResources().getColor(R.color.amarillo),getResources().getColor(R.color.azul)}


    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        view = findViewById(R.id.view_a_cambiar_color);
        view.setBackgroundColor(getResources().getColor(sharedPreferences.getInt("color",R.color.black)));
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cambiar_color:
            dialogoConListaYbotonAcept();


        }





    }

    private void dialogoConListaYbotonAcept() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Escoje un color con boton");
        alertDialogBuilder.setItems(R.array.colores, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                posicion = which;

            }
        });


        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences.Editor editorPreferecia = sharedPreferences.edit();
                int[] colors = {R.color.verde, R.color.rojo, R.color.amarillo,R.color.azul};
                int colorElegido = colors[posicion];
                editorPreferecia.putInt("color",colorElegido);
                editorPreferecia.apply();
                view.setBackgroundColor(getResources().getColor(colorElegido));

            }
        });

        // Configurar que el diálogo no sea cancelable


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }













}