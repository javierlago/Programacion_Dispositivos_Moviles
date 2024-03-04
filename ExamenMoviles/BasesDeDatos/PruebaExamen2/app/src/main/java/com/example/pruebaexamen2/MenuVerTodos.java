package com.example.pruebaexamen2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.pruebaexamen2.Adaptadores.AdapatadoPersonalizado;
import com.example.pruebaexamen2.Usuario.Usuario;
import com.example.pruebaexamen2.bbdd.BaseDeDatosFactory;
import com.example.pruebaexamen2.bbdd.BbDdRepository;
import com.example.pruebaexamen2.bbdd.Constantes;

import java.util.ArrayList;

public class MenuVerTodos extends AppCompatActivity implements View.OnClickListener{
    SQLiteDatabase sqLiteDatabase;

    Button botonSalir;

    ListView listViewdeUsuarios;

    ArrayList<Usuario> listaDeUsuarios= new ArrayList<>();
    BaseDeDatosFactory baseDeDatosFactory=new BaseDeDatosFactory(this, Constantes.nombreBD,null,Constantes.version);
    BbDdRepository bbDdRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ver_todos);
        sqLiteDatabase= baseDeDatosFactory.getReadableDatabase();
        bbDdRepository = new BbDdRepository(sqLiteDatabase,this);
        listaDeUsuarios = bbDdRepository.recuperarTodos(listaDeUsuarios,sqLiteDatabase);
        botonSalir = findViewById(R.id.boton_fin_list_view);
        botonSalir.setOnClickListener(this);
        listViewdeUsuarios = findViewById(R.id.list_view_usuarios);
        AdapatadoPersonalizado adapatadoPersonalizado = new AdapatadoPersonalizado(this,R.layout.layout_personalizado,listaDeUsuarios);
        listViewdeUsuarios.setAdapter(adapatadoPersonalizado);


    }

    @Override
    public void onClick(View v) {
        if(v==botonSalir){
            finish();
        }

    }
}