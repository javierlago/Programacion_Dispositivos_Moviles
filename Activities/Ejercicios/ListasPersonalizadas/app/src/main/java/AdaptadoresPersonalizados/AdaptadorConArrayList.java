package AdaptadoresPersonalizados;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import Array_planetas.Planeta;

public class AdaptadorConArrayList extends ArrayAdapter {
        Activity activity;
        ArrayList<Planeta> listadoPlanetas;


    public AdaptadorConArrayList(@NonNull Context context, int resource, int textViewResourceId, ArrayList<Planeta> listadoPlanetas) {
        super(context, resource, textViewResourceId);
        this.listadoPlanetas=listadoPlanetas;
    }
}
