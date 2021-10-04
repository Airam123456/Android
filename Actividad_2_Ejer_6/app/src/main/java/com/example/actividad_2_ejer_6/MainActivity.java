package com.example.actividad_2_ejer_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton btnToggle1, btnToggle2;
    private Switch btnSwitch1, btnSwitch2;
    private ImageView cam1, cam2, luz1, luz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Conectores
        btnToggle1 = (ToggleButton)findViewById(R.id.BtnToggle1);
        btnToggle2 = (ToggleButton)findViewById(R.id.BtnToggle2);
        btnSwitch1 = (Switch) findViewById(R.id.swi1);
        btnSwitch2 = (Switch) findViewById(R.id.swi2);
        luz1 = (ImageView)findViewById(R.id.imgLuz1);
        luz2 = (ImageView)findViewById(R.id.imgLuz2);
        cam2 = (ImageView)findViewById(R.id.imgCam2);
        cam1 = (ImageView)findViewById(R.id.imgCam1);

        // Para las camaras cambiamos la visibilidad
        btnSwitch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnSwitch1.isChecked())
                    cam1.setVisibility(View.VISIBLE);
                else
                    cam1.setVisibility(View.INVISIBLE);
            }
        });

        // Para la luz cambiamos las fotos
        btnSwitch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnSwitch2.isChecked())
                    luz1.setImageResource(R.drawable.luzon);
                else
                    luz1.setImageResource(R.drawable.luzoff);
            }
        });

        btnToggle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnToggle1.isChecked()) {
                    cam2.setVisibility(View.VISIBLE);
                }
                else
                    cam2.setVisibility(View.INVISIBLE);
            }
        });

        btnToggle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnToggle2.isChecked())
                    luz2.setImageResource(R.drawable.luzon);
                else
                    luz2.setImageResource(R.drawable.luzoff);
            }
        });
    }
}