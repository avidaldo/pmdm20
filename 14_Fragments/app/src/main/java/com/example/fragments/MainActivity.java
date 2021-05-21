package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fragments.basico.Ej1FragmentsEstaticosActivity;
import com.example.fragments.basico.Ej2FragmentsDinamicosActivity;
import com.example.fragments.comunicacion.Ej3FragmentsActivity;
import com.example.fragments.comunicacion.Ej4BasicActivity;

// https://developer.android.com/guide/fragments

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void toEj1FragmentsEstaticosActivity(View view) {
        startActivity(new Intent(getApplicationContext(), Ej1FragmentsEstaticosActivity.class));
    }

    public void toEj2DinamicosBasicActivity(View view) {
       startActivity(new Intent(getApplicationContext(), Ej2FragmentsDinamicosActivity.class));
    }

    public void toEj3FragmentsActivity(View view) {
        startActivity(new Intent(getApplicationContext(), Ej3FragmentsActivity.class));
    }

    public void toEj4BasicActivity(View view) {
        startActivity(new Intent(getApplicationContext(), Ej4BasicActivity.class));
    }
}