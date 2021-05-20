package com.example.recyclerview.ejemplo5;

import android.net.Uri;


public class LenguajeProg5 {

    public final String nombre;
    public final Uri urlImagen;

    private LenguajeProg5(String nombre, Uri urlImagen) {
        this.nombre = nombre;
        this.urlImagen = urlImagen;
    }

    /* Método factoría, para convertir el string en Uri */
    public static LenguajeProg5 newInstance(String nombre, String urlImagenString) {
            return new LenguajeProg5(nombre, Uri.parse(urlImagenString));
    }


}
