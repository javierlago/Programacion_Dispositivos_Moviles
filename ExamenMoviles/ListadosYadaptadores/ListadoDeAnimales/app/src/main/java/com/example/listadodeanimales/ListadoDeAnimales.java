package com.example.listadodeanimales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import Adaptadores.AdaptadorAnimales;

public class ListadoDeAnimales extends AppCompatActivity {

    ListView listaDeAnimales;
    String[] nombreAnimles;
    TypedArray fotosAnimales;
    String[] descripcionAnimales;
    TypedArray fotosPuntos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_de_animales);
        listaDeAnimales = findViewById(R.id.list_view_de_animales);
        nombreAnimles = getResources().getStringArray(R.array.animales_nombre);
        descripcionAnimales = getResources().getStringArray(R.array.animales_descripcion);
        fotosAnimales = getResources().obtainTypedArray(R.array.animales);
        fotosPuntos = getResources().obtainTypedArray(R.array.puntos);
        AdaptadorAnimales adaptadorAnimales = new AdaptadorAnimales(this,R.layout.fila_unica_animales,nombreAnimles,descripcionAnimales,fotosAnimales,fotosPuntos);
        listaDeAnimales.setAdapter(adaptadorAnimales);


        listaDeAnimales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListadoDeAnimales.this, "Nombre->"+nombreAnimles[position]+"\nDescripcion->"+descripcionAnimales[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}