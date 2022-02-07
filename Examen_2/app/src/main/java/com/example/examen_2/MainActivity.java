package com.example.examen_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //Boton ejer1
    public void listener_butEjer1(View view) {
        Intent intent = new Intent(MainActivity.this,Ejer1.class);
        startActivity(intent);
    }
    //Boton ejer2
    public void listener_butEjer2(View view) {
        Intent intent = new Intent(MainActivity.this,Ejer2.class);
        startActivity(intent);
    }
    //Dialog de despedida
    public void listener_butSalir(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Adios")
                .setMessage("Esperamos verle pronto de nuevo.ADIOS!!!!")
                .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .show();
    }
}