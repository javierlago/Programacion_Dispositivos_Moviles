package Adaptadores;

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
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejerciciolistviewplanetas.R;

public class AdaptadorPlanetas extends ArrayAdapter {

    Activity contextAdaptador;

    String[] nombresPLanetas;
    int[] identificadoresFotos;

    // TODO Fallo en este programa en que no le estaba pasando al super un minimo de tres parametros

    public AdaptadorPlanetas(@NonNull Activity context, int layoutPersalizado, String[]nombresPlanetas, int[] idfotos) {
        super(context, layoutPersalizado,nombresPlanetas);
        this.contextAdaptador=context;
        this.nombresPLanetas=nombresPlanetas;
        this.identificadoresFotos=idfotos;



    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // TODO inflamos nuestro layout personalizado
        LayoutInflater layoutInflater = contextAdaptador.getLayoutInflater();
        // TODO le  indicamos con que layout vamos a inflar la view
        View view = layoutInflater.inflate(R.layout.fila_unica_planeta,null);
        // TODO Capturar los ids de los componentes de los layout personalizado;
        TextView txtViewPlanetas = view.findViewById(R.id.txt_view_del_layout_personalizado);
        ImageView imgPlaneta = view.findViewById(R.id.imagen_layout_personalizado);
        // insertar cada valor en el correspondiente id
        txtViewPlanetas.setText(nombresPLanetas[position]);
        imgPlaneta.setImageResource(identificadoresFotos[position]);
        return view;

    }
}
