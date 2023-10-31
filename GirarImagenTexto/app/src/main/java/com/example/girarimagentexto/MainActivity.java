package com.example.girarimagentexto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView cohete;
    TextView textoGiratorio,mensaje;

    RadioGroup grupoBotones;
    RadioButton btnTexto,btnImagen,btnAceptar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cohete = findViewById(R.id.cohete);
        textoGiratorio= findViewById(R.id.textoGiratorio);
        grupoBotones = findViewById(R.id.btnRadioGroup);
        btnImagen = findViewById(R.id.btnImagen);
        btnTexto = findViewById(R.id.btnTexto);
        btnAceptar = findViewById(R.id.btnAceptar);
        mensaje= findViewById(R.id.mensaje);

        cohete.setOnClickListener(this);
        textoGiratorio.setOnClickListener(this);
        grupoBotones.setOnClickListener(this);
        btnImagen.setOnClickListener(this);
        btnImagen.setOnClickListener(this);
        btnAceptar.setOnClickListener(this);








    }

    @Override
    public void onClick(View view) {




         grupoBotones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int i) {
                 if(i == R.id.btnTexto ){
                     if(view.getId()==R.id.btnAceptar){
                     mensaje.setVisibility(View.GONE);
                     btnImagen.setVisibility(View.GONE);
                     btnTexto.setVisibility(View.GONE);
                     btnAceptar.setVisibility(View.GONE);
                     textoGiratorio.setVisibility(View.VISIBLE);}
                 }else if(i == R.id.btnImagen && view.getId()==R.id.btnAceptar ){
                     mensaje.setVisibility(View.GONE);
                     btnImagen.setVisibility(View.GONE);
                     btnTexto.setVisibility(View.GONE);
                     btnAceptar.setVisibility(View.GONE);
                     cohete.setVisibility(View.VISIBLE);
                 }
             }
         });

        }










    }
}