package com.example.a2023_javierlagoamoedo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;


public class ActividadPrincipal extends AppCompatActivity implements View.OnClickListener {
    ImageButton imageButton;
    RadioButton rbtCalcularImc, rbtMasInformacio;
    Button botonDecidir;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);
        identificadores();
        escuchadores();
    }


    public void identificadores(){
        imageButton = findViewById(R.id.boton_imagen);
        rbtCalcularImc = findViewById(R.id.btn_calcular_imc);
        rbtMasInformacio = findViewById(R.id.more_info);
        botonDecidir = findViewById(R.id.btn_calcular);
        linearLayout =  findViewById(R.id.linear_layout);

    }

    public void escuchadores(){
      imageButton.setOnClickListener( ActividadPrincipal.this);
      rbtCalcularImc.setOnClickListener(ActividadPrincipal.this);
      rbtMasInformacio.setOnClickListener(ActividadPrincipal.this);
      botonDecidir.setOnClickListener(ActividadPrincipal.this);



    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        if(v.getId()==imageButton.getId()){
            imageButton.setVisibility(View.GONE);
            linearLayout.setVisibility(View.VISIBLE);



        }
        if(rbtMasInformacio.isChecked()){
            botonDecidir.setText("More info");
        } else if (rbtCalcularImc.isChecked()) {
            botonDecidir.setText("Calculate");
        }
        if(v.getId()==botonDecidir.getId()& rbtCalcularImc.isChecked()){
            Intent intent = new Intent(this,MainActivity2.class);
            startActivity(intent);


        }
        if(v.getId()==botonDecidir.getId()&rbtMasInformacio.isChecked()){
            Intent intent = new Intent(this,MainActivity4.class);
            startActivity(intent);


        }



    }
}