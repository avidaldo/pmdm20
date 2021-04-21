package com.example.dialogosmenus;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BasicDialogsActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_dialogs);
    }

    public void basicAlertDialog(View view) {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setTitle("Atención");
        ventana.setMessage("Esto es un mensaje.");
        ventana.show();
    }

    public void botonAlertDialog(View view) {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setTitle("Atención");
        ventana.setMessage("Esto es un mensaje. Pulsa el botón...");
        // Inhabilitamos la posibilidad de que el usuario cierre la ventana sin pulsar el botón
        ventana.setCancelable(false);
        // Método que indica el texto del botón y la clase anónima que capturará su evento onClick
        ventana.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        ventana.show();
    }

    public void botonesAlertDialog(View view) {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setTitle("Atención");
        ventana.setMessage("Esto es un mensaje. Pulsa el botón...");

        ventana.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(BasicDialogsActivity.this, "Has pulsado ok", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        ventana.setNeutralButton("No sé yo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        ventana.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        ventana.show();
    }

    public void toEjPropuestoActivity(View view) {
        startActivity(new Intent(this, Ej1Activity.class));
    }
}