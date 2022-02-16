package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Tiempo extends AppCompatActivity {

    private Spinner spinner;
    private TextView tvLocalidad_Escogida;
    private String url;
    private ElTiempo tiempoHoy, tiempoMañana, tiempoPasado;
    private TextView txtHoraHoy, txtTemperaturaHoy, txtEstadoHoy;
    private TextView txtHoraMañana, txtTemperaturaMañana, txtEstadoMañana;
    private TextView txtHoraPasado, txtTemperaturaPasado, txtEstadoPasado;
    private ImageView imgEstadoHoy,imgEstadoMañana,imgEstadoPasado;
    private String part1, part2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo);

        // Declaracion de Views
        spinner = (Spinner)findViewById(R.id.spinner);
        tvLocalidad_Escogida = (TextView)findViewById(R.id.tvLocalidad_Escogida);
        txtHoraHoy = (TextView) findViewById(R.id.fechaHoraHoy);
        txtHoraMañana = (TextView) findViewById(R.id.fechaHoraMañana);
        txtHoraPasado = (TextView) findViewById(R.id.fechaHoraPasado);
        txtTemperaturaHoy = (TextView) findViewById(R.id.temperaturaHoy);
        txtTemperaturaMañana = (TextView) findViewById(R.id.temperaturaMañana);
        txtTemperaturaPasado = (TextView) findViewById(R.id.temperaturaPasado);
        txtEstadoHoy = (TextView) findViewById(R.id.estadoHoy);
        txtEstadoMañana= (TextView) findViewById(R.id.estadoMañana);
        txtEstadoPasado= (TextView) findViewById(R.id.estadoPasado);
        imgEstadoHoy =(ImageView) findViewById(R.id.imgEstadoHoy);
        imgEstadoMañana =(ImageView) findViewById(R.id.imgEstadoMañana);
        imgEstadoPasado =(ImageView) findViewById(R.id.imgEstadoPasado);
        Button volver = findViewById(R.id.volver_tiempo);

        //Llamamos al metodo para llenar el spinner
        llenarSpinnerDeProvincias();

        // Metodo onClick del boton volver, vuelve a la ventana principal
        volver.setOnClickListener(view -> {
            finish();
        });

    }

    //Metodo para cargar el spinner desde un fichero
    private void llenarSpinnerDeProvincias()
    {
        try
        {
            ArrayList<String> datos = new ArrayList<String>();
            ArrayList<String> URLs = new ArrayList<String>();

            InputStream is = getResources().openRawResource(R.raw.listado_localidades_xml);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            int contProvincia = -1;
            String linea = br.readLine();

            while (linea != null)
            {
                //Spliteamos el contenido del fichero
                String[] parts = linea.split(";");
                part1 = parts[0];
                part2 = parts[1];
                datos.add(part1);
                URLs.add(part2);
                linea = br.readLine();
            }
            br.close();

            //Creamos el adaptador para el spinner
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, datos);
            adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adaptador);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                    //Cuando seleccionamos un elemnto esto se ejecutara
                    tvLocalidad_Escogida.setText(spinner.getSelectedItem().toString());
                    url = URLs.get(position);
                    cargarConSAXSimplificado();
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
        catch(Exception e)
        {
            Toast.makeText(this,"No se ha podido cargar la lista de provincias",Toast.LENGTH_LONG ).show();
        }
    }

    // Metodo que ejecuta la tarea en segundo plano de la carga de datos
    public void cargarConSAXSimplificado(){
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute(url);
    }

    @SuppressLint("StaticFieldLeak")
    private class CargarXmlTask extends AsyncTask<String,Integer,Boolean> {

        // Metodo doInBackground, llama al parse para coger el objeto Tiempo
        protected Boolean doInBackground(String... params) {
            RssParserSAXSimplificadoTiempo saxparserSimplificado =
                    new RssParserSAXSimplificadoTiempo(params[0]);
            tiempoHoy = saxparserSimplificado.parse();
            tiempoMañana = saxparserSimplificado.parse2();
            tiempoPasado = saxparserSimplificado.parse3();
            return true;
        }

        // Metodo onPostExecute, añade los datos de ese Tiempo a los Views
        @SuppressLint("SetTextI18n")
        protected void onPostExecute(Boolean result) {

            //Tiempo de hoy
            txtHoraHoy.setText(" " + tiempoHoy.getDia() + "/" + tiempoHoy.getHora());
            txtEstadoHoy.setText(" " + tiempoHoy.getEstado());
            txtTemperaturaHoy.setText(" " + tiempoHoy.getTemperatura() + " (Min: " + tiempoHoy.getTemperatura_min() + " / Max: " + tiempoHoy.getTemperatura_max() + ")");

            String icon1 = "a" + tiempoHoy.getIcono();
            Resources res1 = getResources();
            int resID1 = res1.getIdentifier(icon1, "drawable", getPackageName());
            imgEstadoHoy.setImageResource(resID1);

            //Tiempo de mañana
            txtHoraMañana.setText("" + tiempoMañana.getDia());
            txtEstadoMañana.setText("" + tiempoMañana.getEstado());
            txtTemperaturaMañana.setText(" (Min: " + tiempoMañana.getTemperatura_min() + " / Max: " + tiempoMañana.getTemperatura_max() + ")");

            String icon2 = "a" + tiempoMañana.getIcono();
            Resources res2 = getResources();
            int resID2 = res2.getIdentifier(icon2, "drawable", getPackageName());
            imgEstadoMañana.setImageResource(resID2);

            //Tiempo de pasado
            txtHoraPasado.setText("" + tiempoPasado.getDia());
            txtEstadoPasado.setText("" + tiempoPasado.getEstado());
            txtTemperaturaPasado.setText(" (Min: " + tiempoPasado.getTemperatura_min() + " / Max: " + tiempoPasado.getTemperatura_max() + ")");

            String icon3 = "a" + tiempoPasado.getIcono();
            Resources res3 = getResources();
            int resID3 = res3.getIdentifier(icon3, "drawable", getPackageName());
            imgEstadoPasado.setImageResource(resID3);

        }
    }
}