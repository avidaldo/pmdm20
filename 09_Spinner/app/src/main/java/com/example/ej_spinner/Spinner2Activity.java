package com.example.ej_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class Spinner2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner2);

        final Spinner spinner = findViewById(R.id.spinner2);

        /* Selecciona el primer elemento antes de setear el escuchador, evitando que este salte en
        el momento en el que se carga de elementos */
        //spinner.setSelection(0,false);

        /* Seteamos un escuchador para el evento de cambio de evento seleccionado
        en el spinner. */
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) findViewById(R.id.textViewElection))
                        .setText("Elección: " + parent.getSelectedItem());
                ((TextView) findViewById(R.id.textViewPosition))
                        .setText("Posición: " + parent.getSelectedItemId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
