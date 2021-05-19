package com.example.recyclerview.ejemplo5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class Ej5Activity extends AppCompatActivity {

    /* Variable global que simulará persistencia de datos. */
    public static List<LenguajeProg5> lenguajes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej5);

        lenguajes = new ArrayList<>();
        lenguajes.add(LenguajeProg5.newInstance("Java", "https://ubiqum.com/assets/uploads/2019/10/screenshot-2021-02-11-at-115416.png"));
        lenguajes.add(LenguajeProg5.newInstance("Kotlin", "https://kotlinlang.org/assets/images/open-graph/kotlin_250x250.png"));
        lenguajes.add(LenguajeProg5.newInstance("JavaScript", "https://i.pinimg.com/originals/12/49/49/1249492264f909cc540ddc8e87419e42.png"));
        lenguajes.add(LenguajeProg5.newInstance("Swift", "https://upload.wikimedia.org/wikipedia/commons/7/78/Swift_logo.png"));
        lenguajes.add(LenguajeProg5.newInstance("Python", "http://assets.stickpng.com/images/5848152fcef1014c0b5e4967.png"));
        lenguajes.add(LenguajeProg5.newInstance("PHP", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/PHP-logo.svg/1280px-PHP-logo.svg.png"));
        lenguajes.add(LenguajeProg5.newInstance("C#", "https://seeklogo.com/images/C/c-sharp-c-logo-02F17714BA-seeklogo.com.png"));
        lenguajes.add(LenguajeProg5.newInstance("Go", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Go_Logo_Blue.svg/1200px-Go_Logo_Blue.svg.png"));
        lenguajes.add(LenguajeProg5.newInstance("Rust", "Esto va a fallar al convertir a URL"));

    }

    public void mostrarListado(View view) {
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor5,
                Lista5Fragment.newInstance()
        ).commit();
    }

    public void addElemento(View view) {
    }
}