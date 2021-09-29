package com.example.actividad_2_ejer_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtUno, txtDos;
    private TextView lblResul;
    private Button btnSuma, btnResta, btnMulti, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUno = (EditText) findViewById(R.id.txtUno);
        txtDos = (EditText) findViewById(R.id.txtDos);
        btnSuma = (Button) findViewById(R.id.btnSuma);
        btnResta = (Button) findViewById(R.id.btnResta);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        lblResul = (TextView) findViewById(R.id.lblResul);

        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int aux1 = Integer.valueOf(txtUno.getText().toString());
        int aux2 = Integer.valueOf(txtDos.getText().toString());
        int resul = 0;

        if (view.getId() == R.id.btnSuma) {
            resul = aux1 + aux2;
        }
        else if (view.getId() == R.id.btnResta) {
            resul = aux1 - aux2;
        }
        else if (view.getId() == R.id.btnMulti){
            resul = aux1 * aux2;
        }
        else if (view.getId() == R.id.btnDiv){
            if (aux2 == 0){
                resul = 0;
            }
            else {
                resul =aux1/aux2;
            }
        }
        lblResul.setText("" + resul);
    }
}