package com.example.adaptadores2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Ej04Activity extends AppCompatActivity {

    EditText etValor05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej04);

        etValor05 = findViewById(R.id.etValor05);

        Spinner spinner = findViewById(R.id.spinner);

        // Añadiendo el escuchador mediante clase anónima
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                intentNumero(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }


    private void intentNumero(int i) {
        Intent intent = new Intent();

        switch (i) {
            case 0: return;
            case 1:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + etValor05.getText().toString()));
                break;
            case 2:
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + etValor05.getText().toString()));
                break;
            case 3:
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://" + etValor05.getText().toString()));
                break;
            case 4:
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:?q=" + etValor05.getText().toString()));
                break;
            case 5:
                try {
                    LocalTime time = LocalTime.parse(etValor05.getText().toString());
                    intent.setAction(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR, time.getHour());
                    intent.putExtra(AlarmClock.EXTRA_MINUTES, time.getMinute());
                } catch (DateTimeParseException e) {
                    Toast.makeText(this, "El formato del input no es válido. Debe ser: \"HH:MM\"", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            case 6:
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("mailto:" + etValor05.getText().toString()));
                break;
            case 7:
                intent.setAction("android.media.action.IMAGE_CAPTURE");
                intent.setData(Uri.parse("mailto:" + etValor05.getText().toString()));
        }


        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, R.string.no_app_error, Toast.LENGTH_SHORT).show();
        }

    }
}