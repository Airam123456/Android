package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.examen.amigos.ActivityAlta;
import com.example.examen.museos.ActivityMuseos;

//Actividad con los 3 botones correspondientes y los intent a sus actividades
public class ActivityAmigos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigos);

        Button btnAlta = findViewById(R.id.btnAlta);
        btnAlta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityAmigos.this, ActivityAlta.class);


                startActivity(i);
            }
        });

        Button btnListadoAmigos = findViewById(R.id.btnListadoAmigos);
        btnListadoAmigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mensaje de no disponibilidad
                Toast.makeText(ActivityAmigos.this, getText(R.string.NoDisponible), Toast.LENGTH_SHORT).show();
            }
        });

        Button btnListadoMuseos = findViewById(R.id.btnListadoMuseos);
        btnListadoMuseos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityAmigos.this, ActivityMuseos.class);


                startActivity(i);
            }
        });
    }
}
