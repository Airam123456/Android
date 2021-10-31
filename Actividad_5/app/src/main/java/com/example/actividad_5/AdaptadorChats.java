package com.example.actividad_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class AdaptadorChats extends ArrayAdapter<Chat> {

    private Chat[] contactos;

    public AdaptadorChats(@NonNull Context context, Chat[] contactos) {
        super(context, R.layout.chats_view, contactos);
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.chats_view, null);
        TextView contacto = (TextView)item.findViewById(R.id.txtContacto);
        contacto.setText(contactos[position].getContacto());
        TextView texto = (TextView)item.findViewById(R.id.txtTexto);
        texto.setText(contactos[position].getTxtChat());
        return (item);
    }
}
