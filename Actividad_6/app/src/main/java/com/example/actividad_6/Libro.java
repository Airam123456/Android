package com.example.actividad_6;

import android.widget.ImageView;

public class Libro {
    private String titulo, autor, anio;
    private int imagen;

    public Libro(String titulo, String autor, String anio, int imagen) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
