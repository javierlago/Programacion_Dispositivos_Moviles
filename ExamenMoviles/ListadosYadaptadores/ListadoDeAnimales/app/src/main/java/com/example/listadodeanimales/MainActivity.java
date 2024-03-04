package com.example.listadodeanimales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener {

    TextView textView;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.boton_cambiar_al_listado);
        boton.setOnClickListener(this);
        textView = findViewById(R.id.texto_main_pantalla);
        textView.setOnLongClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        if(v==boton){
            intent.setClass(this,ListadoDeAnimales.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onLongClick(View v) {
        Intent intent = new Intent();
        if(v==textView){
            intent.setClass(this,ListadoDeAnimales.class);
            startActivity(intent);
        }
        return false;
    }
}