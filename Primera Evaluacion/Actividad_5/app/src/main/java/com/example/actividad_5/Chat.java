package com.example.actividad_5;

public class Chat {

    private String contacto, txtChat, txtEstado, fechaLlamada ;

    public Chat(String contacto, String txtChat, String txtEstado, String fechaLlamada) {
        this.contacto = contacto;
        this.txtChat = txtChat;
        this.txtEstado = txtEstado;
        this.fechaLlamada = fechaLlamada;
    }

    public String getContacto() {
        return contacto;
    }

    public String getTxtChat() {
        return txtChat;
    }

    public String getTxtEstado() {
        return txtEstado;
    }

    public String getFechaLlamada() {
        return fechaLlamada;
    }
}
