package com.example.pruebaexamen2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button botonInsetar, botonBorrar,botonVerTodos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonInsetar = findViewById(R.id.boton_menu_insertar);
        botonBorrar = findViewById(R.id.boton_menu_borrar);
        botonVerTodos = findViewById(R.id.boton_menu_ver_todos);
        listeners();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        if(v==botonInsetar){
            intent.setClass(this,MenuGuardar.class);


        } else if (v==botonBorrar) {
            intent.setClass(this,MenuBorrado.class);

        } else if (v==botonVerTodos) {
            intent.setClass(this, MenuVerTodos.class);

        }
        startActivity(intent);


    }

    public void listeners(){
        botonVerTodos.setOnClickListener(this);
        botonInsetar.setOnClickListener(this);
        botonBorrar.setOnClickListener(this);


    }

}