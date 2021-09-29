package com.example.actividad_2_ejer_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        color = (ImageView) findViewById(R.id.imgColor); //unimos la imagen
    }

    public void encender(View view) {
        color.setBackgroundColor(Color.rgb(255,0,0)); //color rojo
    }

    public void apagar(View view) {
        color.setBackgroundColor(Color.rgb(0,0,255)); //colo azul
    }
}