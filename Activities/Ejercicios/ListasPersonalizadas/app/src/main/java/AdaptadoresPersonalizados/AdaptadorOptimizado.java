package AdaptadoresPersonalizados;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import Array_planetas.Planeta;

public class AdaptadorOptimizado extends ArrayAdapter<Planeta> {
    Activity context;
    ArrayList<Planeta> listadoPlanetas;


    int identificadorLayout, identificadorTextoUno,identidicadorTextoDos,identificadorImagen;
    
    public AdaptadorOptimizado(@NonNull Activity context,  int identificadorLayout, ArrayList<Planeta> listadoPlanetas,int identificadorTextoUno,int identidicadorTextoDos,int identificadorImagen) {
        super(context,identificadorLayout,listadoPlanetas);
        this.listadoPlanetas=listadoPlanetas;
        this.context=context;
        this.identificadorLayout=identificadorLayout;
        this.identificadorTextoUno=identificadorTextoUno;
        this.identidicadorTextoDos = identidicadorTextoDos;
        this.identificadorImagen=identificadorImagen;

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View fila = convertView;

        if(fila == null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            fila = inflater.inflate(identificadorLayout, null);
        }
        // Identificamos los componentes de layout personalizado
        TextView txtViewPlanetas = fila.findViewById(identificadorTextoUno);
        TextView txtViewMasInfoPlanetas = fila.findViewById(identidicadorTextoDos);
        ImageView imagenViewPlaneta = fila.findViewById(identificadorImagen);
        // Seteamos las variables que acabamos de crear
        // Asignaciond de los recursos a los elementos creados en la view personalizada
        txtViewPlanetas.setText(listadoPlanetas.get(position).getNombre());
        txtViewMasInfoPlanetas.setText(listadoPlanetas.get(position).getDescripcion());
        imagenViewPlaneta.setImageDrawable(context.getDrawable(listadoPlanetas.get(position).getImagen()));
        return fila;
    }
}
