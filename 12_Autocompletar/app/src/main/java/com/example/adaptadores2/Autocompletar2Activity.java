package com.example.adaptadores2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class Autocompletar2Activity extends AppCompatActivity {

    // AutoCompleteTextView de las Provincias
    AutoCompleteTextView provincias;
    // Spinner de las Localidades
    Spinner localidades;

    // Array de las Provincias
    private String[] arrayProvincias = {"A Coruña","Almería","Alicante", "León","Lugo", "Ourense","Palencia","Pontevedra"};
    private String [] sinLocalidades ={"No tenemos localidades"};

    // Arrays de las Localidades
    private String[] arrayCoruña = {"Arteixo", "La Coruña", "Ferrol", "Betanzos"};
    private String[] arrayPontevedra = {"Vigo", "Baiona", "Cangas", "Moaña"};
    private String[] arrayLugo = {"Abadín", "Burela", "Foz", "Guitiriz"};
    private String[] arrayOurense = {"Allariz", "Barbadás", "Carballiño", "Verín"};

    // Arrays de Adaptadores
    private ArrayAdapter<String> adaptadorACoruña;
    private ArrayAdapter<String> adaptadorLugo;
    private ArrayAdapter<String> adaptadorOurense;
    private ArrayAdapter<String> adaptadorPontevedra;
    private ArrayAdapter<String> adaptadorsinLocalidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocompletar2);

        provincias=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        localidades=(Spinner) findViewById(R.id.spinnerLocalidades);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayProvincias);
        provincias.setThreshold(1);
        provincias.setAdapter(adaptador);

        provincias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(provincias.getText().toString().equals("A Coruña")) {
                    cargarLocalidadesSpinner(adaptadorACoruña,arrayCoruña);
                    mostrarToast();
                    mostrarToastLocalidades();
                }
                else if(provincias.getText().toString().equals("Lugo")) {
                    cargarLocalidadesSpinner(adaptadorLugo,arrayLugo);
                    mostrarToast();
                    mostrarToastLocalidades();
                }
                else if(provincias.getText().toString().equals("Ourense")) {
                    cargarLocalidadesSpinner(adaptadorOurense,arrayOurense);
                    mostrarToast();
                    mostrarToastLocalidades();
                }
                else if(provincias.getText().toString().equals("Pontevedra")) {
                    cargarLocalidadesSpinner(adaptadorPontevedra,arrayPontevedra);
                    mostrarToast();
                    mostrarToastLocalidades();
                }
                else if(provincias.getText().toString().equals("Almería") | (provincias.getText().toString().equals("Alicante") | (provincias.getText().toString().equals("León") | (provincias.getText().toString().equals("Palencia"))))) {

                    cargarLocalidadesSpinner(adaptadorsinLocalidades,sinLocalidades);
                    Toast.makeText(getApplicationContext(), "Aún no se han definido localidades", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }


    public void cargarLocalidadesSpinner (ArrayAdapter<String> Adaptador, String [] array) {
        // Creamos el Adaptador con el Array de Localidades de A Coruña
        Adaptador = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, array);
        // Añadimos el Adaptador al Spinner de Localidades
        localidades.setAdapter(Adaptador);

    }
    public void mostrarToast () {
        Toast.makeText(this, "Provincia: " + provincias.getText().toString() + "\nLocalidad: " + localidades.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }
    public void mostrarToastLocalidades() {
        localidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "Provincia: " + provincias.getText().toString() + "\nLocalidad: " + localidades.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}