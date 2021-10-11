package com.example.actividad_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private boolean acierto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView respuesta = (TextView) findViewById(R.id.lblResp);
        Button volver = (Button) findViewById(R.id.btnVolverCalculadora);

        Bundle datos = getIntent().getExtras();
        int n1 = datos.getInt("numero1");
        int n2 = datos.getInt("numero2");
        int resul = datos.getInt("resultado");

        if (n1 + n2 == resul){
            respuesta.setText("CORRECTA");
            acierto = true;
        }
        else{
            respuesta.setText("INCORRECTA");
            acierto = false;
        }


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (acierto == true)
                {
                    Intent intent = new Intent();
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else
                {
                    Intent intent = new Intent();
                    setResult(RESULT_CANCELED, intent);
                    finish();
                }

            }
        });
    }
}