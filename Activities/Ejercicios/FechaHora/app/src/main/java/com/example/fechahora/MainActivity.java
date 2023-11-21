package com.example.fechahora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String mensajeDatos;
    private TimePicker timePicker;
    private DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = findViewById(R.id.time_picker);
        datePicker = findViewById(R.id.calendarView);

    }

    public void onClickBtn(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mensajeDatos = String.format("Fecha" + datePicker.getDayOfMonth() +
                    " " + datePicker.getMonth() +
                    " " + datePicker.getYear() +
                    "\nHora " + timePicker.getHour() +
                    ":" + timePicker.getMinute());
        }else{
            mensajeDatos = String.format("Fecha" + datePicker.getDayOfMonth() +
                    " " + datePicker.getMonth() +
                    " " + datePicker.getYear() +
                    "\nHora " + timePicker.getCurrentHour() +
                    ":" + timePicker.getCurrentMinute());
        }

        Toast.makeText(this,mensajeDatos,Toast.LENGTH_LONG).show();


    }
}