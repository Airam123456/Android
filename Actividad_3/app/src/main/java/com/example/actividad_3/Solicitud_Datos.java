package com.example.actividad_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Solicitud_Datos extends AppCompatActivity {

    private EditText nom, ape;
    private RadioGroup radio;
    private CheckBox musica, lectura, deporte, viajar;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_datos);

        nom = (EditText) findViewById(R.id.txtNombre);
        ape = (EditText) findViewById(R.id.txtApellidos);
        radio = (RadioGroup) findViewById(R.id.radioGrupo);
        musica = (CheckBox) findViewById(R.id.checkMusica);
        lectura = (CheckBox) findViewById(R.id.checkLectura);
        deporte = (CheckBox) findViewById(R.id.checkDeporte);
        viajar = (CheckBox) findViewById(R.id.checkViajar);
        enviar = (Button) findViewById(R.id.btnEnviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = "", apellidos = "", sexo = "", aficiones = "";

                if (nom.getText().toString().length() == 0)
                    nombre = "Nombre Vacio \n";
                else
                    nombre = nom.getText().toString();

                if (ape.getText().toString().length() == 0)
                    apellidos = "\nApellido Vacio ";
                else
                    apellidos = ape.getText().toString();

                if(radio.getCheckedRadioButtonId() == -1)
                    sexo = "No especificado";
                else{
                    RadioButton radioBtn = (RadioButton) findViewById(radio.getCheckedRadioButtonId());
                    sexo = radioBtn.getText().toString();
                }
                if(musica.isChecked())
                    aficiones += "Música \n";
                if(lectura.isChecked())
                    aficiones += "Lectura \n";
                if(deporte.isChecked())
                    aficiones += "Deporte \n";
                if(viajar.isChecked())
                    aficiones += "Viajar \n";
                if(aficiones == "")
                    aficiones = "Sin aficiones";

                Intent intent = new Intent(Solicitud_Datos.this, Registro_Datos.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("apellidos", apellidos);
                intent.putExtra("sexo", sexo);
                intent.putExtra("aficiones", aficiones);
                startActivity(intent);
            }
        });

    }

    public void volver(View view) {
        finish();
    }
}