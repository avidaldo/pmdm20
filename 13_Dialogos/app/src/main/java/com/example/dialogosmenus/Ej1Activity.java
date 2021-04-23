package com.example.dialogosmenus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.switchmaterial.SwitchMaterial;


public class Ej1Activity extends AppCompatActivity {

    TextView tv;
    Switch interruptor;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        tv = findViewById(R.id.textView2);
        interruptor = findViewById(R.id.switch1);
        et = findViewById(R.id.editTextTextPersonName);

        interruptor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( interruptor.isChecked() ) { // Si se pulsa el switch estando a off
                    interruptor.setChecked(true);
                    tv.setVisibility(View.VISIBLE);
                } else {
                    interruptor.setChecked(true);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(Ej1Activity.this);
                    dialog.setTitle("Atención!");
                    dialog.setMessage(et.getText().toString());
                    dialog.setCancelable(false);

                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            interruptor.setChecked(false);
                            tv.setVisibility(View.INVISIBLE);
                        }
                    });
                    dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.create().show();
                }
            }
        });
    }



}