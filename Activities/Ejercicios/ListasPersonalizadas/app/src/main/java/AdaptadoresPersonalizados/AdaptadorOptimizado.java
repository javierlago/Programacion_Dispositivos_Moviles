package AdaptadoresPersonalizados;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import Array_planetas.Planeta;

public class AdaptadorOptimizado extends ArrayAdapter {
    Activity context;
    ArrayList<Planeta> listadoPlanetas;

    int identificadorLayout;


    public AdaptadorOptimizado(@NonNull Activity context, int identificadorLayout, int textViewResourceId, ArrayList<Planeta> listadoPlanetas) {
        super(context, identificadorLayout, textViewResourceId);
        this.listadoPlanetas=listadoPlanetas;
        this.context=context;
        this.identificadorLayout=identificadorLayout;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;

        if(item == null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            item = inflater.inflate(identificadorLayout, null);
        }







        return(item);





    }
}
