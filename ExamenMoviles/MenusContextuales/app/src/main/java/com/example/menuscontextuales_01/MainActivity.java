package com.example.menuscontextuales_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= findViewById(R.id.txt_main);
        imageView = findViewById(R.id.img_main);
        registerForContextMenu(textView);
        registerForContextMenu(imageView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v==textView){
            menu.setHeaderTitle("Menusito");
            getMenuInflater().inflate(R.menu.menu_etiqueta,menu);

        } else if (v==imageView) {
            getMenuInflater().inflate(R.menu.menu_imagen,menu);
        }
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //switch(item.getItemId()){
            if(item.getItemId()== R.id.item_uno) {
                Toast.makeText(this, "Has elegido la opcion uno de la etiqueta", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId()==R.id.item_dos) {
                Toast.makeText(this, "Has elegido la opcion dos de la etiqueta", Toast.LENGTH_SHORT).show();
                return true;
            } else if ( item.getItemId()==R.id.item_uno_img) {
                Toast.makeText(this, "Has elegido la opcion uno de la imagen", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId()==R.id.item_dos_img) {
                Toast.makeText(this, "Has elegido la opcion dos de la imagen", Toast.LENGTH_SHORT).show();
                return true;
            }else{
                return super.onContextItemSelected(item);

            }

    }
}