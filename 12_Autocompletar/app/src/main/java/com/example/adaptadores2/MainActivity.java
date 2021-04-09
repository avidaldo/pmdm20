package com.example.adaptadores2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toAutocompletar1Activity(View view) {
        startActivity(new Intent(this, Autocompletar1Activity.class));
    }

    public void toAutocompletar2Activity(View view) {
        startActivity(new Intent(this, Autocompletar2Activity.class));
    }

    public void toAutocompletar22Activity(View view) {
        startActivity(new Intent(this, Autocompletar22Activity.class));
    }

}
