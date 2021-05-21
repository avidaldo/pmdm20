package com.example.fragments.comunicacion;


// Listener personalizado con el evento que pueda suceder en nuestro fragment
public interface OnOptionMenuSelectedListener {
    public static final int AZUL=1;
    public static final int ROJO=2;
    public static final int VERDE=3;

    public void cambiacontenedor(int colorCode);
}
