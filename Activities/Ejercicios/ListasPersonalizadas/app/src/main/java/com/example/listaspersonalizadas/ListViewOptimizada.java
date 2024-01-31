package com.example.listaspersonalizadas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import AdaptadoresPersonalizados.AdaptadorOptimizado;
import Array_planetas.Planeta;

public class ListViewOptimizada extends AppCompatActivity {
    ArrayList<Planeta> listadoPlanetas = new ArrayList<>();

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_optimizada);
        listView = findViewById(R.id.list_view_optimizada);
        for(int i=0 ;i<getResources().getStringArray(R.array.planetas).length;i++){
            this.listadoPlanetas.add(new Planeta(getResources().getStringArray(R.array.planetas)[i],
                    getResources().getStringArray(R.array.planetas_descripcion)[i],
                    getResources().obtainTypedArray(R.array.planetas_fotos).getResourceId(i,-1)));
        }
        AdaptadorOptimizado adaptadorOptimizado = new AdaptadorOptimizado(this,R.layout.fila_img_variadas,listadoPlanetas,
                R.id.text_view_planeta_img_variadas,R.id.text_view_planeta_img_variadas_mas_info,R.id.img_cambiante_planeta);
        listView.setAdapter(adaptadorOptimizado);



    }
}