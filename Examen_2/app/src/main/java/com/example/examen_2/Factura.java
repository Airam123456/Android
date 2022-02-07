package com.example.examen_2;

public class Factura {

    private int num, dni;
    private String concepto;
    private double valor;

    public Factura(int num, int dni, String concepto, double valor) {
        this.num = num;
        this.dni = dni;
        this.concepto = concepto;
        this.valor = valor;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
