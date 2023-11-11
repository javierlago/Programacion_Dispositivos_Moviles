package com.reibax.ejercicio7saludo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    // Obtener la fecha actual
    Date currentDate = new Date();
    int currentYear;
    // Crear un objeto Calendar y establecer la fecha actual
    Calendar calendar = Calendar.getInstance();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar.setTime(currentDate);
        // Obtener el año actual
       currentYear = calendar.get(Calendar.YEAR);

    }
}