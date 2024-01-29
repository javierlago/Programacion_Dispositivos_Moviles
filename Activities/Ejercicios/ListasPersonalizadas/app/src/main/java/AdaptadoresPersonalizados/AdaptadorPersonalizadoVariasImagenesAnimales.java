package AdaptadoresPersonalizados;

import android.annotation.SuppressLint;
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

import com.example.listaspersonalizadas.R;

public class AdaptadorPersonalizadoVariasImagenesAnimales extends ArrayAdapter {
    Activity context;
    String[] arrayNombresAnimales;
    String[] arrayDescripcionAnimales;

    TypedArray idFotosAnimales;
    TypedArray fotosPuntos;
    int identificadorLayout;


    public AdaptadorPersonalizadoVariasImagenesAnimales(@NonNull Activity context, int identificadorLayout, String[] arrayNombresAnimales, String[] arrayDescripcionAnimales, TypedArray idFotosAnimales, TypedArray fotosPuntos) {
        super(context, identificadorLayout, arrayNombresAnimales);
        this.context = context;
        this.arrayNombresAnimales = arrayNombresAnimales;
        this.idFotosAnimales = idFotosAnimales;
        this.identificadorLayout = identificadorLayout;
        this.fotosPuntos = fotosPuntos;
        this.arrayDescripcionAnimales = arrayDescripcionAnimales;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // inflamos nuestro layout personalizado
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View fila = layoutInflater.inflate(identificadorLayout, null);

        // Identificamos los componentes de layout personalizado
        TextView txtViewNombreAnimal = fila.findViewById(R.id.text_view_nombre_animal);
        TextView txtViewDescripcionAnimal = fila.findViewById(R.id.text_view_decripcion_animal);
        ImageView imagenViewFotoAnimal = fila.findViewById(R.id.img_foto_animal);
        ImageView imagenPunto = fila.findViewById(R.id.img_punto);

        // Asignamos valor a los componentes identificados anteriormente
        txtViewNombreAnimal.setText(arrayNombresAnimales[position]);
        imagenViewFotoAnimal.setImageDrawable(idFotosAnimales.getDrawable(position));
        txtViewDescripcionAnimal.setText(arrayDescripcionAnimales[position]);
        if (position % 2 == 0) {
            fila.setBackgroundColor(context.getColor(R.color.azul));
        } else {
            fila.setBackgroundColor(context.getColor(R.color.azul_claro));
            txtViewNombreAnimal.setTextColor(context.getColor(R.color.color_nombre_dos));
        }

        switch (arrayNombresAnimales[position]) {
            case "Aguila":
            case "Canario": {
                imagenPunto.setImageDrawable(context.getDrawable(R.drawable.color_verde));
            }
            break;
            case "Ballena":
            case "Delfin": {
                imagenPunto.setImageDrawable(context.getDrawable(R.drawable.color_azul));

            }
            break;
            case "Gato":
            case "Vaca":
            case "Caballo":
            case "Perro": {
                imagenPunto.setImageDrawable(context.getDrawable(R.drawable.color_rosa));
            }
            break;
        }
        // Devolvemos la vista personalizada
        return fila;
    }
}