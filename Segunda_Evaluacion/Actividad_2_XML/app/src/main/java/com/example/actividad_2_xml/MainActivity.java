package com.example.actividad_2_xml;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String url = "https://www.esportmaniacos.com/feed/";

    private List<Noticia> noticias;
    private ListView listNoticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarConSAXSimplificado();
        listNoticias = (ListView) findViewById(R.id.listNoticias);
        listNoticias.setOnItemClickListener((parent, view, position, id) -> {
            Noticia not = (Noticia) parent.getItemAtPosition(position);
            String url = not.getGuid().trim();

            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }


    public void cargarConSAXSimplificado(){
        //Carga del XML mediante tarea Asincrona
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute(url);
    }


    //Tarea Asíncrona para cargar un XML en segundo plano
    private class CargarXmlTask extends AsyncTask<String,Integer,Boolean> {

        protected Boolean doInBackground(String... params) {
            RssParserSAXSimplificado saxparserSimplificado =
                    new RssParserSAXSimplificado(params[0]);
            noticias = saxparserSimplificado.parse();
            return true;
        }

        protected void onPostExecute(Boolean result) {
            Noticia[] todasNoticias = new Noticia[noticias.size()];
            for (int i = 0; i < noticias.size(); i++) {
                todasNoticias[i] = noticias.get(i);
            }
           AdaptadorNoticias adaptadorNoticias = new AdaptadorNoticias(getApplicationContext(), todasNoticias);
            listNoticias.setAdapter(adaptadorNoticias);
        }
    }

    private static class AdaptadorNoticias extends ArrayAdapter<Noticia>{
        private final Noticia[] todasNoticias;

        public AdaptadorNoticias(Context context, Noticia[] todasNoticias) {
            super(context, R.layout.listitem_noticia, todasNoticias);
            this.todasNoticias = todasNoticias;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            @SuppressLint({"InflateParams", "ViewHolder"}) View item = inflater.inflate(R.layout.listitem_noticia, null);

            String titulo = todasNoticias[position].getTitulo().trim();
            TextView txtTitulo = item.findViewById(R.id.txtResultado);
            txtTitulo.setText(titulo);

            return item;
        }

    }
}