package com.example.actividad_2_ejer_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGoogle, btnBing;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnGoogle = (Button) findViewById(R.id.btnGoogle);
        btnBing = (Button) findViewById(R.id.btnBing);
        logo = (ImageView) findViewById(R.id.imgLogo);

        // Listener en el propio boton
        btnBing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logo.setImageResource(R.drawable.bing_logo);
            }
        });

        //Implementando un Listener en el MainActivity
        btnGoogle.setOnClickListener(this);

    }
    // Metodo onClick en el disenio
    public void btnYa(View view) {
        logo.setImageResource(R.drawable.yahoo_logo);

    }

    @Override
    public void onClick(View view) {
        logo.setImageResource(R.drawable.google_logo);
    }
}