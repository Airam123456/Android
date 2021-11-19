package com.example.airam_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Localidades extends AppCompatActivity {

    private Spinner spinner;
    private Button ver, salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localidades);

        spinner =  (Spinner) findViewById(R.id.spinner);
        ver = (Button) findViewById(R.id.btnVisuLista);
        salir = (Button) findViewById(R.id.btnVolver);


        final String[] datos = new String [] {"Bizkaia" ,"Araba",
                "Gipuzkoa", "Nafarroa", "Lapurdi", "Behe-Nafarroa", "Zuberoa"} ;

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}