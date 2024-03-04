package com.example.ejerciciciorepaso.ArrayAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ejerciciciorepaso.R;

import java.util.ArrayList;

import Clase.Alumno;


public class AlumnoAdapter extends ArrayAdapter<Alumno> {

    public AlumnoAdapter(Context context, ArrayList<Alumno> alumnos) {
        super(context, 0, alumnos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fila_personalizada, parent, false);
        }

        Alumno alumno = getItem(position);

        // Asegúrate de que el objeto alumno no sea nulo antes de acceder a sus propiedades
        if (alumno != null) {
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView nombreTextView = convertView.findViewById(R.id.nombreTextView);
            TextView cursoTextView = convertView.findViewById(R.id.cursoTextView);
            TextView cicloTextView = convertView.findViewById(R.id.tipo_de_ciclo);

            imageView.setImageResource(alumno.getFoto()); // Establecer la imagen
            nombreTextView.setText(alumno.getNombre());
            cursoTextView.setText(alumno.getCurso());
            if(alumno.getClico()==null){
                cicloTextView.setVisibility(View.GONE);
            }else{
                cicloTextView.setVisibility(View.VISIBLE);
                cicloTextView.setText(alumno.getClico());
            }


        }

        return convertView;
    }
}