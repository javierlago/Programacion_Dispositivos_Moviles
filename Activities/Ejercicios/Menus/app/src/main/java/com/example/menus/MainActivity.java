package com.example.menus;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Inflar mi archivo de xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opc_item_1:
                Toast.makeText(this, "Has elegido el 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opc_item_1_1:
                Toast.makeText(this, "Has elegido el 1 SUB 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opc_item_1_2:
                Toast.makeText(this, "Has elegido el 1 SUB 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opc_item_2:
                Toast.makeText(this, "Has elegido el 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opc_item_3:
                Toast.makeText(this, "Has elegido el 3", Toast.LENGTH_SHORT).show();
                return true;

        }


        return super.onOptionsItemSelected(item);
    }
}