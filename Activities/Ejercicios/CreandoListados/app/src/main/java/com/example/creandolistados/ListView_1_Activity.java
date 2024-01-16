package com.example.creandolistados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListView_1_Activity extends AppCompatActivity {
    ListView listViewPlanetas1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);
        listViewPlanetas1 = findViewById(R.id.list_View_Planetas1);
        // ESCUCHADOR DE LA LIST VIEW
        listViewPlanetas1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // accedemos al String del array

                String planetaSeleccionado = listViewPlanetas1.getItemAtPosition(position).toString();
                // podemos acceder a traves de la posicion del item
                String planetaselecionado2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(ListView_1_Activity.this, "Has seleccionado"+ planetaSeleccionado+ "\n Que es el item numero "+ planetaselecionado2, Toast.LENGTH_SHORT).show();

            }
        });

    }
}