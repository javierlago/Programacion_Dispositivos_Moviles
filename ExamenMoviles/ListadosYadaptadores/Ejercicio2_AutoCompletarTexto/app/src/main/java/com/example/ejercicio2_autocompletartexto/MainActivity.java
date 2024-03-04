package com.example.ejercicio2_autocompletartexto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextViewNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextViewNames = findViewById(R.id.autoComplete_names);
        ArrayAdapter arrayAdapterNames = new ArrayAdapter(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.nombres));
        autoCompleteTextViewNames.setAdapter(arrayAdapterNames);

        autoCompleteTextViewNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Seleccioon desde el getText()->aa"+ autoCompleteTextViewNames.getText()
                        +"Posicon de lista ->"+ position, Toast.LENGTH_SHORT).show();
            }
        });


    }
}