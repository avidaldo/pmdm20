package com.example.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;


// Los menús contextuales suelen utilizarse cuando se hace una pulsación larga sobre una vista

public class Ej3ContextMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej3_context_menu_avtivity);

        registerForContextMenu(findViewById(R.id.textView3)); // Vinculamos una vista al menú contextual
        // a partir de ahí, sus eventos serán gestionados por los propios métodos de la Activity
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        menu.setHeaderTitle("Título del menú");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
            case R.id.item2:
            case R.id.item3:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    public void clickNormal(View view) {
        Toast.makeText(this, "Tienes que mantener pulsado más tiempo", Toast.LENGTH_SHORT).show();
    }
}