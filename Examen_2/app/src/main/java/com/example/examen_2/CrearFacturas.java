package com.example.examen_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CrearFacturas extends AppCompatActivity {

    private EditText txtnum, txtdni, txtconcepto, txtvalor;
    private ClienteSQLiteHelper fact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_facturas);
        //Asociacion
        txtnum = (EditText) findViewById(R.id.editTextNum);
        txtdni = (EditText) findViewById(R.id.editTextDNIF);
        txtconcepto = (EditText) findViewById(R.id.editTextConcepto);
        txtvalor = (EditText) findViewById(R.id.editTextValor);
        //Conexion
        fact = new ClienteSQLiteHelper(this,"Facturas",null,3);
    }

    public void listener_ConfirmarFact(View view) {

        SQLiteDatabase db = fact.getWritableDatabase();

        if(db != null){
            try {
                //Recuperar datos a insertar
                int num = Integer.parseInt(txtnum.getText().toString());
                int dni = Integer.parseInt(txtdni.getText().toString());
                String concepto = txtconcepto.getText().toString();
                double valor = Double.parseDouble(txtvalor.getText().toString());


                //Insertar
                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("Num", num);
                nuevoRegistro.put("dni", dni);
                nuevoRegistro.put("concepto", concepto);
                nuevoRegistro.put("valor", valor);

                //Insertamos
                db.insert("Facturas", null, nuevoRegistro);
            }
            catch(NumberFormatException e)
            {
                Toast.makeText(this,"Los valores introducidos como Num deben ser numéricos.",Toast.LENGTH_LONG ).show();
            }
            catch(Exception e)
            {
                Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG ).show();
            }
        }
    }

    public void listener_butVolverFAct(View view) {
        txtdni.setText("");
        txtnum.setText("");
        txtvalor.setText("");
        txtconcepto.setText("");
        finish();
    }
}