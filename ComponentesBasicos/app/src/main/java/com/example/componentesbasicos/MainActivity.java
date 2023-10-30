package com.example.componentesbasicos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ToggleButton toggleButton;
    private Switch switchWifi;

    private CheckBox checkBoxAcept;
    private EditText etTextoAlfaNumerico;
    private EditText etNumber;
    private EditText etDecimal;
    private Button botonStandar;
    private RadioGroup radioGroup1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sentenciasFind();
        sentenciasListener();


    }

    public void onClick(View v) {
        if (v.getId() == R.id.toggle1) {
            if (toggleButton.isChecked()) {
                Toast.makeText(this, "Toggle Activado", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Toggle desactivado", Toast.LENGTH_SHORT).show();
            }


        } else if (v.getId() == R.id.swiWifi) {
            if (switchWifi.isChecked()) {
                Toast.makeText(this, "Wifi Activado", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, "Wifi desctivado", Toast.LENGTH_LONG).show();
            }

        } else if (v.getId() == R.id.chkAcept) {
            if (checkBoxAcept.isChecked()) {
                Toast.makeText(this, "Aceptado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No aceptas", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.boton_normal) {
            String mensaje;
            mensaje = etDecimal.getText().toString() + "\n" +
                    etNumber.getText().toString() + "\n" +
                    etTextoAlfaNumerico.getText().toString();
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();


        }


    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


    public void sentenciasFind() {

        etTextoAlfaNumerico = findViewById(R.id.et_texto_alfanumerico);
        etNumber = findViewById(R.id.et_number);
        etDecimal = findViewById(R.id.et_decimal);
        botonStandar = findViewById(R.id.boton_normal);
        toggleButton = findViewById(R.id.toggle1);
        switchWifi = findViewById(R.id.swiWifi);
        checkBoxAcept = findViewById(R.id.chkAcept);
        radioGroup1 = findViewById(R.id.btn_radio_group);


    }

 public void sentenciasListener(){
     toggleButton.setOnClickListener(this);
     switchWifi.setOnClickListener(this);
     checkBoxAcept.setOnClickListener(this);
     botonStandar.setOnClickListener(this);
    // escuchador para el onCheckedChanged para la checkBox//
     checkBoxAcept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
             if(isChecked){
                 Toast.makeText(MainActivity.this,"Cambio de estado:Acepto",Toast.LENGTH_SHORT).show();
             }else{
                 Toast.makeText(MainActivity.this,"Cambio de etado : Nooooooooooooooo",Toast.LENGTH_SHORT).show();
             }
         }
     });
    // escuchador para el evento de onCheckedChanged para el radioGroup //
     radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(RadioGroup group, int checkedId) {
             if(checkedId== R.id.btnSi){
                 Toast.makeText(MainActivity.this,"Has clicado Si",Toast.LENGTH_SHORT).show();
             }else if(checkedId==R.id.btnNo){
                 Toast.makeText(MainActivity.this,"Has clicado No",Toast.LENGTH_SHORT).show();
             }else{
                 Toast.makeText(MainActivity.this,"Has clicado No",Toast.LENGTH_SHORT).show();
             }

             }

     });


 }
}