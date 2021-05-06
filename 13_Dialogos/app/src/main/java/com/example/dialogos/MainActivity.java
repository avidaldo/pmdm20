package com.example.dialogos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dialogos.basicdialogs.BasicDialogsActivity;
import com.example.dialogos.fragmentdialog.DialogFramentActivity;
import com.example.dialogos.simplepickers.SimplePickersActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* https://developer.android.com/guide/topics/ui/dialogs */

    public void toBasicDialogsActivity(View view) {
        startActivity(new Intent(this, BasicDialogsActivity.class));
    }

    public void toDialogFramentActivity(View view) {
        startActivity(new Intent(this, DialogFramentActivity.class));
    }

    public void toPickersActivity(View view) {
        startActivity(new Intent(this, SimplePickersActivity.class));
    }
}