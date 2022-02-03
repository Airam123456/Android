package com.example.actividad_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Historial extends AppCompatActivity {

    private String hd6="", hd10="", hd20="";
    private TextView hisD6 ,hisD10, hisD20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        hisD6 = (TextView) findViewById(R.id.lblTiradaD6);
        hisD10 = (TextView) findViewById(R.id.lblTiradaD10);
        hisD20 = (TextView) findViewById(R.id.lblTiradaD20);

        Bundle datos = getIntent().getExtras();
        hd6 = datos.getString("dado6");
        hd10 = datos.getString("dado10");
        hd20 = datos.getString("dado20");
        hisD6.setText(hd6);
        hisD10.setText(hd10);
        hisD20.setText(hd20);

    }

    public void atras(View view) {
        finish();
    }

    public void reset(View view) {
        hisD6.setText("");
        hisD10.setText("");
        hisD20.setText("");
    }
}