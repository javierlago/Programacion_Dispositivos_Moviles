package com.example.textogiratorio;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.Date;


@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView mensaje;
    int giro = 0;
    int year = LocalDate.now().getYear();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensaje = findViewById(R.id.mensaje);
        mensaje.setOnClickListener(this);
//        if (savedInstanceState != null) {
//            giro = savedInstanceState.getInt("giro");
//        }

    }
//    @Override
//    public void onSaveInstanceState( @NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt("giro", giro);
//    }


    @Override
    public void onClick(View view) {

        giro += 45;
        if (giro == 360) {
            giro=0 ;
        }
        mensaje.setText(getResources().getString(R.string.saludo));
        mensaje.setBackgroundColor(getResources().getColor(R.color.amarillo));
        //mensaje.setBackgroundColor(ContextCompat.getColor(this, R.color.amarillo));
        mensaje.setRotation(giro);
        mensaje.setTextSize(getResources().getDimension(R.dimen.grande));



    }
}