package com.example.ejerciciodeprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ejerciciodeprueba.Adaptadores.AdaptadorAlumnos;
import com.example.ejerciciodeprueba.BBDD.BaseDeDatosPersonalizada;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    SQLiteDatabase baseDeDatos;
    ListView listViewAlumnos;
    Button botonGuardar,botonBorrar;
    EditText editTextNombreAlumno,editTextCodigoAlumno;
    ArrayList<Usuario> listDeUsuarios = new ArrayList<>();
    AdaptadorAlumnos adaptadorAlumnos;
    BaseDeDatosPersonalizada baseDeDatosPersonalizada = new BaseDeDatosPersonalizada(this,"BaseDeDatosUsuarios",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Todo Creamos el objeto pero luego tenemos que asocicarlo a una variable del tipo SQLiteDatabase

        // todo asignacion del objeto a nuestra avariable de tipo SQLiteDatabase, con este metodo lo que hacemos es que podemos escribire y leer en la base de datos
        identificadores();
        listeners();

        baseDeDatos = baseDeDatosPersonalizada.getWritableDatabase();
        listDeUsuarios = recuperarDatos(listDeUsuarios);
        adaptadorAlumnos = new AdaptadorAlumnos(this,R.layout.layout_datos_alumno, listDeUsuarios);
        listViewAlumnos.setAdapter(adaptadorAlumnos);



    }





    public void identificadores(){
        listViewAlumnos = findViewById(R.id.list_view_del_alumnado);
        botonGuardar = findViewById(R.id.boton_guardar);
        botonBorrar = findViewById(R.id.boton_borrar);
        editTextNombreAlumno = findViewById(R.id.nombre_del_alumno);
        editTextCodigoAlumno = findViewById(R.id.edit_text_codigo);


    }

    public void listeners(){
        botonGuardar.setOnClickListener(this);
        botonBorrar.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v==botonGuardar){
            if (editTextNombreAlumno.getText().toString().isEmpty()|| editTextCodigoAlumno.getText().toString().isEmpty()){
                Toast.makeText(this, "Rellena los campos", Toast.LENGTH_SHORT).show();
            }else{

                if(verificarUsuario(Integer.parseInt(editTextCodigoAlumno.getText().toString()))){
                    Toast.makeText(this, "Usuario ya existe", Toast.LENGTH_SHORT).show();
                }else{
                Usuario usuario = new Usuario(Integer.parseInt(editTextCodigoAlumno.getText().toString()),editTextNombreAlumno.getText().toString());
                listDeUsuarios.add(usuario);
                adaptadorAlumnos.notifyDataSetChanged();
                // objeto para crear un nuevo registro
                ContentValues nuevoRegistro= new ContentValues();
                nuevoRegistro.put("codigo",usuario.getCodigo());
                nuevoRegistro.put("nombre",usuario.getNombre());
                if(baseDeDatos.insert("usuarios",null,nuevoRegistro)!=-1){
                    Toast.makeText(this, "insercion realizada", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "No se ha insertado el dato", Toast.LENGTH_SHORT).show();
                }

            }


            }


        } else if (v==botonBorrar) {
            if(editTextCodigoAlumno.getText().toString().isEmpty()){
                Toast.makeText(this, "Debes indicar un codigo", Toast.LENGTH_SHORT).show();
            }else{
                if(verificarUsuario(Integer.parseInt(editTextCodigoAlumno.getText().toString()))){
                    int posicionAborrar=-1;
                    baseDeDatos.delete("usuarios","codigo=?",new String[]{editTextCodigoAlumno.getText().toString()});
                    Toast.makeText(this, "Se ha elimninado el usuario", Toast.LENGTH_SHORT).show();
                    for(int i=0;i<listDeUsuarios.size();i++){
                        if(listDeUsuarios.get(i).getCodigo()==Integer.parseInt(editTextCodigoAlumno.getText().toString())){
                            posicionAborrar=i;
                        }
                    }
                    try {
                        listDeUsuarios.remove(posicionAborrar);
                    }catch (IndexOutOfBoundsException e){
                        e.printStackTrace();
                    }
                    adaptadorAlumnos.notifyDataSetChanged();


                }else{
                    Toast.makeText(this, "usuario a borrar", Toast.LENGTH_SHORT).show();
                }



            }



        }








    }

    public ArrayList<Usuario> recuperarDatos(ArrayList<Usuario> listado) {
        // metodo parametrizado
        String[] datos1 = {"codigo", "nombre"};
        Cursor cursor4 = baseDeDatos.query("usuarios", datos1, null, null, null, null, null);
        if (cursor4.moveToFirst()) {
            do {
                Usuario usuario = new Usuario();
                usuario.setCodigo(cursor4.getInt(0));
                usuario.setNombre(cursor4.getString(1));
                listDeUsuarios.add(usuario);
            } while (cursor4.moveToNext());
        }
        cursor4.close();
    return listado;
    }

    public boolean verificarUsuario(int codigo) {
        // Método parametrizado
        String[] datos = {"codigo"};

        // Utiliza un argumento de selección para comparar el código proporcionado
        Cursor cursorParametros = baseDeDatos.query("usuarios", datos, "codigo = ?", new String[]{String.valueOf(codigo)}, null, null, null);

        // Verifica si el cursor tiene algún resultado
        boolean usuarioExiste = cursorParametros.moveToFirst();

        cursorParametros.close(); // Cierra el cursor después de usarlo

        return usuarioExiste;
    }











}