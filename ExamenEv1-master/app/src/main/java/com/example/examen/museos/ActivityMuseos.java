package com.example.examen.museos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.examen.R;

import java.util.ArrayList;

public class ActivityMuseos extends AppCompatActivity {

    ListView listView;

    ArrayList<Museo> arrayMuseo;

    //Actividad con listView de museos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museos);

        //Array con los datos de los museos
        arrayMuseo = new ArrayList<Museo>();

        arrayMuseo.add(new Museo("Museo Guggenheim de Bilbao","Bilbo (Bizkaia)","https://www.guggenheim-bilbao.eus/",R.drawable.guggenheim));
        arrayMuseo.add(new Museo("Museo de Bellas Artes de Bilbao","Bilbo (Bizkaia)","http://www.museobilbao.com/",R.drawable.bellas_artes_bilbao_1));
        arrayMuseo.add(new Museo("Museo San Telmo","Donostia (Gipuzkoa)","https://www.santelmomuseoa.eus",R.drawable.san_telmo_donostia_1));
        arrayMuseo.add(new Museo("Azkuna Zentroa","Bilbo (Bizkaia)","https://www.azkunazentroa.eus",R.drawable.azkuna_zentroa_bilbo_1));
        arrayMuseo.add(new Museo("Museo de Bellas Artes","Gasteiz (Araba)",null,R.drawable.bellas_artes_gasteiz_1));
        arrayMuseo.add(new Museo("Tabakalera","Donostia (Gipuzkoa)","https://www.tabakalera.eu/eu",R.drawable.tabakalera_donostia));
        arrayMuseo.add(new Museo("Museo Diocesano de Arte Sacro","Gasteiz (Araba)",null,R.drawable.arte_sacro_vitoria_1));
        arrayMuseo.add(new Museo("Museo de Arte Sacro","Bilbo (Bizkaia)","http://www.eleizmuseoa.com/",R.drawable.arte_sacro_bilbo_1));
        arrayMuseo.add(new Museo("Artium","Gasteiz (Araba)","http://www.artium.org/es/",R.drawable.artium_vitoria_1));
        arrayMuseo.add(new Museo("Museo de los Faroles","Gasteiz (Araba)",null,R.drawable.museo_faroles_vitoria_1));
        arrayMuseo.add(new Museo("Deposito de Agua – Montehermoso","Gasteiz (Araba)","https://www.montehermoso.net",R.drawable.montehermoso));





        listView = findViewById(R.id.listView);

        final AdaptadorMuseo adaptadorMuseo = new AdaptadorMuseo(this,arrayMuseo);

        listView.setAdapter(adaptadorMuseo);

    }

    //Adaptador para los items del listView
    class AdaptadorMuseo extends ArrayAdapter<Museo> {

        public AdaptadorMuseo(@NonNull Context context, ArrayList<Museo> resource) {
            super(context, R.layout.list_museo,arrayMuseo);
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_museo, null);

            ImageView imageView = item.findViewById(R.id.imageView);
            imageView.setImageResource(arrayMuseo.get(position).getImagen());

            TextView tvNombre = item.findViewById(R.id.tvNombre);
            tvNombre.setText(arrayMuseo.get(position).getNombre());

            TextView tvLocalidad = item.findViewById(R.id.tvLocalidad);
            tvLocalidad.setText(arrayMuseo.get(position).getLocalidad());


            //Al hacer click ir a la web en caso de tenerla
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(arrayMuseo.get(position).getWeb()!=null){
                        Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(arrayMuseo.get(position).getWeb()));
                        startActivity(intent);
                    }
                }
            });

            return item;
        }


    }
}
