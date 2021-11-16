package com.example.examen.amigos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examen.R;

public class ActivityAlta extends AppCompatActivity {

    EditText edNombre,edApellidos,edOtros;

    RadioGroup rdGroup;
    RadioButton radioMasc,radioFem;

    CheckBox[] checkArray;

    Button btnCancelar,btnAlta;

    static final int ACEPTADO = 1;

    TextView tvContador;

    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);

        contador = 0;

        edNombre = findViewById(R.id.edNombre);
        edApellidos = findViewById(R.id.edApellidos);

        edOtros = findViewById(R.id.edOtros);

        rdGroup = findViewById(R.id.rdGroup);

        radioMasc = findViewById(R.id.rdMasculino);
        radioFem = findViewById(R.id.rdFemenino);

        checkArray = new CheckBox[3];
        checkArray[0] = findViewById(R.id.ckArte);
        checkArray[1]  = findViewById(R.id.ckCiencia);
        checkArray[2]  = findViewById(R.id.ckOtros);

        checkArray[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edOtros.setVisibility(View.VISIBLE);
            }
        });

        btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    finish();
            }
        });
        btnAlta = findViewById(R.id.btnAlta);
        btnAlta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityAlta.this, ActivityVerificarAmigo.class);

                String nombre = edNombre.getText().toString();
                String apellidos = edApellidos.getText().toString();
                RadioButton radio = findViewById(rdGroup.getCheckedRadioButtonId());

                String museos = getCheckString();

                //Verificar que estén los campos rellenos
                if (nombre.equals("") || apellidos.equals("") || radio==null){

                    Toast.makeText(ActivityAlta.this,getText(R.string.Falta),Toast.LENGTH_SHORT).show();
                    return;
                }

                String sexo = radio.getText().toString();


                i.putExtra("Nombre",nombre);
                i.putExtra("Apellidos",apellidos);



                i.putExtra("Sexo",sexo);

                i.putExtra("Museos",museos);

                //Hacemos intent esperando un resultado de vuelta
                startActivityForResult(i,ACEPTADO);
            }
        });

        tvContador = findViewById(R.id.tvContador);


    }

    //Chequeamos que checkbox están seleccionado
    private String getCheckString(){

        String strCheck ="";

        for(CheckBox check : checkArray){

            if(check.isChecked())
                if(check.getText().toString().equals("Otros")){
                    strCheck += edOtros.getText().toString() + ", ";
                }else{
                    strCheck += (check.getText().toString() + ", ");

                }

        }


        return strCheck;

    }

    //Al recibir el resultado de la verificación si el codigo es ACEPTADO se vaciarán los campos y el contador sumará 1
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == ACEPTADO) {

            edNombre.setText("");
            edApellidos.setText("");

            //Vaciar y hacer invisible editText Otros
            edOtros.setText("");
            edOtros.setVisibility(View.INVISIBLE);

            rdGroup.setSelected(false);
            radioMasc.setSelected(false);
            radioFem.setSelected(false);

            for(CheckBox check : checkArray){

                check.setChecked(false);

            }
            contador++;
            tvContador.setText(getText(R.string.Tenemos)+" "+contador+" "+getText(R.string.NuevosAmigos));


        }
    }
}
