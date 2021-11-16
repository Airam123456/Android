package com.example.examen.amigos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.examen.R;

public class ActivityVerificarAmigo extends AppCompatActivity {

    TextView tvNombre,tvApellidos,tvSexo,tvMuseos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_amigo);

        tvNombre = findViewById(R.id.tvNombreAmigo);
        tvApellidos = findViewById(R.id.tvApellidosAmigo);
        tvSexo = findViewById(R.id.tvSexoAmigo);
        tvMuseos = findViewById(R.id.tvMuseosAmigo);


        //Recoger los datos del intent
        Bundle extras = getIntent().getExtras();

        tvNombre.setText(extras.getString("Nombre"));
        tvApellidos.setText(extras.getString("Apellidos"));
        tvSexo.setText(extras.getString("Sexo"));
        tvMuseos.setText(extras.getString("Museos"));


        //Al hacer click en aceptar mandamos un result con el codigo ACEPTADO
        Button btnAceptar = findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(ActivityAlta.ACEPTADO);

                finish();
            }
        });

        //Al hacer click en aceptar mandamos un result con codigo diferente a ACEPTADO
        Button btnRechazar = findViewById(R.id.btnRechazar);
        btnRechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(0);
                finish();
            }
        });
    }
}
