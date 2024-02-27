package com.example.persitencia_1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.persistencia_1:
                System.out.println("Hola");
                SharedPreferences.Editor editorPreferecia = sharedPreferences.edit();
                editorPreferecia.putString("nombre","Manolo");
                editorPreferecia.putString("e-mail","manolo@gmail.com");
                editorPreferecia.apply();
                Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();
                break;

            case R.id.persistencia_2:
                System.out.println("Adios");
                String nombre = sharedPreferences.getString("nombre","no data");
                String correo = sharedPreferences.getString("e-mail","no data");
                Toast.makeText(this, "nombre: "+nombre + " Correo: "+correo, Toast.LENGTH_SHORT).show();
                break;


        }


    }
}