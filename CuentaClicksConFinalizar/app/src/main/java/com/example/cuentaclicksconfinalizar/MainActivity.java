package com.example.cuentaclicksconfinalizar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView contador;
    Button btnSumar,btnFinalizar;
    int clicks = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = findViewById(R.id.numeroDeClicks);
        btnSumar = findViewById(R.id.btnSumar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnSumar.setOnClickListener(this);
        btnFinalizar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        /* Para que un listener funcione con varios botones lo que se tiene que hacer es comprobar
         la coincidencia de las IDs "view.getId() == btnSumar.getId()" de esta manera se verifica
         el boton que se ha ejecutado y asi se hace una funcion diferente a cada boton.

        */
        if (view.getId() == btnSumar.getId()) {
            contador.setText("");
            clicks += 1;
        }
        else if (view.getId()==btnFinalizar.getId()){
            contador.setText("Has pulsado "+ clicks + "veces");
            clicks =0;
        }

    }
}