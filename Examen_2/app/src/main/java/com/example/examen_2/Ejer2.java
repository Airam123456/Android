package com.example.examen_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ejer2 extends AppCompatActivity {

    private TextView txtEleccionTiempoOutput;
    private TextView txtResultadoTiempo;
    private Tiempo tiempo;

    private String url;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer2);

        txtEleccionTiempoOutput = (TextView)findViewById(R.id.txtEleccion);
        txtResultadoTiempo = (TextView)findViewById(R.id.txtResultado);
    }

    private void buscarInfo() {
        //Carga del XML mediante tarea Asincrona
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute(url);
    }

    //Tarea Asíncrona para cargar un XML en segundo plano
    private class CargarXmlTask extends AsyncTask<String,Integer,Boolean> {
        //Nuevo hilo
        protected Boolean doInBackground(String... params) {
            Parseador domParser = new Parseador(params[0]);
            tiempo = domParser.parse();

            return true;
        }
        protected void onPostExecute(Boolean result) {
            //Tratamos la lista de tiempos
            if (tiempo != null)
            {
                String resultado = getResources().getString(R.string.outputFecha) + ": " + tiempo.getFecha() + "\n";
                resultado += getResources().getString(R.string.outputTemp) + ": (Min: " + String.valueOf(tiempo.getTempMin()) + " / Max: " +  String.valueOf(tiempo.getTempMax()) +")\n";
                resultado += tiempo.getEstadoCielo();

                txtResultadoTiempo.setText(resultado);
            }
        }
    }


    //Botones
    public void listener_butBilbao(View view) {
        url = "https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=8050";

        String output = getResources().getString(R.string.butBilbao);
        txtEleccionTiempoOutput.setText(output);

        buscarInfo();
    }

    public void listener_butVitoria(View view) {
        url = "https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=8043";

        String output = getResources().getString(R.string.butVitoria);
        txtEleccionTiempoOutput.setText(output);

        buscarInfo();
    }

    public void listener_butDonostia(View view) {
        url = "https://api.tutiempo.net/xml/?lan=es&apid=qsTX4X4qq44as6Q&lid=4917";

        String output = getResources().getString(R.string.butDonosita);
        txtEleccionTiempoOutput.setText(output);

        buscarInfo();
    }

    public void listener_butVolver(View view)
    {
        finish();
    }
}