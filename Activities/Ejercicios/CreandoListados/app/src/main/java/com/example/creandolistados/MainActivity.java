package com.example.creandolistados;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.creandolistados.spiners.ListView2_Activity;
import com.example.creandolistados.spiners.ListView3_Activity;
import com.example.creandolistados.spiners.ListView4_Autocompletar_Activity;
import com.example.creandolistados.spiners.ListViewDiferentesImagenesTypedArray;
import com.example.creandolistados.spiners.ListView_1_Activity;
import com.example.creandolistados.spiners.boton1_Activity;
import com.example.creandolistados.spiners.boton2_Activity;
import com.example.creandolistados.spiners.boton3_Activity;
import com.example.creandolistados.spiners.boton4_Activity;
import com.example.creandolistados.spiners.boton5_Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClickBtnListados(View view) {
        Intent i = new Intent();
        switch (view.getId()) {
            case R.id.button1:
                i.setClass(this, boton1_Activity.class);
                break;

            case R.id.button2:
                i.setClass(this, boton2_Activity.class);
                break;
            case R.id.button3:
                i.setClass(this, boton3_Activity.class);
                break;
            case R.id.button4:
                i.setClass(this, boton4_Activity.class);
                break;
            case R.id.button5:
                i.setClass(this, boton5_Activity.class);
                break;
            case R.id.button6:
                i.setClass(this, Provincias_Activity.class);
                break;
            // probando las list view
            case R.id.list_view:
                i.setClass(this, ListView_1_Activity.class);
                break;
            case R.id.list_View_Planetas2:
                i.setClass(this, ListView2_Activity.class);
                break;
            case R.id.list_View_Planetas3:
                i.setClass(this, ListView3_Activity.class);
                break;
            case R.id.list_View_AutoCompletar:
                i.setClass(this, ListView4_Autocompletar_Activity.class);
                break;
            case R.id.btn_autocompletado_prov:
                i.setClass(this,Activity_autocompletar_provincias.class);
            case R.id.btn_list_view_img:
                i.setClass(this, lista_view_imagenes.class);
            case R.id.btn_list_view_img_varias:
                i.setClass(this, ListViewPersonalizadaImagnes2.class);
            case R.id.btn_list_view_img_varias_typed_array:
                i.setClass(this, ListViewDiferentesImagenesTypedArray.class);

        }
        //startActiviy
        startActivity(i);


    }
}