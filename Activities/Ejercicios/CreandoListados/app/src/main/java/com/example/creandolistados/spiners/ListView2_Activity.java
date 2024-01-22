package com.example.creandolistados.spiners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.creandolistados.R;

public class ListView2_Activity extends AppCompatActivity {
    ListView listViewPlanetas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        listViewPlanetas2 = findViewById(R.id.list_View_Planetas2);
        // Creamos el adaptador para el list View //
        // cambia el layout en este caso utilizamos android.R.layout.simple_list_item_1 //
        // ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(ListView2_Activity.this,R.array.planetas, android.R.layout.simple_list_item_1);
        //listViewPlanetas2.setAdapter(adapter);
        // Gestionar el adaptador cojiendo dirctamente de recursos
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(ListView2_Activity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.planetas));
        listViewPlanetas2.setAdapter(adapter2);
        // Creamos el listener


        listViewPlanetas2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // accedemos al String del array

                String planetaSeleccionado = listViewPlanetas2.getItemAtPosition(position).toString();
                // podemos acceder a traves de la posicion del item
                String planetaselecionado2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(ListView2_Activity.this, "Has seleccionado"+ planetaSeleccionado+ "\n Que es el item numero "+ planetaselecionado2, Toast.LENGTH_SHORT).show();

            }
        });


    }
}