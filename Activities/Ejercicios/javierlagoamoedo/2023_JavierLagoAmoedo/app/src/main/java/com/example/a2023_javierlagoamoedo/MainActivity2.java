package com.example.a2023_javierlagoamoedo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    EditText valoresMedida,valoresPeso;
    Button btncalcular,btnfinalizarApp;
    String resultado;

    public void setIndice(Float indice) {
        this.indice = indice;
    }

    Float indice;

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        identificadors();
        escuchadores();


    }

    public void identificadors(){
        valoresMedida = findViewById(R.id.valores_medida);
        valoresPeso = findViewById(R.id.valores_peso);
        btncalcular= findViewById(R.id.btn_calcular);
        btnfinalizarApp = findViewById(R.id.btn_finalizar_app);

    }

    public void escuchadores(){
        btncalcular.setOnClickListener(this);
        btnfinalizarApp.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v.getId()==btncalcular.getId()){
            if(!valoresPeso.getText().toString().isEmpty()|| !valoresMedida.getText().toString().isEmpty()){
                float medida = Float.parseFloat(valoresMedida.getText().toString());
                float peso  = Float.parseFloat(valoresPeso.getText().toString());
                calcularIndice(peso,medida);
                calcularEstado(indice);
                Intent intent = new Intent(this,MainActivity3.class);
                Bundle bundle = new Bundle();
                bundle.putFloat("valor_numerico",indice);
                bundle.putString("valor_caracteres",resultado);
                intent.putExtras(bundle);
                startActivity(intent);

            }else {
                Toast.makeText(this,"Debes introducir valores",Toast.LENGTH_LONG).show();
            }






        }


    }

    public void calcularIndice(float peso , float estatura){
       setIndice(peso/(estatura*estatura));
    }

    public void calcularEstado(float resultado){
        String valoracion=null;
        if(resultado<25){
            setResultado("Normal");
        }else if (resultado>=25& resultado<30){
            setResultado("Sobrepeso");
        } else if (resultado>30) {
            setResultado("Obesidad");
        }

    }


}