package com.example.actividad_4;

public class Webs {

    private String nombre, url,id;
    private int  imagen;

    public Webs (String nombre, String url, String id, int imagen)
    {
        this.nombre = nombre;
        this.url = url;
        this. id = id;
        this. imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }

    public String getId() {
        return id;
    }

    public int getImagen() {
        return imagen;
    }
}
