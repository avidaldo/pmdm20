package com.example.examen3t;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListadoActivity extends AppCompatActivity {

    private static List<Album> listado, listadoRock, listadoBlues, listadoJazz;
    LinearLayout linearBotones, linearChecks;

    Button bRock,bBlues,bJazz;
    CheckBox checkRock, checkBlues, checkJazz;

    boolean[] chequeados = {false, false, false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        cargaListados();

        linearBotones = findViewById(R.id.linearBotones);
        linearChecks = findViewById(R.id.linearChecks);

        bRock = findViewById(R.id.bRock);
        bBlues = findViewById(R.id.bBlues);
        bJazz = findViewById(R.id.bJazz);

        bRock.setOnClickListener(new MyOnClickListener());
        bBlues.setOnClickListener(new MyOnClickListener());
        bJazz.setOnClickListener(new MyOnClickListener());



        checkRock = findViewById(R.id.checkRock);
        checkBlues = findViewById(R.id.checkBlues);
        checkJazz = findViewById(R.id.checkJazz);

        checkRock.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        checkBlues.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        checkJazz.setOnCheckedChangeListener(new MyOnCheckedChangeListener());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.simple:
                showBotones();
                break;
            case R.id.compuesta:
                showChecks();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showBotones() {
        linearBotones.setVisibility(View.VISIBLE);
        linearChecks.setVisibility(View.GONE);
    }

    private void showChecks() {
        linearChecks.setVisibility(View.VISIBLE);
        linearBotones.setVisibility(View.GONE);

        if (chequeados[0]) checkRock.setChecked(true);
        else if (chequeados[1]) checkBlues.setChecked(true);
        else if (chequeados[2]) checkJazz.setChecked(true);
    }

    private void updateListado() {
        List<Album> listado = new ArrayList<>();

        if (chequeados[0]) listado.addAll(listadoRock);
        if (chequeados[1]) listado.addAll(listadoBlues);
        if (chequeados[2]) listado.addAll(listadoJazz);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, ListadoFragment.newInstance(listado)).commit();

    }


    private class MyOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            if (buttonView.getId() == R.id.checkRock) {
                chequeados[0]=isChecked;
            }
            else if (buttonView.getId() == R.id.checkBlues) {
                chequeados[1]=isChecked;
            }
            else if (buttonView.getId() == R.id.checkJazz) {
                chequeados[2]=isChecked;
            }
            updateListado();
        }

    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            chequeados[0]=false;
            chequeados[1]=false;
            chequeados[2]=false;
            switch (v.getId()) {
                case R.id.bRock: chequeados[0]=true; break;
                case R.id.bBlues: chequeados[1]=true; break;
                case R.id.bJazz: chequeados[2]=true; break;
            }
            updateListado();
        }
    }


    private void cargaListados() {
        listadoRock = new ArrayList<>();

        listadoRock.add(new Album("Abbey Road", "The Beatles", R.drawable.abbeyroad,
                getResources().getString(R.string.abbeyroad)));
        listadoRock.add(new Album("Exile on Main Street", "The Rolling Stones", R.drawable.exileonmainst,
                getResources().getString(R.string.exilesonmainstreet)));
        listadoRock.add(new Album("The Velvet Underground", "The Velvet Underground and Nico", R.drawable.velvetunderground,
                getResources().getString(R.string.velvetunderground)));
        listadoRock.add(new Album("Are You Experienced", "Jimi Hendrix", R.drawable.areyouexperienced,
                getResources().getString(R.string.areyouexperienced)));
        listadoRock.add(new Album("Back in Black", "AC/DC", R.drawable.backinblack,
                getResources().getString(R.string.backinblack)));
        listadoRock.add(new Album("Appetite for Destruction", "Guns N’ Roses", R.drawable.appetitefordestruction,
                getResources().getString(R.string.appetitefordestruction)));
        listadoRock.add(new Album("Led Zeppelin IV", "Led Zeppelin", R.drawable.ledzeppeliniv,
                getResources().getString(R.string.ledzeppeliniv)));

        listadoBlues = new ArrayList<>();
        listadoBlues.add(new Album("Lady Soul", "Aretha Franklin", R.drawable.ladysoul,
                getResources().getString(R.string.ladysoul)));
        listadoBlues.add(new Album("I Never Loved a Man the Way I Love You", "Aretha Franklin", R.drawable.neverloved,
                getResources().getString(R.string.ineverloveda)));
        listadoBlues.add(new Album("What's Going On", "Marvin Gaye", R.drawable.whatsgoingon,
                getResources().getString(R.string.whatsgoingon)));

        listadoJazz = new ArrayList<>();
        listadoJazz.add(new Album("Kind of Blue", "Miles Davis", R.drawable.kindofblue,
                getResources().getString(R.string.kindofblue)));
        listadoJazz.add(new Album("Bitches Brew", "Miles Davis", R.drawable.bitchesbrew,
                getResources().getString(R.string.bitchesbrew)));
        listadoJazz.add(new Album("A Love Supreme", "John Coltrane", R.drawable.alovesupreme,
                getResources().getString(R.string.alovesupreme)));


    }



}