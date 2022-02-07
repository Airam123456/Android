package com.example.examen_2;

public class Tiempo {
    private String fecha;
    private int tempMax;
    private int tempMin;
    private String estadoCielo;

    public Tiempo(String fecha,int tempMax,int tempMin,String estadoCielo) {
        this.fecha = fecha;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.estadoCielo = estadoCielo;
    }

    //Solo necesitamos geters
    public String getFecha() {
        return fecha;
    }

    public int getTempMax() {
        return tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public String getEstadoCielo() {
        return estadoCielo;
    }
}


