package com.example.examen3t;


public class Album {
    private String titulo;
    private String autor;
    private int imageId;
    private String descripcion;


    public Album(String titulo, String autor, int imageId, String descripcion) {
        this.titulo = titulo;
        this.autor = autor;
        this.imageId = imageId;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getImageId() {
        return imageId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor;
    }
}
