package com.example.textviewporcodigo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
//paquete que contiene la clase TextView

public class MainActivity extends AppCompatActivity {

    private TextView tvMsg ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // asociar objeto text view con la correspondiente visata del layout
        tvMsg = findViewById(R.id.tvMsg);

    }

    public void onClickBtn(View view) {

        if (view.getId() == R.id.btnSi) {
            tvMsg.setText("Has pulsado si");
        } else if (view.getId() == R.id.btnNo) {
            tvMsg.setText("Has pulsado no");
        } else if (view.getId() == R.id.btnAveces) {
            tvMsg.setText("Has pulsado a veces");
        }

    }

   /* public void onClickBtnSi(View view) {
        //Operaciones para el boton Si
        tvMsg.setText("Le has dado al si");
    }

    public void onClickBtnNo(View view) {

        //Operaciones para el boton No
        tvMsg.setText("Le has dado al no");
    }

    public void onClickBtnAveces(View view) {
        //Operaciones para el boton A veces
        tvMsg.setText("Le has dado al a veces");
    }*/




}

