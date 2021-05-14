package com.example.recyclerview.ejemplo4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.recyclerview.R;


public class Ej4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej4);

    }

    public void mostrarListado(View view) {
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor4, new ListaFragment()).commit();
        findViewById(R.id.buttonEj4).setVisibility(View.GONE);
    }

}