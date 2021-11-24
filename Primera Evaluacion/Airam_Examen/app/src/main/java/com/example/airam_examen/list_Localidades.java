package com.example.airam_examen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class list_Localidades extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_localidades);


        lista = (ListView) findViewById(R.id.listLocalidades);
        rellenarLista();

    }

    private void rellenarLista(){

        ArrayList<Localidad> arrayListLocalidades = new ArrayList<Localidad>();
        Localidad localidad;

        localidad = new Localidad("Orduña", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.orduna),"http://www.urduna.com/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Ondarroa", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.ondarroa),"http://www.ondarroa.eu/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Areatza", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.areatza),"http://www.areatza.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Gernika", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.gernika), "http://www.gernika-lumo.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Bermeo", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.bermeo),"http://www.bermeo.eus/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Balmaseda", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.balmaseda),"http://www.balmaseda.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Karrantza", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.karrantza),"http://www.karrantza.org/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Lekeitio", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.lekeitio),"http://www.lekeitio.com/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Getxo", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.getxo),"http://www.getxo.eus/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Laguardia", "Araba", "Interior", ContextCompat.getDrawable(this, R.drawable.laguardia),"http://www.laguardia-alava.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Hondarribia", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.hondarribia),"http://www.hondarribia.eus/es/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Zarautz", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.zarautz),"http://www.zarautz.org/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Pasaia", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.pasaia),"http://www.pasaia.eus/es");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Astigarraga", "Gipuzkoa", "Interior", ContextCompat.getDrawable(this, R.drawable.astigarraga),"http://astigarraga.eus");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Donostia", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.donostia),"http://www.donostia.eus");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Vitoria-Gasteiz", "Araba", "Interior", ContextCompat.getDrawable(this, R.drawable.vitoria_gasteiz),"http://www.vitoria-gasteiz.org/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Añana", "Araba", "Interior", ContextCompat.getDrawable(this, R.drawable.anana),"http://www.cuadrilladeanana.es/anana/");
        arrayListLocalidades.add(localidad);


    }


    class AdaptardorLocalidades extends ArrayAdapter<Localidad>{

        private Localidad[] datosLocal;

        public AdaptardorLocalidades(@NonNull Context context, Localidad[] datosLocal) {
            super(context, R.layout.listitem_localidad, datosLocal);
            this.datosLocal = datosLocal;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_localidad, null);

            ImageView Foto = (ImageView)item.findViewById(R.id.imgLocal);
            //Foto.setImageResource(datosLocal[position]);


            return item;
        }
    }
}