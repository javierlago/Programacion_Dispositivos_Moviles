package com.example.pruebaexamen2.Adaptadores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pruebaexamen2.R;
import com.example.pruebaexamen2.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AdapatadoPersonalizado extends ArrayAdapter {

    ArrayList<Usuario> listadoUsuarios;
    Context context;


    public AdapatadoPersonalizado(@NonNull Context context, int resource, @NonNull ArrayList<Usuario> listadoUsuarios) {
        super(context, resource, listadoUsuarios);
        this.listadoUsuarios = listadoUsuarios;
        this.context=context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_personalizado,null);
        TextView codigo = view.findViewById(R.id.texto_codigo_layout_personalizado);
        TextView nombre = view.findViewById(R.id.texto_nombre_layout_personalizado);
        TextView apellidos = view.findViewById(R.id.texto_apellidos_layout_personalizado);
        codigo.setText(listadoUsuarios.get(position).getCodigo());
        nombre.setText(listadoUsuarios.get(position).getNombre());
        apellidos.setText(listadoUsuarios.get(position).getApellido());
        return view;



    }
}
