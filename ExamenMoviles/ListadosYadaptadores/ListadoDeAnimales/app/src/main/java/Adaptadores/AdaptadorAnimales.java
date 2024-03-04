package Adaptadores;

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

import com.example.listadodeanimales.R;

import java.util.List;

public class AdaptadorAnimales extends ArrayAdapter {

    Context contexto;
    String[] nombreAnimales;
    int identificadorLayOutPersonalizado;
    String[] descripcionAnimales;
    TypedArray fotosDeAnimales;
    TypedArray fotosPuntos;

    // Todo Se puede pasar un contexto y no una activity, lo que pasa es que
    //  debemos importar la clase R para acceder a algunos recurso y otro se accede desde el contexto
    public AdaptadorAnimales(@NonNull Context context, int resource,String[] nombreAnimales,String[]descripcionAnimales,TypedArray fotosDeAnimales,TypedArray fotosPuntos) {
        super(context, resource, nombreAnimales);
        this.contexto=context;
        this.identificadorLayOutPersonalizado=resource;
        this.nombreAnimales=nombreAnimales;
        this.descripcionAnimales=descripcionAnimales;
        this.fotosDeAnimales=fotosDeAnimales;
        this.fotosPuntos=fotosPuntos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // inflamos nuestro layout personalizado
        LayoutInflater layoutInflater = LayoutInflater.from(contexto);
        View view = layoutInflater.inflate(identificadorLayOutPersonalizado,null);
        // todo identificar las partes del layout personalizado
        TextView textViewNombneAnimal = view.findViewById(R.id.text_view_nombre_animal);
        TextView textViewDecripcionAnimal = view.findViewById(R.id.text_view_decripcion_animal);
        ImageView imagenDelAnimal = view.findViewById(R.id.img_foto_animal);
        ImageView imageDelPunto = view.findViewById(R.id.img_punto);
        // Todo darle foma al la view seteando los componestes
        if (position %2==0){
            view.setBackgroundColor(contexto.getColor(R.color.blueMagic));
        }else {
            view.setBackgroundColor(contexto.getColor(R.color.magicBlue));
        }
        textViewNombneAnimal.setText(nombreAnimales[position]);
        textViewDecripcionAnimal.setText(descripcionAnimales[position]);
        imagenDelAnimal.setImageDrawable(fotosDeAnimales.getDrawable(position));
        imageDelPunto.setImageDrawable(fotosPuntos.getDrawable(position));
        return view;
    }
}
