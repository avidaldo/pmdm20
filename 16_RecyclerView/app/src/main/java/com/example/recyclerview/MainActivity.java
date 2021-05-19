package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.recyclerview.ejemplo1.Ej1Activity;
import com.example.recyclerview.ejemplo2.Ej2Activity;
import com.example.recyclerview.ejemplo3.Ej3Activity;
import com.example.recyclerview.ejemplo4.Ej4Activity;
import com.example.recyclerview.ejemplo5.Ej5Activity;


// https://developer.android.com/guide/topics/ui/layout/recyclerview

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void toEj1(View view) {
        startActivity(new Intent(this, Ej1Activity.class));
    }
    public void toEj2(View view) {
        startActivity(new Intent(this, Ej2Activity.class));
    }
    public void toEj3(View view) { startActivity(new Intent(this, Ej3Activity.class)); }
    public void toEj4(View view) {
        startActivity(new Intent(this, Ej4Activity.class));
    }
    public void toEj5(View view) { startActivity(new Intent(this, Ej5Activity.class)); }

}