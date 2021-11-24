package com.example.actividad_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Aceptar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceptar);

        TextView frase = (TextView) findViewById(R.id.lblAceptar);

        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("auxNombre");
        String apellidos = datos.getString("auxApellidos");

        frase.setText("Hola " + nombre.toUpperCase() + " " + apellidos.toUpperCase() + " ¿Aceptas las condiciones?");

        Button btnAceptar = (Button) findViewById(R.id.btnAceptar);
        Button btnRechazar = (Button) findViewById(R.id.btnRechazar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnRechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

    }
}