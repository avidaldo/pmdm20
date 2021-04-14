package com.example.a7_p2_eventos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Ej06Activity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    ToggleButton tb;
    Switch interruptor;

    private boolean isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej06);

        tv = findViewById(R.id.textView2);
        tb = findViewById(R.id.toggleButton);
        interruptor = findViewById(R.id.switch1);

        /* Asignamos un escuchador de cambio de estado a las dos views,
        al ser común a ambos, lo implementamos en la propia clase */
        tb.setOnClickListener(this);
        interruptor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (isChecked) {
            isChecked=false;
            interruptor.setChecked(false);
            tb.setChecked(false);
            tv.setVisibility(View.INVISIBLE);
        }
        else {
            isChecked=true;
            interruptor.setChecked(true);
            tb.setChecked(true);
            tv.setVisibility(View.VISIBLE);
        }
    }

}