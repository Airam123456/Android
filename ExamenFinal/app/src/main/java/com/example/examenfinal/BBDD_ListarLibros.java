package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BBDD_ListarLibros extends AppCompatActivity {

    //Declaracion de variables
    private RadioGroup radioGroupLeido;
    private ListView lvLibros;
    private BibliotecaSQLiteHelper bsdbh;
    private RadioButton radio1, radio2;
    private Button butVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbdd_listar_libros);

        // Declaracion de Views
        butVolver = findViewById(R.id.butVolver_bdlistar_libros);
        radio1 = (RadioButton) findViewById(R.id.radButLeido);
        radio2 = (RadioButton) findViewById(R.id.radButNoLeido);
        radioGroupLeido = (RadioGroup)findViewById(R.id.radioGroupLeido);
        lvLibros = (ListView)findViewById(R.id.lvLibros);
        lvLibros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Libro libro = (Libro) parent.getItemAtPosition(position);
                String titulo = libro.toString();
                String autor = libro.getAutor();
                String editorial = libro.getEditorial();
                long isbn = libro.getIsbn();
                boolean leido = libro.getLeido();
                int numPag = libro.getNumPag();

                Intent intent = new Intent(BBDD_ListarLibros.this, BBDD_Detalles.class);
                intent.putExtra(getString(R.string.titulo4),titulo);
                intent.putExtra(getString(R.string.autor4),autor);
                intent.putExtra(getString(R.string.editoral4),editorial);
                intent.putExtra(getString(R.string.isbn4),isbn);
                intent.putExtra(getString(R.string.leido4),leido);
                intent.putExtra(getString(R.string.numpag4),numPag);
                startActivityForResult(intent,1);
            }
        });

        bsdbh = new BibliotecaSQLiteHelper(this, "Biblioteca", null, 1);

        llenarLista();


        // Metodo onClick del boton volver, vuelve a la ventana anterior
        butVolver.setOnClickListener(view -> finish());

        radio1.setOnClickListener(view -> {llenarLista();});
        radio2.setOnClickListener(view -> {llenarLista();});

    }

    //Metodo para llenar la lista
    private void llenarLista()
    {
        try
        {
            RadioButton butSeleccionado = findViewById(radioGroupLeido.getCheckedRadioButtonId());
            int seleccion = -1;
            String texto = butSeleccionado.getText().toString().trim();
            String opcion1 = getResources().getString(R.string.leidos);
            String opcion2 = getResources().getString(R.string.por_leer);
            if(texto.equals(opcion1))
                seleccion = 1;
            else if(texto.equals(opcion2))
                seleccion = 2;
            if(seleccion == -1)
                throw new Exception("No se ha seleccionado ninguna opción.");
            ArrayList<Libro> listaLibros = conseguirLibrosBD(seleccion);

            Libro datos[] = new Libro[listaLibros.size()];
            for(int contDatos = 0; contDatos < datos.length; contDatos++)
                datos[contDatos] = listaLibros.get(contDatos);

            AdaptadorTitulares adaptadorTitulares = new AdaptadorTitulares(this, datos);
            lvLibros.setAdapter(adaptadorTitulares);
        }
        catch(Exception e)
        {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG ).show();
        }
    }

    private ArrayList<Libro>conseguirLibrosBD(int seleccion)
    {
        ArrayList<Libro>resultado = new ArrayList<Libro>();
        SQLiteDatabase db = bsdbh.getWritableDatabase();
        Cursor c = null;

        //Libros Leidos
        if(seleccion == 1){
            c = db.rawQuery("SELECT titulo, autor, editorial, isbn, numPag, leido FROM Libro ", null);

            //Nos aseguramos de que existe el primer registro
            if (c.moveToFirst()) {
                do {
                    String titulo = c.getString(0);
                    String autor = c.getString(1);
                    String editorial = c.getString(2);
                    long isbn = c.getLong(3);
                    int numPag = c.getInt(4);
                    boolean leido = true;

                    Libro libro = new Libro(titulo, autor, editorial, isbn, numPag, leido);
                    resultado.add(libro);
                }
                while(c.moveToNext());
            }
        }

        //Libros no leidos
        else if(seleccion == 2) {
            c = db.rawQuery("SELECT titulo, autor, editorial, isbn, numPag, leido FROM Libro WHERE leido = false", null);

            //Nos aseguramos de que existe el primer registro
            if (c.moveToFirst()) {
                do {
                    String titulo = c.getString(0);
                    String autor = c.getString(1);
                    String editorial = c.getString(2);
                    long isbn = c.getLong(3);
                    int numPag = c.getInt(4);
                    boolean leido = false;

                    Libro libro = new Libro(titulo, autor, editorial, isbn, numPag, leido);
                    resultado.add(libro);
                }
                while(c.moveToNext());
            }
        }
        c.close();
        db.close();
        return resultado;
    }

    //Hacemos aparacer los elementos
    private class AdaptadorTitulares extends ArrayAdapter<Libro>
    {
        private Libro[] datos;

        public AdaptadorTitulares(Context context, Libro[] datos)
        {
            super(context, R.layout.listitem_libro, datos);
            this.datos = datos;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_libro, null);

            TextView tvNomLibro = (TextView)item.findViewById(R.id.tvNomLibro);
            tvNomLibro.setText(datos[position].toString());

            TextView tvAutor = (TextView)item.findViewById(R.id.tvAutor);
            tvAutor.setText(datos[position].getAutor());

            return item;
        }
    }
}