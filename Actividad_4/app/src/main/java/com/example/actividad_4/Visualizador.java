package com.example.actividad_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Array;

public class Visualizador extends AppCompatActivity {

    private ImageView perro;
    private int[] arrPerros = {R.drawable.puppy_1,R.drawable.puppy_2,R.drawable.puppy_3,R.drawable.puppy_4,
            R.drawable.puppy_5,R.drawable.puppy_6,R.drawable.puppy_7,R.drawable.puppy_8,R.drawable.puppy_9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizador);

        Bundle datos = getIntent().getExtras();
        int i = datos.getInt("posicion");

        perro.setImageResource(arrPerros[i]);
    }

    public void salir(View view) {finish();
    }
}