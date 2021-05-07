package com.example.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


// https://developer.android.com/guide/topics/ui/menus

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toEj1(View view) {
        startActivity(new Intent(this, Ej1OptionsMenuActivity.class));
    }

    public void toEj2(View view) {
        startActivity(new Intent(this, Ej2OptionsMenuActivity.class));
    }

    public void toEj3(View view) {
        startActivity(new Intent(this, Ej3ContextMenuActivity.class));
    }

    public void toEj4(View view) {
        startActivity(new Intent(this, Ej4ContextMenuActivity.class));
    }

}