package com.example.dialogosmenus;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class BasicDialogsActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_dialogs);
    }

    public void basicAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Atención");
        builder.setMessage("Esto es un mensaje.");
        builder.show();
    }

    public void botonAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Atención");
        builder.setMessage("Esto es un mensaje. Pulsa el botón...");
        // Inhabilitamos la posibilidad de que el usuario cierre la ventana sin pulsar el botón
        builder.setCancelable(false);
        // Método que indica el texto del botón y la clase anónima que capturará su evento onClick
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show(); // Mostramos el Diálogo
    }

    public void botonesAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Atención");
        builder.setMessage("Esto es un mensaje. Pulsa el botón...");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(BasicDialogsActivity.this, "Has pulsado ok", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("No sé yo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.create(); // No es necesario para mostrarlo, pero puede crearse para guardarlo para hacer algo antes de mostrarlo
        builder.show();
    }

    public void toEjPropuestoActivity(View view) {
        startActivity(new Intent(this, Ej1Activity.class));
    }

    public void listDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleccionar")
                .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(BasicDialogsActivity.this,
                                getResources().getStringArray(R.array.colors_array)[which],
                                Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();
    }

    public void multipleSelectionDialog(View view) {
        List<Integer> selectedItems = new ArrayList();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.pick_toppings)
                .setMultiChoiceItems(R.array.toppings, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) { // Si se marca un elemento
                                    selectedItems.add(which); // Añadimos su posición al ArrayList
                                } else if (selectedItems.contains(which)) { // si se desmarca
                                    selectedItems.remove(Integer.valueOf(which)); // lo eliminamos
                                }
                            }
                        })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String mensaje = "Los ingredientes seleccionados son:";
                        for (Integer indice : selectedItems) {
                            mensaje += " " + getResources().getStringArray(R.array.toppings)[indice];
                        }
                        Toast.makeText(BasicDialogsActivity.this, mensaje, Toast.LENGTH_SHORT).show();
                    }
                });
        builder.show();
    }

    public void editTextDialog(View view) {
        EditText edText = new EditText(this);
        edText.setHint("Introduzca un texto");
        edText.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Título")
                .setMessage("Mensaje")
                .setView( edText )
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(BasicDialogsActivity.this, edText.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton("Cancel", null);
        builder.create().show();
    }
}