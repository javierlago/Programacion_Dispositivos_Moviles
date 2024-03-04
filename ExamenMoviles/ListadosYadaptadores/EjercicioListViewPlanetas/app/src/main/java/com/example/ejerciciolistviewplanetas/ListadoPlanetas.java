package com.example.ejerciciolistviewplanetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import Adaptadores.AdaptadorPlanetas;

public class ListadoPlanetas extends AppCompatActivity {
    ListView listadoDePlanetas;
    String[] arrayNombresPlanetas;
    int[] identificadoresFotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_planetas);
        identificadoresFotos =new int[]{R.drawable.marte,R.drawable.mercurio,R.drawable.venus,R.drawable.jupiter,R.drawable.saturno,R.drawable.urano,R.drawable.neptuno,R.drawable.tierra};
        arrayNombresPlanetas = getResources().getStringArray(R.array.planetas);
        listadoDePlanetas = findViewById(R.id.list_view_a_rellenar);
        AdaptadorPlanetas adaptadorPlanetas = new AdaptadorPlanetas(this,R.layout.fila_unica_planeta,arrayNombresPlanetas,identificadoresFotos);
        listadoDePlanetas.setAdapter(adaptadorPlanetas);

    }


}