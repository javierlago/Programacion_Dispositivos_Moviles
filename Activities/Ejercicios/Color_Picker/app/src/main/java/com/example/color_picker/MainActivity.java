package com.example.color_picker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    SeekBar barra1,barra2,barra3;
    View pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indentando();
        barra1.setMax(255);
        barra2.setMax(255);
        barra3.setMax(255);
    }



    public void indentando(){
        barra1 = findViewById(R.id.seekBar);
        barra2 = findViewById(R.id.seekBar2);
        barra3 = findViewById(R.id.seekBar3);
        pantalla = findViewById(R.id.pantalla);

        barra1.setOnSeekBarChangeListener(seekBarChangeListener);
        barra2.setOnSeekBarChangeListener(seekBarChangeListener);
        barra3.setOnSeekBarChangeListener(seekBarChangeListener);




    }
    private final SeekBar.OnSeekBarChangeListener seekBarChangeListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                    // Calcula un color RGB basado en los valores de las SeekBars
                    int red = barra1.getProgress();
                    int green = barra2.getProgress();
                    int blue = barra3.getProgress();
                    int color = Color.rgb(red, green, blue);

                    // Actualiza el color de fondo de la View
                    pantalla.setBackgroundColor(color);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    // No es necesario implementar para este ejemplo
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    // No es necesario implementar para este ejemplo
                }
            };



}