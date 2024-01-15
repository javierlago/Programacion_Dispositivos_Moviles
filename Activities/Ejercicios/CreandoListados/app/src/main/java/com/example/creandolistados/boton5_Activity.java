package com.example.creandolistados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class boton5_Activity extends AppCompatActivity implements View.OnClickListener {

    Button botonAceptar;
    Spinner spinerPlanetas;
    EditText textoIntroducir;


    ArrayList<String> arrayListPlanetas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton5);
        idents();
        listeners();
        arrayListPlanetas= new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrayListPlanetas);
        spinerPlanetas.setAdapter(adapter);



    }

    public void idents(){
        botonAceptar = findViewById(R.id.botonAceptar);
        spinerPlanetas = findViewById(R.id.spiner5);
        textoIntroducir = findViewById(R.id.texto_anadir);

    }
    public void listeners(){
        botonAceptar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()== botonAceptar.getId() & textoIntroducir.getText().toString().equals("")){
            Toast.makeText(this,"Debes de introducir un valor en la caja de texto",Toast.LENGTH_SHORT).show();
        } else if (v.getId()== botonAceptar.getId() & !textoIntroducir.getText().toString().equals("")) {
            arrayListPlanetas.add(textoIntroducir.getText().toString());
            spinerPlanetas.setVisibility(View.VISIBLE);
            textoIntroducir.setText("");
                    }
    }
}