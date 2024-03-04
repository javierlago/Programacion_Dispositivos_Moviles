package com.example.ejerciciciorepaso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ejerciciciorepaso.ArrayAdapter.AlumnoAdapter;

import Clase.Alumno;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Alumno> listadoAlumnos = new ArrayList<>();
    EditText editTextNombreAlumno;

    ListView ListViewDeAlumnos;
    String curso, ciclo;
    int posicionSpinerUno;

    Spinner spninerCurso;
    Spinner spinnerCiclos;

    AlumnoAdapter adapter;
    int posicion;


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo informaionRecogida = (AdapterView.AdapterContextMenuInfo)menuInfo;
        String alumno = listadoAlumnos.get(informaionRecogida.position).getNombre();
        posicion= informaionRecogida.position;
        menu.setHeaderTitle(alumno);
        getMenuInflater().inflate(R.menu.menu_alumnos,menu);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.opc1:
                adapter.remove(adapter.getItem(posicion));
                adapter.notifyDataSetChanged();
                return true;
            case R.id.opc2:
                Alumno alumno = listadoAlumnos.get(posicion);
                Toast.makeText(this, "Nombre->"+alumno.getNombre(), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListViewDeAlumnos = findViewById(R.id.list_view_alumnos);
        spninerCurso = findViewById(R.id.spiner_cursos);
        spinnerCiclos = findViewById(R.id.spiner_ciclos);
        editTextNombreAlumno = findViewById(R.id.txt_edit_nombre);
        listenerSpiner();
        ListViewDeAlumnos = findViewById(R.id.list_view_alumnos);
        // Crear instancias del adaptador y asignar al ListView
        adapter = new AlumnoAdapter(this, listadoAlumnos);
        ListViewDeAlumnos.setAdapter(adapter);
        //Llenar tu lista de alumnos con datos de ejemplo (reemplázalo con tus datos reales)
        //listadoAlumnos.add(new Alumno("Juan Pérez", "ESO",null,R.drawable.icono_eso));
        //listadoAlumnos.add(new Alumno("María Gómez", "Ciclo",null,R.drawable.icono_resto));

        // Notificar al adaptador sobre los cambios en los datos
        adapter.notifyDataSetChanged();
        ListViewDeAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Alumno alumno = listadoAlumnos.get(position);

                Toast.makeText(MainActivity.this, "Has selecionado "+ alumno.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(ListViewDeAlumnos);













        /*listaDeAlumnos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Alumno alumno = listadoAlumnos.get(position);
                String[] opciones = {"Eliminar el alumno","Mostrar Toast de Alumnos"};
                AlertDialog.Builder ventana = new AlertDialog.Builder(MainActivity.this);
                ventana.setCancelable(false);
                ventana.setTitle(alumno.getNombre());
                //TODO Puedes configurar varias opicones y creas un tistener sobre ellas
                ventana.setItems(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which == 0){
                            listadoAlumnos.remove(position);

                        }else{
                            Toast.makeText(MainActivity.this, "Has selecionado "+ alumno.getNombre(), Toast.LENGTH_SHORT).show();
                        }
                    adapter.notifyDataSetChanged();
                    }
                });
                ventana.show();

                return false;
            }
        });*/

    }





    public void listenerSpiner() {
        spninerCurso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                posicionSpinerUno = position;
                if (position == 2) {
                    System.out.println(position);
                    spinnerCiclos.setVisibility(View.VISIBLE);
                    curso = getResources().getStringArray(R.array.cursos)[position];
                    System.out.println("Has elegido el curso "+ curso);

                } else {
                    curso = getResources().getStringArray(R.array.cursos)[position];
                    System.out.println("Has elegido el curso "+ curso);
                    spinnerCiclos.setVisibility(View.GONE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }


        });
        spinnerCiclos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ciclo = getResources().getStringArray(R.array.cliclos)[position];
                    System.out.println("Has elegido el ciclo "+ ciclo);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {



            }

            ;
        });






    }







    public void onClick(View view) {
        if (view.getId()==R.id.boton_guardar) {
            Alumno alumno = null;
            if (editTextNombreAlumno.getText().toString().equals("") ) {
                Toast.makeText(this, "Debes rellenar el campo con el nombe del alumno", Toast.LENGTH_SHORT).show();
            } else {
                alumno = new Alumno();
                alumno.setNombre(editTextNombreAlumno.getText().toString());
                alumno.setCurso(curso);
                if(posicionSpinerUno==0){
                    alumno.setFoto(R.drawable.icono_eso);
                }else{
                    alumno.setFoto(R.drawable.icono_resto);                }
                if (posicionSpinerUno == 2) {
                    alumno.setClico(ciclo);
                } else {
                    alumno.setClico(null);
                }

            }
            if(alumno!=null){
            listadoAlumnos.add(alumno);}

            adapter.notifyDataSetChanged();
        }
    }






}
