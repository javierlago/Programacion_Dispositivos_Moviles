package AdaptadoresPersonalizados;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listaspersonalizadas.R;

public class AdaptadorPersonalizadoVariasImagenes extends ArrayAdapter {
    Activity context;
    String[] arrayPlanetas;
    TypedArray idFotos;
    int identificadorLayout;


    public AdaptadorPersonalizadoVariasImagenes(@NonNull Activity context, int identificadorLayout, String[] arrayPlanetas,TypedArray idFotos) {
        super(context, identificadorLayout, arrayPlanetas);
        this.context=context;
        this.arrayPlanetas=arrayPlanetas;
        this.idFotos=idFotos;
        this.identificadorLayout=identificadorLayout;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // inflamos nuestro layout personalizado
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View fila = layoutInflater.inflate(identificadorLayout, null);

        // Identificamos los componentes de layout personalizado
        TextView txtViewPlanetas = fila.findViewById(R.id.text_view_planeta_img_variadas);
        TextView txtViewMasInfoPlanetas = fila.findViewById(R.id.text_view_planeta_img_variadas_mas_info);
        ImageView imagenViewPlaneta = fila.findViewById(R.id.img_cambiante_planeta);

        // Asignamos valor a los componentes identificados anteriormente
        txtViewPlanetas.setText(arrayPlanetas[position]);
        imagenViewPlaneta.setImageDrawable(idFotos.getDrawable(position));
        txtViewMasInfoPlanetas.setText(context.getResources().getString(R.string.info)+ arrayPlanetas[position]);

        // Devolvemos la vista personalizada
        return fila;
    }
}
