package com.example.ejerciciocuatro.actividad;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.ejerciciocuatro.R;

public class OpcionesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
    }
}