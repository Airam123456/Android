package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class BBDD_NuevoLibro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbdd_nuevo_libro);

        // Conexion con la BBDD
        BibliotecaSQLiteHelper bsdbh = new BibliotecaSQLiteHelper(this, "Biblioteca", null, 1);
        SQLiteDatabase db = bsdbh.getWritableDatabase();

        // Declaracion de Views
        EditText txtTituloLibro = findViewById(R.id.txtTituloLibro);
        EditText txtAutorLibro = findViewById(R.id.txtAutorLibro);
        EditText txtIsbnLibro = findViewById(R.id.txtIsbnLibro);
        EditText txtEditorialLibro = findViewById(R.id.txtEditorialLibro);
        EditText txtNumPagLibro = findViewById(R.id.txtNumPagLibro);
        CheckBox checkLeido = findViewById(R.id.checkLeido);
        Button butInsertarLibro = findViewById(R.id.butInsertarLibro);
        Button butCancelarLibro = findViewById(R.id.butCancelarLibro);
        Button butVolver = findViewById(R.id.butSalir_bdnuevo_libro);

        // Metodo onClick del boton volver, vuelve a la ventana principal
        butVolver.setOnClickListener(view -> finish());

        //Metodo onClick del boton insertar
        butInsertarLibro.setOnClickListener(view -> {
            try {
                //Recuperar datos a insertar
                String titulo = txtTituloLibro.getText().toString();
                if(titulo.equals(""))
                    throw new Exception("El libro debe tener un título.");
                String autor = txtAutorLibro.getText().toString();
                if(autor.equals(""))
                    throw new Exception("El libro debe tener un autor.");
                String editorial = txtEditorialLibro.getText().toString();
                if(editorial.equals(""))
                    throw new Exception("El libro debe tener una editorial.");

                long isbn = Long.parseLong(txtIsbnLibro.getText().toString());
                int numPag = Integer.parseInt(txtNumPagLibro.getText().toString());
                boolean leido = checkLeido.isChecked();

                //Insertar
                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put(getString(R.string.titulo3), titulo);
                nuevoRegistro.put(getString(R.string.autor3), autor);
                nuevoRegistro.put(getString(R.string.editorial3), editorial);
                nuevoRegistro.put(getString(R.string.isbn3), isbn);
                nuevoRegistro.put(getString(R.string.num3), numPag);
                nuevoRegistro.put(getString(R.string.leido3), leido);

                db.insert("Libro", null, nuevoRegistro);
            }
            catch(NumberFormatException e)
            {
                Toast.makeText(this,"Los valores introducidos como ISBN y número de páginas deben ser numéricos.",Toast.LENGTH_LONG ).show();
            }
            catch(Exception e)
            {
                Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG ).show();
            }
            //Cerramo la base
        db.close();
        //Limpiamos campos
        txtTituloLibro.setText("");
        txtAutorLibro.setText("");
        txtIsbnLibro.setText("");
        txtEditorialLibro.setText("");
        txtNumPagLibro.setText("");
        checkLeido.setChecked(false);
        });

    butCancelarLibro.setOnClickListener(view -> {
        txtTituloLibro.setText("");
        txtAutorLibro.setText("");
        txtIsbnLibro.setText("");
        txtEditorialLibro.setText("");
        txtNumPagLibro.setText("");
        checkLeido.setChecked(false);
    });

    }
}