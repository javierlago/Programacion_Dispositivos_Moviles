package com.example.girarimagentexto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView cohete;
    TextView textoGiratorio,mensaje;

    RadioGroup grupoBotones;
    RadioButton btnTexto,btnImagen;
    Button btnAceptar;
    int giro;

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

        if(view.getId()==btnAceptar.getId()){
            if(btnImagen.isChecked()){
                grupoBotones.setVisibility(View.GONE);
                btnAceptar.setVisibility(View.GONE);
                mensaje.setVisibility(View.GONE);
                cohete.setVisibility(View.VISIBLE);
                if (view.getId()==R.id.cohete) {
                    giro += 45;
                    if(giro==360){giro=0;}
                    cohete.setRotation(giro);
                }
            }else if(btnTexto.isChecked()) {
                grupoBotones.setVisibility(View.GONE);
                btnAceptar.setVisibility(View.GONE);
                mensaje.setVisibility(View.GONE);
                textoGiratorio.setVisibility(View.VISIBLE);

            }else{
                Toast.makeText(MainActivity.this,"Selecciona una opcion",Toast.LENGTH_LONG).show();
            }




        }

        if (view.getId()==cohete.getId()) {
            giro = giro(giro);
            cohete.setRotation(giro(giro));
        }
        if (view.getId()==textoGiratorio.getId()) {
            giro = giro(giro);
            textoGiratorio.setRotation(giro(giro));
        }






    }

    public int giro(int giro){
        giro +=45;
        if(giro==360){giro =0;}
    return giro;
    }
}