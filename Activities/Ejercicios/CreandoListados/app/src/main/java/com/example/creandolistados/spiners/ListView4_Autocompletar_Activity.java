package com.example.creandolistados.spiners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.creandolistados.R;

public class ListView4_Autocompletar_Activity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view4_autocompletar);
        autoCompleteTextView = findViewById(R.id.list_View_AutoCompletar);
        // Creamos el adaptador para el list View //
        // cambia el layout en este caso utilizamos android.R.layout.simple_list_item_1 //
        // ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(ListView2_Activity.this,R.array.planetas, android.R.layout.simple_list_item_1);
        //listViewPlanetas2.setAdapter(adapter);
        // Gestionar el adaptador cojiendo dirctamente de recursos
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(ListView4_Autocompletar_Activity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.nombres));
        autoCompleteTextView.setAdapter(adapter2);
        // Creamos el listener


        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // accedemos al String del array
                String nombreSeleccionado = autoCompleteTextView.getText().toString();
                // podemos acceder a traves de la posicion del item
                String planetaselecionado2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(ListView4_Autocompletar_Activity.this, "Has seleccionado"+ nombreSeleccionado+ "\n Que es el item numero "+ planetaselecionado2, Toast.LENGTH_SHORT).show();

            }
        });


    }
}