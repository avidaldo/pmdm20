package com.example.examen2t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.examen2t.AddAlbumActivity.ALBUM_MESSAGE;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;

    public static List<String> lista;

    private Spinner spinnerAlbumes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.albums_base)));

        Button button = findViewById(R.id.buttonToAdd);

        spinnerAlbumes = findViewById(R.id.spinner_albumes);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAlbumes.setAdapter(adaptador);

        spinnerAlbumes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0) {
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Álbum seleccionado: "+ ((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

    }

    public void toAddAlbum(View view) {
        Intent intent = new Intent(this, AddAlbumActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((resultCode == RESULT_OK) && (requestCode == REQUEST_CODE)) {
            lista.add(data.getStringExtra(ALBUM_MESSAGE));
        }
    }



}