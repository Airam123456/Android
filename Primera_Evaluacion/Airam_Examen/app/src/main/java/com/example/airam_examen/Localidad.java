package com.example.airam_examen;

import android.graphics.drawable.Drawable;

public class Localidad {

    private String nombre, provincia, zona, url;
    private Drawable imagen;

    public Localidad(String nombre, String provincia, String zona, Drawable imagen, String url) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.zona = zona;
        this.url = url;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }


}
