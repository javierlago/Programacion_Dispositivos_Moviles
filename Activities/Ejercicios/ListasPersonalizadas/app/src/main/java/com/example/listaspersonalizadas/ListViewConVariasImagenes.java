package com.example.listaspersonalizadas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import AdaptadoresPersonalizados.AdaptadorPersonalizadoVariasImagenes;

public class ListViewConVariasImagenes extends AppCompatActivity {
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_con_varias_imagenes);
    listView = findViewById(R.id.list_view_con_imagenes_variadas);
        AdaptadorPersonalizadoVariasImagenes adaptadorPersonalizadoVariasImagenes = new AdaptadorPersonalizadoVariasImagenes(this,R.layout.fila_img_variadas,
                getResources().getStringArray(R.array.planetas),getResources().obtainTypedArray(R.array.planetas_fotos));
    listView.setAdapter(adaptadorPersonalizadoVariasImagenes);
    }
}