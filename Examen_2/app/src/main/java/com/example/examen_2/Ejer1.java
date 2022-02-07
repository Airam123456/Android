package com.example.examen_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ejer1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer1);


    }

    public void listener_butCrearCli(View view) {
        Intent intent = new Intent(Ejer1.this,CrearCliente.class);
        startActivity(intent);
    }

    public void listener_butCrearFact(View view) {
        Intent intent = new Intent(Ejer1.this,CrearFacturas.class);
        startActivity(intent);
    }

    public void listener_butConsul(View view) {
        Intent intent = new Intent(Ejer1.this,CrearFacturas.class);
        startActivity(intent);
    }

    public void listener_butVolverBBDD(View view) {
        finish();
    }
}