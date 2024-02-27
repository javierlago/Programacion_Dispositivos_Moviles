package com.example.basesdedatosejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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
                try{
                    db.execSQL("delete from usuarios where codigo = 3");
                    Toast.makeText(this, "Borrado", Toast.LENGTH_SHORT).show();
                }catch (SQLException e){
                    Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
                }
                if(db.delete("usuarios","codigo=2",null)==0){
                    Toast.makeText(this, "Eliminacion erronea", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "no elemento borrado", Toast.LENGTH_SHORT).show();
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

            case R.id.boton_consultar_uno:
                //todo

            case R.id.boton_consulta_varios:

                //todo

        }
    }
}