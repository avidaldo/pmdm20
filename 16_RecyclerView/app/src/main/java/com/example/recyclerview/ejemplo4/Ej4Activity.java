package com.example.recyclerview.ejemplo4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;


public class Ej4Activity extends AppCompatActivity {
    private List<LenguajeProg> lenguajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej4);


        lenguajes = new ArrayList<>();
        lenguajes.add(new LenguajeProg("Java", R.drawable.java));
        lenguajes.add(new LenguajeProg("Kotlin", R.drawable.kotlin));
        lenguajes.add(new LenguajeProg("JavaScript", R.drawable.javascript));
        lenguajes.add(new LenguajeProg("Swift", R.drawable.swift));
        lenguajes.add(new LenguajeProg("Python", R.drawable.python));
        lenguajes.add(new LenguajeProg("PHP", R.drawable.php));
        lenguajes.add(new LenguajeProg("C#", R.drawable.csharp));
        lenguajes.add(new LenguajeProg("Go", R.drawable.go));
        lenguajes.add(new LenguajeProg("Rust", R.drawable.rust));

    }

    public void mostrarListado(View view) {
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor4, new ListaFragment(lenguajes)).commit();
        findViewById(R.id.buttonEj4).setVisibility(View.GONE);
    }

}