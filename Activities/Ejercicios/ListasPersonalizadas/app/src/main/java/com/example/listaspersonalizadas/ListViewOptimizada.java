package com.example.listaspersonalizadas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import AdaptadoresPersonalizados.AdaptadorOptimizado;
import Array_planetas.Planeta;

public class ListViewOptimizada extends AppCompatActivity {
    ArrayList<Planeta> listadoPlanetas = new ArrayList<>();

    ListView listView;

    AdaptadorOptimizado adaptadorOptimizado ;
    Planeta planeta;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_optimizada);
        listView = findViewById(R.id.list_view_optimizada);
        for (int i = 0; i < getResources().getStringArray(R.array.planetas).length; i++) {
            this.listadoPlanetas.add(new Planeta(getResources().getStringArray(R.array.planetas)[i],
                    getResources().getStringArray(R.array.planetas_descripcion)[i],
                    getResources().obtainTypedArray(R.array.planetas_fotos).getResourceId(i, -1)));
        }
        adaptadorOptimizado = new AdaptadorOptimizado(this, R.layout.fila_img_variadas, listadoPlanetas,
                R.id.text_view_planeta_img_variadas, R.id.text_view_planeta_img_variadas_mas_info, R.id.img_cambiante_planeta);
        listView.setAdapter(adaptadorOptimizado);
        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        //menu.setHeaderTitle(listadoPlanetas.get(((AdapterView.AdapterContextMenuInfo) menuInfo).position).getNombre());
        planeta = (Planeta) listView.getAdapter().getItem(((AdapterView.AdapterContextMenuInfo) menuInfo).position);
        position = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;
        menu.setHeaderTitle(planeta.getNombre());
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opc_item_1_contextual:
                Toast.makeText(this, "Borrado de elemento", Toast.LENGTH_SHORT).show();
                // Dos opciones de borrado
                //adaptadorOptimizado.remove(planeta);
                // borrado desde el Array List
                listadoPlanetas.remove(planeta);
                adaptadorOptimizado.notifyDataSetChanged();
                return true;
            case R.id.opc_item_2_contextual:
                Toast.makeText(this, "Has elegido el contextual 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opc_item_3_contextual:
                Toast.makeText(this, "Has elegido el contextual 3", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }


}