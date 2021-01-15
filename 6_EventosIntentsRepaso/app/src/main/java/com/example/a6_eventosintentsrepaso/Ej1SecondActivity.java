package com.example.a6_eventosintentsrepaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.example.a6_eventosintentsrepaso.Ej1OnclickActivity.MENSAJE;

public class Ej1SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej1_second);

        String mensaje = getIntent().getStringExtra(MENSAJE);

        TextView tv= findViewById(R.id.tv12);

        tv.setText(mensaje);

        // En una línea:
        // ((TextView) findViewById(R.id.tv12)).setText(getIntent().getStringExtra(MENSAJE));
    }
}