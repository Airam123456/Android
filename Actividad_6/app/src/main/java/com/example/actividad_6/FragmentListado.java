package com.example.actividad_6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentListado extends Fragment {

     private int[] arrLibros = {R.drawable.hp1,R.drawable.hp2,R.drawable.hp3,R.drawable.hp4,R.drawable.hp5,R.drawable.hp6,R.drawable.hp7};

     private Libro[] datos = new Libro[]{
             new Libro("La Piedra Filosofal", "J.K.Rowling","1997",arrLibros[0]),
             new Libro("La Cámara de los Secretos","J.K.Rowling","1998",arrLibros[1]),
             new Libro("El Prisionero de Azkaban","J.K.Rowling","1999",arrLibros[2]),
             new Libro("El Cáliz de Fuego","J.K.Rowling","2000",arrLibros[3]),
             new Libro("La Orden del Fénix","J.K.Rowling","2003",arrLibros[4]),
             new Libro("El Misterio del Principe","J.K.Rowling","2005",arrLibros[5]),
             new Libro("Las Reliquias de la Muerte","J.K.Rowling","2007",arrLibros[6])
     };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment_listado, container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}