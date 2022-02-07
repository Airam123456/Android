package com.example.examen_2;

public class Cliente {

    private int dni;
    private String nombre, direccion, tfno;

    public Cliente(int dni, String nombre, String direccion, String tfno) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tfno = tfno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTfno() {
        return tfno;
    }

    public void setTfno(String tfno) {
        this.tfno = tfno;
    }
}
