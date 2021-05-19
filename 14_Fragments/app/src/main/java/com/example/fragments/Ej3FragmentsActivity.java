package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

public class Ej3FragmentsActivity extends AppCompatActivity implements OnOptionMenuSelectedListener {

    Fragment fragment, blueFragment, redFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej3_fragments);

        blueFragment = new BlueFragment();
        redFragment = new RedFragment();


    }



    @Override
    public void cambiacontenedor(int colorCode) {

        if (colorCode==AZUL) fragment = blueFragment;
        else if  (colorCode==ROJO) fragment = redFragment;


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor3, fragment)
                .commit();

    }
}