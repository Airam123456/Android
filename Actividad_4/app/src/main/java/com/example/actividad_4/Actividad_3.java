package com.example.actividad_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class Actividad_3 extends AppCompatActivity {

    private String[] datosGV = new String [9];
    private GridView gvOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);

        for
        (int i=1; i<=9; i++){
            datosGV[i-1]= "Perrito Sorpresa "+i;
        }
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, datosGV);
        gvOpciones = (GridView)findViewById(R.id.gridPerros);
        gvOpciones.setAdapter(adaptador);

        gvOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent = new Intent(Actividad_3.this, Visualizador.class);
                    intent.putExtra("posicion", i);
                    startActivity(intent);
            }
        });
    }

    public void salir(View view) {finish();
    }
}