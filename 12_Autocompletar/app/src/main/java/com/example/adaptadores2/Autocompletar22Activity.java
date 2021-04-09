package com.example.adaptadores2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Autocompletar22Activity extends AppCompatActivity {

    AutoCompleteTextView actv;
    Spinner spinnerCiudades;
    TextView tvCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocompletar22);

        spinnerCiudades = findViewById(R.id.spinnerCidades);
        tvCiudades = findViewById(R.id.tv_ciudades);

        actv = findViewById(R.id.provincias);
        actv.setAdapter(ArrayAdapter.createFromResource(this, R.array.provincias_espana,
                android.R.layout.simple_spinner_item));
        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (actv.getText().toString()) {
                    case "A Coruña": setSpinner(R.array.ciudades_corunha); break;
                    case "Lugo": setSpinner(R.array.ciudades_lugo); break;
                    case "Ourense": setSpinner(R.array.ciudades_ourense); break;
                    case "Pontevedra": setSpinner(R.array.ciudades_pontevedra); break;
                    default:
                        Toast.makeText(Autocompletar22Activity.this, "No hay ciudades registradas de esa provincia", Toast.LENGTH_SHORT).show();
                        setSpinner(null);
                }
            }
        });
    }

    private void setSpinner(Integer recurso) {
        if (recurso == null) {
            spinnerCiudades.setVisibility(View.GONE);
            tvCiudades.setVisibility(View.GONE);
        } else {
            spinnerCiudades.setAdapter(ArrayAdapter.createFromResource(this, recurso, android.R.layout.simple_spinner_dropdown_item));
            spinnerCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(Autocompletar22Activity.this, "Provincia: " + actv.getText() +
                            "\nLocalidade: " + spinnerCiudades.getSelectedItem(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            });

            tvCiudades.setVisibility(View.VISIBLE);
            spinnerCiudades.setVisibility(View.VISIBLE);
        }
    }
}
