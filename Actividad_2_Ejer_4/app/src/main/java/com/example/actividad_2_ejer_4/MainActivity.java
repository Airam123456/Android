package com.example.actividad_2_ejer_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtNum, txtLetra; // Input
    private TextView lblResul; // Texto de resultado
    // Array con las letras posibles del DNI
    char[] letraDni = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',  'X',  'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Conectores
        txtNum = (EditText) findViewById(R.id.txtNum);
        txtLetra = (EditText) findViewById(R.id.txtLet);
        lblResul = (TextView) findViewById(R.id.lblResul);

    }

    public void validar(View view) {

        String dni = txtNum.getText().toString(); // dni
        String letra = txtLetra.getText().toString().toUpperCase(); // letra

        if (dni.length() != 8 || letra.length() != 1 || !Character.isLetter(letra.charAt(0)))
            // Comprobamos que tenga 8 numeros, y una letra
            lblResul.setText(R.string.noDNI);
        else
        {
            int numAValidar = Integer.parseInt(dni);
            numAValidar %= 23;

            if ((new Character(letra.charAt(0))) != letraDni[numAValidar]) // Comprobamos si la letra introducida es correcta
            {
                lblResul.setText(R.string.fallo); // Preguntar a Amaia como concatenar aqui
            }
            else
                lblResul.setText(R.string.correcto);
        }

    }
}