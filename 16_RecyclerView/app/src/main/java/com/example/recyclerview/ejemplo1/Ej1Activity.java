package com.example.recyclerview.ejemplo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej1Activity extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private Custom1Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej1);

        recyclerView1 = findViewById(R.id.recyclerView1);

        List<String> lenguajes = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.lenguajes)));

        // RecyclerView requiere utilizar un adaptador personalizado
        recyclerView1.setAdapter(new Custom1Adapter(lenguajes));

        /* Seteamos el Layaout Manager, que es el que generará la distribución interna de la lista
        para el número de columnas que queramos. Para una única columna, se utiliza internamente
        un LinearLayout, generado por LinearLayoutManager; para varias, se utiliza GridLayout */
        //recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setLayoutManager(new GridLayoutManager(this, 3));


    }





}