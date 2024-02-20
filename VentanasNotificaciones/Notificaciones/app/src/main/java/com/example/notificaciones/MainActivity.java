package com.example.notificaciones;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnsVentanas(View view) {
        switch (view.getId()) {
            case R.id.dialogo_con_mensaje: {
                dialogoMensaje();
                break;
            }
            case R.id.ventana2: {
                dialogoVentana1Boton();
                break;
            }
            case R.id.button3: {
                dialogoConLista();
                break;
            }
            case R.id.button4: {
                // Opcion con funcionalidad cuestionable.No se puede hacer asi ya que al seleccionar un item se cierra la ventana sin la posibilidad de darle al boton "OK"
                dialogoConListaYbotonAcept();
                break;
            }
            case R.id.button5: {
                dialogoConListaYbotonAceptBien();
                break;
            }
            case R.id.button6: {
                dialogoConListaMultipleYbotonAceptBien();
                break;
            }


        }


    }


    // Metodo con el que se crea la ventana
    private void dialogoMensaje() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.taxi);
        alertDialogBuilder.setMessage("Esto es una ventana");
        alertDialogBuilder.setTitle("Atencion");
        alertDialogBuilder.show();


    }

    private void dialogoVentana1Boton() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.taxi).setTitle("esto es un aviso").setMessage("hola que tal");
        ventana.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(MainActivity.this, "Has pulsado ok", Toast.LENGTH_SHORT).show();
                // Personalizacion de las toast
                Toast toast = Toast.makeText(MainActivity.this, "Toast por defecto", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP,0,0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
                dialog.cancel();
            }
        });
        ventana.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(MainActivity.this, "Has pulsado cancel", Toast.LENGTH_SHORT).show();
                // Toast personalizada desde un layout creado previamente
                toastPersonalizada();

                dialog.cancel();
            }
        });
        ventana.show();
    }

    private void toastPersonalizada() {
        LinearLayout linearLayoutToast = findViewById(R.id.ll_toast);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.toast_personalizada,linearLayoutToast);
        TextView textView = view.findViewById(R.id.txt_mensaje_toast);
        textView.setText("Has pulsado cancelar");
        // Primero hemos inflado el layout y depues generamos la toast
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }

    private void dialogoConLista() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.taxi);
        alertDialogBuilder.setTitle("Escoje un color");
        alertDialogBuilder.setItems(R.array.colores, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Has elegido " + getResources().getStringArray(R.array.colores)[which], Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        alertDialogBuilder.show();
    }

    private void dialogoConListaYbotonAcept() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.taxi);
        alertDialogBuilder.setTitle("Escoje un color con boton");
        alertDialogBuilder.setItems(R.array.colores, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color = getResources().getStringArray(R.array.colores)[which];

            }
        });


        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Has elegido " + color, Toast.LENGTH_SHORT).show();
            }
        });

        alertDialogBuilder.show();
    }

    private void dialogoConListaYbotonAceptBien() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.taxi);
        alertDialogBuilder.setTitle("Escoje un color con boton");
        alertDialogBuilder.setSingleChoiceItems(R.array.colores, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color = getResources().getStringArray(R.array.colores)[which];
            }
        });
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Has elegido " + color, Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogBuilder.show();


    }


    private void dialogoConListaMultipleYbotonAceptBien() {
        ArrayList<Integer> selectedItems = new ArrayList<>();  // Where we track the selected items
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(R.drawable.taxi);
        alertDialogBuilder.setTitle("Escoje un color con boton");
        alertDialogBuilder.setMultiChoiceItems(R.array.colores, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    // Verificamos que el item ha sido seleccionado y lo añadimos a un array
                    selectedItems.add(which);

                } else if (selectedItems.contains(which)) {
                    // si se vuelve a clicar sobre el item este se borrara de la lista de los selecciondados
                    selectedItems.remove(which);
                }
            }
        });
        alertDialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (selectedItems.size() == 0) {
                    Toast.makeText(MainActivity.this, "No has seleccionado nada", Toast.LENGTH_SHORT).show();
                } else {

                    StringBuilder selecciones = new StringBuilder();
                    for (Integer i : selectedItems) {
                        selecciones.append(getResources().getStringArray(R.array.colores)[i]).append(" ");
                    }
                    Toast.makeText(MainActivity.this, "Has elegido " + selecciones, Toast.LENGTH_SHORT).show();

                }


            }


        });

        alertDialogBuilder.show();
    }


}
