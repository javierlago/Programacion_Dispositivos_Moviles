package com.example.imagengiratoria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView giramos ;
    ImageView cohete ;
    int giro=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        giramos = findViewById(R.id.mensaje);
        cohete = findViewById(R.id.cohete);
        cohete.setOnClickListener(this);
        giramos.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.mensaje){
            giramos.setVisibility(View.GONE);
            cohete.setVisibility(View.VISIBLE);
        } else if (view.getId()==R.id.cohete) {
            giro += 45;
            if(giro==360){giro=0;}
            cohete.setRotation(giro);

            
        }


    }
}