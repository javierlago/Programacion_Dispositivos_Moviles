package com.example.alarma22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = findViewById(R.id.time_picker);

    }


    public void onClickBtn(View view) {

        int  hora = timePicker.getChildCount();
        int  minutos = timePicker.getCurrentMinute();
        String mensaje = "Esto es el aviso actual de mi alarma";
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE,mensaje);
        intent.putExtra(AlarmClock.EXTRA_HOUR,hora);
        intent.putExtra(AlarmClock.EXTRA_MINUTES,minutos);

        if (intent.resolveActivity(getPackageManager())!=null){

        startActivity(intent);
        }else{
            Toast.makeText(this,"No se puede ejecutar",Toast.LENGTH_LONG).show();

        }





    }
}