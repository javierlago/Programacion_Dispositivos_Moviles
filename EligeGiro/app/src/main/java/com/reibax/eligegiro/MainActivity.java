package com.reibax.eligegiro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtGiramos, lblGirando;
    RadioGroup gBtn;
    RadioButton rbTexto, rbImagen;
    Button btnAceptar;
    ImageView imgEspiral;
    EditText editTextGrados;
    int grados;
    int giro;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFinds();
        setListeners();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnAceptar.getId()){

            if(editTextGrados.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this, "El valor no puede estar vacio",Toast.LENGTH_LONG).show();
            }else {
                grados = Integer.parseInt(editTextGrados.getText().toString());
                giro = Integer.parseInt(editTextGrados.getText().toString());

                if (grados < 10 | grados > 90) {
                    Toast.makeText(MainActivity.this, "El rango debe estar entre 10 y 90", Toast.LENGTH_LONG).show();
                } else if (rbImagen.isChecked()) {
                    txtGiramos.setVisibility(View.GONE);
                    gBtn.setVisibility(View.GONE);
                    editTextGrados.setVisibility(View.GONE);
                    btnAceptar.setVisibility(View.GONE);
                    imgEspiral.setVisibility(View.VISIBLE);

                } else {
                    txtGiramos.setVisibility(View.GONE);
                    gBtn.setVisibility(View.GONE);
                    editTextGrados.setVisibility(View.GONE);
                    btnAceptar.setVisibility(View.GONE);
                    lblGirando.setVisibility(View.VISIBLE);
                    }
                }
            }

            if(v.getId()==imgEspiral.getId()){
                girarImagen(imgEspiral,giro);
                giro +=grados;

            }
            if(v.getId()==lblGirando.getId()){

                girarImagen(lblGirando,giro);
                giro +=grados;
            }

    }

    public void setFinds() {
        txtGiramos = findViewById(R.id.lblGiramos);
        lblGirando = findViewById(R.id.lblGirando);
        gBtn = findViewById(R.id.gBtn);
        rbTexto = findViewById(R.id.rbTexto);
        rbImagen = findViewById(R.id.rbImagen);
        btnAceptar = findViewById(R.id.btnAcepatr);
        imgEspiral = findViewById(R.id.imgEspiral);
        editTextGrados = findViewById(R.id.editTextGrados);
    }

    public void setListeners() {
        txtGiramos.setOnClickListener(MainActivity.this);
        lblGirando.setOnClickListener(MainActivity.this);
        gBtn.setOnClickListener(MainActivity.this);
        rbTexto.setOnClickListener(MainActivity.this);
        rbImagen.setOnClickListener(MainActivity.this);
        btnAceptar.setOnClickListener(MainActivity.this);
        imgEspiral.setOnClickListener(MainActivity.this);


    }
    public void girarImagen(View imagen,int grados){
        imagen.setRotation(grados);
    }

}
