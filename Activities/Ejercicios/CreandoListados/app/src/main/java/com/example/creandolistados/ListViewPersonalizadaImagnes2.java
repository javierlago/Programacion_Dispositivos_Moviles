package com.example.creandolistados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.creandolistados.adaptadores.AdaptadorPersonalizadoUno;

public class ListViewPersonalizadaImagnes2 extends AppCompatActivity {
    ListView listView;
    int[] arrayIdFotosPlanetas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_personalizada_imagnes2);
        listView = findViewById(R.id.list_view_con_imagenes_variadas);
        // Creamos instancia del adaptador personalizado
        // auxiliar
        arrayIdFotosPlanetas = new int[]{
                R.drawable.marte,R.drawable.mercurio,R.drawable.venus,R.drawable.jupiter,R.drawable.saturno,R.drawable.urano,R.drawable.neptuno,R.drawable.img_planeta
        };

        AdaptadorPersonalizadoUno adaptadorPersonalizadoUno = new AdaptadorPersonalizadoUno(this,
                R.layout.fila_img_variadas,getResources().getStringArray(R.array.planetas)
                ,arrayIdFotosPlanetas);
        // asignar adaptador a vista
        listView.setAdapter(adaptadorPersonalizadoUno);

        //

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewPersonalizadaImagnes2.this, "Planeta seleccionado"+ parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}