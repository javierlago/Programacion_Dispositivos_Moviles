package com.example.ejerciciodeprueba.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ejerciciodeprueba.R;
import com.example.ejerciciodeprueba.Usuario;

import java.util.ArrayList;

public class AdaptadorAlumnos extends ArrayAdapter {

    ArrayList<Usuario> listDeUsuarios;
    Context context;

    public AdaptadorAlumnos(@NonNull Context context, int resource, @NonNull ArrayList<Usuario> objects) {
        super(context, resource, objects);

    this.listDeUsuarios=objects;
    this.context=context;



    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_datos_alumno,null);
        TextView textViewNombreUsuario = view.findViewById(R.id.text_view_nombre_layout_personalizado);
        TextView textViewCodigoUsuario = view.findViewById(R.id.text_view_codigo_layout_personalizado);
        textViewNombreUsuario.setText(listDeUsuarios.get(position).getNombre());
        textViewCodigoUsuario.setText(String.valueOf(listDeUsuarios.get(position).getCodigo()));
        return view;
    }
}
