package com.example.fragments.comunicacion;

import android.os.Bundle;

import com.example.fragments.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.View;

public class Ej4BasicActivity extends AppCompatActivity implements OnOptionMenuSelectedListener {

    Fragment fragment4, blueFragment, redFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej3_basic);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        redFragment = new RedFragment();
        blueFragment = new BlueFragment();


        fragment4 = redFragment;
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor4, fragment4).commit();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fragment4 instanceof RedFragment) {
                    fragment4 = blueFragment; // sustituimos el fragment por el otro
                } else {
                    fragment4 = redFragment;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor4, fragment4).commit();


                // Ejemplo de Snackbar
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).show();
                    /*    .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(Ej3BasicActivity.this, "Toast", Toast.LENGTH_SHORT).show();
                            }
                        }).show();*/
            }
        });
    }


    @Override
    public void cambiacontenedor(int colorCode) {
        if (colorCode == AZUL) fragment4 = blueFragment;
        else if (colorCode == ROJO) fragment4 = redFragment;


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor4, fragment4)
                .commit();

    }

}