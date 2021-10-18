package com.example.actividad_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class Actividad_1 extends AppCompatActivity {

    private ListView lista;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        lista = (ListView) findViewById(R.id.listLista);
        texto = (TextView) findViewById(R.id.txtDatos);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.paises, android.R.layout.simple_spinner_item);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        texto.setText("Superficie: 505.990 km²\n" +
                                "Población: 47,35 millones");
                        break;
                    case 1:
                        texto.setText("Superficie: 92.212 km²\n" +
                                "Población: 10,31 millones");
                        break;
                    case 2:
                        texto.setText("Superficie: 632.734 km²\n" +
                                "Población: 67,39 millones");
                        break;
                    case 3:
                        texto.setText("Superficie: 468 km²\n" +
                                "Población: 77.265");
                        break;
                }
            }
        });

    }
    public void salir(View view) {finish();
    }
}