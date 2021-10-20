package com.example.actividad_4;

import androidx.appcompat.app.AppCompatActivity;

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

    public void actividad1(View view) {
        Intent intent = new Intent(MainActivity.this, Actividad_1.class);
        startActivity(intent);
    }
    public void actividad2(View view) {
        Intent intent = new Intent(MainActivity.this, Actividad_2.class);
        startActivity(intent);
    }

    public void actividad3(View view) {
        Intent intent = new Intent(MainActivity.this, Actividad_3.class);
        startActivity(intent);
    }

    public void salir(View view) {finish();
    }
}