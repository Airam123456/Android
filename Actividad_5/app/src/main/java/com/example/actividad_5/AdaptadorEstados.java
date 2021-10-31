package com.example.actividad_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class AdaptadorEstados extends ArrayAdapter<Chat> {

    private Chat[] contactos;

    public AdaptadorEstados(@NonNull Context context, Chat[] contactos) {
        super(context, R.layout.estados_view, contactos);
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.estados_view, null);
        TextView contacto = (TextView)item.findViewById(R.id.txtContacto);
        contacto.setText(contactos[position].getContacto());
        TextView texto = (TextView)item.findViewById(R.id.txtTexto);
        texto.setText(contactos[position].getTxtEstado());
        return (item);
    }
}
