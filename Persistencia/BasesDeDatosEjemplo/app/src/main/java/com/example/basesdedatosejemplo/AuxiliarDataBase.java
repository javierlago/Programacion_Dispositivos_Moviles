package com.example.basesdedatosejemplo;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class AuxiliarDataBase extends SQLiteOpenHelper {
    private String strCreateTable = "CREATE TABLE usuarios(codigo int primary key,nombre TEXT)";
    //Creacion de un contexto para poder usarlo en el toast
    private Context context;
    public AuxiliarDataBase(@Nullable Context context,
                            @Nullable String name,
                            @Nullable SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, name, factory, version);
        // Asignacion del contexto creado al que recibe por parametro
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // sentencia de la creacion de la tabla en la base de datos
        db.execSQL(strCreateTable);
        // sentencia de insercion de los datos iniciales
        try {
            db.execSQL("insert into usuarios (codigo,nombre) values (1,'Pepe Perez')");
        }catch (SQLException e){
            Toast.makeText(context, "Error en la inserccion de datos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
