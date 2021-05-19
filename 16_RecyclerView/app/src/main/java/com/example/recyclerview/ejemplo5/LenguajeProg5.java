package com.example.recyclerview.ejemplo5;

import android.net.Uri;


public class LenguajeProg5 {

    private String nombre;
    private Uri urlImagen;

    private LenguajeProg5(String nombre, Uri urlImagen) {
        this.nombre = nombre;
        this.urlImagen = urlImagen;
    }

    /* Método factoría, para convertir el string en URL (garantizando así que es una URL válida */
    public static LenguajeProg5 newInstance(String nombre, String urlImagenString) {
            return new LenguajeProg5(nombre, Uri.parse(urlImagenString));
        // return null; // Si no se puede descargar la imagen, simplemente se pasará null
    }

    public String getNombre() {
        return nombre;
    }

    public Uri getUrlImagen() {
        return urlImagen;
    }

}
