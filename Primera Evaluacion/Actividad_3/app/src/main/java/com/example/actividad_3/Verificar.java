package com.example.actividad_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Verificar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar);

        Button volver = (Button) findViewById(R.id.btnVolver);
        Button verificar = (Button) findViewById(R.id.btnVeri);
        EditText nombre = (EditText) findViewById(R.id.txtNom);
        EditText apellidos = (EditText) findViewById(R.id.txtApe);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Verificar.this, MainActivity.class);
                startActivity(intent);
            }
        });

        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String auxNombre = nombre.getText().toString();
                String auxApellido = apellidos.getText().toString();

                Intent intent = new Intent(Verificar.this, Aceptar.class);
                intent.putExtra("auxNombre", auxNombre);
                intent.putExtra("auxApellidos", auxApellido);
                startActivityForResult(intent,12);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView lblRespuesta = (TextView) findViewById(R.id.lblResp);
        if (requestCode==12 && resultCode==RESULT_OK)
            lblRespuesta.setText("ACEPTADO");
        else
            lblRespuesta.setText("RECHAZADO");
    }
}