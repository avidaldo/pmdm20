package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragments.R;
import com.example.fragments.RedFragment;

public class Ej2FragmentsDinamicosActivity extends AppCompatActivity {

    Fragment fragment, redFragment, blueFragment;

    String mensaje="mensaje inicial";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej2_fragments_dinamicos);

        Button boton = findViewById(R.id.btnChangeFragment2);

        redFragment = new RedFragment(); // RedFragment no tiene método factory
        blueFragment = BlueFragment.newInstance(mensaje);

        // Cargamos el primer fragment
        fragment = redFragment;
        getSupportFragmentManager().beginTransaction()
                .add(R.id.contenedor2, fragment)  // Añadimos un fragment al contenedor
                .commit();


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragment = (fragment == redFragment) ? blueFragment : redFragment;
                // La condición también podría ser "(fragment instanceof BlueFragment)"

                // Reemplazamos un fragment por otro
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contenedor2, fragment) // Reemplazamos el fragment
                        .commit();


            }
        });






    }




}