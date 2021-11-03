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

    public String getAutor() {
        return autor;
    }

    public String getAnio() {
        return anio;
    }

    public int getImagen() {
        return imagen;
    }
}
