package com.example.examen3t;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String OPCIONES = "opciones";
    int check=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> listoOpciones = new ArrayList<String>();
        listoOpciones.add(getResources().getString(R.string.cabeceraspinner));
        listoOpciones.addAll(Arrays.asList(getResources().getStringArray(R.array.generos)));
        listoOpciones.add(getResources().getString(R.string.varios));

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                listoOpciones);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinnerAlbumes = findViewById(R.id.spinner_albumes);
        spinnerAlbumes.setAdapter(adaptador);

        spinnerAlbumes.setSelection(0,false);
        spinnerAlbumes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0) return; // cabecera
                else if (position==4) showSelectorGenerosDialog();
                else toListadoActivity(position-1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

    }


    private void toListadoActivity(int position) {
        boolean[] seleccion = {false, false, false};
        seleccion[position] = true;

        toListadoActivity(seleccion);
    }

    private void toListadoActivity(boolean[] seleccion) {
        Intent intent = new Intent(this, ListadoActivity.class);
        intent.putExtra(OPCIONES, seleccion);
        startActivity(intent);
    }


    private void showSelectorGenerosDialog() {
        String[] stringArray = getResources().getStringArray(R.array.generos);
        boolean[] seleccion = {false, false, false};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Elige géneros")
                .setMultiChoiceItems(stringArray, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        seleccion[which] = isChecked;
                    }
                })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        toListadoActivity(seleccion);
                    }
                });
        builder.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info:
                dialogoInfo();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void dialogoInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Información");
        builder.setMessage("Proyecto de examen del 3er trimestre");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
    }


}