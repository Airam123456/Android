package com.example.examen_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CrearCliente extends AppCompatActivity {

    private EditText txtdni, txtnombre, txtdireccion, txttfno;
    private ClienteSQLiteHelper cli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cliente);
        //Asociacion
        txtdni = (EditText) findViewById(R.id.editTextDNI);
        txtnombre = (EditText) findViewById(R.id.editTextNombre);
        txtdireccion = (EditText) findViewById(R.id.editTextDireccion);
        txttfno = (EditText) findViewById(R.id.editTextTfno);
        //Conexion
        cli = new ClienteSQLiteHelper(this,"Clientes",null,3);
    }

    public void listener_ConfirmarCli(View view) {

        SQLiteDatabase db = cli.getWritableDatabase();

        if(db != null){
            try {
                //Recuperar datos a insertar
                int dni = Integer.parseInt(txtdni.getText().toString());
                String nombre = txtnombre.getText().toString();
                String direcccion = txtdireccion.getText().toString();
                String tfno = txttfno.getText().toString();

                //Insertar
                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("dni", dni);
                nuevoRegistro.put("nombre", nombre);
                nuevoRegistro.put("direccion", direcccion);
                nuevoRegistro.put("tfno", tfno);

                //Insertamos
                db.insert("Clientes", null, nuevoRegistro);

                txtdni.setText("");
                txtnombre.setText("");
                txtdireccion.setText("");
                txttfno.setText("");
                finish();
            }
            catch(NumberFormatException e)
            {
                Toast.makeText(this,"Los valores introducidos como DNI deben ser numéricos.",Toast.LENGTH_LONG ).show();
            }
            catch(Exception e)
            {
                Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG ).show();
            }
        }

    }

    public void listener_butVolverCli(View view) {
        txtdni.setText("");
        txtnombre.setText("");
        txtdireccion.setText("");
        txttfno.setText("");
        finish();
    }
}