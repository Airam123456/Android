package com.example.examen_2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClienteSQLiteHelper extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de Clientes
    String sqlCreate1 = "CREATE TABLE Clientes (dni INTEGER PRIMARY KEY," +
                    " nombre TEXT, direccion TEXT, tfno TEXT)";

    String sqlCreate2 = "CREATE TABLE Facturas (num INTEGER PRIMARY KEY," +
            "dni INTEGER, concepto TEXT, valor REAL," +
            "FOREIGN KEY (dni) REFERENCES Clientes(dni))";


    public ClienteSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate1);
        db.execSQL(sqlCreate2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Clientes");
        db.execSQL("DROP TABLE IF EXISTS Facturas");
        //Se crea la nueva version de la tabla
        db.execSQL(sqlCreate1);
        db.execSQL(sqlCreate2);
    }
}
