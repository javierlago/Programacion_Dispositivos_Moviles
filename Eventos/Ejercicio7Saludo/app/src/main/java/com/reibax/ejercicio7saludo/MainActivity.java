package com.reibax.ejercicio7saludo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;


import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    // Obtener la fecha actual
    Date currentDate = new Date();
    int currentYear;
    // Crear un objeto Calendar y establecer la fecha actual
    Calendar calendar = Calendar.getInstance();

    Button btnSaludar;
    RadioButton btnSr,btnSra,btnAdios,btnHastaPronto;
    CheckBox chkDeseaSaludo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar.setTime(currentDate);
        // Obtener el año actual
       currentYear = calendar.get(Calendar.YEAR);
       finds();


    }

    public void finds(){
        btnSaludar = findViewById(R.id.button_saludar);
        btnAdios = findViewById(R.id.rbt_adios);
        btnHastaPronto = findViewById(R.id.rbtn_hasta_pronto);
        btnSra = findViewById(R.id.btn_senora);
        btnSr = findViewById(R.id.btn_senor);
        chkDeseaSaludo = findViewById(R.id.chk_despedida);
    }

