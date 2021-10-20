package com.example.actividad_4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Webs webSelect = (Webs) parent.getItemAtPosition(position);
                String urlWeb = webSelect.getUrl();

                Uri uri = Uri.parse(urlWeb);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private void rellenarLista() {
        Webs[] datosWebs =
                {
                        new Webs("Youtube", "https://www.youtube.com/", "Para perder tiempo", R.drawable.yt),
                        new Webs("Spotify", "https://www.spotify.com/es/", "Para escuchar musica", R.drawable.spotify),
                        new Webs("Github", "https://github.com/", "Para copiar", R.drawable.gato),
                        new Webs("La Voz de Horus", "https://www.lavozdehorus.com/", "Para entretenerme", R.drawable.lvdh)
                };
        AdaptadorWebs AdaptadorWebs = new AdaptadorWebs(this, datosWebs);
        lista.setAdapter(AdaptadorWebs);
    }

    public void salir(View view) {finish(); }

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