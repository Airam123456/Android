package com.example.actividad_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Lanzador_Dados extends AppCompatActivity {

    private ImageButton d6, d10, d20;
    private TextView tirada;
    private int aux1, aux2, aux3;
    private String tiradasD6="", tiradasD10="", tiradasD20="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanzador_dados);

        d6 = (ImageButton) findViewById(R.id.imgBtnDado6);
        d10 = (ImageButton) findViewById(R.id.imgBtnDado10);
        d20 = (ImageButton) findViewById(R.id.imgBtnDado20);
        tirada = (TextView) findViewById(R.id.lblResultado);


        d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aux1 =(int)(Math.random() * 6) + 1;
                tirada.setText(String.valueOf(aux1));
                tiradasD6 = aux1 + "\n" + tiradasD6 ;
            }
        });

        d10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aux2 =(int)(Math.random() * 10) + 1;
                tirada.setText(String.valueOf(aux2));
                tiradasD10 = aux2 +"\n" + tiradasD10 ;
            }
        });

        d20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aux3 =(int)(Math.random() * 20) + 1;
                tirada.setText(String.valueOf(aux3));
                tiradasD20 = aux3 + "\n" + tiradasD20;
            }
        });

    }

    public void historial(View view) {
        Intent intent = new Intent(Lanzador_Dados.this, Historial.class);
        intent.putExtra("dado6", tiradasD6);
        intent.putExtra("dado10", tiradasD10);
        intent.putExtra("dado20", tiradasD20);
        startActivity(intent);
    }
    public void salir(View view) {
        finish();
    }
}