package com.example.actividad_1_ficheros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private Button btnAniadirFichInt, btnAniadirFichExt, btnLeerFichInt, btnLeerFichExt, btnLeerRecurso,
            btnBorrarFichInt, btnBorrarFichExt;
    private EditText txtInput;
    private TextView lblOutout;
    private String fichero = "ejer1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAniadirFichInt = (Button) findViewById(R.id.btnAniadirFichInt);
        btnAniadirFichExt = (Button) findViewById(R.id.btnAniadirFichExt);
        btnLeerFichInt = (Button) findViewById(R.id.btnLeerFichInt);
        btnLeerFichExt = (Button) findViewById(R.id.btnLeerFichExt);
        btnLeerRecurso = (Button) findViewById(R.id.btnLeerRecurso);
        btnBorrarFichInt = (Button) findViewById(R.id.btnBorrarFichInt);
        btnBorrarFichExt = (Button) findViewById(R.id.btnBorrarFichExt);
        txtInput = (EditText) findViewById(R.id.txtInput);
        lblOutout = (TextView) findViewById(R.id.lblOutout);

    btnAniadirFichInt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                OutputStreamWriter osw = new OutputStreamWriter(openFileOutput(fichero, Context.MODE_PRIVATE));
                osw.write(txtInput.getText().toString());
                osw.close();
            }
            catch (Exception e){
                Log.e ("Ficheros", "ERROR!! al escribir fichero en memoria interna");
            }
            txtInput.setText("");
        }
    });

    btnLeerFichInt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try{
                BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput("ejer1.txt")));
                lblOutout.setText(fin.readLine());
                fin.close();
                Log.i("Ficheros", "Fichero leido!");
            }
            catch (Exception ex){
                Log.e ("Ficheros", "ERROR!! al leer fichero de la memoria interna");
            }
        }
    });

    btnBorrarFichInt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            File f = new File(fichero);
            f.delete();
        }
    });

    }
}