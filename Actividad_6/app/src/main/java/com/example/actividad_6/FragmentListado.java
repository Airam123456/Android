package com.example.actividad_6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

     private ListView lstListado;
     private LibroListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment_listado, container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lstListado = (ListView) getView().findViewById(R.id.lstListado);
        lstListado.setAdapter(new AdaptadorLibros(this));

        lstListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                if (listener != null)
                    listener.onLibroSeleccionado(
                            (Libro)lstListado.getAdapter().getItem(position));
            }
        });
    }

    class AdaptadorLibros extends ArrayAdapter<Libro>{
        Activity context;

        AdaptadorLibros(Fragment context){
            super(context.getActivity(), R.layout.listitem_libro, datos);
            this.context = context.getActivity();
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_libro, null);
            TextView titulo = (TextView) item.findViewById(R.id.txtTitulo);
            titulo.setText(datos[position].getTitulo());
            ImageView portada = (ImageView) item.findViewById(R.id.imgPortada);
            portada.setImageResource(datos[position].getImagen());
            return (item);        }
    }

    public void setLibroListener(LibroListener listener){
        this.listener = listener;
    }
}