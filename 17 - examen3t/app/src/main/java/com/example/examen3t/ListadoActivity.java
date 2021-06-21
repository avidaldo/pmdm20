package com.example.examen3t;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.examen3t.MainActivity.OPCIONES;

public class ListadoActivity extends AppCompatActivity {

    private static List<Album> listadoRock, listadoBlues, listadoJazz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        boolean[] seleccion = getIntent().getBooleanArrayExtra(OPCIONES);

        cargaListados();
        List<Album> listado = new ArrayList<>();

        if (seleccion[0]) listado.addAll(listadoRock);
        if (seleccion[1]) listado.addAll(listadoBlues);
        if (seleccion[2]) listado.addAll(listadoJazz);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.contenedor, ListadoFragment.newInstance(listado)).commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.listado:
                updateListadoDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateListadoDialog() {
        String[] stringArray = getResources().getStringArray(R.array.generos);
        boolean[] isCheckedList = {false, false, false};

        List<Album> listado = new ArrayList<>();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Actualiza géneros")
                .setMultiChoiceItems(stringArray, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                        isCheckedList[which] = isChecked;
                    }
                })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (isCheckedList[0]) listado.addAll(listadoRock);
                        if (isCheckedList[1]) listado.addAll(listadoBlues);
                        if (isCheckedList[2]) listado.addAll(listadoJazz);

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.contenedor, ListadoFragment.newInstance(listado)).commit();
                    }
                });
        builder.show();

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