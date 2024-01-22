package com.example.creandolistados.spiners;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.creandolistados.R;

import java.util.ArrayList;

public class ListView3_Activity extends AppCompatActivity implements View.OnClickListener {

    Button botonAceptar;
    ListView listViewDinamico;
    EditText textoIntroducir;


    ArrayList<String> arrayListPlanetas;

    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3);
        idents();
        listeners();
        arrayListPlanetas = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrayListPlanetas);
        listViewDinamico.setAdapter(adapter);
        listViewDinamico.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // accedemos al String del array
                String planetaSeleccionado = listViewDinamico.getItemAtPosition(position).toString();
                // podemos acceder a traves de la posicion del item
                String planetaselecionado2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(ListView3_Activity.this, "Has seleccionado" + planetaSeleccionado + "\n Que es el item numero " + planetaselecionado2, Toast.LENGTH_SHORT).show();
            }

        });


    }

    public void idents() {
        botonAceptar = findViewById(R.id.botonAceptarListView);
        listViewDinamico = findViewById(R.id.ListViewDinamico);
        textoIntroducir = findViewById(R.id.texto_anadirListView);

    }

    public void listeners() {
        botonAceptar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == botonAceptar.getId() & textoIntroducir.getText().toString().equals("")) {
            Toast.makeText(this, "Debes de introducir un valor en la caja de texto", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == botonAceptar.getId() & !textoIntroducir.getText().toString().equals("")) {
            arrayListPlanetas.add(textoIntroducir.getText().toString());
            //if (listViewDinamico.getVisibility() == View.GONE)
            //    listViewDinamico.setVisibility(View.VISIBLE);
            textoIntroducir.setText("");
            adapter.notifyDataSetChanged();
        }
    }
}