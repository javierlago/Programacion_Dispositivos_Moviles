package com.example.cambiandomainactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String datoAenviar;
    private static final int codigoLlamadaA5 =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCambioActivity(View view) {
        if(view.getId() == R.id.btnLlamadaActividad2){
          // crear un objeto Inten
            Intent intent = new Intent(this,Activity2.class);
          //realeizar la llamada
            startActivity(intent);
        } else if (view.getId()== R.id.btnLlamadaActividad3) {
          // crear otro objeto
          Intent intent = new Intent(this, Activity3.class);
          datoAenviar = "La activity uno envia este mensaje";
          // añadir dato al input
          intent.putExtra("mensaje",datoAenviar);
          startActivity(intent);

        }else if (view.getId()==R.id.btnLlamadaActividad4) {
          Intent intent = new Intent(this, Activity4.class);
          datoAenviar = "La activity uno envia este mensaje a la 4 con Bundle";
          Bundle bundle = new Bundle();
          bundle.putString("mensaje",datoAenviar);
          intent.putExtras(bundle);
          startActivity(intent);

        }else if (view.getId()== R.id.btnLlamadaConEsperaRespuesta) {
            Intent intent = new Intent(this,Activity5.class);
            // llamada esperando  restpuesta
            startActivityForResult(intent,codigoLlamadaA5);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Vemos quien nos esta contestando
        if (requestCode== codigoLlamadaA5){
            // Testeamos el código de resultado
            if(resultCode==RESULT_OK){
                // operaciones de si la actividad finalizo según lo previsto
                Toast.makeText(this,"Todo ok", Toast.LENGTH_SHORT).show();
                TextView txtVrespuesta = findViewById(R.id.txtViewRespuesta);
                txtVrespuesta.setText(data.getStringExtra("mensaje"));
            }else{
                // Alternativa para cuando no finaliza segun lo previsto
                Toast.makeText(this,"Algo falla", Toast.LENGTH_SHORT).show();

            }

        }
    }
}