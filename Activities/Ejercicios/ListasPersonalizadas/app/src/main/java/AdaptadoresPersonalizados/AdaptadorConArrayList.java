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

public class AdaptadorConArrayList extends ArrayAdapter {
        Activity context;
        ArrayList<Planeta> listadoPlanetas;

        int identificadorLayout;


    public AdaptadorConArrayList(@NonNull Activity context, int resource, int textViewResourceId, ArrayList<Planeta> listadoPlanetas) {
        super(context, resource, textViewResourceId);
        this.listadoPlanetas=listadoPlanetas;
        this.context=context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View fila = layoutInflater.inflate(identificadorLayout,null);
        return fila;





    }
}
