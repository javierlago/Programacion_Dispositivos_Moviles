package com.example.pruebaexamen2.bbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.pruebaexamen2.Usuario.Usuario;

import java.util.ArrayList;

public class BbDdRepository {


    SQLiteDatabase sqLiteDatabase;
    Context context;

    public BbDdRepository(SQLiteDatabase sqLiteDatabase,Context context) {
        this.sqLiteDatabase = sqLiteDatabase;
        this.context=context;

    }

    public ArrayList<Usuario> recuperarTodos(ArrayList<Usuario> arrayListArellenar,SQLiteDatabase sqLiteDatabase){
        Cursor cursor = sqLiteDatabase.query(Constantes.nombreTabla,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                Usuario usuario = new Usuario();
                usuario.setCodigo( cursor.getString(0));
                usuario.setNombre(cursor.getString(1));
                usuario.setApellido(cursor.getString(2));
                arrayListArellenar.add(usuario);
            }while (cursor.moveToNext());
        }
        cursor.close();

        return arrayListArellenar;
    }




    public boolean borrarUsuario(int codigo,SQLiteDatabase sqLiteDatabase){

        if(sqLiteDatabase.delete(Constantes.nombreTabla,"codigo=?",new String[]{String.valueOf(codigo)})>0){
            Toast.makeText(context, "Usuario borrado", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            Toast.makeText(context, "No se ha borrado", Toast.LENGTH_SHORT).show();
            return false;
        }



    }
    public boolean insertarUsuario(int codigo,String nombre,String apellidos){
        ContentValues registro = new ContentValues();
        registro.put("nombre",nombre);
        registro.put("apellidos",apellidos);
        registro.put("codigo",codigo);
        if(sqLiteDatabase.insert(Constantes.nombreTabla,null,registro)!=-1){
            Toast.makeText(context, "Se ha insertado el usuario", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            Toast.makeText(context, "No se ha realizado la inserccion", Toast.LENGTH_SHORT).show();
            return false;
        }



    }




    public boolean validarCodigo(int codigo){
            // Método parametrizado
            String[] datos = {"codigo"};
            // Utiliza un argumento de selección para comparar el código proporcionado
            Cursor cursorParametros = sqLiteDatabase.query(Constantes.nombreTabla, datos, "codigo = ?", new String[]{String.valueOf(codigo)}, null, null, null);
            // Verifica si el cursor tiene algún resultado
            boolean usuarioExiste = cursorParametros.moveToFirst();
            cursorParametros.close(); // Cierra el cursor después de usarlo
            return usuarioExiste;
        }


}
