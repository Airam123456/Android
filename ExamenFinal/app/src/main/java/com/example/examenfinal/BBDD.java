package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class BBDD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbdd);

        // Declaracion de Views
        Button butNuevoLibro = findViewById(R.id.btnNuevoLibro);
        Button butListadoLibro = findViewById(R.id.btnListadoLibros);
        Button salir = findViewById(R.id.btnSalirBBDD);

        // Metodo onClick butNuevoLibro
        butNuevoLibro.setOnClickListener(view -> {
            Intent intent = new Intent(BBDD.this, BBDD_NuevoLibro.class);
            startActivity(intent);
        });

        // Metodo onClick butListadoLibro
        butListadoLibro.setOnClickListener(view -> {
            Intent intent = new Intent(BBDD.this, BBDD_ListarLibros.class);
            startActivity(intent);
        });
        // Metodo onClick del boton volver, vuelve a la ventana principal
        salir.setOnClickListener(view -> finish());
    }
}