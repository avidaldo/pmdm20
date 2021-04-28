package com.example.dialogosmenus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    https://developer.android.com/guide/topics/ui/dialogs
     */

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