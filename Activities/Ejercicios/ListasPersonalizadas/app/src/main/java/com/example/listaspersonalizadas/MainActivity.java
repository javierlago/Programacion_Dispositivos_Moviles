package com.example.listaspersonalizadas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button botonIraListViewConImagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonIraListViewConImagenes = findViewById(R.id.ir_a_list_view_varias_img);
    }


    public void listenerButton(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.ir_a_list_view_varias_img:
                intent.setClass(this,ListViewConVariasImagenes.class);
                break;
            case R.id.ir_a_list_view_varias_img_animales:
                intent.setClass(this, ListViewConImagenesDeAnimales.class);
                break;
        }
        startActivity(intent);
    }
}