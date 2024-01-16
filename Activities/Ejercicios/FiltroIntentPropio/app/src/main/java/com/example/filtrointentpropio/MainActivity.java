package com.example.filtrointentpropio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text_url);

    }

    public void onClickBtn(View view) {
        String srtUrl = editText.getText().toString();
        if (view.getId()==R.id.btn_cargar_web){
          if(!srtUrl.isEmpty()) {
              Intent intent = new Intent(this, ExplicitActivity.class);
              intent.putExtra("url_key", srtUrl);
              startActivity(intent);

          }else{
              Toast.makeText(this,"Introduce url",Toast.LENGTH_LONG).show();
          }

        } else if (view.getId()==R.id.btn_cargar_web_implicito) {
            Intent intern = new Intent(Intent.ACTION_VIEW);
        }


    }
}