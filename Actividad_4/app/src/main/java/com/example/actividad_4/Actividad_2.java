package com.example.actividad_4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Actividad_2 extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        lista = (ListView) findViewById(R.id.ltsWebs);
        rellenarLista();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }

    private void rellenarLista() {
        Webs[] datosWebs =
                {
                        new Webs("Youtube", "www.youtube.com", "Para perder tiempo", R.drawable.yt),
                        new Webs("Spotify", "www.youtube.com", "Para escuchar musica", R.drawable.spotify),
                        new Webs("Github", "www.youtube.com", "Para copiar", R.drawable.gato),
                        new Webs("La Voz de Horus", "www.youtube.com", "Para entretenerme", R.drawable.lvdh)
                };
        AdaptadorWebs AdaptadorWebs = new AdaptadorWebs(this, datosWebs);
        lista.setAdapter(AdaptadorWebs);
    }

    class AdaptadorWebs extends ArrayAdapter<Webs> {

        private Webs[] datosWebs;

        public AdaptadorWebs(@NonNull Context context, Webs[] datosWebs) {
            super(context, R.layout.listitem_web, datosWebs);
            this.datosWebs = datosWebs;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView,
                            @NonNull ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_web, null);

            ImageView Logo = (ImageView)item.findViewById(R.id.imgLogo);
            Logo.setImageResource(datosWebs[position].getImagen());

            TextView Nombre = (TextView)item.findViewById(R.id.txtNombre);
            Nombre.setText(datosWebs[position].getNombre());

            TextView ID = (TextView)item.findViewById(R.id.txtID);
            ID.setText(datosWebs[position].getId());

            return (item);
        }
    }

}