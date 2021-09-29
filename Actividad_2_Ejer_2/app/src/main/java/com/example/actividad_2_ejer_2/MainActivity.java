package com.example.actividad_2_ejer_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtDos,txtCuatro;
    private Button btnSuma, btnResta, btnMulti, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDos = (EditText) findViewById(R.id.txtDos);
        txtCuatro = (EditText) findViewById(R.id.txtCuatro);
        btnSuma = (Button) findViewById(R.id.btnSuma);
        btnResta = (Button) findViewById(R.id.btnResta);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        int aux1 = Integer.valueOf(txtDos.getText().toString());
        int aux2 = Integer.valueOf(txtCuatro.getText().toString());
        btnSuma.setOnClickListener(this);

    }
}