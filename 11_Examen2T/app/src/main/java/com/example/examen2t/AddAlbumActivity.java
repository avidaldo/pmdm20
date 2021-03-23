package com.example.examen2t;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddAlbumActivity extends AppCompatActivity {
    static final String ALBUM_MESSAGE = "album";
    EditText etAlbum;
    EditText etArtista;
    RadioGroup rgGenero;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_album);

        etAlbum = findViewById(R.id.et_titulo);
        etArtista = findViewById(R.id.et_autor);
        rgGenero = findViewById(R.id.rg_genero);
        spinner = findViewById(R.id.spinner_subgeneros);

        rgGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int elementos;
                if (checkedId == R.id.rb_rock) {
                    elementos = R.array.subgeneros_rock;
                } else {
                    elementos = R.array.subgeneros_metal;
                }

                ArrayAdapter adapter = ArrayAdapter.createFromResource(AddAlbumActivity.this, elementos, R.layout.item_guay);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                spinner.setVisibility(View.VISIBLE);
            }
        });

    }

    public void addAlbum(View view) {
        String titulo = etAlbum.getText().toString();
        String artista = etArtista.getText().toString();

        int idRBGenero = rgGenero.getCheckedRadioButtonId();

        if (titulo.matches("\\s*")) {
            Toast.makeText(this, R.string.error_noAlbum, Toast.LENGTH_SHORT).show();
        } else if (artista.matches("\\s*")) {
            Toast.makeText(this, R.string.error_noArtista, Toast.LENGTH_SHORT).show();
        } else if (idRBGenero == -1) {
            Toast.makeText(this, R.string.error_noGenero, Toast.LENGTH_SHORT).show();
        } else {
            setResult(Activity.RESULT_OK, new Intent().putExtra(ALBUM_MESSAGE, titulo + " - " + artista));
            finish();
        }


    }

    public void buscarAlbum(View view) {
        String titulo = etAlbum.getText().toString();
        String artista = etArtista.getText().toString();
        if (titulo.matches("\\s*") && artista.matches("\\s*")) {
            Toast.makeText(this, R.string.error_noAlbumArtista, Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + titulo + "+" + artista));
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, R.string.no_app_error, Toast.LENGTH_SHORT).show();
            }
        }

    }
}