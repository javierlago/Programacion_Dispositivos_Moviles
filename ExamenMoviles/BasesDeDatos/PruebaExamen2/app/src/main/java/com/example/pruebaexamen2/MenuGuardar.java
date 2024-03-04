package com.example.pruebaexamen2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pruebaexamen2.bbdd.BaseDeDatosFactory;
import com.example.pruebaexamen2.bbdd.BbDdRepository;
import com.example.pruebaexamen2.bbdd.Constantes;

public class MenuGuardar extends AppCompatActivity implements View.OnClickListener{

    SQLiteDatabase sqLiteDatabase;

    Button guardar,fin;
    TextView editTextNombreUsuario,codigoUsuario,editTextApellidos;



    BaseDeDatosFactory baseDeDatosFactory=new BaseDeDatosFactory(this, Constantes.nombreBD,null,Constantes.version);
    BbDdRepository bbDdRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_guardar);
        sqLiteDatabase= baseDeDatosFactory.getWritableDatabase();
        guardar = findViewById(R.id.boton_guardar_alumno);
        fin = findViewById(R.id.boton_fin_guardar_alumno);
        editTextNombreUsuario = findViewById(R.id.edit_text_nombre_guardar_usuario);
        editTextApellidos = findViewById(R.id.edit_text_nombre_guardar_usuario_apellidos);
        codigoUsuario= findViewById(R.id.edit_text_codigo_guardar_alumno);
        guardar.setOnClickListener(this);
        fin.setOnClickListener(this);
        bbDdRepository = new BbDdRepository(sqLiteDatabase,this);
    }


    @Override
    public void onClick(View v) {
        if(v==guardar){
            if(editTextNombreUsuario.getText().toString().length()==0||editTextApellidos.getText().toString().length()==0||codigoUsuario.getText().toString().length()==0){
                Toast.makeText(this, "Datos Vacios", Toast.LENGTH_SHORT).show();
            }else{

            if(bbDdRepository.validarCodigo(Integer.parseInt(codigoUsuario.getText().toString()))){
                Toast.makeText(this, "Codigo existe", Toast.LENGTH_SHORT).show();
                codigoUsuario.setText("");
            }else {
                if(bbDdRepository.insertarUsuario(Integer.parseInt(codigoUsuario.getText().toString()),editTextNombreUsuario.getText().toString()
                        ,editTextApellidos.getText().toString())){
                    editTextApellidos.setText("");
                    editTextNombreUsuario.setText("");
                    codigoUsuario.setText("");
                }




            }
            }

        } else if (v==fin) {
            finish();

        }
    }
}