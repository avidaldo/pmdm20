package com.example.recyclerview.ejemplo3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.ejemplo4.LenguajeProg;
import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class Ej3Activity extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private Custom3Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej1);

        recyclerView1 = findViewById(R.id.recyclerView1);

        List<LenguajeProg> lenguajes = new ArrayList<>();
        lenguajes.add(new LenguajeProg("Java", R.drawable.java));
        lenguajes.add(new LenguajeProg("Kotlin", R.drawable.kotlin));
        lenguajes.add(new LenguajeProg("JavaScript", R.drawable.javascript));
        lenguajes.add(new LenguajeProg("Swift", R.drawable.swift));
        lenguajes.add(new LenguajeProg("Python", R.drawable.python));
        lenguajes.add(new LenguajeProg("PHP", R.drawable.php));
        lenguajes.add(new LenguajeProg("C#", R.drawable.csharp));
        lenguajes.add(new LenguajeProg("Go", R.drawable.go));
        lenguajes.add(new LenguajeProg("Rust", R.drawable.rust));

        recyclerView1.setAdapter(new Custom3Adapter(lenguajes));


        recyclerView1.setLayoutManager(new LinearLayoutManager(this));


    }





}