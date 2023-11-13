package com.example.cambiandomainactivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String datoAenviar;

    // Código usado para referenciar la activity
    private static final int codigoLlamadaA5 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("cicloDevida", "Ejecuto on Crate");
    }

    public void onClickCambioActivity(View view) {
        if (view.getId() == R.id.btnLlamadaActividad2) {
            // crear un objeto Inten
            Intent intent = new Intent(this, Activity2.class);
            //realeizar la llamada
            startActivity(intent);


        } else if (view.getId() == R.id.btnLlamadaActividad3) {
            // crear otro objeto
            Intent intent = new Intent(this, Activity3.class);
            datoAenviar = "La activity uno envia este mensaje";
            // añadir dato al input
            intent.putExtra("mensaje", datoAenviar);
            startActivity(intent);

        } else if (view.getId() == R.id.btnLlamadaActividad4) {
            Intent intent = new Intent(this, Activity4.class);
            datoAenviar = "La activity uno envia este mensaje a la 4 con Bundle";
            Bundle bundle = new Bundle();
            bundle.putString("mensaje", datoAenviar);
            intent.putExtras(bundle);
            startActivity(intent);

        } else if (view.getId() == R.id.btnLlamadaConEsperaRespuesta) {
            Intent intent = new Intent(this, Activity5.class);
            // llamada esperando  restpuesta
            startActivityForResult(intent, codigoLlamadaA5);
            TextView txtVrespuesta = findViewById(R.id.txtViewRespuesta);
            txtVrespuesta.setText("");
        } else if (view.getId() == R.id.btn_llamada_a_otra_app) {
            Intent intent = new Intent();
            // Llamamos al paquete de la app que queremos llamar y a su clae
            intent.setClassName("com.example.cuentaclicks", "com.example.cuentaclicks.MainActivity");

           /* try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(MainActivity.this, "Ninguna actividad puede realizar esta acción", Toast.LENGTH_SHORT).show();
            }*/

            PackageManager pm = getPackageManager();
            List actividadesPosibles = pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            if (actividadesPosibles.size() > 0) {
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Ninguna actividad puede realizar esta acción", Toast.LENGTH_SHORT).show();
            }

        } else if (view.getId() == R.id.llamar_calculadora) {
            Intent intent = new Intent();
            intent.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException a) {
                Toast.makeText(MainActivity.this, "Ninguna actividad puede realizar esta acción", Toast.LENGTH_SHORT).show();
            }


        }else if (view.getId() == R.id.llamar_settings) {
            Intent intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings.Settings");
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException a) {
                Toast.makeText(MainActivity.this, "Ninguna actividad puede realizar esta acción", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.e("cicloDevida", "Ejecuto onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
        // Vemos quien nos esta contestando con el código que le indicamos en el inicio
        if (requestCode == codigoLlamadaA5) {
            // Testeamos el código de resultado
            if (resultCode == RESULT_OK) {
                // operaciones de si la actividad finalizo según lo previsto
                Toast.makeText(this, "Todo ok", Toast.LENGTH_SHORT).show();
                TextView txtVrespuesta = findViewById(R.id.txtViewRespuesta);
                txtVrespuesta.setText(data.getStringExtra("mensaje"));
            } else {
                // Alternativa para cuando no finaliza segun lo previsto
                Toast.makeText(this, "Algo falla", Toast.LENGTH_SHORT).show();

            }

        }
    }

    protected void onStart() {
        super.onStart();
        Log.i("cicloDevida", "Ejecuto on Start Activity 1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("cicloDevida", "Ejecuto on Stop Activity 1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("cicloDevida", "Ejecuto on Restart Activity 1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("cicloDevida", "Ejecuto on Pause Activity 1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("cicloDevida", "Ejecuto on Destroy Activity 1");

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i("cicloDevida", "Ejecuto on Resume Activity 1");
    }

}