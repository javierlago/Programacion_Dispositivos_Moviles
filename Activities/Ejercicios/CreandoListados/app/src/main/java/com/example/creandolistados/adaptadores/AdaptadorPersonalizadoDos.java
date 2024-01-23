package com.example.creandolistados.adaptadores;

import android.app.Activity;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.creandolistados.R;

public class AdaptadorPersonalizadoDos extends ArrayAdapter {
    Activity context;
    String [] arrayPlanetas;
    TypedArray idFotos;
    int layOut;



    public AdaptadorPersonalizadoDos(
                                     @NonNull Activity context,
                                     int layOutPersonalizado,
                                     String[] nombresPlanetas, TypedArray idFotos) {
        // constructor defectivo de la clase ArrayAdapter
        super(context, layOutPersonalizado,nombresPlanetas);
        this.context=context;
        this.arrayPlanetas=nombresPlanetas;
        this.idFotos=idFotos;
        this.layOut=layOutPersonalizado;
    }
    // fin de la definicion de la clase


    // Implementar el metodo getView


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // inflamos nuestro layout personalizado
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View fila = layoutInflater.inflate(layOut,null);
        // Capturar los ids de los componentes de los layout personalizado;
        TextView txtViewPlanetas = fila.findViewById(R.id.text_view_planeta_img_variadas);
        ImageView  imgPlaneta = fila.findViewById(R.id.img_cambiante_planeta);
        // insertar cada valor en el correspondiente id
        txtViewPlanetas.setText(arrayPlanetas[position]);
        //imgPlaneta.setImageResource(idFotos[position]);
        imgPlaneta.setImageDrawable(idFotos.getDrawable(position));
        return fila;
    }
}
