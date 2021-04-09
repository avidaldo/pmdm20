package com.example.adaptadores2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class Autocompletar1Activity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;

    // Array de palabras que puede elegir el Usuario
    // Podría leerse de un recurso
    private String [] arrayAutocompletado = {"Abel","Ana","Anacleto","Anastasio","Anastasia","Anibal","Antonio"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocompletar1);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        //ArrayAdapter<String> adaptador = ArrayAdapter.createFromResource(this, R.array.nombres, android.R.layout.simple_spinner_dropdown_item));
        //ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, arrayAutocompletado);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, getResources().getStringArray(R.array.nombres));

        // Para que el Autocompletado empiece a dar sugerencias desde la primera palabra que se introduzca
        autoCompleteTextView.setThreshold(1);
        // Añadimos el Adaptador al autoCompleteTextView
        autoCompleteTextView.setAdapter(adaptador);
        // Listener del Autocompletado
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int pos, long id) {
                Toast.makeText(getApplicationContext(),"Has elegido el nombre " + autoCompleteTextView.getText().toString() , Toast.LENGTH_LONG).show();

            }
        });


    }
}
