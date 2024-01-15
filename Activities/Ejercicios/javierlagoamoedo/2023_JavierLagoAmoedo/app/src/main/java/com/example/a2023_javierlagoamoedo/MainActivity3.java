package com.example.a2023_javierlagoamoedo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity3 extends AppCompatActivity {
    TextView floatFinal,stringFinal;
    ImageView imageView;

    Float  floatRecivido;
    String  stringRecivido;

    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        indentificadores();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        stringRecivido = bundle.getString("valor_caracteres");
        floatRecivido = bundle.getFloat("valor_numerico");
        stringFinal.setText(stringRecivido);
        floatFinal.setText(String.valueOf(df.format(floatRecivido)));
        configurarImg(floatRecivido);


        //imageView.setImageDrawable(getDrawable(getResources().getDrawable(R.drawable.)));



    }

    public void indentificadores(){
    floatFinal = findViewById(R.id.float_resultado_final);
    stringFinal = findViewById(R.id.string_estado_final);
    imageView = findViewById(R.id.imageFinal);

    }

    public void configurarImg(float imc){
        if(imc<25){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.imc_correcto));
        }else if (imc>=25& imc<30){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.imc_sobrepeso));
        } else if (imc>30) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.imc_sobrepeso));

        }



    }



}