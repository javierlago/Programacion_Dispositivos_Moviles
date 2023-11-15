package com.example.intentsimplicitos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    // constante identificadora de llamada de telefono
    private static final int llamadaDirecta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @SuppressLint("QueryPermissionsNeeded")
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onclickBtn(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.button:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+34)986454091"));
                startActivity(intent);
                break;
            case R.id.button4:
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
                    intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)986454091"));
                    startActivity(intent);
                }
                break;

            case R.id.button5:
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)986454091"));
                    startActivity(intent);

                } else {
                    // solicitamos al usuario la aceptacion o denegacion del permiso
                    ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CALL_PHONE}, llamadaDirecta);

                }
                break;
            case R.id.button6:

                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.openai.com/"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "No se puede resolver accion", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.button7:

                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:42.877058273485694, -8.546743930256104"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "No se puede resolver accion", Toast.LENGTH_LONG).show();
                }
                break;

        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == llamadaDirecta) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // acciones pertinentes al permiso concedido
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)986454091"));
                startActivity(intent);
                Toast.makeText(this, "El usuario ha concedido", Toast.LENGTH_LONG).show();
            } else {
                // acciones correspondientes al permiso denegado
                Toast.makeText(this, "El usuario ha denegado el permiso de llamada", Toast.LENGTH_LONG).show();

            }
        }
    }
}