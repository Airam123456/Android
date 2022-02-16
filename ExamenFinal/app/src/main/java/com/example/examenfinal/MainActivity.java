package com.example.examenfinal;

import static java.lang.System.exit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaracion de Views
        Button BBDD = findViewById(R.id.Main1);
        Button XML = findViewById(R.id.Main2);
        Button salir = findViewById(R.id.Main3);

        // Metodo onClick del boton BBDD, abre la BBDD del examen
        BBDD.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, BBDD.class);
            startActivity(intent);
        });

        // Metodo onClick del boton XML, abre la Tiempo del examen
        XML.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Tiempo.class);
            startActivity(intent);
        });

        //Metodo onClick del boton salir, paracera un Dialog para preguntar
        salir.setOnClickListener(view -> new AlertDialog.Builder(MainActivity.this)
                .setTitle(R.string.adios)
                .setMessage(R.string.mensajeAdios)
                .setCancelable(false)
                .setPositiveButton(R.string.salir, (dialogInterface, i) -> exit(0))
                .setNegativeButton(R.string.cancelar,(dialogInterface, i) -> closeContextMenu())
                .show());
    }
}