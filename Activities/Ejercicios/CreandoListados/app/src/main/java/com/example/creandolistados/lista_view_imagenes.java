package com.example.creandolistados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class lista_view_imagenes extends AppCompatActivity {
    ListView listViewConImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_view_imagenes);
        listViewConImg = findViewById(R.id.list_view_con_imagenes);

        // Creacion de adaptador personalizado en el que le pasaremos una imagen //
        ArrayAdapter adapter = new ArrayAdapter<>(this,R.layout.fila_simple,R.id.text_view_planeta_img,getResources().getStringArray(R.array.planetas));
        listViewConImg.setAdapter(adapter);

        listViewConImg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String seleccionado = parent.getItemAtPosition(position).toString();
                Toast.makeText(lista_view_imagenes.this, "Planeta" + seleccionado, Toast.LENGTH_SHORT).show();

            }
        });



    }
}