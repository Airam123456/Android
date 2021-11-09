package com.example.actividad_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int aux1, aux2, aux3, respCorrectas;
    private EditText operando1, operando2, resultado, operador;
    private TextView respuesta;
    private Button volver, comprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volver = (Button) findViewById(R.id.btnVolver);
        operando1 = (EditText) findViewById(R.id.txtOperando1);
        operando2 = (EditText) findViewById(R.id.txtOperando2);
        operador = (EditText) findViewById(R.id.txtOperador);
        resultado = (EditText) findViewById(R.id.txtResultado);
        comprobar = (Button) findViewById(R.id.btnComprobarResult);
        respuesta = (TextView) findViewById(R.id.lblRespuesta);

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
                switch (aux3)
                {
                    case 0: if((aux1 + aux2) == Integer.parseInt(resultado.getText().toString())) {
                        respuesta.setText("CORRECTA");
                        respCorrectas++;
                        generarNumeros();
                    }
                    else{
                        respuesta.setText("INCORRECTA");
                        generarNumeros();
                    }
                    break;
                    case 1: if((aux1 - aux2) == Integer.parseInt(resultado.getText().toString())){
                        respuesta.setText("CORRECTA");
                        respCorrectas++;
                        generarNumeros();
                    }
                    else{
                        respuesta.setText("INCORRECTA");
                        generarNumeros();
                    }
                    break;
                    case 2: if((aux1 * aux2) == Integer.parseInt(resultado.getText().toString())){
                        respuesta.setText("CORRECTA");
                        respCorrectas++;
                        generarNumeros();
                    }
                    else{
                        respuesta.setText("INCORRECTA");
                        generarNumeros();
                    }
                    break;
                    case 3: if((aux1 / aux2) == Integer.parseInt(resultado.getText().toString())){
                        respuesta.setText("CORRECTA");
                        respCorrectas++;
                        generarNumeros();
                    }
                    else{
                        respuesta.setText("INCORRECTA");
                        generarNumeros();
                    }
                    break;
                }
            }
        });

    }


    private void generarNumeros()
    {
        aux1 = (int)(Math.random() * 100);
        operando1.setText(String.valueOf(aux1));
        aux2 = (int)(Math.random()  * 100 + 1);
        operando2.setText(String.valueOf(aux2));
        aux3 = (int)(Math.random() * 3);
        if (aux3 == 0)
            operador.setText("+");
        else if (aux3 == 1)
            operador.setText("-");
        else if (aux3 == 2)
            operador.setText("*");
        else
            operador.setText("/");
    }
}