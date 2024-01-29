package com.example.listaspersonalizadas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import AdaptadoresPersonalizados.AdaptadorPersonalizadoVariasImagenesAnimales;

public class ListViewConImagenesDeAnimales extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_con_imagenes_de_animales);
    listView = findViewById(R.id.list_view_con_imagenes_variadas_de_animales);
        AdaptadorPersonalizadoVariasImagenesAnimales adaptadorPersonalizadoVariasImagenesAnimales =
                new AdaptadorPersonalizadoVariasImagenesAnimales(
                        this,R.layout.fila_img_variadas_animales,
                        getResources().getStringArray(R.array.animales_nombre),getResources().getStringArray(R.array.animales_descripcion),
                        getResources().obtainTypedArray(R.array.animales),getResources().obtainTypedArray(R.array.puntos));

    listView.setAdapter(adaptadorPersonalizadoVariasImagenesAnimales);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          /*  String[] nombreAnimal= getResources().getStringArray(R.array.animales_nombre);
            String[] descripcion= getResources().getStringArray(R.array.animales_descripcion);*/
            Toast.makeText(ListViewConImagenesDeAnimales.this, parent.getResources().getStringArray(R.array.animales_nombre)[position]+
                    "\n"+parent.getResources().getStringArray(R.array.animales_descripcion)[position], Toast.LENGTH_SHORT).show();
        }
    });
    }
}