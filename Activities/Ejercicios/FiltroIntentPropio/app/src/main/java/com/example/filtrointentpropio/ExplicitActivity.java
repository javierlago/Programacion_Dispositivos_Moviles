package com.example.filtrointentpropio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class ExplicitActivity extends AppCompatActivity {
        WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
        webView = findViewById(R.id.web_view_explicito);
        // capturar el intent
        Intent intent = getIntent();
        String urlRecibida = intent.getExtras().getString("url_key");
        webView.loadUrl(urlRecibida);
        startActivity(intent);
    }
}