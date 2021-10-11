package com.example.actividad_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {

    private int aux1, aux2, respCorrectas = 0, respIncorrectas = 0;
    private TextView correctas, incorrectas;
    private  EditText suma1, suma2, resultado;
    private Button volver, comprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        volver = (Button) findViewById(R.id.btnVolver);
        suma1 = (EditText) findViewById(R.id.txtSuma1);
        suma2 = (EditText) findViewById(R.id.txtSuma2);
        resultado = (EditText) findViewById(R.id.txtResultado);
        comprobar = (Button) findViewById(R.id.btnComprobarResult);
        correctas = (TextView) findViewById(R.id.lblCorrectas);
        incorrectas = (TextView) findViewById(R.id.lblIncorrectas);

        generarNumeros();

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int resul = Integer.valueOf(resultado.getText().toString());
                    Intent intent = new Intent(Calculadora.this, Resultado.class);
                    intent.putExtra("numero1", aux1);
                    intent.putExtra("numero2", aux2);
                    intent.putExtra("resultado", resul);
                    startActivityForResult(intent, 20);
                }
                catch (Exception e){
                    generarNumeros();
                }
            }
        });
    }

    private void generarNumeros()
    {
        aux1 = (int)(Math.random() * 100);
        suma1.setText(String.valueOf(aux1));
        aux2 = (int)(Math.random() * 100);
        suma2.setText(String.valueOf(aux2));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 20 && resultCode == RESULT_OK)
        {
            respCorrectas++;
            correctas.setText("PREGUNTAS CORRECTAS: " + respCorrectas);
        }
        else
        {
            respIncorrectas++;
            incorrectas.setText("PREGUNTAS INCORRECTAS: " + respIncorrectas);
        }
        generarNumeros();
        resultado.setText("");
    }
}