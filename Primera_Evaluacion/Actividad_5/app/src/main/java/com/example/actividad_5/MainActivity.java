package com.example.actividad_5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.ClipData;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ListView lvChats, lvLlamadas, lvEstados;
    private Chat[] chatsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chatsArray = new Chat[]
                {
                        new Chat("Ander", "Conecta a discord","Flyin Free","Ultima llamada: ayer"),
                        new Chat("Elena", "Gracias","Me gustan los gatos", "Ultima llamada: nunca"),
                        new Chat("Raul", "Jajajajajjaa ","Play 5","Ultima llamada: 12/10/1999"),
                        new Chat("Dani", "Hola me llamo...","VendeSeguros","Ultima llamada: nunca"),
                        new Chat("Mama", "Estoy en casa de tu tia", "ISLA BONITA","Ultima llamada: 31/10/2021"),
                        new Chat("El Jonan", "A ver si nos vemos","Vamossssss" ,"Ultima llamada: nunca"),
                        new Chat("El Txori", "xD", "Eres el p...","Ultima llamada: 20/02/2020"),
                };


        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new PageAdaprter());
        TabLayout tabLayout= findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);

    }
    class PageAdaprter extends PagerAdapter {
        private LinearLayout chats;
        private LinearLayout estados;
        private LinearLayout llamadas;
        private final int[] tabs = {R.string.tab1, R.string.tab2, R.string.tab3};

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String s = getString(tabs[position]);
            return s;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View page;
            switch(position){
                case 0:
                    if (chats == null) {
                        chats = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.chats, container, false);

                    }
                    page = chats;
                    lvChats = (ListView) chats.findViewById(R.id.lvChats);
                    AdaptadorChats adaptadorChats = new AdaptadorChats(chats.getContext(), chatsArray);
                    lvChats.setAdapter(adaptadorChats);
                    break;
                case 1:
                    if (estados ==  null) {
                        estados = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.estados, container, false);
                    }
                    page = estados;
                    lvEstados = (ListView) estados.findViewById(R.id.lvEstados);
                    AdaptadorEstados adaptadorEstados = new AdaptadorEstados(estados.getContext(), chatsArray);
                    lvEstados.setAdapter(adaptadorEstados);
                    break;
                default:
                    if (llamadas == null){
                        llamadas = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.llamadas, container, false);
                    }
                    page = llamadas;
                    lvLlamadas = (ListView) llamadas.findViewById(R.id.lvLlamadas);
                    AdaptadorLlamadas adaptadorLLamadas = new AdaptadorLlamadas(llamadas.getContext(), chatsArray);
                    lvLlamadas.setAdapter(adaptadorLLamadas);
                    break;
            }

            container.addView(page,0);
            return page;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            //return false;
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container,
                                int position, @NonNull Object object) {
            container.removeView((View)object);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}