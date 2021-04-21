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


public class Ej1Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    TextView tv;
    Switch interruptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        tv = findViewById(R.id.textView2);
        interruptor = findViewById(R.id.switch1);

        interruptor.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (!isChecked) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Atención!");
            alertDialogBuilder.setMessage(((EditText)findViewById(R.id.editTextTextPersonName)).getText().toString());

            alertDialogBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tv.setVisibility(View.GONE);
                }
            });

            alertDialogBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {

                    interruptor.setChecked(true);
                }
            });
            alertDialogBuilder.show();
        }
        else {
            tv.setVisibility(View.VISIBLE);
        }
    }

}