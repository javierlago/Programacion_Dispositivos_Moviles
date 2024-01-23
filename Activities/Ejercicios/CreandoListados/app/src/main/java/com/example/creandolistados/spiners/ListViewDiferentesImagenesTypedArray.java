package com.example.creandolistados.spiners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.creandolistados.ListViewPersonalizadaImagnes2;
import com.example.creandolistados.R;
import com.example.creandolistados.adaptadores.AdaptadorPersonalizadoDos;
import com.example.creandolistados.adaptadores.AdaptadorPersonalizadoUno;

public class ListViewDiferentesImagenesTypedArray extends AppCompatActivity {

    ListView listView;
    TypedArray arrayIdFotosPlanetas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_diferentes_imagenes_typed_array);
        listView = findViewById(R.id.list_view_con_imagenes_variadas_typed_array);
        // Creamos instancia del adaptador personalizado
        // auxiliar


        AdaptadorPersonalizadoDos adaptadorPersonalizadoUno = new AdaptadorPersonalizadoDos(this,
                R.layout.fila_img_variadas,getResources().getStringArray(R.array.planetas)
                ,getResources().obtainTypedArray(R.array.planetas_fotos));
        // asignar adaptador a vista
        listView.setAdapter(adaptadorPersonalizadoUno);

        //

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewDiferentesImagenesTypedArray.this, "Planeta seleccionado"+ parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}