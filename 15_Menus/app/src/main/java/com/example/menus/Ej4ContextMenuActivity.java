package com.example.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej4ContextMenuActivity extends AppCompatActivity {

    ListView lv_planetas; // ListView está deprecated, se debería sustituir por una RecyclerView
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e4_context_menu);

        // cargamos el ArrayList de planetas desde el recurso (como en el proyecto "Examen2T")
        List<String> planetas = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.planetas)));

        lv_planetas = (ListView) findViewById (R.id.lv_planetas);

        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas);
        lv_planetas.setAdapter(adaptador);

        lv_planetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Elección: " + lv_planetas.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
        registerForContextMenu(lv_planetas);
    }

    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu3, menu);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(lv_planetas.getAdapter().getItem(info.position).toString());
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.ayuda:
                Toast.makeText(this, "item " + info.position, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.eliminar:
                adaptador.remove(adaptador.getItem(info.position));
                return true;
        }
        return true;
    }



}