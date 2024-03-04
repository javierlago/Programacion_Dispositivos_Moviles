package com.example.pruebaexamen2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pruebaexamen2.bbdd.BaseDeDatosFactory;
import com.example.pruebaexamen2.bbdd.BbDdRepository;
import com.example.pruebaexamen2.bbdd.Constantes;


public class MenuBorrado extends AppCompatActivity implements View.OnClickListener {
    EditText codigoBorrar;
    Button borrar,fin;
    SQLiteDatabase sqLiteDatabase;
    BaseDeDatosFactory baseDeDatosFactory=new BaseDeDatosFactory(this, Constantes.nombreBD,null,Constantes.version);
    BbDdRepository bbDdRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_borrado);
        sqLiteDatabase=baseDeDatosFactory.getWritableDatabase();
        bbDdRepository = new BbDdRepository(sqLiteDatabase,this);
        codigoBorrar = findViewById(R.id.edit_text_codigo_borrar_usuario);
        borrar = findViewById(R.id.boton_borrar_usuario);
        fin = findViewById(R.id.boton_fin_borrar_alumno);
        borrar.setOnClickListener(this);
        fin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==borrar){
            if(codigoBorrar.getText().toString().length()==0){
                Toast.makeText(this, "Introduce un codigo", Toast.LENGTH_SHORT).show();
            }else{
                if(bbDdRepository.borrarUsuario(Integer.parseInt(codigoBorrar.getText().toString()),sqLiteDatabase)){
                    codigoBorrar.setText("");
                }
            }
        } else if (v==fin) {
            finish();

        }


    }
}