package com.example.basesdedatosejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Instanciamos la clase auxiliar que hemos creado
        AuxiliarDataBase auxiliarDataBase = new AuxiliarDataBase(this,"BDusers",null,1);
        // invocar el método de apertura de mi base de datos correpondiente a lo que quiera hacer-> getReadebleDatabase() y getWriteableDatabase();
        db = auxiliarDataBase.getWritableDatabase();



    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boton_insertar:
                //código SQL directo
                try {
                db.execSQL("insert into usuarios (codigo,nombre) values (2,'Juan Rodriguez')");
                }catch (SQLException e){
                    Toast.makeText(this, "Repetida", Toast.LENGTH_SHORT).show();
                }
                // objeto para crear un nuevo registro
                ContentValues nuevoRegistro= new ContentValues();
                nuevoRegistro.put("codigo",3);
                nuevoRegistro.put("nombre","Manuel Rivada");
                if(db.insert("usuarios",null,nuevoRegistro)!=-1){
                    Toast.makeText(this, "insercion realizada", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "No se ha insertado el dato", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.boton_borrar:
                //Borrado mediante codigo y mediante clausula hardcodeada
                // En esta operacion no necesitamos el Content Values
                try{
                    db.execSQL("delete from usuarios where codigo = 3");
                    Toast.makeText(this, "Borrado", Toast.LENGTH_SHORT).show();
                }catch (SQLException e){
                    Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
                }
                if(db.delete("usuarios","codigo=2",null)==0){
                    Toast.makeText(this, "Eliminacion erronea", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Se ha eliminado el elemento", Toast.LENGTH_SHORT).show();
                }
                break;
                

            case R.id.boton_modificar:
                //todo
                try{
                    db.execSQL("update usuarios set nombre='caca' where codigo=1 ");

                }catch (SQLException e){
                    Toast.makeText(this, "Error en la modificacion directa", Toast.LENGTH_SHORT).show();
                }
                //metodo especifico parametrizado
                ContentValues registroAmodificar = new ContentValues();
                registroAmodificar.put("nombre","uwu");
                int filas = db.update("usuarios",registroAmodificar,"codigo=1",null);
                if (filas==0){
                    Toast.makeText(this, "Caca di vaca en el borrado parametrizado", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.boton_consultar_uno:
                // Utilizamos codigo SQL directo
                Cursor cursor = db.rawQuery("select nombre from usuarios where codigo = 1 ",null);
                if(cursor.moveToFirst()){
                    String nombre = cursor.getString(0);
                    Toast.makeText(this, "El nombre recuperado ha sido->"+nombre, Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(this, "No existe el dato en busqueda directa", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
                // metodo parametrizado
                String[] datos = {"nombre"};
                Cursor CursorParametros = db.query("usuarios",datos,"codigo = 4",null,null,null,null);
                if(CursorParametros.moveToFirst()){
                    String nombre = CursorParametros.getString(0);

                }else{
                    Toast.makeText(this, "No existen datos en la busqueda parametrizada", Toast.LENGTH_SHORT).show();

                }
                CursorParametros.close();
                break;
            case R.id.boton_consulta_varios:
                // Utilizamos codigo SQL directo
                Cursor cursor3 = db.rawQuery("select * from usuarios",null);
                if(cursor3.moveToFirst()){
                    do{
                        // los indices recuperados de la consulta
                        int codigo = cursor3.getInt(0);
                        String nombre = cursor3.getString(1);
                        Toast.makeText(this, "El nombre recuperado ha sido->"+nombre + " Codigo "+ codigo, Toast.LENGTH_SHORT).show();

                    }while (cursor3.moveToNext());

                }else {
                    Toast.makeText(this, "No existe el dato en busqueda directa", Toast.LENGTH_SHORT).show();
                }
                cursor3.close();
                // metodo parametrizado
                String[] datos1 = {"codigo","nombre"};
                Cursor cursor4 = db.query("usuarios",datos1,null,null,null,null,null);
                if(cursor4.moveToFirst()){
                    do{
                    int codigo = cursor4.getInt(0);
                    String nombre = cursor4.getString(1);
                    Toast.makeText(this, "Parametrizado-- Nombre-> " + nombre+ " Codigo-> " +codigo, Toast.LENGTH_SHORT).show();
                    }while (cursor4.moveToNext());
                }else{
                    Toast.makeText(this, "No existen datos en la busqueda parametrizada", Toast.LENGTH_SHORT).show();

                }
                cursor4.close();
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}