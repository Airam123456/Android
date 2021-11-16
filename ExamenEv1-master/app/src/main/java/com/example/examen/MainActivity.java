package com.example.examen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements DialogoLogin.OnDialogoConfirmacionListener {

    private DialogoLogin dialogoLogin;
    private FragmentManager fragmentManager;
    private final String USUARIO = "usuario1";
    private final String CONTRASENIA = "123456";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        //Dialogo de login usuario/contraseña
        dialogoLogin = new DialogoLogin();
        dialogoLogin.show(fragmentManager,"Dialogo");

        Button btnSalir = findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();

            }
        });

        Button btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //Iniciamos actividad amigos
                Intent i = new Intent(MainActivity.this, ActivityAmigos.class);


                startActivity(i);

            }
        });


    }


    @Override
    public void onPossitiveButtonClick() {
        String usuario = dialogoLogin.getEdUsuario().getText().toString();
        String contrasenia = dialogoLogin.getEdContrasenia().getText().toString();

        if(usuario.equals(USUARIO) && contrasenia.equals(CONTRASENIA)){

        }else{

            //Contraseña/Usuario incorrecto se crea Alert Dialog
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setCancelable(false);
            alertDialog.setTitle(getText(R.string.Info));
            alertDialog.setMessage(getText(R.string.UsuarioyContr));
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
        //Click en cancelar se crea Alert Dialog
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle(getText(R.string.Info));
        alertDialog.setMessage(getText(R.string.UsuarioyContrNeces));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        alertDialog.show();


    }
}
