package com.example.airam_examen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Dialogo_Login.OnDialogoConfirmacionListener{

    private Dialogo_Login dialogoLogin;
    private FragmentManager fragmentManager;
    private final String USUARIO = "usuario";
    private final String CONTRASENIA = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        dialogoLogin = new Dialogo_Login();
        dialogoLogin.show(fragmentManager,"Dialogo");



        Button acti1 = (Button) findViewById(R.id.btnActividad1);
        Button acti2 = (Button) findViewById(R.id.btnActividad2);
        Button exit = (Button) findViewById(R.id.btnExit);

        acti1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Solicitud_Datos.class);
                startActivity(intent);
            }
        });

        acti2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Localidades.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @Override
    public void onPossitiveButtonClick() {

        String usuario = dialogoLogin.getUser().getText().toString();
        String contrasenia = dialogoLogin.getPass().getText().toString();

        if(usuario.equals(USUARIO) && contrasenia.equals(CONTRASENIA)){

        }else{
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setCancelable(false);
            alertDialog.setTitle("¡¡ATENCION!!");
            alertDialog.setMessage("Usuario y/o pass erroneos. la aplicacion se cerrara");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            alertDialog.show();
        }

    }

    @Override
    public void onNegativeButtonClick() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle("¡¡ATENCION!!");
        alertDialog.setMessage("User y pass necesarios para entrar");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        alertDialog.show();
    }
}