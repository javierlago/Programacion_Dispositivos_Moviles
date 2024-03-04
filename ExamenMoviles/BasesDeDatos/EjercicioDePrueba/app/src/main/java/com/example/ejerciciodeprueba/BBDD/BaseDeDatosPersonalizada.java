package com.example.ejerciciodeprueba.BBDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDeDatosPersonalizada extends SQLiteOpenHelper {
    private String strCreateTable = "CREATE TABLE usuarios(codigo int primary key,nombre TEXT)";
    //Creacion de un contexto para poder usarlo en el toast
    private Context context;
    public BaseDeDatosPersonalizada(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;



    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(strCreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Usuarios");
        db.execSQL(strCreateTable);

    }
}
