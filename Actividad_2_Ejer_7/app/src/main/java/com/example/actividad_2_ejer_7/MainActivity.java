package com.example.actividad_2_ejer_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton btnLuz, btnCam, btnPer;
    private ImageView imgLuz, imgCam, imgPer;
    private EditText tempElegida;
    private TextView tempActu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCam = (ToggleButton)findViewById(R.id.btnCam);
        btnLuz = (ToggleButton)findViewById(R.id.btnLuz);
        btnPer = (ToggleButton)findViewById(R.id.btnPers);
        imgCam = (ImageView) findViewById(R.id.imgCam);
        imgLuz = (ImageView) findViewById(R.id.imgLuz);
        imgPer = (ImageView) findViewById(R.id.imgPers);
        tempElegida = (EditText) findViewById(R.id.txtTemp);
        tempActu = (TextView) findViewById(R.id.lblTem);

        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnCam.isChecked())
                    imgCam.setVisibility(View.VISIBLE);
                else
                    imgCam.setVisibility(View.INVISIBLE);
            }
        });

        btnLuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnLuz.isChecked())
                    imgLuz.setImageResource(R.drawable.luzon);
                else
                    imgLuz.setImageResource(R.drawable.luzoff);
            }
        });

        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnPer.isChecked())
                    imgPer.setImageResource(R.drawable.persianaon);
                else
                    imgPer.setImageResource(R.drawable.persianoff);
            }
        });
    }


    public void ajustarTemp(View view) {

        String temp = tempElegida.getText().toString();
        tempActu.setText(temp + "º");
    }
}