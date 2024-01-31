package AdaptadoresPersonalizados;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listaspersonalizadas.R;

import java.util.ArrayList;

import Array_planetas.Planeta;

public class AdaptadorConArrayList extends ArrayAdapter {
        Activity context;
        ArrayList<Planeta> listadoPlanetas;

        int identificadorLayout,identificadorTextoUno, identidicadorTextoDos,identificadorImagen;




    public AdaptadorConArrayList(@NonNull Activity context,  int identificadorLayout, ArrayList<Planeta> listadoPlanetas,int identificadorTextoUno,int identidicadorTextoDos,int identificadorImagen) {
        super(context,identificadorLayout,listadoPlanetas);
        this.listadoPlanetas=listadoPlanetas;
        this.context=context;
        this.identificadorLayout=identificadorLayout;
        this.identificadorTextoUno=identificadorTextoUno;
        this.identidicadorTextoDos = identidicadorTextoDos;
        this.identificadorImagen=identificadorImagen;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View fila = layoutInflater.inflate(identificadorLayout,null);
        // Identificamos los componentes de layout personalizado
        TextView txtViewPlanetas = fila.findViewById(identificadorTextoUno);
        TextView txtViewMasInfoPlanetas = fila.findViewById(identidicadorTextoDos);
        ImageView imagenViewPlaneta = fila.findViewById(identificadorImagen);
        // Asignaciond de los recursos a los elementos creados en la view personalizada
        txtViewPlanetas.setText(listadoPlanetas.get(position).getNombre());
        txtViewMasInfoPlanetas.setText(listadoPlanetas.get(position).getDescripcion());
        imagenViewPlaneta.setImageDrawable(context.getDrawable(listadoPlanetas.get(position).getImagen()));
        return fila;
    }
}
