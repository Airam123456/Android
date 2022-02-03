package com.example.actividad_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Registro_Datos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_datos);

        TextView datosNomApe = (TextView) findViewById(R.id.lblDatosNom);
        TextView datosSexo = (TextView) findViewById(R.id.lblDatosSexo);
        TextView datosAfi = (TextView) findViewById(R.id.lblDatosAficiones);

        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("nombre");
        String apellidos = datos.getString("apellidos");
        String sexo = datos.getString("sexo");
        String aficiones = datos.getString("aficiones");

        datosNomApe.setText(nombre + " " + apellidos);
        datosSexo.setText(sexo);
        datosAfi.setText(aficiones);

    }

    public void confirmar(View view) {
        finish();
    }
}