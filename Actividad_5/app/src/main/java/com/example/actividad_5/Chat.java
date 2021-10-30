package com.example.actividad_5;

public class Chat {

    private String contacto, texto;

    public Chat (String contacto, String texto){
        this.contacto = contacto;
        this.texto = texto;
    }

    public String getContacto() {
        return contacto;
    }

    public String getTexto() {
        return texto;
    }
}
