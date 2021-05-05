package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ej2FragmentsDinamicosActivity extends AppCompatActivity {

    private Fragment fragment, redFragment, blueFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej2_fragments_dinamicos);

        Button boton = findViewById(R.id.btnChangeFragment2);

        redFragment = new RedFragment();
        blueFragment = new BlueFragment();

        // Se carga primero el fragment rojo
        fragment = redFragment;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor2, fragment)
                .commit();


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragment == redFragment)
                    fragment = blueFragment;
                else {
                    fragment = redFragment;
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contenedor2, fragment)
                        .commit();


            }
        });


    }


}