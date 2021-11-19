package com.example.airam_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Registro_Datos extends AppCompatActivity {

    private TextView datosNombre, datosFecha, datosProvincia, datosSexo, datosConocimiento;
    private Button aceptar, rechazar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_datos);

        datosNombre = (TextView) findViewById(R.id.txtRDMostrarNombre);
        datosFecha = (TextView) findViewById(R.id.txtRDMostrarFecha);
        datosProvincia = (TextView) findViewById(R.id.txtRDMostrarProvincia);
        datosSexo = (TextView) findViewById(R.id.txtRDMostrarSexo);
        datosConocimiento = (TextView) findViewById(R.id.txtRDMostrarConocimientos);
        aceptar = (Button) findViewById(R.id.btnRDAceptar);
        rechazar = (Button)findViewById(R.id.btnRDRechazar);

        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("name");
        String fecha = datos.getString("date");
        String provi = datos.getString("prov");
        String sexo = datos.getString("sexo");
        String cono = datos.getString("cono");

        datosNombre.setText(nombre);
        datosFecha.setText(fecha);
        datosProvincia.setText(provi);
        datosSexo.setText(sexo);
        datosConocimiento.setText(cono);


        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        rechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}