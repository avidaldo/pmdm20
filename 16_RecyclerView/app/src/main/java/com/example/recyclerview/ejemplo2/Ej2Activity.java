package com.example.recyclerview.ejemplo2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej2Activity extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private Custom2Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej1);

        recyclerView1 = findViewById(R.id.recyclerView1);

        List<String> lenguajes = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.lenguajes)));

        recyclerView1.setAdapter(new Custom2Adapter(lenguajes));


        recyclerView1.setLayoutManager(new LinearLayoutManager(this));


    }





}