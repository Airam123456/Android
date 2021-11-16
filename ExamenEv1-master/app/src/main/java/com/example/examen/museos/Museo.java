package com.example.examen.museos;

//Clase museo
public class Museo {

    private String nombre;
    private String Localidad;
    private String web;
    private int imagen;

    public Museo(String nombre, String localidad, String web,int imagen) {
        this.nombre = nombre;
        Localidad = localidad;
        this.web = web;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
