package com.example.ejercicio_dos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    //Todo Tener cuidado con el color ya que a veces falla con el getColor() y es mejor usar el ContextCompat.getColor(this,R.color.black);

    Button buttonGuardar, buttonResetear;
    RadioButton radioButtonRed,radioButtonBlue,radioButtonGreen,radioButtonYellow;
    RadioGroup radioGroup;
    TextView textViewTextoCambiante;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indentificar();
        listeners();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        editor=sharedPreferences.edit();
        textViewTextoCambiante.setTextColor(sharedPreferences.getInt("color",getResources().getColor(R.color.black)));
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                comprobarBotones();            }
        });



    }


    public void indentificar(){
        buttonGuardar=findViewById(R.id.boton_guardar_color);
        buttonResetear =findViewById(R.id.boton_resetear_color);
        radioButtonRed =findViewById(R.id.radio_buton_rojo);
        radioButtonBlue =findViewById(R.id.radio_buton_azul);
        radioButtonGreen =findViewById(R.id.radio_buton_verde);
        radioButtonYellow=findViewById(R.id.radio_buton_amarillo);
        textViewTextoCambiante = findViewById(R.id.texto_que_cambia_de_color);
        radioGroup = findViewById(R.id.grupo_de_radio_buttons);

    }
    public void listeners(){
        buttonGuardar.setOnClickListener(this);
        buttonResetear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==buttonGuardar){
            Toast.makeText(this, "Color guardado", Toast.LENGTH_SHORT).show();
            editor.putInt("color",comprobarBotones());
            editor.apply();
        } else if (v==buttonResetear) {
            int color = ContextCompat.getColor(this,R.color.black);
            Toast.makeText(this, "Reset de color", Toast.LENGTH_SHORT).show();
            textViewTextoCambiante.setTextColor(color);
            editor.putInt("color",color);
            editor.apply();

        }


    }

    public  int comprobarBotones(){
        int color=getColor(R.color.black);
        if(radioButtonRed.isChecked()){
                color=getColor(R.color.red);
        } else if (radioButtonBlue.isChecked()) {
                color=getColor(R.color.azul);


        } else if (radioButtonGreen.isChecked()) {
                color=getColor(R.color.verde);

        } else if (radioButtonYellow.isChecked()){
                color=getColor(R.color.amarillo);

        }
        textViewTextoCambiante.setTextColor(color);
        return color;
    }



}