package com.example.adaptadores2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Autocompletar1Activity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;

    // Array y ArrayList de palabras que puede elegir el Usuario, ejemplificando el caso de que fuesen cargadas dinámicamente
    private static final String[] arrayAutocompletado = {"Abel","Ana","Anacleto","Anastasio","Anastasia","Anibal","Antonio"};
    private static final List<String> arrayNombres = new ArrayList<String>(Arrays.asList(arrayAutocompletado));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocompletar1);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        // Cargando desde el Array
        //ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.select_dialog_item, arrayAutocompletado);
        // O cargando desde el Array
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, arrayNombres);

        // Si el array de elementos no se va a generar dinámicamente, tiene más sentido leerlo de un recurso
        //ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.select_dialog_item, getResources().getStringArray(R.array.nombres));

        // Para lo cual, mejor, existe un método específico:
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.nombres, android.R.layout.select_dialog_item);

        // Para que el Autocompletado empiece a dar sugerencias desde la primera letra que se introduzca
        autoCompleteTextView.setThreshold(1);

        // Añadimos el Adaptador al autoCompleteTextView
        autoCompleteTextView.setAdapter(adapter);

        // Listener sobre la elección de una de las opciones
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int pos, long id) {
                Toast.makeText(getApplicationContext(),"Has elegido el nombre " + autoCompleteTextView.getText().toString() , Toast.LENGTH_LONG).show();

            }
        });


    }
}
