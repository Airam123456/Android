package com.example.actividad_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Pulsar alt intro para apñadir las clases al import

    private TextView lblSiete;
    private Button btnCinco;
    private EditText txtDos,txtCuatro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnCinco = (Button) findViewById(R.id.btnCinco);
        lblSiete = (TextView) findViewById(R.id.lblSiete);
        txtDos = (EditText) findViewById(R.id.txtDos);
        txtCuatro = (EditText) findViewById(R.id.txtCuatro);

        btnCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int aux1 = Integer.valueOf(txtDos.getText().toString());
                int aux2 = Integer.valueOf(txtCuatro.getText().toString());
                int resul = aux1 + aux2;
                lblSiete.setText(""+resul);
            }
        });
    }
}


