package com.example.a2023_javierlagoamoedo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {

    private static final int llamadaDirecta = 0;
    Button ok, volver;
    RadioButton rbtWikipedia, rbtLlamada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        identificadores();
        escuchadores();
    }

    public void identificadores() {
        ok = findViewById(R.id.boton_ok);
        volver = findViewById(R.id.boton_volver_atras);
        rbtWikipedia = findViewById(R.id.rbt_wikipedia);
        rbtLlamada = findViewById(R.id.rbt_llamada);



    }


    public void escuchadores() {
        rbtLlamada.setOnClickListener(MainActivity4.this);
        rbtWikipedia.setOnClickListener(MainActivity4.this);
        volver.setOnClickListener(MainActivity4.this);


    }

    public void btnok(View view) {
        Intent intent = new Intent();
        if(rbtWikipedia.isChecked()){
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://es.wikipedia.org/wiki/Indice_de_masa_corporal"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No se puede resolver accion", Toast.LENGTH_LONG).show();
        }
        } else if (rbtLlamada.isChecked()) {
            // averiguar se ya se concedio el permiso
            if (Build.VERSION.SDK_INT >= 23) {// evitar la ejecucion en apis anteriores
                if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)986454091"));
                    startActivity(intent);

                } else {
                    // solicitamos al usuario la aceptacion o denegacion del permiso
                    requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE}, llamadaDirecta);

                }
            } else {// en apis anteriores a la 23 realizamos la accion dorectamente
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)999555555"));
                startActivity(intent);
            }

        }


    }

    @Override
    public void onClick(View v) {

        if(v.getId()==volver.getId()){
            finish();
        }

    }


    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == llamadaDirecta) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // acciones pertinentes al permiso concedido
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)999555555"));
                startActivity(intent);
                Toast.makeText(this, "El usuario ha concedido", Toast.LENGTH_LONG).show();
            } else {
                // acciones correspondientes al permiso denegado
                Toast.makeText(this, "El usuario ha denegado el permiso de llamada", Toast.LENGTH_LONG).show();

            }
        }
    }





}