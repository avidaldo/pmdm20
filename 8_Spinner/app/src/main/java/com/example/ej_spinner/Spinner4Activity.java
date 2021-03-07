package com.example.ej_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Spinner4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner4);

        final Spinner spinner = findViewById(R.id.spinner);

        // Creando el adaptador desde un recurso
        /*spinner.setAdapter(ArrayAdapter.createFromResource(this,
                R.array.planetas, R.layout.chachi_spinner_item));*/

        spinner.setAdapter(ArrayAdapter.createFromResource(this,
                R.array.planetas, R.layout.chachi_spinner_item));


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) findViewById(R.id.textViewElection)).setText("Elección: " + spinner.getSelectedItem());
                ((TextView) findViewById(R.id.textViewPosition)).setText("Posición: " + spinner.getSelectedItemId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
