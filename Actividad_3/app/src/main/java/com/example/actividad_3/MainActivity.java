package com.example.actividad_3;

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

        Button act1 = (Button) findViewById(R.id.btnAct1);
        Button act2 = (Button) findViewById(R.id.btnAct2);
        Button act3 = (Button) findViewById(R.id.btnAct3);
        Button act4 = (Button) findViewById(R.id.btnAct4);

        act1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Verificar.class);
                startActivity(intent);
            }
        });

    }

    public void salir(View view) {
        finish();
    }
}