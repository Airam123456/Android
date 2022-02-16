package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class BBDD_Detalles extends AppCompatActivity {

    private TextView txtTitulo, txtAutor, txtIsbn, txtEditorial, txtNumpag, txtLeido;
    private long isbn;
    private Button butCancelar, butEliminar;
    private BibliotecaSQLiteHelper bsdbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbdd_detalles);

        // Declaracion de Views
        txtTitulo = (TextView)findViewById(R.id.tvTituloLibro_detalles);
        txtAutor = (TextView)findViewById(R.id.tvAutor_detalles);
        txtIsbn = (TextView)findViewById(R.id.tvIsbn_detalles);
        txtEditorial = (TextView)findViewById(R.id.tvEditorial_detalles);
        txtNumpag = (TextView)findViewById(R.id.tvNumPag_detalles);
        txtLeido = (TextView)findViewById(R.id.tvLeido_detalles);
        butCancelar = (Button)findViewById(R.id.butCancela_detalles);
        butEliminar = (Button)findViewById(R.id.butEliminar_detalles);

        BibliotecaSQLiteHelper bsdbh = new BibliotecaSQLiteHelper(this, "Biblioteca", null, 1);

        mostrarDatos();

        // Metodo onClick del boton volver, vuelve a la ventana principal
        butCancelar.setOnClickListener(view -> {

            Intent intent = new Intent();
            intent.putExtra("check", false);
            setResult(RESULT_OK, intent);

            finish();
        });

        // Metodo onClick del boton eliminar, elimina la entrada en la tabla
        butEliminar.setOnClickListener(view -> {
            SQLiteDatabase db = bsdbh.getWritableDatabase();

            //Si hemos abierto correctamente la base de datos
            if (db != null)
                db.execSQL("DELETE FROM Libro WHERE isbn = '" + isbn + "'");
            db.close();

            Intent intent = new Intent();
            intent.putExtra("check", true);
            setResult(RESULT_OK, intent);

            finish();
        });
    }

    private void mostrarDatos()
    {
        //mostramos los datos
        Bundle extras = getIntent().getExtras();
        String titulo = (String)extras.get(getString(R.string.titulo2));
        String autor = (String)extras.get(getString(R.string.autor2));
        String editorial = (String)extras.get(getString(R.string.aditorial2));
        isbn = (long)extras.get("isbn");
        boolean leido = (boolean)extras.get("leido");
        int numPag = (int)extras.get("numPag");

        txtTitulo.setText(titulo);
        txtAutor.setText(autor);
        txtIsbn.setText(String.valueOf(isbn));
        txtEditorial.setText(editorial);
        txtLeido.setText(String.valueOf(numPag));

        if(leido == true)
            txtLeido.setText(R.string.lIBROleidos);
        else
            txtLeido.setText(R.string.LIBROpor_leer);
    }

}